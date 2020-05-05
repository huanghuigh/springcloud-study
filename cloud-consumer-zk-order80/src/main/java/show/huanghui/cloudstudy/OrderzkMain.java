package show.huanghui.cloudstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author guangtou
 * @create 2020--05--03--13:28
 */
@SpringBootApplication
@EnableDiscoveryClient // zk注册,用户
public class OrderzkMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderzkMain.class,args);
    }
}
