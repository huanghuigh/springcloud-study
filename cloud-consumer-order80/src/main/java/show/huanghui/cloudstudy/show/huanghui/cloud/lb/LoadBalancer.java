package show.huanghui.cloudstudy.show.huanghui.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author guangtou
 * @create 2020--05--04--23:48
 */
public interface LoadBalancer {
    /**
     * 传入所有服务,返回轮询到的服务
     * @param serviceInstances
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
