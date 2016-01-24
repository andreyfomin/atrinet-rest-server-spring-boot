package com.atrinet.service;

import com.atrica.netmanager.AtricaServer;
import com.atrica.nm.AsyncNotificationImpl;
import com.atrinet.api.YP;
import com.atrinet.infra.RTExc;
import com.atrinet.infra.rmi.RMIHelper;
import com.atrinet.model.services.dto.CliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by rasth on 1/21/2016.
 */

@Service
public class AtrServiceConManager {

    @Value("${artinet.remote.ip}")
    String rmiServerIp;

    public AtrServiceConManager() {

    }

    public void connect(){
        try {

            RMIHelper.ignoreRmiStubs();

            String name = "rmi://" + rmiServerIp + ":10001/AtricaServer";
            AtricaServer theServer = (AtricaServer) RMIHelper.lookupWithRetries(name, 20, 3000); // up to 60 seconds
            RMIHelper.initAllProxiesClientSide(theServer.getAllProxies());

        } catch (Exception e) {
            throw RTExc.wrap(e);
        }
    }

}
