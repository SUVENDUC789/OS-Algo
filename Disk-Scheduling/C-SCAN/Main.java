import java.util.Arrays;

public class Main {
    private static int abs(int n) {
        if (n < 0)
            n *= (-1);
        return n;
    }

    public static void main(String[] args) {

        int[] process = { 4,40,11,35,7,14 };
        int start = 15;

        double total_head_movement = C_SCAN(process, start, 0, 49);

        System.out.println("Total head movement : " + (int) total_head_movement);
        System.out.println("Average head movement : " + (total_head_movement / process.length));

    }

    private static double C_SCAN(int[] process, int start, int start_trac, int end_track) {
        Arrays.sort(process);

        int temp = start;
        double total = 0;

        for (int i = 0; i < process.length; i++) {
            if (process[i] > start) {
                // System.out.printf("(%d - %d)\n", process[i], start);
                total += abs(process[i] - start);
                start = process[i];
            }
        }
        // System.out.printf("(%d - %d)\n", end_track, start);
        total += abs(end_track - start);
        start = temp;

        for (int i = 0; i < process.length; i++) {
            if (process[i] < temp) {
                total += abs(start_trac - process[i]);
                start_trac = process[i];
            }
        }

        return total;
    }

}
