package show.huanghui.cloudstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author guangtou
 * @create 2020--05--08--21:46
 */
@SpringBootApplication
@EnableConfigServer
public class AppConfigCenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(AppConfigCenterMain3344.class,args);
    }
}
