package com.atrinet.service;

import com.atrica.apps.model.esu.A2200DeviceImpl;
import com.atrica.infra.model.primitives.ModelElement;
import com.atrinet.service.model.Device;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


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


    public DeviceManager() {

//        ModelElement device = new A2200DeviceImpl(1);
        Device device = new Device();

        device.setId(1l);
        device.setStatus("OK");
        device.setName("20.25.30.3");
        device.setIpAdress("20.25.30.3");
        device.setType("A-4100");
        device.setLocation("F2");
        device.setContact("efi");
        device.setSerialNumber("N/A");
        device.setBarCode("N/A");
        device.setCleiCode("N/A");
        device.setUsiCode("N/A");
        device.setSwVersion("5.0.4.b");
        device.setHwVersion("14.00");

        devices.put(device.getId(), device);

        device = new Device();

        device.setId(2l);
        device.setStatus("Disconnected");
        device.setName("11.11.70.11");
        device.setIpAdress("11.11.70.11");
        device.setType("A-2100");
        device.setLocation("F2");
        device.setContact("efi");
        device.setSerialNumber("0001DAG001576F");
        device.setBarCode("ATC2000100000AA");
        device.setCleiCode("N/A");
        device.setUsiCode("N/A");
        device.setSwVersion("4.0.2.l");
        device.setHwVersion("AG");

        devices.put(device.getId(), device);

    }

    public List<Device> getDevices() {
        r.lock();
        try {
            return new ArrayList<>(devices.values());
        } finally {
            r.unlock();
        }

    }

    public void addDevice(Device device) {
        w.lock();
        try {
            devices.put(device.getId(), device);
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
            devices.put(device.getId(), device);
        } finally {
            w.unlock();
        }
    }

}
