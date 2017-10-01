package com.example.auspicious.lijiangtrip;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class App extends Application {

    private static Context context = null;
    private static SharedPreferences phonePreferences = null;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        phonePreferences = getSharedPreferences("data", MODE_PRIVATE);
        addKeyValuePairOrDoNothing("千里雅阁", "13988717437", phonePreferences);
        addKeyValuePairOrDoNothing("天净苑", "18108804756\n", phonePreferences);
    }

    //如果key存在就只是返回false，否则将键值对存入sharedPreferences
    public static  <T> boolean addKeyValuePairOrDoNothing(String key, T value, SharedPreferences sharedPreferences){
        if(sharedPreferences.contains(key)){
            return false;
        }
        else {
            SharedPreferences.Editor editor = phonePreferences.edit();
            switch (value.getClass().getSimpleName()){
                case "String":
                    editor.putString(key, (String)value);
                    break;
                case "Float":
                    editor.putFloat(key, (Float)value);
                    break;
                case "Integer":
                    editor.putInt(key, (Integer) value);
                    break;
                case "Long":
                    editor.putLong(key, (Long)value);
                    break;
                case "Boolean":
                    editor.putBoolean(key, (Boolean) value);
                    break;
                default:
                    if(value.getClass().getSimpleName().endsWith("Set")){
                        Set set = (Set) value;

                        HashSet<String> hashSet = new HashSet<>();
                        for (Object aSet : set) {
                            hashSet.add(aSet.toString());
                        }
                        editor.putStringSet(key, hashSet);

                    }
                    break;
            }
            editor.commit();
            return true;

        }
    }
    public static SharedPreferences getPhonePreferences(){
        return phonePreferences;
    }
}
