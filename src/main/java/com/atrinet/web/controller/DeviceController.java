package com.atrinet.web.controller;

import com.atrinet.service.DeviceManager;
import com.atrinet.service.model.Device;
import com.atrinet.web.messages.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by AFomin on 7/5/2015.
 */
@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    DeviceManager deviceManager;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Device> getDevices() {
        return deviceManager.getDevices();
    }

    @RequestMapping(value = "/id/{deviceId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<Device> getDeviceById(@PathVariable Integer deviceId) {
        return deviceManager.getDeviceById(deviceId);
    }

    @RequestMapping(value = "/name/{deviceName}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<Device> getDeviceByName(@PathVariable String deviceName) {
        return deviceManager.getDeviceByName(deviceName);
    }

    @RequestMapping(value = "/ip/{deviceIp:.+}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<Device> getDeviceByIp(@PathVariable String deviceIp) {
        return deviceManager.getDeviceByIp(deviceIp);
    }

//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.OK)
//    public
//    @ResponseBody
//    ResponseMessage updateDevices(@RequestBody Device device) {
//        deviceManager.updateDevice(device);
//        return new ResponseMessage();
//    }


//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.OK)
//    public
//    @ResponseBody
//    ResponseMessage addDevice(@RequestBody Device device) {
//        deviceManager.addDevice(device);
//        return new ResponseMessage();
//    }
//
//    @RequestMapping(value = "/remove/{deviceId}", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public
//    @ResponseBody
//    ResponseMessage removeDevice(@PathVariable Long deviceId) {
//        deviceManager.removeDevice(deviceId);
//        return new ResponseMessage();
//    }

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