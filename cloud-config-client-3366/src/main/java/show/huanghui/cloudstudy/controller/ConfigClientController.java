package show.huanghui.cloudstudy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guangtou
 * @create 2020--05--09--18:10
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${spring.application.name}")
    private String configInfo;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return "serverPort:" +serverPort + "\t\n\n"+ configInfo;
    }

    @GetMapping("/server")
    public String server(){
        return serverPort;
    }

}
