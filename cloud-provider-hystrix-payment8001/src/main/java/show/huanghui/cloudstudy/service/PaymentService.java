package show.huanghui.cloudstudy.service;

/**
 * @author guangtou
 * @create 2020--05--05--18:04
 */
public interface PaymentService {
    String paymentInfo_OK(Integer id);

    String paymentInfo_TimeOut(Integer id );

    String paymentInfo_TimeOutHandle(Integer id);
}
