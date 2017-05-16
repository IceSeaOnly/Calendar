package site.binghai.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import site.binghai.Entity.Event;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by IceSea on 2017/5/15.
 * GitHub: https://github.com/IceSeaOnly
 */
public interface EventOfDayRepository extends JpaRepository<Event,Integer>{
    public long countByAvailableAndUserIdAndTime(boolean b,int id,long ts);
    public List<Event> findByUserIdAndAvailableAndTimeBetween(int userid,boolean b,long min, long max);

    @Modifying
    @Transactional
    @Query("update Event set available=false where userId=?1 and id=?2")
    public int deleteEvent(int uid,int eid);

    public List<Event> findByUserIdAndAvailableAndTime(int uid,boolean b,long ts);

    @Modifying
    @Transactional
    @Query("update Event set indexInDay=indexInDay-1 where userId=?1 and time=?2 and indexInDay >?3")
    public int updateEventTop(int uid,long ts,int index);


    @Modifying
    @Transactional
    @Query("update Event set y=y-20 where userId=?1 and time=?2 and indexInDay >= ?3 and indexInDay < 2")
    public int updateEventIndex(int uid,long ts,int oindex);
}
