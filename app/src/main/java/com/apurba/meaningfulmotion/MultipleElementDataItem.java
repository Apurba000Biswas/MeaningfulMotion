package com.apurba.meaningfulmotion;

public class MultipleElementDataItem {

    private String name;
    private int imgID;

    public MultipleElementDataItem(String name, int imageID){
        this.name = name;
        this.imgID = imageID;
    }

    public String getName(){
        return name;
    }

    public int getImgID(){
        return imgID;
    }
}
