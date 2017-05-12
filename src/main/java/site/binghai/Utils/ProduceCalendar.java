package site.binghai.Utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.text.DateFormatSymbols;
import java.util.Calendar;

/**
 * 产生日期二维表
 */

public class ProduceCalendar {
    private static final int[] week = {0,7,1,2,3,4,5,6};
    public int[][] produceCalendar(int year,int month){
        Calendar calendar = Calendar.getInstance();
        if(year > 0)
            calendar.set(Calendar.YEAR,year);
        if(month > 0)
            calendar.set(Calendar.MONTH,month);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        int firstDayOfMonthInWeek = week[calendar.get(Calendar.DAY_OF_WEEK)];
        int daysOfThisMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int[][] days = new int[6][7];
        int day = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = (i == 0?firstDayOfMonthInWeek-1:0); j < 7 && day <= daysOfThisMonth; j++) {
                days[i][j] = day++;
            }
        }
        for (int i = 0; i < 7; i++) {
            if(days[5][i] != 0){
                days[0][i] = days[5][i];
                days[5][i] = 0;
            }
        }
        return days;
    }
}
