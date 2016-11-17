package con.lele.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liu on 16-10-16.
 */
@Controller
public class TextController {

    @RequestMapping("/index.html")
    public String text(){
        return "index";
    }
}
