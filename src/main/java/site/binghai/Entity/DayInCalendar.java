package site.binghai.Entity;

/**
 * Created by IceSea on 2017/5/10.
 * GitHub: https://github.com/IceSeaOnly
 * 日历中每天的表示元素
 */
public class DayInCalendar {
    int day;
    int leftOff;
    int topOff;

    int flagWordX;
    int flagWordY;
    int flagX;
    int flagY;

    public DayInCalendar(int day, int leftOff, int topOff, int flagWordX, int flagWordY, int flagX, int flagY) {
        this.day = day;
        this.leftOff = leftOff;
        this.topOff = topOff;
        this.flagWordX = flagWordX;
        this.flagWordY = flagWordY;
        this.flagX = flagX;
        this.flagY = flagY;
    }

    public DayInCalendar() {
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getLeftOff() {
        return leftOff;
    }

    public void setLeftOff(int leftOff) {
        this.leftOff = leftOff;
    }

    public int getTopOff() {
        return topOff;
    }

    public void setTopOff(int topOff) {
        this.topOff = topOff;
    }

    public int getFlagX() {
        return flagX;
    }

    public void setFlagX(int flagX) {
        this.flagX = flagX;
    }

    public int getFlagY() {
        return flagY;
    }

    public void setFlagY(int flagY) {
        this.flagY = flagY;
    }

    public int getFlagWordX() {
        return flagWordX;
    }

    public void setFlagWordX(int flagWordX) {
        this.flagWordX = flagWordX;
    }

    public int getFlagWordY() {
        return flagWordY;
    }

    public void setFlagWordY(int flagWordY) {
        this.flagWordY = flagWordY;
    }
}
