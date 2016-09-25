package com.wlz.adslibrary;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;

import java.util.ArrayList;

/**
 * Created by WaiLynnZaw on 9/23/16.
 */

public class AdsBannerView extends FrameLayout {
    private ArrayList<Ads> objects = new ArrayList<Ads>();
    private NonScrollablePager pager;
    private boolean pagerMoved = false;
    private static final long ANIM_VIEWPAGER_DELAY = 5000;

    private Handler h = new Handler();
    private int i=0;
    private Runnable animateViewPager = new Runnable() {
        public void run() {
            if (!pagerMoved) {
                if(objects.size() != 0){
                    if( i >= objects.size()){
                        i = 0;
                    }else{
                        i = i+1;
                    }
                    pager.setCurrentItem(i, true);
                    h.postDelayed(animateViewPager, ANIM_VIEWPAGER_DELAY);
                }
            }
        }
    };



    public AdsBannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public AdsBannerView(Context context){
        super(context);
    }
    public void setObjects(ArrayList<Ads> objects){
        this.objects = objects;
        init();
    }

    private void init(){
        pager = new NonScrollablePager(getContext());
        pager.setPagingEnabled(false);

        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        int width = display.getWidth();  // deprecated
        int height = display.getHeight();  // deprecated

        catchLog("Width : "+ width);
        catchLog("Height : "+ height);

        if(objects.size() != 0){
            AdsPagerAdapter adapter = new AdsPagerAdapter(getContext(), objects);
            pager.setAdapter(adapter);

            h.postDelayed(animateViewPager, ANIM_VIEWPAGER_DELAY);

            removeAllViews();

            addView(pager);
        }
    }
    private void catchLog(String log){
        if(BuildConfig.DEBUG) Log.i(getClass().getSimpleName(), log);
    }
}
