package com.atrinet.service.model;

import lombok.Data;

/**
 * Created by John on 9/5/2015.
 */
@Data
public class EdgeDevice {

    private Integer id;
    private String status;
    private String name;
    private String ipAdress;
    private String Type;
    private String location;
    private String Contact;
    private String swVersion;
    private String hwVersion;
    private String sysOID;
}