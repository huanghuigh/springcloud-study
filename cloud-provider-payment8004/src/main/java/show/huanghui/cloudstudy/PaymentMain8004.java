package show.huanghui.cloudstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import show.huanghui.cloudstudy.entities.Payment;

/**
 * @author guangtou
 * @create 2020--05--02--17:29
 */
@SpringBootApplication
@EnableDiscoveryClient // 使用该注解,consul/zookeeper作为注册中心时,注册服务
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class,args);
    }
}
