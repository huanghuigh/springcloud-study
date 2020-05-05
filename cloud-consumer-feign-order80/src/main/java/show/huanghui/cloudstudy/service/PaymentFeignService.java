package show.huanghui.cloudstudy.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import show.huanghui.cloudstudy.entities.CommonResult;
import show.huanghui.cloudstudy.entities.Payment;

/**
 * @author guangtou
 * @create 2020--05--05--9:34
 * feign需要调用服务相同的接口上添加@FeignClient注解,并且接口和controller上保持一致
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
//    测试Feign的正常使用
    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
//    测试Feign超时设置
    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();
}