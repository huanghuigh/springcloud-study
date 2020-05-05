package show.huanghui.cloudstudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import show.huanghui.cloudstudy.entities.CommonResult;
import show.huanghui.cloudstudy.entities.Payment;
import show.huanghui.cloudstudy.show.huanghui.cloud.lb.LoadBalancer;

import javax.annotation.Resource;
import java.net.URI;
import java.net.URL;
import java.util.List;

/**
 * @author guangtou
 * @create 2020--05--01--15:14
 */
@RestController
@Slf4j
public class OrderController { // 模拟用户模块
//    public static final String PAYMENT_URL ="http://CLOUD-PAYMENT-SERVICE";
    public static final String PAYMENT_URL ="http://CLOUD-PAYMENT-SERVICE"; // 通过服务名称进行调用
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;


    @GetMapping("/consumer/payment/create") // 订单新增
    public CommonResult<Payment> create(Payment payment){
//        restTemplate在发送数据的时候,将对象转成了json格式,因此收数据的时候需要@requestBody
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}") // 订单查询
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
//        getForObject,返回对象为响应体中数据转化成的对象(json)
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/getEntity/{id}") // 订单查询
    public CommonResult<Payment> getPaymentById2(@PathVariable("id") Long id){
//         getForEntity返回对象为ResponseEntity,包含了响应中的一些重要信息,比如响应头,状态码等.
         ResponseEntity<CommonResult> entity =  restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
         if(entity.getStatusCode().is2xxSuccessful()){
             log.info(entity.getStatusCode().toString() + "\t" + entity.getHeaders());
            return entity.getBody();
         }else{
             return new CommonResult<>(444,"信息错误",null);
         }
    }
    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
//        获取所有服务
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size() == 0){
            return null;
        }else{
//            传入所有服务
            ServiceInstance serviceInstance = loadBalancer.instances(instances);
//            获取uri
            URI uri = serviceInstance.getUri();
            return restTemplate.getForObject(uri+"/payment/lb",String.class);
        }
    }
}
