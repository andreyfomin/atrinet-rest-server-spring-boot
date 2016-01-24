package com.atrinet.service;

import com.atrinet.api.YP;
import com.atrinet.model.generic.device.dto.GenericDeviceDto;
import com.atrinet.service.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by rasth on 8/20/2015.
 */
@Service
public class DeviceManager {

    Class<GenericDeviceDto> clazz = GenericDeviceDto.class;

    @Autowired
    AtrServiceConManager atrServiceConManager;

    public List<Device> getDevices() {

        List<Device> devList = new ArrayList<>();

        List<GenericDeviceDto> dtos = YP.dataInventory.findAll(clazz);

        devList.addAll(dtos.stream().map(this::dtoToDevice).collect(Collectors.toList()));

        return devList;

    }

    public List<Device> getDeviceById(Integer deviceId) {

        List<Device> devList = new ArrayList<>();
        GenericDeviceDto deviceDto = YP.dataInventory.findById(clazz, deviceId);

        if (deviceDto != null)
            devList.add(dtoToDevice(deviceDto));

        return devList;
    }

    public List<Device> getDeviceByName(String deviceName) {

        List<Device> devList = new ArrayList<>();
        GenericDeviceDto deviceDto = YP.dataInventory.findByName(clazz, deviceName);

        if (deviceDto != null)
            devList.add(dtoToDevice(deviceDto));

        return devList;
    }

    public List<Device> getDeviceByIp(String deviceIp) {
        List<Device> devList = new ArrayList<>();

        List<GenericDeviceDto> dtos = YP.dataInventory.findAll(clazz);

        for (GenericDeviceDto dto : dtos) {
            if (dto.getIpAddress().equals(deviceIp)) {
                devList.add(dtoToDevice(dto));
            }
        }
        return devList;
    }

    private Device dtoToDevice(GenericDeviceDto deviceDto) {
        Device device = new Device();

        device.setId(deviceDto.getId());
        device.setIpAdress(deviceDto.getIpAddress());
        device.setName(deviceDto.getDnsName());
        device.setType(deviceDto.getDeviceType().name());
        device.setSysOID(deviceDto.getSysOID());
        device.setSwVersion(deviceDto.getSwVersion());
        device.setStatus(deviceDto.getExtStatus().name());

        return device;
    }
}
