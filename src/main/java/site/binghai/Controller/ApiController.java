package site.binghai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.binghai.Entity.DayInCalendar;
import site.binghai.Entity.Event;
import site.binghai.Entity.FlagOfDay;
import site.binghai.Entity.User;
import site.binghai.Service.EventOfDayService;
import site.binghai.Service.FlagOfDayService;
import site.binghai.Utils.Colors;
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
    @Autowired
    EventOfDayService eventOfDayService;

    @RequestMapping(value = "addFlag",method = RequestMethod.POST)
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

    @RequestMapping(value = "addEvent",method = RequestMethod.POST)
    public String addEvent(@RequestParam int date,@RequestParam int color,
                           @RequestParam String name,
                           @RequestParam String content,
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
        int size = eventOfDayService.countEventInDay(user.getId(),ts);
        int ex = day.getTopEventLeft();
        int ey = day.getTopEventTop()+(size>=2?2:size)*20;
        String type = (size>2?"hide":"show");
        eventOfDayService.save(
                new Event(
                        name,
                        content,
                        ts,user.getId(),
                        Colors.colors[color][0],
                        Colors.colors[color][1]
                        ,ex,ey,type,size));
        return "success";
    }

    @RequestMapping("deleteFlag")
    public String deleteFlag(@RequestParam int fid,HttpSession session){
        User user = (User) session.getAttribute("user");
        flagOfDayService.delete(user.getId(),fid);
        return "success";
    }

    @RequestMapping("shouldReload")
    public String shouldReload(HttpSession session){
        Object o = session.getAttribute("shouldReload");
        if(o == null) return "false";
        int shouldReload = (int)o;
        if(shouldReload < 1)
            return "false";
        session.setAttribute("shouldReload",0);
        return "true";
    }

    @RequestMapping("deleteEvent")
    public String deleteEvent(@RequestParam int id,HttpSession session){
        User user = (User) session.getAttribute("user");
        int r = eventOfDayService.delete(user.getId(),id);
        if(r > 0){
            session.setAttribute("shouldReload",1);
            eventOfDayService.resetEventTop(user.getId(),id);
        }
        return r > 0 ?"success":"false";
    }
}
