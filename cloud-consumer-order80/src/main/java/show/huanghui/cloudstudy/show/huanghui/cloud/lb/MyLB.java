package show.huanghui.cloudstudy.show.huanghui.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author guangtou
 * @create 2020--05--04--23:49
 */
@Component // 注入配置类
public class MyLB implements LoadBalancer{
    // 原子类Integer,用于并发情况下保证数据
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 传入所有服务,返回轮询到的服务
     * @param serviceInstances
     * @return
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        // 使用的服务为 访问次数 % 总服务数
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);


    }
//  获取访问次数
    public final int getAndIncrement(){
        int current ; //当前次数
        int next; // 下一个
        for (;;){
            current = this.atomicInteger.get();
            next = current == Integer.MAX_VALUE?0:current+1;
//            如果此数据没有被修改,则跳出
            if (this.atomicInteger.compareAndSet(current,next)){
                break;
            }
        }
        System.out.println("******访问次数 next:"+next);
        return next;
    }
}
