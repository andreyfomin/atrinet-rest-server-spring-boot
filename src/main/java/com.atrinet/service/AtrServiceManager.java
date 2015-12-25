package com.atrinet.service;

import com.atrinet.api.YP;
import com.atrinet.infra.rmi.RMIHelper;
import com.atrinet.model.generic.device.dto.LinkDto;
import com.atrinet.netace.managers.IServiceImpl;
import com.atrinet.service.model.AtrService;
import com.atrinet.service.model.Device;
import com.atrinet.service.model.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * Created by rasth on 8/20/2015.
 */
@Service
public class AtrServiceManager {

    //    List<ModelElement> devices = new ArrayList<>();
    Map<Long, Device> devices = new HashMap<>();

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    Lock r = lock.readLock();
    Lock w = lock.writeLock();

    Class<IServiceImpl> clazz = IServiceImpl.class;

    @Autowired
    public AtrServiceManager(
            @Value("${artinet.remote.ip}")
            String rmiServerIp) {

        RMIHelper.setAsIp(rmiServerIp);
        RMIHelper.ignoreRmiStubs();
    }

    public List<AtrService> geServises() {

        List<AtrService> serviceList = new ArrayList<>();

        List<IServiceImpl> dtos = YP.dataInventory.findAll(clazz);

        for (IServiceImpl iService : dtos) {
            serviceList.add(dtoToService(iService));
        }

        return serviceList;

    }

    public List<AtrService> getServiceById(Integer serviceId) {

        List<AtrService> serviceList = new ArrayList<>();

        return serviceList;
    }

    public List<AtrService> getServiceByExternalId(String externalId) {

        List<AtrService> serviceList = new ArrayList<>();

        return serviceList;
    }

    public List<AtrService> getServiceByDescription(String description) {
        List<AtrService> serviceList = new ArrayList<>();

        return serviceList;
    }


    public List<AtrService> getServiceByOrderName(String orderName) {
        List<AtrService> serviceList = new ArrayList<>();

        return serviceList;
    }

    public List<AtrService> getServiceByOperatorName (String operatorName) {
        List<AtrService> serviceList = new ArrayList<>();

        return serviceList;
    }

    private AtrService dtoToService(IServiceImpl iService) {

        AtrService atrService = new AtrService();
//        atrService.setId(iService.);
//        atrService.setName(linkDto.getName()); // name
//        atrService.setStatus(linkDto.getStatus().name());//status
//        atrService.setPortId1(linkDto.getPortId1()); //
//        atrService.setPortId2(linkDto.getPortId2()); //

        return atrService;
    }

}
