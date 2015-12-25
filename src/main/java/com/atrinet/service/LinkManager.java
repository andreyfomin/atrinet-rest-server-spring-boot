package com.atrinet.service;

import com.atrinet.api.YP;
import com.atrinet.infra.rmi.RMIHelper;
import com.atrinet.model.generic.device.dto.LinkDto;
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
public class LinkManager {

    //    List<ModelElement> devices = new ArrayList<>();
    Map<Long, Device> devices = new HashMap<>();

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    Lock r = lock.readLock();
    Lock w = lock.writeLock();

    Class<LinkDto> clazz = LinkDto.class;

    @Autowired
    public LinkManager(
            @Value("${artinet.remote.ip}")
            String rmiServerIp) {

        RMIHelper.setAsIp(rmiServerIp);
        RMIHelper.ignoreRmiStubs();
    }

    public List<Link> getLinks() {
        r.lock();
        List<Link> linkList = new ArrayList<>();


        List<LinkDto> dtos = YP.dataInventory.findAll(clazz);

        for (LinkDto linkDto : dtos) {
            linkList.add(dtoToLink(linkDto));
        }

        return linkList;

    }

    public List<Link> getLinkById(Integer linkId) {

        List<Link> linkList = new ArrayList<>();
        LinkDto linkDto = YP.dataInventory.findById(clazz, linkId);

        if (linkDto != null)
            linkList.add(dtoToLink(linkDto));

        return linkList;
    }

    public List<Link> getLinkByName(String linkName) {

        List<Link> linkList = new ArrayList<>();
        LinkDto linkDto = YP.dataInventory.findByName(clazz, linkName);

        if (linkDto != null)
            linkList.add(dtoToLink(linkDto));

        return linkList;
    }

    public List<Link> getLinkByIp(String linkIp) {
        List<Link> linkList = new ArrayList<>();

        List<LinkDto> dtos = YP.dataInventory.findAll(clazz);

//        for (LinkDto dto : dtos) {
//            if (dto.getIpAddress().equals(linkIp)) {
//                linkList.add(dtoToLink(dto));
//            }
//        }
        return linkList;
    }

    private Link dtoToLink(LinkDto linkDto) {

        Link link = new Link();
        link.setId(linkDto.getId());
        link.setName(linkDto.getName()); // name
        link.setStatus(linkDto.getStatus().name());//status
        link.setPortId1(linkDto.getPortId1()); //
        link.setPortId2(linkDto.getPortId2()); //

        return link;
    }

}
