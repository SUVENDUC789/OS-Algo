package LOOK;

import java.util.Arrays;

public class Main {

    private static int abs(int n) {
        if (n < 0)
            n *= (-1);
        return n;
    }

    public static void main(String[] args) {
        int[] process = { 176, 79, 34, 60, 92, 11, 41, 114 };
        // int[] process = { 98, 183, 37, 122, 14, 124, 65, 67 };
        int start = 50;

        double total = look(process, start);

        System.out.println("Total head movement : " + (int) total);
        System.out.println("Average head movement : " + (total / process.length));

    }

    private static double look(int[] process, int start) {
        Arrays.sort(process);

        int temp = start;
        double total = 0;

        for (int i = process.length - 1; i >= 0; i--) {
            if (start > process[i]) {
                total += abs(start - process[i]);
                start = process[i];
            }
        }

        for (int i = 0; i < process.length; i++) {
            if (temp < process[i]) {
                total += abs(start - process[i]);
                start = temp = process[i];
            }
        }
        // System.out.println(start);

        return total;
    }
}
