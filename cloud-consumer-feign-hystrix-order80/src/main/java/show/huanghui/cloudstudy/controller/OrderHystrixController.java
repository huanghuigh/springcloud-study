package show.huanghui.cloudstudy.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import show.huanghui.cloudstudy.service.PaymentHystrixService;

import javax.annotation.Resource;

/**
 * @author guangtou
 * @create 2020--05--05--23:12
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod" ) // 全局默认fallback方法
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/order/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",
//    设置此方法调用的超时时间
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                            value = "1500")
            })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        int a = 10/0;
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }

    @GetMapping("/order/hystrix/ok/{id}")
//    @HystrixCommand
    public String paymentInfo_OK(@PathVariable("id") Integer id){
//        int a = 10/0;
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }
    //    hystrix延时事例,当调用过长,会出现 Read timed out executing错误

    //    这是备选方法
    public String paymentTimeOutFallbackMethod(Integer id) {
        return " 消费者80端口提示:  支付系统繁忙: " + Thread.currentThread().getName() +
                "  paymentTimeOutFallbackMethod,id:"
                + id + "\t" + " 请稍后再试  ┭┮﹏┭┮" ;
    }

    //    这是全局备选方法
//    public String payment_Global_FallbackMethod() {
//        return " 消费者80端口提示:  支付系统繁忙: " + Thread.currentThread().getName() +
//                "  payment_Global_FallbackMethod, "
//                 + "\t" + " 请稍后再试  ┭┮﹏┭┮" ;
//    }
}
