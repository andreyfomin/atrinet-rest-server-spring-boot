package com.atrinet.web.messages;

import lombok.Data;

/**
 * Created by rasth on 9/6/2015.
 */
@Data
public class ResponseMessage {
    private String status = "OK";
    private String message = "";
}
