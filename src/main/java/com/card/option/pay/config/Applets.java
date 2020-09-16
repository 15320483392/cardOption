package com.card.option.pay.config;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author WTar
 * @date 2020/9/16 17:40
 */
@Data
@Component
@Accessors(chain = true)
@ConfigurationProperties(prefix = "wx-app")
@EnableConfigurationProperties()
public class Applets {

    private String appId;

    private String appScret;

}
