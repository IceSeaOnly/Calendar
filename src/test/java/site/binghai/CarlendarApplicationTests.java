package site.binghai;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import site.binghai.Utils.TimeFormat;

import java.util.Calendar;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class CarlendarApplicationTests {

	@Test
	public void contextLoads() {

	}

	@Test
	public void test(){
		System.out.println(TimeFormat.format(1492444800000L));
	}

}
