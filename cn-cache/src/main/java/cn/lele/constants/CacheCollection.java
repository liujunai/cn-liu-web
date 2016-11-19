package cn.lele.constants;

import java.util.List;
import java.util.Set;

/**
 * Created by liu on 16-11-18.
 */
//缓存的集合
public enum  CacheCollection {

    NONE(null),

    LIST(List.class),

    SET(Set.class);

    private Class<?> type;

    CacheCollection(Class<?> type)
    {
        this.setType(type);
    }

    public Class<?> getType()
    {
        return type;
    }

    public void setType(Class<?> type)
    {
        this.type = type;
    }
}
