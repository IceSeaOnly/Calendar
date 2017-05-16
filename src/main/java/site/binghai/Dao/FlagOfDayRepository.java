package site.binghai.Dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import site.binghai.Entity.FlagOfDay;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by IceSea on 2017/5/12.
 * GitHub: https://github.com/IceSeaOnly
 */
public interface FlagOfDayRepository extends JpaRepository<FlagOfDay,Integer> {
    public List<FlagOfDay> findByUserIdAndAvailableAndTimeBetween(int userid,boolean b,long s,long e);

    @Modifying
    @Transactional
    @Query("update FlagOfDay set available =false where userId=?1 and id = ?2")
    public int deleteFlag(int uid,int fid);
}
