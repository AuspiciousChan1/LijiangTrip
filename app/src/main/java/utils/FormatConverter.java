package utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FormatConverter {
    //通过layout的id和所属的context，将Layout转换为View
    public static View changeLayoutToView(int layoutID, Context context){
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        return layoutInflater.inflate(layoutID, null);
    }
    public static ArrayList<View> changeLayoutsToViews(List<Integer> layoutIDs, Context context){
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        ArrayList<View> viewList = new ArrayList<>();
        for (Integer id : layoutIDs) {
            viewList.add(layoutInflater.inflate(id, null));
        }
        return viewList;
    }
}
