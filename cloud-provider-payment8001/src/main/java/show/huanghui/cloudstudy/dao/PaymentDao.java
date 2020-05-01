package show.huanghui.cloudstudy.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import show.huanghui.cloudstudy.entities.Payment;

/**
 * @author guangtou
 * @create 2020--05--01--11:04
 */
@Mapper
public interface PaymentDao {

     int create(Payment payment);

     Payment getPaymentById(@Param("id") Long id);
}
