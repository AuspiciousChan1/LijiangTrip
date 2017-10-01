package Hotels;

import java.util.ArrayList;

public class Hotel{
    ArrayList<String> arrayList;
    public Hotel(String name, String phoneNum, String position, String startDate){
        arrayList = new ArrayList<>();
        arrayList.add(name);//0
        arrayList.add(phoneNum);//1
        arrayList.add(position);//2
        arrayList.add(startDate);//3
    }
    public String getName(){
        return this.arrayList.get(0);
    }
    public  String getPhoneNum(){
        return this.arrayList.get(1);
    }
    public String getPosition(){
        return this.arrayList.get(2);
    }
    public String getStartDate(){
        return this.arrayList.get(3);
    }
}
