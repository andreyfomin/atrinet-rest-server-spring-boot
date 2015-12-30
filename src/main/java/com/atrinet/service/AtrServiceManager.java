package com.atrinet.service;

import com.atrinet.api.YP;
import com.atrinet.infra.rmi.RMIHelper;
import com.atrinet.model.services.dto.CliService;
import com.atrinet.service.model.AtrService;
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

    Class<CliService> clazz = CliService.class;

    @Autowired
    public AtrServiceManager(
            @Value("${artinet.remote.ip}")
            String rmiServerIp) {

        RMIHelper.setAsIp(rmiServerIp);
        RMIHelper.ignoreRmiStubs();
    }

    public List<AtrService> geServices() {

        List<AtrService> serviceList = new ArrayList<>();

        List<CliService> cliServices = YP.dataInventory.findAll(clazz);

        for (CliService iService : cliServices) serviceList.add(dtoToService(iService));

        return serviceList;

    }

    public List<AtrService> getServiceById(Integer serviceId) {

        List<AtrService> serviceList = new ArrayList<>();

        CliService cliService = YP.dataInventory.findById(clazz, serviceId);

        if (cliService != null)
            serviceList.add(dtoToService(cliService));

        return serviceList;
    }

    public List<AtrService> getServiceByExternalId(Integer externalId) {

        List<AtrService> serviceList = new ArrayList<>();

        List<CliService> cliServices = YP.dataInventory.findAll(clazz);

        for (CliService iService : cliServices) {
            if (iService.getExternalId() == externalId.intValue())
                serviceList.add(dtoToService(iService));
        }

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

    public List<AtrService> getServiceByOperatorName(String operatorName) {
        List<AtrService> serviceList = new ArrayList<>();

        return serviceList;
    }
    private AtrService dtoToService(CliService iService) {

        AtrService atrService = new AtrService();
        atrService.setId(iService.getId());
        atrService.setName(iService.getName());
        atrService.setExternalId(iService.getExternalId());
        atrService.setOrderNumber(iService.getOrderNumber());
        atrService.setOperatorName(iService.getOperatorName());
        atrService.setOperationalStatus(iService.getOperStatus().name());
        atrService.setConfigStatus(iService.getConfigStatus().name());
        atrService.setCreationTime(iService.getCreationTime());
        atrService.setDeviceIP(iService.getDeviceIPs());

        return atrService;
    }
}
