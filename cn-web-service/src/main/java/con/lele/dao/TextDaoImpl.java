package con.lele.dao;

import org.springframework.stereotype.Repository;
/**
 * Created by liu on 16-10-16.
 */

@Repository
public class TextDaoImpl implements TextDao {

    public String getData() {

        return "TextDao";
    }
}
