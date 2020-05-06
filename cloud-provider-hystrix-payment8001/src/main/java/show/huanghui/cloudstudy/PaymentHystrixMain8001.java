package show.huanghui.cloudstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author guangtou
 * @create 2020--05--05--17:50
 * Hystrix的启动类
 */
@SpringBootApplication
@EnableCircuitBreaker // 激活回路?
@EnableDiscoveryClient // 服务发现,注册进Eureka
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class,args);
    }
}
