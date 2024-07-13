public class Statistis implements Statistisinterface {
    private double totalServiceTime;
    private double totalWaititngTime;
    private double averageWaitingTime;
    private double averageServiceTime;
    private int totalldleTime;
    private double numberofcalls;
    private int MaximumQueueSize;

    //constructor to set value to the attributes

    public Statistis(double totalServiceTime,double totalWaititngTime,int totalldleTime,double numberOdCalls,int MaximumQueueSize){
        this.totalServiceTime=totalServiceTime;
        this.totalWaititngTime=totalWaititngTime;
        this.totalldleTime=totalldleTime;
        this.numberofcalls=numberOdCalls;
        this.MaximumQueueSize =MaximumQueueSize;
    }


    //funtion to set the total service time

    public void settotalServiceTime(int totalServiceTime){
        this.totalServiceTime=totalServiceTime;
    }


    //funtion to get the total service time

    public double gettotalServiceTime(){
        return totalServiceTime;
    }


    //funtion to set the total service time

    public void settotalWaititngTime(int totalWaititngTime){
        this.totalWaititngTime=totalWaititngTime;
    }


    //funtion to get the total waiting time

    public double gettotalWaititngTime(){
        return totalWaititngTime;
    }


    //function to set the value of Average Waiting Time by divide the total Waititng Time by number of calls

    public void setaverageWaitingTime(int averageWaitingTime){
        this.averageWaitingTime=totalWaititngTime/numberofcalls;
    }


    //function to get the value of Average Waiting Time by divide the total Waititng Time by number of calls

    public double getaverageWaitingTime(){
        return (totalWaititngTime/numberofcalls);
    }


    //funtion to set the value of Average service time by divide the total service time by number of calls

    public void setaverageServiceTime(){
        this.averageServiceTime=totalServiceTime/numberofcalls;
    }


    //funtion to get the value of Average service time by divide the total service time by number of calls

    public double getaverageServiceTime(){
        return (totalServiceTime/numberofcalls);
    }


    //funtion to set the value of total idle time(free time)

    public void settotalldleTime(int totalldleTime){
        this.totalldleTime=totalldleTime;
    }


    //funtion to get the value of total idle time(free time)

    public int gettotalldleTime(){
        return totalldleTime;
    }


    //fuction to get the number of calls

    public double getNumberofcalls() {
        return numberofcalls;
    }


    //fuction to display the statistics .

    public void print_satistics_report(){
        System.out.println("Total call: "+numberofcalls);
        System.out.println("Total idle time:"+totalldleTime);
        System.out.println("Total wait time:"+totalWaititngTime);
        System.out.println("Total service time:"+totalServiceTime);
        System.out.println("Maximum queue size:"+ MaximumQueueSize);
        System.out.println("Average wait time:"+getaverageWaitingTime());
        System.out.println("Average service time:"+getaverageServiceTime());
        System.out.println("Thanks for Using our program:)");


    }
}

