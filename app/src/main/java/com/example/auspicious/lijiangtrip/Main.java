package com.example.auspicious.lijiangtrip;

import MyViews.MyPagerAdapter;
import MyViews.MyViewPager;
import android.os.PersistableBundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import utils.FormatConverter;

import java.util.ArrayList;


public class Main extends AppCompatActivity implements View.OnClickListener {

    //MyViewPager
    @BindView(R.id.myViewPager) MyViewPager myViewPager;//底部按钮对应界面的容器
    //底部按钮
    @BindView(R.id.linearLayoutBottom) LinearLayout linearLayoutBottom;//底部按钮所在的LinearLayout
    @BindView(R.id.viewAttractions) View viewAttractions;//景点按钮
    @BindView(R.id.viewTranslation) View viewTranslation;//交通按钮
    @BindView(R.id.viewFood) View viewFood;//食物按钮
    @BindView(R.id.viewHotel) View viewHotel;//旅店按钮


    @BindView(R.id.textViewInformation) TextView textViewInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        ButterKnife.bind(this);
        initView();

    }


    private void initView(){
        //为底部按钮设置点击事件与接触事件
        viewAttractions.setOnClickListener(this);
        viewTranslation.setOnClickListener(this);
        viewFood.setOnClickListener(this);
        viewHotel.setOnClickListener(this);
        //为底部按钮设置初始外观
        resetBottomButtons();
        setBottomButtonClicked(R.id.viewAttractions);

        //设置MyViewPager
        ArrayList<Integer> layoutIds_List = new ArrayList<>(linearLayoutBottom.getChildCount() + 1);
        layoutIds_List.add(R.layout.layout_attractions);
        layoutIds_List.add(R.layout.layout_translation);
        layoutIds_List.add(R.layout.layout_food);
        layoutIds_List.add(R.layout.layout_hotel);
        final ArrayList<View> viewList = FormatConverter.changeLayoutsToViews(layoutIds_List, Main.this);
        PagerAdapter pagerAdapter = new MyPagerAdapter(viewList);
        this.myViewPager.setAdapter(pagerAdapter);
        this.myViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetBottomButtons();
                switch (position){
                    case 0:
                        setBottomButtonClicked(R.id.viewAttractions);
                        break;
                    case 1:
                        setBottomButtonClicked(R.id.viewTranslation);
                        break;
                    case 2:
                        setBottomButtonClicked(R.id.viewFood);
                        break;
                    case 3:
                        setBottomButtonClicked(R.id.viewHotel);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void resetBottomButtons(){
        viewAttractions.setBackground(getDrawable(R.drawable.attractions));
        viewTranslation.setBackground(getDrawable(R.drawable.translation));
        viewFood.setBackground(getDrawable(R.drawable.food));
        viewHotel.setBackground(getDrawable(R.drawable.hotel));
    }
    private void setBottomButtonClicked(int id){
        switch (id){
            case R.id.viewAttractions://7f0b0062
                viewAttractions.setBackground(getDrawable(R.drawable.attractions_clicked));
                break;
            case R.id.viewTranslation://7f0b0063
                viewTranslation.setBackground(getDrawable(R.drawable.translation_clicked));
                break;
            case R.id.viewFood://7f0b0064
                viewFood.setBackground(getDrawable(R.drawable.food_clicked));
                break;
            case R.id.viewHotel://7f0b0065
                viewHotel.setBackground(getDrawable(R.drawable.hotel_clicked));
                break;
            default:
                Toast.makeText(Main.this, "未知", Toast.LENGTH_LONG).show();
                break;
        }

    }

    @Override
    public void onClick(View view) {
        resetBottomButtons();
        int id = view.getId();
        setBottomButtonClicked(id);
        switch (id){
            case R.id.viewAttractions:
//                Toast.makeText(Main.this, "景点", Toast.LENGTH_LONG).show();
                myViewPager.setCurrentItem(0);
                break;
            case R.id.viewTranslation:
//                Toast.makeText(Main.this, "交通", Toast.LENGTH_LONG).show();
                myViewPager.setCurrentItem(1);
                break;
            case R.id.viewFood:
//                Toast.makeText(Main.this, "食物", Toast.LENGTH_LONG).show();
                myViewPager.setCurrentItem(2);
                break;
            case R.id.viewHotel:
//                Toast.makeText(Main.this, "旅馆", Toast.LENGTH_LONG).show();
                myViewPager.setCurrentItem(3);
                break;
            default:
                Toast.makeText(Main.this, "未知", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
