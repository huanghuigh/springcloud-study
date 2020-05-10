package show.huanghui.cloudstudy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guangtou
 * @create 2020--05--08--22:51
 */
@RestController
@RefreshScope // 开启刷新
public class ConfigClientController {
    @Value("${spring.application.name}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
