package com.atrinet.service.model;

import lombok.Data;

/**
 * Created by John on 9/5/2015.
 */
@Data
public class Link {

    private Integer id;
    private String name;
    private String ipAddress;
    private Integer portId1;
    private Integer portId2;
    private String status;
}
