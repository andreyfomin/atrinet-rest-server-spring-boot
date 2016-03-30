package com.atrinet.service;

import com.atrinet.api.YP;
import com.atrinet.model.generic.device.dto.GenericDeviceDto;
import com.atrinet.model.generic.device.dto.PortDto;
import com.atrinet.model.services.dto.EdgeDeviceDto;
import com.atrinet.service.model.Device;
import com.atrinet.service.model.EdgeDevice;
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

    public List<EdgeDevice> getServiceEdgeDevices(Integer serviceId) {

        List<EdgeDevice> devList = new ArrayList<>();

        List<EdgeDeviceDto> edgeDevices = YP.dataInventory.getServiceEdgeDevices(serviceId);

        for (EdgeDeviceDto edgeDeviceDto : edgeDevices) {
            devList.add(dtoToEdgeDeviceDto(edgeDeviceDto));
        }
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

    private EdgeDevice dtoToEdgeDeviceDto(EdgeDeviceDto deviceDto) {
        EdgeDevice device = new EdgeDevice();

        device.setId(deviceDto.getDevice().getId());
        device.setIpAdress(deviceDto.getDevice().getIpAddress());
        device.setName(deviceDto.getDevice().getDnsName());
        device.setType(deviceDto.getDevice().getDeviceType().name());
        device.setSysOID(deviceDto.getDevice().getSysOID());
        device.setSwVersion(deviceDto.getDevice().getSwVersion());
        device.setStatus(deviceDto.getDevice().getExtStatus().name());
        device.setUserPortId(deviceDto.getUserPortId());
        device.setNetworkPortId(deviceDto.getNetworkPortId());

        return device;
    }
}