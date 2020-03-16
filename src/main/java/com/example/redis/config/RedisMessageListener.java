package com.example.redis.config;

import com.example.redis.entity.RedPackage;
import com.example.redis.service.RedPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * Created by lw on 2020/3/13
 * redisx消息监听器
 * 获取redis中消息并处理
 *
 * @author lw
 */
@Component
public class RedisMessageListener implements MessageListener {


    @Autowired
    RedPackageService redPackageService;

    /**
     * 处理消息
     *
     * @param message 完整 的消息 (频道信息  消息的具体内容)
     * @param bytes   获取的频道信息
     */
    @Override
    public void onMessage(Message message, byte[] bytes) {
        String key = new String(message.getBody());
        if (key.startsWith("red")) {
            String packageId = key.split(":")[1];
            RedPackage redPackage = redPackageService.getRedPackage(packageId);
            redPackage.packageStatus = "outtime";
            Integer num = redPackageService.updateRedPackage(redPackage);

        }
    }
}
