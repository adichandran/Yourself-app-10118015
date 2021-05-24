package com.adichandra.yourselfapp.model;

/*
 * NIM   : 10118015
 * NAMA  : Adi Chandra Nugraha
 * KELAS : IF1
 * TGL   : 22/05/2021
 * Deskripsi : Membuat modelApp dan membuat constructor, getter dan setter
 * */

public class modelApp {

    private String[] dailyAct;
    private String[] friendAct;
    private int[] imgDaily;
    private int[] imgFriend;
    private int[] imgGallery;
    private String[] musicAct;

    public String[] getFriendAct() {
        return friendAct;
    }

    public void setFriendAct(String[] friendAct) {
        this.friendAct = friendAct;
    }

    public int[] getImgFriend() {
        return imgFriend;
    }

    public void setImgFriend(int[] imgFriend) {
        this.imgFriend = imgFriend;
    }

    public String[] getDailyAct() {
        return dailyAct;
    }

    public void setDailyAct(String[] dailyAct) {
        this.dailyAct = dailyAct;
    }

    public int[] getImgDaily() {
        return imgDaily;
    }

    public void setImgDaily(int[] imgDaily) {
        this.imgDaily = imgDaily;
    }

    public int[] getImgGallery() {
        return imgGallery;
    }

    public void setImgGallery(int[] imgGallery) {
        this.imgGallery = imgGallery;
    }

    public String[] getMusicAct() {
        return musicAct;
    }

    public void setMusicAct(String[] musicAct) {
        this.musicAct = musicAct;
    }
}
