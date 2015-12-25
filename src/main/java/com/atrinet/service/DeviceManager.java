package com.atrinet.service;

import com.atrinet.api.YP;
import com.atrinet.infra.rmi.RMIHelper;
import com.atrinet.model.generic.device.dto.GenericDeviceDto;
import com.atrinet.service.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;


/**
 * Created by rasth on 8/20/2015.
 */
@Service
public class DeviceManager {

    //    List<ModelElement> devices = new ArrayList<>();
    Map<Long, Device> devices = new HashMap<>();

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    Lock r = lock.readLock();
    Lock w = lock.writeLock();

    Class<GenericDeviceDto> clazz = GenericDeviceDto.class;

//    @Value("${artinet.remote.ip}")
//    private String rmiServerIp;

    @Autowired
    public DeviceManager(
            @Value("${artinet.remote.ip}")
            String rmiServerIp) {

        RMIHelper.setAsIp(rmiServerIp);
        RMIHelper.ignoreRmiStubs();

    }

    public List<Device> getDevices() {

        List<Device> devList = new ArrayList<>();

        List<GenericDeviceDto> dtos = YP.dataInventory.findAll(clazz);

        devList.addAll(dtos.stream().map(this::dtoToDevice).collect(Collectors.toList()));

        return devList;

    }

    public void addDevice(Device device) {
        w.lock();
        try {
//            devices.put(device.getId(), device);
        } finally {
            w.unlock();
        }
    }

    public void removeDevice(Long deviceId) {
        w.lock();
        try {
            devices.remove(deviceId);
        } finally {
            w.unlock();
        }
    }

    public void updateDevice(Device device) {
        w.lock();
        try {
//            devices.put(device.getId(), device);
        } finally {
            w.unlock();
        }
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
        //device.setType(deviceDto.getDeviceTypeDto().getDisplayName());
        device.setType(deviceDto.getDeviceType().name());
        device.setSysOID(deviceDto.getSysOID());
        device.setSwVersion(deviceDto.getSwVersion());
        device.setStatus(deviceDto.getExtStatus().name());

        return device;

    }
}
