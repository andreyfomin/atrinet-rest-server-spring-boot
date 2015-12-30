package com.atrinet.service.model;

import lombok.Data;

/**
 * Created by John on 9/5/2015.
 */
@Data
public class AtrService {
    private Integer id;
    private Integer externalId;
    private String name;
    private String orderNumber;
    private String operatorName;
    private String operationalStatus;
    private String configStatus;
    private Long   creationTime;
    private String deviceIP;
}
