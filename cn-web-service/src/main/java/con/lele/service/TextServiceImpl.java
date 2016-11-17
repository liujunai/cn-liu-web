package con.lele.service;

import con.lele.dao.TextDao;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
/**
 * Created by liu on 16-10-16.
 */
@Service
public class TextServiceImpl implements TextService{

    @Resource
    TextDao textDao;

    public String mockTest() {
        return "text test";
    }

    public String getData() {

        String dao = textDao.getData();
        return dao;
    }
}
