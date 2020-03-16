package com.example.redis.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by lw on 2020/3/13
 *
 * @author lw
 */
@Data
public class RedPackage {
    public String packageId;
    public String packageName;
    public BigDecimal packageValue;
    public String packageStatus;
    public long validTime;
    public Date exprieTime;
    public Date createTime;
    public Date updateTime;
}
