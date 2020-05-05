package show.huanghui.cloudstudy.show.huanghui.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guangtou
 * @create 2020--05--04--14:00
 */
@Configuration
public class MyselfRule { // ribbon负载规则替换

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
