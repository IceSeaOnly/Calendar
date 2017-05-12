package site.binghai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.binghai.Dao.UserRepository;
import site.binghai.Entity.User;
import site.binghai.Utils.MD5;

import java.util.List;

/**
 * Created by IceSea on 2017/5/12.
 * GitHub: https://github.com/IceSeaOnly
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User validate(String phone, String password) {
        List<User> ls = userRepository.findByPhoneAndPassword(phone,MD5.encryption(password));
        if(ls.size() == 0) return null;
        return ls.get(0);
    }

    public boolean userExist(String phone) {
        return userRepository.countByPhone(phone) > 0;
    }

    public void addUser(String username, String phone, String password) {
        userRepository.save(new User(username,phone, MD5.encryption(password)));
    }
}
