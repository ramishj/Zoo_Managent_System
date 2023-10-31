package org.example;

import java.util.ArrayList;

public class FeedBack{
    public static ArrayList<FeedBack> Feeds = new ArrayList<>();
    public String FeedBack1;
    public String Name;
    public FeedBack(String Name,String FeedBack){
        this.FeedBack1=FeedBack;
        this.Name=Name;
        Feeds.add(this);
    }

}