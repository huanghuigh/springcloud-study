package show.huanghui.cloudstudy.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author guangtou
 * @create 2020--05--03--13:29
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //调用服务端,需要开启负载均衡的功能
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
