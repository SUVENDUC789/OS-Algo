import java.util.Arrays;
import java.util.Comparator;

class NonPrimetive {
    public String pid;
    public int AT;
    public int BT;

    public NonPrimetive(String pid, int at, int bt) {
        this.pid = pid;
        this.AT = at;
        this.BT = bt;
    }
}

class AscendingWithAT implements Comparator<NonPrimetive> {
    public int compare(NonPrimetive o1, NonPrimetive o2) {
        return o1.AT - o2.AT;
    }
}

class FCFSAlgo {

    public static void calculate(NonPrimetive[] o) {
        Arrays.sort(o, new AscendingWithAT());

        int sum = 0;
        int[] CT = new int[o.length];

        for (int i = 0; i < o.length; i++) {
            if (sum < o[i].AT) {
                sum += (o[i].AT - sum);
            }
            sum += o[i].BT;
            CT[i] = sum;

        }

        int[] TAT = new int[o.length];
        int[] RT = new int[o.length];
        int[] WT = new int[o.length];

        for (int i = 0; i < o.length; i++) {
            TAT[i] = CT[i] - o[i].AT;
            RT[i] = TAT[i] - o[i].BT;
            WT[i] = RT[i];
        }

        System.out.println("PID\tAT\tBT\tCT\tTAT\tWT\tRT");
        for (int i = 0; i < o.length; i++) {
            System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\t%d\n", o[i].pid, o[i].AT, o[i].BT, CT[i], TAT[i], WT[i], RT[i]);
        }

        double avgt = 0;
        int calc = 0;
        for (int i = 0; i < o.length; i++) {
            calc += WT[i];
        }

        avgt = (double) calc / (double) o.length;

        System.out.println("\nAverage Waiting time : " + avgt + " unit\n");

    }

    static {
        System.out.println("AT : Arival Time");
        System.out.println("BT : Burst Time");
        System.out.println("CT : Compilation Time");
        System.out.println("TAT : Turn Around Time");
        System.out.println("WT : Waiting Time");
        System.out.println("RT : Response Time\n\n");
    }

}

class DriverClass {
    public static void main(String[] args) {
        int i = 0;
        NonPrimetive[] arr = new NonPrimetive[4];

        arr[i++] = new NonPrimetive("p1", 0, 2);
        arr[i++] = new NonPrimetive("p2", 1, 2);
        arr[i++] = new NonPrimetive("p3", 5, 3);
        arr[i++] = new NonPrimetive("p4", 6, 4);

        // arr[i++] = new NonPrimetive("p1", 2, 6);
        // arr[i++] = new NonPrimetive("p2", 5, 3);
        // arr[i++] = new NonPrimetive("p3", 1, 8);
        // arr[i++] = new NonPrimetive("p4", 0, 3);
        // arr[i++] = new NonPrimetive("p5", 4, 4);

        FCFSAlgo.calculate(arr);

    }
}