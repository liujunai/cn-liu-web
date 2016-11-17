package cn.lele.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by liu on 16-10-26.
 */
@Repository
public class LoginDaoImpl implements LoginDao
{
    Logger log = Logger.getLogger(this.getClass());

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List queryUser(String userName, String password) {

        log.info(userName);
        log.info(password);

        List list = jdbcTemplate.queryForList("SELECT userId,userName,Price FROM LOL WHERE userName=? AND userPassword=?", userName,password);
        return list;
    }
}
