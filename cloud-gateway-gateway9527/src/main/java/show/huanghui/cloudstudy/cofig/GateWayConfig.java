package show.huanghui.cloudstudy.cofig;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guangtou
 * @create 2020--05--07--23:14
 * 编码配置网关
 */
@Configuration
public class GateWayConfig {

    /**
     * 配置了一个id为path_route_baidu的路由规则
     * 当访问http://localost:9527/baidu就会自动跳转到百度首页
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customRouterLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_baidu", r -> r.path("/baidu")
                .uri("https://www.baidu.com")).build();
        return routes.build();
    }
}
