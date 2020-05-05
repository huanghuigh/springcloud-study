package show.huanghui.cloudstudy.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guangtou
 * @create 2020--05--05--13:54
 */
@Configuration
public class FeignConfig {
//    Feign日志级别配置
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
