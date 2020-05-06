package show.huanghui.cloudstudy.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author guangtou
 * @create 2020--05--05--18:04
 */
public interface PaymentService {
    String paymentInfo_OK(Integer id);

    String paymentInfo_TimeOut(Integer id );

    String paymentInfo_TimeOutHandle(Integer id);

    /**
     * 服务熔断事例
     * @param id
     * @return
     */
    String paymentCircuitBreaker(Integer id);
}
