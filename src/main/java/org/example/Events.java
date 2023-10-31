package org.example;

import javax.xml.namespace.QName;
import java.util.ArrayList;

public interface Events {
    public void visit();
    ArrayList<Events> all_events =new ArrayList<>();
    public String get_Status();
    int getPrice();
    void setPrice(int price);
    void changeStatus();
    public  String get_Name();

    public int getTic_count();
    public void TicketSale();

}
class EventTasks{
    public static  Events getEventInstance(String Name){
        for (int i=0;i<Events.all_events.size();i++){
            if(Events.all_events.get(i).get_Name()==Name){
                return Events.all_events.get(i);
            }
        }
        System.out.println("No Such Event");
        return null;
    }
}
