package show.huanghui.cloudstudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author guangtou
 * @create 2020--05--03--13:32
 */
@RestController
@Slf4j
public class OrderController {
    public static final String INVOKE_URL = "http://cloud-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String paymemtzk(){
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);

        return result;
    }
}
