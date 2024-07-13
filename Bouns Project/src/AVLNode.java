// Name: Ahmed Mostafa Bassouny Shokr              ID: 20100547
// Name: Yousef Tarek ALi Abdelaziz                ID: 20200102
// Name: Youssef Mohamed Gamaleldin Samy Badreldin ID: 20100294
// Name: Nour Walid Mohamed Abdelhalim Mohamed     ID: 20100250

public class AVLNode {
    int height;
    AVLNode left, right;
    private String data;
    private PriorityQueue queueData;

    public AVLNode(String data) {
        this.data = data;
        this.height = 1;
        left = right = null;
        queueData = new PriorityQueue();
    }

    public String getData() {
        return data;
    }

    public PriorityQueue getQueueData() {
        return queueData;
    }

    public void setData(String newData) {
        this.data = newData;
    }

    public void addPairToQueueData(Pair p) {
        queueData.enqueue(p);
    }
}
