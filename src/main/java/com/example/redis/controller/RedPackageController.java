package com.example.redis.controller;

import com.example.redis.entity.RedPackage;
import com.example.redis.service.RedPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by lw on 2020/3/13
 *
 * @author lw
 */
@RestController
@RequestMapping("/redpackage")
public class RedPackageController {
    @Autowired
    RedPackageService redPackageService;

    @GetMapping("/add")
    public Integer grantRedPackage() {
        RedPackage redPackage = new RedPackage();
        RedPackage redPackage2 = new RedPackage();
        redPackage.packageName = "红包test";
        redPackage.packageStatus = "unused";
        redPackage.validTime = 1;//2分钟失效
        redPackage.packageValue = new BigDecimal(2);
        Date now = new Date();
        redPackage.createTime = now;
        redPackage.exprieTime = new Date(now.getTime() + (redPackage.validTime * 60000));

        redPackage2.packageName = "红包test2";
        redPackage2.packageStatus = "unused";
        redPackage2.validTime = 1;//2分钟失效
        redPackage2.packageValue = new BigDecimal(2);
        redPackage2.createTime = now;
        redPackage2.exprieTime = new Date(now.getTime() + (redPackage.validTime * 60000));
        return redPackageService.grantRedPackage(redPackage,redPackage2);
    }
}
