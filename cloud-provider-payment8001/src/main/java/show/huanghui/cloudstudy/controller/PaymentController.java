package show.huanghui.cloudstudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import show.huanghui.cloudstudy.entities.CommonResult;
import show.huanghui.cloudstudy.entities.Payment;
import show.huanghui.cloudstudy.service.PaymentService;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author guangtou
 * @create 2020--05--01--11:33
 */
@RestController
@Slf4j
public class PaymentController { // 模拟支付/订单模块

    @Resource
    private PaymentService paymentService;
    @Resource
    private DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")     // 订单新增
    public CommonResult create(@RequestBody Payment payment){ //@RequestBody用于接收json格式数据
        int result = paymentService.create(payment);
        log.info("****插入结果:"+result);
        if (result >0){
            return new CommonResult(200,"插入成功,来自:"+serverPort,result);
        }else{
            return new CommonResult(400,"插入失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")    // 订单查询
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果为:"+payment);
        if(payment != null){
            return new CommonResult(200,"查询成功,来自:"+serverPort,payment);
        }else{
            return new CommonResult(400,"没有对应记录",null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        // 获取所有注册名称
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("****"+element);
        }
        // 获取注册名称的信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;

    }
//    测试自己写的ribbon负载规则
    @GetMapping(value = "/payment/lb")
    public String getPayment(){
        return serverPort;
    }
    //    测试Feign超时设置
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
//        延迟3S
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }


}
