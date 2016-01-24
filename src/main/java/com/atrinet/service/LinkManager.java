package com.atrinet.service;

import com.atrinet.api.YP;
import com.atrinet.model.generic.device.dto.LinkDto;
import com.atrinet.service.model.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by rasth on 8/20/2015.
 */
@Service
public class LinkManager {

    Class<LinkDto> clazz = LinkDto.class;

    @Autowired
    AtrServiceConManager atrServiceConManager;

    public List<Link> getLinks() {
        List<Link> linkList = new ArrayList<>();


        List<LinkDto> linkDtos = YP.dataInventory.findAll(clazz);

        for (LinkDto linkDto : linkDtos) {
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
