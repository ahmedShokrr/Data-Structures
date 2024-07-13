import java.util.*;
public class Node implements Nodeinterface {
    private int Waiting_time;
    private int service_time;
    private int arrival_time;
    public Node next;


    //constructor to set value to the attributes

    public Node(int Waiting_time, int service_time, int arrival_time){
        this.Waiting_time=Waiting_time;
        this.service_time=service_time;
        this.arrival_time=arrival_time;
        next=null;
    }


    //funtion to get the waiting time

    public int getWaiting_time(){

        return Waiting_time;
    }


    //funtion to get the service time

    public int getService_time(){
        return service_time;
    }


    //funtion to set the waiting time

    public void setWaiting_time(int waiting_time){
        this.Waiting_time=waiting_time;
    }


    //funtion to get the service time

    public void setService_time(int service_time){
        this.service_time=service_time;
    }

}
