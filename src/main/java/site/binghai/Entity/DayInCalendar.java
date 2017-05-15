package site.binghai.Entity;

import java.util.List;

/**
 * Created by IceSea on 2017/5/10.
 * GitHub: https://github.com/IceSeaOnly
 * 日历中每天的表示元素
 */
public class DayInCalendar {
    private int day;
    private int leftOff;
    private int topOff;

    private int flagWordX;
    private int flagWordY;
    private int flagX;
    private int flagY;

    private int topEventLeft;
    private int topEventTop;


    public DayInCalendar(int day, int leftOff, int topOff, int flagWordX, int flagWordY, int flagX, int flagY,int tl,int tt) {
        this.day = day;
        this.leftOff = leftOff;
        this.topOff = topOff;
        this.flagWordX = flagWordX;
        this.flagWordY = flagWordY;
        this.flagX = flagX;
        this.flagY = flagY;
        this.topEventLeft = tl;
        this.topEventTop = tt;
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

    public int getTopEventLeft() {
        return topEventLeft;
    }

    public void setTopEventLeft(int topEventLeft) {
        this.topEventLeft = topEventLeft;
    }

    public int getTopEventTop() {
        return topEventTop;
    }

    public void setTopEventTop(int topEventTop) {
        this.topEventTop = topEventTop;
    }
}
