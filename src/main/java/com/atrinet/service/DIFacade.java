package com.atrinet.service;

import com.atrinet.api.IDataInventory;
import com.atrinet.api.YP;
import com.atrinet.model.services.dto.CliService;
import com.atrinet.service.model.AtrService;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rasth on 1/21/2016.
 */
public class DIFacade {

    public <T> List<T> findById(Class<T> aClass, int i) {
        return null;
    }


    public <T> List<T> tryFindById(Class<T> aClass, int i)  {
        return null;
    }


    public <T> List<T> findAll(Class<T> clazz)  {
       return  YP.dataInventory.findAll(clazz);
    }


    public <T> List<T> findByName(Class<T> aClass, String s)  {
        return null;
    }


    public <T> List<T> tryFindByName(Class<T> aClass, String s) {
        return null;
    }


    public <T> List<T> findByNames(Class<T> aClass, List<String> list) {
        return null;
    }
}
