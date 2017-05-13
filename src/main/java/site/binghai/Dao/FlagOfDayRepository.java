package site.binghai.Dao;
import org.springframework.data.jpa.repository.JpaRepository;
import site.binghai.Entity.FlagOfDay;

import java.util.List;

/**
 * Created by IceSea on 2017/5/12.
 * GitHub: https://github.com/IceSeaOnly
 */
public interface FlagOfDayRepository extends JpaRepository<FlagOfDay,Integer> {
    public List<FlagOfDay> findByUserIdAndTimeBetween(int userid,long s,long e);
}
