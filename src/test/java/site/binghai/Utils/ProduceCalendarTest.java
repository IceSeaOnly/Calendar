package site.binghai.Utils;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/5/10.
 */
public class ProduceCalendarTest {

    @Test
    public void produceCalendar() throws Exception {
        new ProduceCalendar().produceCalendar(2017,5);
    }

}