package site.binghai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.binghai.Dao.UserRepository;

/**
 * Created by IceSea on 2017/5/12.
 * GitHub: https://github.com/IceSeaOnly
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

}
