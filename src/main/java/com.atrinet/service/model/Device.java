package com.atrinet.service.model;

import lombok.Data;

/**
 * Created by John on 9/5/2015.
 */
@Data
public class Device {

    private Long id;
    private String status;
    private String name;
    private String ipAdress;
    private String Type;
    private String location;
    private String Contact;
    private String serialNumber;
    private String barCode;
    private String cleiCode;
    private String usiCode;
    private String swVersion;
    private String hwVersion;
}
