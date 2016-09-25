package com.wlz.adsview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wlz.adslibrary.Ads;
import com.wlz.adslibrary.AdsBannerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Ads> al = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        al.add(new Ads("123","http://kingofwallpapers.com/landscape-pics/landscape-pics-001.jpg","http://kingofwallpapers.com/landscape-pics/landscape-pics-001.jpg"));
        al.add(new Ads("124","http://s.hswstatic.com/gif/landscape-photography-1.jpg","http://s.hswstatic.com/gif/landscape-photography-1.jpg"));
        al.add(new Ads("125","http://kingofwallpapers.com/landscape-pics/landscape-pics-001.jpg","http://kingofwallpapers.com/landscape-pics/landscape-pics-001.jpg"));
        al.add(new Ads("126","http://goodlifezen.s3.amazonaws.com/wp-content/uploads/2011/06/View-of-landscape-low-res.jpg","http://goodlifezen.s3.amazonaws.com/wp-content/uploads/2011/06/View-of-landscape-low-res.jpg"));


        AdsBannerView bannerView = (AdsBannerView) findViewById(R.id.banner);
        bannerView.setObjects(al);


    }
}
