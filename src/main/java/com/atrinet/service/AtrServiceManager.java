package com.atrinet.service;

import com.atrica.netmanager.AtricaServer;
import com.atrinet.api.YP;
import com.atrinet.infra.RTExc;
import com.atrinet.infra.rmi.RMIHelper;
import com.atrinet.model.services.dto.CliService;
import com.atrinet.service.model.AtrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by rasth on 8/20/2015.
 */
@Service
public class AtrServiceManager {

    Class<CliService> clazz = CliService.class;

    @Autowired
    AtrServiceConManager atrServiceConManager;

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

        List<CliService> cliServices = YP.dataInventory.findAll(clazz);

        for (CliService iService : cliServices) {
            if (iService.getOrderNumber() == orderName)
                serviceList.add(dtoToService(iService));
        }

        return serviceList;
    }

    public List<AtrService> getServiceByOperatorName(String operatorName) {
        List<AtrService> serviceList = new ArrayList<>();

        List<CliService> cliServices = YP.dataInventory.findAll(clazz);

        for (CliService iService : cliServices) {
            if (iService.getOperatorName().equals(operatorName))
                serviceList.add(dtoToService(iService));
        }

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
