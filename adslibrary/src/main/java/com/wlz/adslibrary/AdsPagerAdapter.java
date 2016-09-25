package com.wlz.adslibrary;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

class AdsPagerAdapter extends PagerAdapter {

	private Context context;

	private ArrayList<Ads> objects = new ArrayList<Ads>();


	AdsPagerAdapter(Context c, ArrayList<Ads> objects) {
		context = c;
        this.objects = objects;
	}

	public Object instantiateItem(View collection, int position) {
		Ads d = objects.get(position);

		View v = getDetailView(position, d);

		((ViewPager) collection).addView(v, 0);
		return v;
	}

	private View getDetailView(int position, final Ads p) {

		ImageView v = new ImageView(context);
		v.setScaleType(ScaleType.FIT_XY);
		v.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        Glide.with(context)
                .load(p.image_url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(v);

		v.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				catchLog(p.link_url);
				if(URLUtil.isValidUrl(p.link_url)){
					Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(p.link_url));
					context.startActivity(browserIntent);
				}
			}
		});

		return v;
	}

	@Override
	public int getCount() {
		return objects.size();
	}

	@Override
	public void destroyItem(View collection, int position, Object view) {
		((ViewPager) collection).removeView((View) view);
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == ((View) object);
	}

	@Override
	public void restoreState(Parcelable arg0, ClassLoader arg1) {
	}

	@Override
	public Parcelable saveState() {
		return null;
	}

	private void catchLog(String log) {
		if(BuildConfig.DEBUG) Log.i(getClass().getSimpleName(), log);
	}
}
