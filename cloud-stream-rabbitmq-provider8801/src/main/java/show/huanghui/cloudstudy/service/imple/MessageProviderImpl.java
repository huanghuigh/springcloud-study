package show.huanghui.cloudstudy.service.imple;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import show.huanghui.cloudstudy.service.IMessageProvider;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author guangtou
 * @create 2020--05--10--21:01
 */
// 信道channel和exchange绑定在一起,定义消息的推送管道
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output; // 消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("****serial:  "+ serial);
        return null;
    }
}
