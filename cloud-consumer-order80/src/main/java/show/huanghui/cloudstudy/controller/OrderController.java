package show.huanghui.cloudstudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import show.huanghui.cloudstudy.entities.CommonResult;
import show.huanghui.cloudstudy.entities.Payment;

import javax.annotation.Resource;

/**
 * @author guangtou
 * @create 2020--05--01--15:14
 */
@RestController
@Slf4j
public class OrderController { // 模拟用户模块
    public static final String PAYMENT_URL ="http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create") // 订单新增
    public CommonResult<Payment> create(Payment payment){
//        restTemplate在发送数据的时候,将对象转成了json格式,因此收数据的时候需要@requestBody
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}") // 订单查询
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
}
