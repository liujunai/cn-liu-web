package cn.lele.dao;

import java.util.List;

/**
 * Created by liu on 16-10-26.
 */
public interface LoginDao
{
    public List queryUser(String userName, String password);
}
