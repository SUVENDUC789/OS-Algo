import java.util.Arrays;

public class Main {
    private static int abs(int n) {
        if (n < 0)
            n *= (-1);
        return n;
    }

    public static void main(String[] args) {
        int[] process = { 98, 183, 37, 122, 14, 124, 65, 67 };
        int RW_HEAD = 53;
        double result = C_LOOK(process, RW_HEAD);
        System.out.println("The total head movement : " + (int) result);
        System.out.println("The Average head movement : " + (result / process.length));
    }

    private static double C_LOOK(int[] p, int head) {
        Arrays.sort(p);

        int temp = head;
        double total = 0;

        for (int i = 0; i < p.length; i++) {
            if (p[i] > head) {
                total += abs(head - p[i]);
                head = p[i];
            }
        }

        head = temp;

        for (int i = 1; i < p.length; i++) {
            if (p[i] < head) {
                total += abs(p[i] - p[i - 1]);
            }
        }
        return total;
    }
}
