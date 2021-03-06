package show.huanghui.cloudstudy.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author guangtou
 * @create 2020--05--01--15:21
 */
@Configuration // 表明是一个配置类
public class ApplicationContextConfig {
    @Bean // 注入bean
//    @LoadBalanced // 开启默认负载均衡规则
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
