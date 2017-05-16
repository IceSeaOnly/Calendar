package site.binghai.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by IceSea on 2017/5/15.
 * GitHub: https://github.com/IceSeaOnly
 */
@Entity
public class Event {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String content;
    private long time;
    private Date addTime;
    private int userId;
    private String color;
    private String onColor;
    private int x;
    private int y;
    private int indexInDay;
    private String foo;
    private boolean available;

    public Event(String title, String content, long time, int userId, String color,String onColor, int x, int y,String f,int indexInDay) {
        this.onColor = onColor;
        this.title = title;
        this.content = content;
        this.time = time;
        this.addTime = new Date(System.currentTimeMillis());
        this.userId = userId;
        this.color = color;
        this.x = x;
        this.y = y;
        this.foo = f;
        this.indexInDay = indexInDay;
        this.available = true;
    }

    public Event() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public int getIndexInDay() {
        return indexInDay;
    }

    public void setIndexInDay(int indexInDay) {
        this.indexInDay = indexInDay;
    }

    public String getOnColor() {
        return onColor;
    }

    public void setOnColor(String onColor) {
        this.onColor = onColor;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
