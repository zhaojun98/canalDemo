package com.yl.common;

/**
 * @author ：jerry
 * @date ：Created in 2022/1/7 15:03
 * @description：MQ消息监听
 * @version: V1.1
 */
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yl.entity.CanalMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 监听MQ获取Canal增量的数据消息
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class CanalRabbitMQListener {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(value = "canal.queue", durable = "true"),
                    exchange = @Exchange(value = "canal.exchange"),
                    key = "canal.routing.key"
            )
    })
    public void handleDataChange(String message) {
        //将message转换为CanalMessage
        CanalMessage canalMessage = JSON.toJavaObject(JSONObject.parseObject(message), CanalMessage.class);
//        CanalMessage canalMessage = JSONUtil.toBean(message, CanalMessage.class);
        String tableName = canalMessage.getTable();
        log.info("Canal 监听 {} 发生变化；明细：{}", tableName, message);
        //TODO 业务逻辑自己完善...............
    }
}
