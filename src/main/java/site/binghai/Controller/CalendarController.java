package site.binghai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import site.binghai.Dao.FlagOfDayRepository;
import site.binghai.Entity.DayInCalendar;
import site.binghai.Entity.Event;
import site.binghai.Entity.FlagOfDay;
import site.binghai.Entity.User;
import site.binghai.Service.EventOfDayService;
import site.binghai.Service.FlagOfDayService;
import site.binghai.Utils.Month;
import site.binghai.Utils.ProduceCalendar;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Administrator on 2017/5/10.
 */
@Controller
public class CalendarController {
    @Autowired
    FlagOfDayService flagOfDayService;
    @Autowired
    EventOfDayService eventOfDayService;

    private static final int[] monthMap = {1,2,3,4,5,6,7,8,9,10,11,12};

    @RequestMapping("/")
    public String index(){
        return "index";
    }


    @RequestMapping("mycalendar")
    public String demo(@RequestParam int year, @RequestParam int month, Model model, HttpSession session){
        Calendar calendar = Calendar.getInstance();

        if(year >= 0 && month >= 0){
            year = year%2100;
            month = month%12;
        }else{
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH);
        }

        model.addAttribute("todayYear",calendar.get(Calendar.YEAR));
        model.addAttribute("todayMonth",calendar.get(Calendar.MONTH));

        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);

        ArrayList<DayInCalendar> arr = Month.makeMonthDays(new ProduceCalendar().produceCalendar(year,month));
        model.addAttribute("days", arr);
        model.addAttribute("curYear",year);
        model.addAttribute("curMonth",monthMap[month]);
        session.setAttribute("curYear",year);
        session.setAttribute("curMonth",month);

        calendar.add(Calendar.MONTH,1);
        model.addAttribute("nextYear",calendar.get(Calendar.YEAR));
        model.addAttribute("nextMonth",calendar.get(Calendar.MONTH));

        calendar.add(Calendar.MONTH,-2);
        model.addAttribute("lastYear",calendar.get(Calendar.YEAR));
        model.addAttribute("lastMonth",calendar.get(Calendar.MONTH));

        User user = (User) session.getAttribute("user");
        model.addAttribute("username",user.getName());
        // 添加本月所有标志
        model.addAttribute("flags",
                flagOfDayService.getMonthFlags(
                        user.getId(),
                        year,
                        monthMap[month]
                )
        );
        model.addAttribute("events",eventOfDayService.getMonthEvent(
                user.getId(),
                year,
                monthMap[month]
        ));
        return "main";
    }


    @RequestMapping("detail")
    public String detail(int type,int id,Model model,HttpSession session){
        User user = (User) session.getAttribute("user");
        if(type == 0){
            // 标志
            FlagOfDay flagOfDay = flagOfDayService.getFlagById(user.getId(),id);
            model.addAttribute("flag",flagOfDay);
            return "detailOfFlag";
        }else{
            // 事件
            List<Event> eventList = eventOfDayService.listEvent(user.getId(),id);
            if(eventList == null || eventList.size() == 0)
                return "emptyResult";
            model.addAttribute("events",eventList);
            return "detailOfEvent";
        }
    }
}
