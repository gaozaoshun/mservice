package org.gfs.order.server.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author gaozaoshun
 * @ProjectName order
 * @Package org.gfs.order.server.config
 * @ClassName DataSourceConfig
 * @description
 * @date created in 2019-04-19 16:47
 * @modified by
 */
@Data
@Component
@ConfigurationProperties("spring.datasource")
@RefreshScope
public class DataSourceConfig {
    private  String driverClassName;
    private  String url;
    private  String username;
    private  String password;
}
