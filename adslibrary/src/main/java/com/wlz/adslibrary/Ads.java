package com.wlz.adslibrary;

/**
 * Created by WaiLynnZaw on 9/25/16.
 */

public class Ads {
    public String id;
    public String image_url;
    public String link_url;

    public Ads(){
    }

    public Ads(String id, String image_url, String link_url){
        this.id = id;
        this.image_url = image_url;
        this.link_url = link_url;
    }
}
