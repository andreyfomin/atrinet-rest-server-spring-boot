package com.atrinet.web.controller;

import com.atrinet.service.LinkManager;
import com.atrinet.service.model.Link;
import com.atrinet.web.messages.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by AFomin on 7/5/2015.
 */
@RestController
@RequestMapping("/links")
public class LinkController {

    @Autowired
    LinkManager linkManager;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Link> getLinks() {
        return linkManager.getLinks();
    }

    @RequestMapping(value = "/id/{linkId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<Link> getLinkById(@PathVariable Integer linkId) {
        return linkManager.getLinkById(linkId);
    }

    @RequestMapping(value = "/name/{linkName}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<Link> getLinkByName(@PathVariable String linkName) {
        return linkManager.getLinkByName(linkName);
    }

    @RequestMapping(value = "/ip/{linkIp:.+}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<Link> getLinkByIp(@PathVariable String linkIp) {
        return linkManager.getLinkByIp(linkIp);
    }

    @ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseMessage handleBankConflict(Exception ex) {
        //log.error(ex.getMessage(), ex);

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus("Error");
        responseMessage.setMessage(ex.getMessage());
        return responseMessage;
    }

}