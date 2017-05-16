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
    public long countByUserIdAndTime(int id,long ts);
    public List<Event> findByUserIdAndAvailableAndTimeBetween(int userid,boolean b,long min, long max);

    @Modifying
    @Transactional
    @Query("update Event set available=false where userId=?1 and id=?2")
    public int deleteEvent(int uid,int eid);
}
