package site.binghai.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import site.binghai.Entity.User;

import java.util.List;

/**
 * Created by IceSea on 2017/5/12.
 * GitHub: https://github.com/IceSeaOnly
 * 用户数据访问接口
 */
public interface UserRepository extends JpaRepository<User,Integer>{
    public List<User> findByPhoneAndPassword(String phone,String password);
    public Long countByPhone(String phone);
}
