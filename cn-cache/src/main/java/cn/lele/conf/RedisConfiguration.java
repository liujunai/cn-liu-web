package cn.lele.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


/**
 * redis链接配置
 */
//redis的配置
@Configuration
public class RedisConfiguration
{
    @Value("${redis.maxIdle}")
    private int aaa;
}
