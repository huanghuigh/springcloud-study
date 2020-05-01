package show.huanghui.cloudstudy.service.impl;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import show.huanghui.cloudstudy.dao.PaymentDao;
import show.huanghui.cloudstudy.entities.Payment;
import show.huanghui.cloudstudy.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author guangtou
 * @create 2020--05--01--11:31
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
