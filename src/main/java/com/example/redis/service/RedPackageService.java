package com.example.redis.service;

import com.example.redis.dao.RedPackageDao;
import com.example.redis.entity.RedPackage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by lw on 2020/3/13
 *
 * @author lw
 */
@Service
@Slf4j
public class RedPackageService {
    @Autowired
    RedPackageDao redPackageDao;

    @Autowired
    RedisTemplate redisTemplate;

    public Integer grantRedPackage(RedPackage redPackage,RedPackage redPackage2) {
        redPackage.packageId = UUID.randomUUID().toString();
        redPackage2.packageId = UUID.randomUUID().toString();
        Integer num = redPackageDao.grantRedPackage(redPackage);
        Integer num2 = redPackageDao.grantRedPackage(redPackage2);
        //存入redis
        try {
            redisTemplate.opsForValue().set("red:" + redPackage.packageId, redPackage.packageId, redPackage.validTime, TimeUnit.MINUTES);
            redisTemplate.opsForValue().set("red:" + redPackage2.packageId, redPackage2.packageId, redPackage2.validTime, TimeUnit.MINUTES);
        } catch (Exception e) {
            log.error("redis存除数据错误{}", redPackage.packageId);
            return 0;
        }
        return num;
    }


    public Integer updateRedPackage(RedPackage redPackage) {

        return redPackageDao.updateRedPackage(redPackage);
    }


    public RedPackage getRedPackage(String packageId) {
        return redPackageDao.getRedPackage(packageId);
    }
}
