package com.atrinet.web.controller;

import com.atrinet.service.AtrServiceManager;
import com.atrinet.service.model.AtrService;
import com.atrinet.web.messages.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by AFomin on 7/5/2015.
 */
@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    AtrServiceManager serviceManager;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public
    @ResponseBody
    List<AtrService> geServices() {
        return serviceManager.geServices();
    }


    @RequestMapping(value = "/id/{serviceId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<AtrService> getServiceById(@PathVariable Integer serviceId) {
        return serviceManager.getServiceById(serviceId);
    }

    @RequestMapping(value = "/external/id/{serviceExternalId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<AtrService> getServiceByExternalId(@PathVariable Integer serviceExternalId) {
        return serviceManager.getServiceByExternalId(serviceExternalId);
    }

    @RequestMapping(value = "/description/{description}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<AtrService> getServiceByDescription(@PathVariable String description) {
        return serviceManager.getServiceByDescription(description);
    }

    @RequestMapping(value = "/order/name/{orderName}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<AtrService> getServiceByOrderName(@PathVariable String orderName) {
        return serviceManager.getServiceByOrderName(orderName);
    }

    @RequestMapping(value = "/operator/name/{operatorName}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<AtrService> getServiceByOperatorName(@PathVariable String operatorName) {
        return serviceManager.getServiceByOperatorName(operatorName);
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