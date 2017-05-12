package site.binghai.Entity;

import java.util.ArrayList;

/**
 * Created by IceSea on 2017/5/10.
 * GitHub: https://github.com/IceSeaOnly
 */
public class Month {
    public static final int[] leftOff = {132,282,432,582,732,882,1032};
    public static final int[] topOff = {240,350,460,570,680,790};

    public static final int[] flagXoff = {202,341,449,562,671};

    /**
     * 用来生成一个月的日子
     * */
    public static ArrayList<DayInCalendar> makeMonthDays(int[][] days){
        ArrayList<DayInCalendar> res = new ArrayList<>();

        for (int i = 0; i < days.length; i++) {
            for (int j = 0; j < days[i].length; j++) {
                if(days[i][j] != 0){
                    res.add(
                            new DayInCalendar(
                                    days[i][j],
                                    leftOff[j],
                                    topOff[i],
                                    flagXoff[j]+10,
                                    leftOff[j]+55,
                                    flagXoff[j],
                                    leftOff[j]+52));
                }
            }
        }

        return res;
    }
}
