package com.imadiaos.common.redis;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class RedisKeyExpiredMessageDelegate implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] bytes) {
        if (RedisConstants.EVENT_CHANNEL.equalsIgnoreCase(new String(message.getChannel()))) {
            String msg = new String(message.getBody());

            String panelId = msg.replace(RedisConstants.EVENT_PANEL_PREFIX, "");

            System.out.println("清除到期面板数据：" + panelId);

        }
    }
}
