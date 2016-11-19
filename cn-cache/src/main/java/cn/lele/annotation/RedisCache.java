package cn.lele.annotation;

import cn.lele.constants.CacheCollection;
import cn.lele.constants.CacheConstants;

import java.lang.annotation.*;
import java.net.CacheRequest;

/**
 * 功能描述：
 * key 表示 redis中的key，表示一个缓存区域，如 用户信息，货币类型，店铺信息等。
 * fieldIndex : 缓存 的标识是第几个参数;
 * type: 缓存获取后 转化的类型。
 * expired: 过期时间(与key绑定)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
//Redis缓存 注解接口
public @interface RedisCache {
    /**
     * redis  中的key
     * */
    String key();

    /**
     * redis field 组合
     */
    int[] fieldIndex();

    /**
     * 缓存 转换bean
     */
    Class<?> type();

    /**
     * 过期时间,默认一天
     */
    int expired() default CacheConstants.ONE_DAY_S;

    /**
     * 缓存失效时,是否检查库
     */
    boolean ignoreDb() default false;

    /**
     *
     */
    CacheCollection collectionType() default CacheCollection.NONE;

}
