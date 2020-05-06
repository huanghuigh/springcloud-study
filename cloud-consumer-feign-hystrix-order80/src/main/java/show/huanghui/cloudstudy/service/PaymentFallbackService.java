package show.huanghui.cloudstudy.service;

import org.springframework.stereotype.Component;

/**
 * @author guangtou
 * @create 2020--05--06--13:35
 * 用户Hystrix服务降级fallback方法
 */
@Component
public class PaymentFallbackService implements  PaymentHystrixService
{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService  Fallback   paymentInfo_OK o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----paymentInfo_TimeOut  Fallback   paymentInfo_OK o(╥﹏╥)o";

    }
}
