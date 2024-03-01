package com.example.veritabani;

public class Notlar {

    private String notId,notIcerigi;

    Notlar(String notId, String notIcerigi){
        this.notId=notId;
        this.notIcerigi=notIcerigi;
    }

    public String getNotId() {
        return notId;
    }

    public void setNotId(String notId) {
        this.notId = notId;
    }
    public String getNotIcerik() {
        return notIcerigi;
    }

    public void setNotIcerik(String notIcerik) {
        this.notIcerigi = notIcerik;
    }
}
