package show.huanghui.cloudstudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import show.huanghui.cloudstudy.entities.CommonResult;
import show.huanghui.cloudstudy.entities.Payment;
import show.huanghui.cloudstudy.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author guangtou
 * @create 2020--05--01--11:33
 */
@RestController
@Slf4j
public class PaymentController { // 模拟支付/订单模块

    @Resource
    private PaymentService paymentService;
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
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果为:"+payment);
        if(payment != null){
            return new CommonResult(200,"查询成功,来自:"+serverPort,payment);
        }else{
            return new CommonResult(400,"没有对应记录",null);
        }
    }

}
