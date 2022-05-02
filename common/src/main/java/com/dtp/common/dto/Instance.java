package com.dtp.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Instance
 *
 * @author 方便面
 * @date 2022/5/2
 */
@Data
@AllArgsConstructor
public class Instance {

    private String ip;

    private int port;

    private String serviceName;

    private String env;

}
