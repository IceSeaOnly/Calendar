package site.binghai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.binghai.Dao.FlagOfDayRepository;
import site.binghai.Entity.DayInCalendar;
import site.binghai.Entity.FlagOfDay;
import site.binghai.Utils.TimeFormat;

import javax.transaction.Transactional;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by IceSea on 2017/5/12.
 * GitHub: https://github.com/IceSeaOnly
 */
@Service
public class FlagOfDayService {
    @Autowired
    private FlagOfDayRepository flagOfDayRepository;

    public void save(FlagOfDay flagOfDay) {
        flagOfDayRepository.save(flagOfDay);
    }


    public List<FlagOfDay> getMonthFlags(int uid, int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        int minDay = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        Long min = TimeFormat.data2Timestamp(year+"-"+month+"-"+minDay);
        Long max = TimeFormat.data2Timestamp(year+"-"+month+"-"+maxDay);
        List<FlagOfDay> res = flagOfDayRepository.findByUserIdAndAvailableAndAddTimeBetween(uid,true,min,max);
        return res;
    }

    public FlagOfDay getFlagById(int id) {
        return flagOfDayRepository.getOne(id);
    }

    @Transactional
    public void delete(int id, int fid) {
        flagOfDayRepository.deleteFlag(id,fid);
    }
}
