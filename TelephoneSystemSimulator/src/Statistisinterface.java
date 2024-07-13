public interface Statistisinterface {
    public void settotalServiceTime(int totalServiceTime);
    public double gettotalServiceTime();
    public void settotalWaititngTime(int totalWaititngTime);
    public double gettotalWaititngTime();
    public void setaverageWaitingTime(int averageWaitingTime);
    public double getaverageWaitingTime();
    public void setaverageServiceTime();
    public double getaverageServiceTime();
    public void settotalldleTime(int totalldleTime);
    public int gettotalldleTime();
    public double getNumberofcalls();
    public void print_satistics_report();
}
