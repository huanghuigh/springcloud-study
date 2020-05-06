package show.huanghui.cloudstudy.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import rx.internal.operators.OnSubscribeDelaySubscriptionOther;
import show.huanghui.cloudstudy.service.PaymentService;

import java.util.concurrent.TimeUnit;

/**
 * @author guangtou
 * @create 2020--05--05--18:04
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
//    @HystrixCommand注解,fallbackMethod调用类中指定的方法,
//    当服务方法失败抛出了错误信息后会自动调用方法,超时/方法运行出错都会调用
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandle",
            commandProperties = {
//    设置此方法调用的超时时间
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                            value = "3000")
            })
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 5;
//        int age = 10/0;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: " + Thread.currentThread().getName() + " paymentInfo_TimeOut,id: " + id + "\t" + "耗时: " + timeNumber + " 秒" ;
    }

    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + " paymentInfo_OK: " + id + "\t" + "O(∩_∩)O哈哈~";
    }
//    这是备选方法
    @Override
    public String paymentInfo_TimeOutHandle(Integer id) {
        return " 备选线程池: " + Thread.currentThread().getName() + " 系统异常     paymentInfo_TimeOutHandle,id: " + id + "\t" + "┭┮﹏┭┮" ;
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //   请求次数 10S
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//  时间窗口期 10S
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") //  失败率6达到60%后跳闸
    })
    public String paymentCircuitBreaker(Integer id) {
        System.out.println(id);
        if( id < 0){
            throw  new RuntimeException("**** id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+ "\t" + "调用成功,流水号为: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(Integer id){
        return "id 不能为负数,请稍后再试o(╥﹏╥)o";
    }
}
