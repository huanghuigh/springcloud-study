package show.huanghui.cloudstudy;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import show.huanghui.cloudstudy.show.huanghui.myrule.MyselfRule;

/**
 * @author guangtou
 * @create 2020--05--01--15:51
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyselfRule.class) // 修改此访问服务名时所用负载规则
public class OrderMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain.class);
    }
}
