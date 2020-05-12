package show.huanghui.cloudstudy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author guangtou
 * @create 2020--05--10--23:12
 */
@Component
@EnableBinding(Sink.class) // 消费
public class ReceiverMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者1号,------收到的消息为:  "+ message.getPayload() + "\t  port: " +serverPort);
    }
}
