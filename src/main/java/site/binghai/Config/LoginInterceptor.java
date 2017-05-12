package site.binghai.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import site.binghai.Interceptors.LoginInter;

/**
 * Created by IceSea on 2017/5/12.
 * GitHub: https://github.com/IceSeaOnly
 * 主体业务登录拦截器
 */
@Configuration
public class LoginInterceptor extends WebMvcConfigurerAdapter {

    @Bean
    public LoginInter loginInter(){
        return new LoginInter();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInter()).addPathPatterns("/mycalendar");
        super.addInterceptors(registry);
    }
}
