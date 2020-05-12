package show.huanghui.cloudstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import show.huanghui.cloudstudy.service.IMessageProvider;

import javax.annotation.Resource;

/**
 * @author guangtou
 * @create 2020--05--10--21:23
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}
