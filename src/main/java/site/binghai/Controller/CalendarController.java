package site.binghai.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import site.binghai.Dao.FlagOfDayRepository;
import site.binghai.Entity.Month;
import site.binghai.Utils.ProduceCalendar;

import java.util.Calendar;

/**
 * Created by Administrator on 2017/5/10.
 */
@Controller
public class CalendarController {
    @Autowired
    FlagOfDayRepository flagOfDayRepository;

    private static final int[] monthMap = {1,2,3,4,5,6,7,8,9,10,11,12};

    @RequestMapping("/")
    public String index(){
        return "index";
    }


    @RequestMapping("mycalendar")
    public String demo(@RequestParam int year,@RequestParam int month, Model model){
        Calendar calendar = Calendar.getInstance();

        if(year > 0 && month > 0){
            year = year%2100;
            month = month%12;
        }else{
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH)+1;
        }

        model.addAttribute("todayYear",calendar.get(Calendar.YEAR));
        model.addAttribute("todayMonth",calendar.get(Calendar.MONTH));

        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);

        model.addAttribute("days", Month.makeMonthDays(new ProduceCalendar().produceCalendar(year,month)));
        model.addAttribute("curYear",calendar.get(Calendar.YEAR));
        model.addAttribute("curMonth",monthMap[calendar.get(Calendar.MONTH)]);

        calendar.add(Calendar.MONTH,1);
        model.addAttribute("nextYear",calendar.get(Calendar.YEAR));
        model.addAttribute("nextMonth",calendar.get(Calendar.MONTH));

        calendar.add(Calendar.MONTH,-2);
        model.addAttribute("lastYear",calendar.get(Calendar.YEAR));
        model.addAttribute("lastMonth",calendar.get(Calendar.MONTH));
        return "demo";
    }
}
