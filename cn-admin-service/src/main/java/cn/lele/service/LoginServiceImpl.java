package cn.lele.service;


import cn.lele.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liu on 16-10-26.
 */
@Service
public class LoginServiceImpl implements LoginService
{
    @Autowired
    LoginDao loginDao;

    public int queryUser(String userName, String password) {
        List list = loginDao.queryUser(userName,password);
        if (list !=null && list.size() > 0){
            return 1000;
        }else {
            return 5000;
        }
    }
}
