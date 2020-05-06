package show.huanghui.cloudstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author guangtou
 * @create 2020--05--06--23:21
 * 作为hystrix的仪表盘
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(show.huanghui.cloudstudy.HystrixDashboardMain9001.class,args);
    }
}

