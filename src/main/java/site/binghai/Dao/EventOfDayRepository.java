package site.binghai.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import site.binghai.Entity.Event;

import java.util.List;

/**
 * Created by IceSea on 2017/5/15.
 * GitHub: https://github.com/IceSeaOnly
 */
public interface EventOfDayRepository extends JpaRepository<Event,Integer>{
    public long countByUserIdAndTime(int id,long ts);
    public List<Event> findByUserIdAndTimeBetween(int userid, long min, long max);
}
