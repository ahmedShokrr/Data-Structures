import java.util.*;
public class TelephoneSystem implements TelephoneSysteminterface{
    private int total_service_time;
    private int total_waiting_time;
    private int total_idle_time;
    private int number_of_calls;
    private int lengthOfService;
    private int lengthOfCall;
    private Queue myQueue;
    private  int MaximumQueueSize;


    //constructor

    public TelephoneSystem(int lengthOfSerivce, int lengthOfCall) {
        this.lengthOfCall = lengthOfCall;
        this.lengthOfService = lengthOfSerivce*60;
        myQueue = new Queue();
        total_service_time = 0;
        total_waiting_time = 0;
        total_idle_time = 0;
    }


    //funtion to display the statistis.

    public void finalise_report_simulator(){
        Statistis s1 = new Statistis(total_service_time,total_waiting_time,total_idle_time,number_of_calls, MaximumQueueSize);
        s1.print_satistics_report();
    }



    //This function will include the main timing loop.

    public void run_simulator() {
        call_simulator();
    }

    /* The call simulator will use a random number generator to determine
       whether a call has been received. Scale the random number to an appropriate range,
       such as 1 to 10. The random number should be compared with a defined constant. If the
        value is less than the constant, a call was received; if it is not, then no call was received.
        For the simulation, set the call level to %50; that is, on average, a call will be received every
        2 minutes. If a call is received, place it in a queue.
     */

    public void call_simulator() {
        Random rand = new Random();
        int time_of_service = lengthOfService;
        System.out.println("Clock Time        Number of Calls        Arrival Time       Waiting Time      Starting Time      Service Time      Queue Size");
        int constant = 5;
        for(int min = 0; min < time_of_service; min++) {
            if(min % 2 == 0) {
                int numberRandomOfCalls = 1 + rand.nextInt(10);
                if(numberRandomOfCalls <= constant) {
                    for(int i = 0; i < numberRandomOfCalls; i++) {
                        int time_needed = 1+rand.nextInt(4);
                        Node newCall = new Node(get_waiting_time_for_call(), time_needed, min);
                        myQueue.enqueue(newCall);
                        total_service_time+=time_needed;
                        number_of_calls++;
                        total_waiting_time+=newCall.getWaiting_time();
                    }
                }
            }
            process_active_call(min);
        }
    }


    /*  If a call is active, test whether it has been completed. In order to check
        if it is completed, you will again need to randomly decide whether a call is completed or
        not. In order to do that, you need to check the time of the service and make sure that it is
        always less than the given maximum service time.
     */

    private void process_active_call(int min) {
        Node active_call = start_new_call(min);
        if(active_call != null) {
            if (active_call.getService_time() - lengthOfCall > 0) {
                total_service_time += active_call.getService_time();
                active_call.setService_time(active_call.getService_time() - lengthOfCall);
                myQueue.enqueue(active_call);
            }
        }
    }


    /* If there are no active calls, start a new call if there is one waiting in the
    queue. Note that starting a call must calculate the time the call has been waiting. This will
    show the time that the call has been waiting in the queue.
     */

    private Node start_new_call(int min) {
        if(myQueue.isEmpty()) {
            total_idle_time += lengthOfCall;
            return null;
        } else {
            Node active_call = myQueue.dequeue();
            System.out.println(min + "                 " + myQueue.size+ "                      " + min +
                    "                  " + active_call.getWaiting_time() + "                " +  active_call.getService_time() + "                   " + active_call.getService_time() +
                    "                 " + myQueue.size);
            MaximumQueueSize +=myQueue.size;
            return active_call;
        }
    }



    //funtion to get the waiting time for the callSystem
    public int get_waiting_time(){
        int counter=0;
        Node current = myQueue.front;
        while (current!=null){
            counter+=get_waiting_time();
            current=current.next;
        }
        return counter;
    }

    //fuction to get the waiting time for one call in the Queue
    private int get_waiting_time_for_call() {
        Node current = myQueue.front;
        int counter = 0;
        while(current != null) {
            counter += current.getService_time();
            current = current.next;
        }
        return counter;
    }

}
