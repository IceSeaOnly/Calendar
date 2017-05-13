package site.binghai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.binghai.Entity.DayInCalendar;
import site.binghai.Entity.FlagOfDay;
import site.binghai.Entity.User;
import site.binghai.Service.FlagOfDayService;
import site.binghai.Utils.Month;
import site.binghai.Utils.TimeFormat;

import javax.servlet.http.HttpSession;

import static site.binghai.Utils.FormatValidate.noEmptyOrNull;

/**
 * Created by IceSea on 2017/5/12.
 * GitHub: https://github.com/IceSeaOnly
 * api接口
 */
@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
    FlagOfDayService flagOfDayService;

    @RequestMapping("addFlag")
    public String addFlag(@RequestParam int date,
                          @RequestParam String name,
                          HttpSession session){
        if(!noEmptyOrNull(name))
            return "数据格式错误!";
        int y = (int) session.getAttribute("curYear");
        int m = (int) session.getAttribute("curMonth");
        DayInCalendar day = Month.getDay(y,m,date);
        if(day == null)
            return "非法数据输入!";
        Long ts = TimeFormat.data2Timestamp(y+"-"+(m+1)+"-"+date);
        User user = (User) session.getAttribute("user");
        flagOfDayService.save(new FlagOfDay(
                user.getId(),
                name,
                ts,
                day.getFlagWordX(),day.getFlagWordY(),
                day.getFlagX(),day.getFlagY(),true));
        return "success";
    }
}
