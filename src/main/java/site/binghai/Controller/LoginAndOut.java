package site.binghai.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import site.binghai.Utils.MD5;

import javax.servlet.http.HttpSession;

/**
 * Created by IceSea on 2017/5/12.
 * GitHub: https://github.com/IceSeaOnly
 * 登入登出接口
 */
@Controller
public class LoginAndOut {
    @RequestMapping("login")
    public String login(HttpSession session){
        session.setAttribute("_validate", MD5.encryption(System.currentTimeMillis()+""));
        return "login";
    }
    @RequestMapping("reg")
    public String reg(HttpSession session){
        session.setAttribute("_validate", MD5.encryption(System.currentTimeMillis()+""));
        return "reg";
    }
}
