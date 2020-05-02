package show.huanghui.cloudstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka启动类
 * @author guangtou
 * @create 2020--05--01--23:37
 */
@SpringBootApplication
@EnableEurekaServer // 作为eureka服务配置中心
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
    }
}
