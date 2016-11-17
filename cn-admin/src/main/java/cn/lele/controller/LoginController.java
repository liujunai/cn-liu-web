package cn.lele.controller;

import com.google.gson.Gson;
import cn.lele.bean.LoginBean;
import cn.lele.service.LoginService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

/**
 * Created by liu on 16-10-26.
 */
@Controller
@RequestMapping(value="login")
public class LoginController
{

    Logger log = Logger.getLogger(this.getClass());

    @Autowired
    LoginService loginService;

    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    public Object execLogin(@RequestBody String jsonInput) throws SQLException
    {
        log.info(jsonInput);

        Gson g = new Gson();

        LoginBean login =  g.fromJson(jsonInput, LoginBean.class);

        if(login != null)
        {
            int code = loginService.queryUser(login.getName(),login.getPassword());
            return code;
        }


        return "5000";
    }
}
