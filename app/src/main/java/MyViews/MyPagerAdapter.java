package MyViews;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyPagerAdapter extends PagerAdapter {
    private List<View> views;
    public MyPagerAdapter(List<View> views){
        super();
        this.views = views;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(this.views.get(position));
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=this.views.get(position);
        container.addView(view);
        return view;
    }
    @Override
    public int getCount() {
        return this.views.size();
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}