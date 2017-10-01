package utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

public class GetFromId {
    //通过颜色的id获取颜色
    public static int getColorFromColorID(int id, Context context){
        return ContextCompat.getColor(context, id);
    }
    //通过字符串的id获取字符串
    public static String getStringFromStringID(int id, Context context){
        return context.getResources().getString(id);
    }
    //通过颜色id获取drawable
    public static Drawable getDrawableFromID(int id, Context context){
        return context.getDrawable(id);
    }
}
