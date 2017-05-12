package site.binghai.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by IceSea on 2017/5/12.
 * GitHub: https://github.com/IceSeaOnly
 * 日历中日期右上角的标志
 */
@Entity
public class FlagOfDay {
    @Id
    @GeneratedValue
    private int id;
    private int userId;
    private String name;
    private Long time;
    private boolean available;

    public FlagOfDay(int userId, String name, Long time, boolean available) {
        this.userId = userId;
        this.name = name;
        this.time = time;
        this.available = available;
    }

    public FlagOfDay() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
