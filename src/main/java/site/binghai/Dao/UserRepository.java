package site.binghai.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import site.binghai.Entity.User;

/**
 * Created by IceSea on 2017/5/12.
 * GitHub: https://github.com/IceSeaOnly
 * 用户数据访问接口
 */
public interface UserRepository extends JpaRepository<User,Integer>{

}
