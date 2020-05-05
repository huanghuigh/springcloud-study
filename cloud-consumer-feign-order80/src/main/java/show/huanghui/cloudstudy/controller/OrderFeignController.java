package show.huanghui.cloudstudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import show.huanghui.cloudstudy.entities.CommonResult;
import show.huanghui.cloudstudy.entities.Payment;
import show.huanghui.cloudstudy.service.PaymentFeignService;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author guangtou
 * @create 2020--05--05--9:49
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;
//  测试Feign
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }
//  测试Feign TimeOut
    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout(){
        return paymentFeignService.paymentFeignTimeout();
    }

}
