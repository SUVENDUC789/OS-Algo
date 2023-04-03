import java.util.Arrays;

public class Main {

    static int abs(int n) {
        if (n < 0)
            n *= (-1);
        return n;
    }

    static double scan(int[] p, int start) {
        int temp = start;
        double total = 0;
        Arrays.sort(p);

        int end = 0;

        for (int i = p.length - 1; i >= 0; i--) {
            if (start > p[i]) {
                // System.out.printf("(%d - %d)\n", start, p[i]);
                total += abs(start - p[i]);
                start = p[i];
            }
        }

        total += abs(0 - start);
        start = temp;

        for (int i = 0; i < p.length; i++) {
            if (start < p[i]) {
                // System.out.printf("(%d - %d)\n", end, p[i]);
                total += abs(end - p[i]);
                end = p[i];
                start = end;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        int[] process = { 4,40,11,35,7,14 };
        int START_HEAD = 15;

        System.out.println("Total head movement : " + scan(process, START_HEAD));
        System.out.println("Average head movement : " + (scan(process, START_HEAD) / process.length));

        // System.out.println(Arrays.toString(process));
    }

}
