package show.huanghui.cloudstudy.service;

import org.apache.ibatis.annotations.Param;
import show.huanghui.cloudstudy.entities.Payment;

/**
 * @author guangtou
 * @create 2020--05--01--11:30
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
