package com.sc.po;

public class VipCard {
    private int cid;
    private String name;
    private String password;
    private String card;
    private int point;
    private String cdate;
    private int pid;

    public VipCard() {
        
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public VipCard(int cid, String name, String password, String card, int point, String cdate, int pid) {
        this.cid = cid;
        this.name = name;
        this.password = password;
        this.card = card;
        this.point = point;
        this.cdate = cdate;
        this.pid = pid;
    }
}
