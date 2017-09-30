package com.example.auspicious.lijiangtrip;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Main extends AppCompatActivity implements View.OnClickListener{

    View viewAttractions, viewTranslation, viewFood , viewHotel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        initView();

    }
    private void initView(){
        viewAttractions = findViewById(R.id.viewAttractions);
        viewAttractions.setOnClickListener(this);
        viewTranslation = findViewById(R.id.viewTranslation);
        viewTranslation.setOnClickListener(this);
        viewFood = findViewById(R.id.viewFood);
        viewFood.setOnClickListener(this);
        viewHotel = findViewById(R.id.viewHotel);
        viewHotel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.viewAttractions:
                Toast.makeText(Main.this, "景点", Toast.LENGTH_LONG).show();
                break;
            case R.id.viewTranslation:
                Toast.makeText(Main.this, "交通", Toast.LENGTH_LONG).show();
                break;
            case R.id.viewFood:
                Toast.makeText(Main.this, "食物", Toast.LENGTH_LONG).show();
                break;
            case R.id.viewHotel:
                Toast.makeText(Main.this, "旅馆", Toast.LENGTH_LONG).show();
                break;
            default:
                Toast.makeText(Main.this, "未知", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
