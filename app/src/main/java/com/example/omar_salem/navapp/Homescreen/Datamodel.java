package com.example.omar_salem.navapp.Homescreen;

/**
 * Created by Omar_Salem on 8/4/2017.
 */
public class Datamodel {

    private String head;
    private String descraption;
    private Integer img;
    private String imgStr;

    public Datamodel(String head, String descraption, Integer img) //this for my resours that i have in may drawable
    {
        this.head=head;
        this.descraption=descraption;
        this.img=img;


    }
    public Datamodel(String head, String descraption, String img) { //this for data that came form Jeson Array
        this.head=head;
        this.descraption=descraption;
        this.imgStr=img;


    }




    public String getHead() {
        return head;
    }



    public String getDescraption() {
        return descraption;
    }



    public Integer getImg() {
        return img;
    }
    public String getImgStr(){return imgStr;}

}
