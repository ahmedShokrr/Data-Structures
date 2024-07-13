// Name: Ahmed Mostafa Bassouny Shokr              ID: 20100547
// Name: Yousef Tarek ALi Abdelaziz                ID: 20200102
// Name: Youssef Mohamed Gamaleldin Samy Badreldin ID: 20100294
// Name: Nour Walid Mohamed Abdelhalim Mohamed     ID: 20100250

public class PriorityQueueNode {
    PriorityQueueNode next;
    Pair data;

    public PriorityQueueNode(Pair data) {
        this.data = data;
        next = null;
    }
    public String toString() {
        return "{ "+ data.strData + " - "  + data.statistics + " }";
    }
}
