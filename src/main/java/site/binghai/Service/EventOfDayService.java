package site.binghai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.binghai.Dao.EventOfDayRepository;
import site.binghai.Entity.Event;
import site.binghai.Entity.FlagOfDay;
import site.binghai.Utils.TimeFormat;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by IceSea on 2017/5/15.
 * GitHub: https://github.com/IceSeaOnly
 */
@Service
public class EventOfDayService {

    @Autowired
    EventOfDayRepository eventOfDayRepository;

    public int countEventInDay(int id,Long ts) {
        System.out.println("ID="+id+",ts="+ts);
        Long rs = eventOfDayRepository.countByAvailableAndUserIdAndTime(true,id,ts);
        return rs.intValue();
    }

    public void save(Event event) {
        eventOfDayRepository.save(event);
    }

    public List<Event> getMonthEvent(int id, int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        int minDay = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        Long min = TimeFormat.data2Timestamp(year+"-"+month+"-"+minDay);
        Long max = TimeFormat.data2Timestamp(year+"-"+month+"-"+maxDay);
        List<Event> res = eventOfDayRepository.findByUserIdAndAvailableAndTimeBetween(id,true,min,max);
        for (int i = 0; i < res.size(); i++) {
            if(res.get(i).getIndexInDay() > 2){
                res.get(i).setTitle("+ 更多"+(res.get(i).getIndexInDay()-1)+"个");
            }
        }
        return res;
    }

    @Transactional
    public int delete(int uid,int eid){
        return eventOfDayRepository.deleteEvent(uid,eid);
    }

    public List<Event> listEvent(int uid, int eid) {
        Event event = eventOfDayRepository.findOne(eid);
        if(event == null) return null;
        if(event.getUserId() != uid || !event.isAvailable()) return null;
        List<Event> events = listEventOfDay(uid,event.getTime());
        for (int i = 0; i < events.size(); i++) {
            if(events.get(i).getId() == eid && events.size() > 3 && i > 2)
                return events;
        }
        ArrayList<Event> es = new ArrayList<>();
        es.add(event);
        return es;
    }

    public List<Event> listEventOfDay(int uid,long ts){
        return eventOfDayRepository.findByUserIdAndAvailableAndTime(uid,true,ts);
    }

    public void resetEventTop(int id, int eventId) {
        Event event = eventOfDayRepository.findOne(eventId);
        if(event == null || event.getUserId() != id) return;
        eventOfDayRepository.updateEventTop(id,event.getTime(),event.getIndexInDay());
        eventOfDayRepository.updateEventIndex(id,event.getTime(),event.getIndexInDay());
    }
}
