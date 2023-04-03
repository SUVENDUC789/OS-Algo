package SSTF;

public class Main {

    static int abs(int n) {
        if (n < 0)
            n *= (-1);
        return n;
    }

    static int minimumSeekTime(int[] p, int[] v, int start) {

        int min = Integer.MAX_VALUE;
        int pro = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < p.length; i++) {
            if (abs(p[i] - start) < min && v[i] == 0) {
                min = abs(p[i] - start);
                pro = p[i];
                index = i;
            }
        }

        v[index] = 1;
        // System.out.println(pro);
        return pro;
    }

    public static void main(String[] args) {

        int[] process = { 4, 40, 11, 35, 7, 14 };
        // int[] process = { 98, 183, 37, 122, 14, 124, 65, 67 };
        int[] visiter = new int[process.length];

        int READ_WRITE_HEAD = 15;
        double TOTAL_HEAD_MOVEMENT = 0;

        for (int i = 0; i < visiter.length; i++) {
            int minSeekProcess = minimumSeekTime(process, visiter, READ_WRITE_HEAD);
            TOTAL_HEAD_MOVEMENT += abs(READ_WRITE_HEAD - minSeekProcess);
            READ_WRITE_HEAD = minSeekProcess;
        }

        System.out.println("The total head movement : " + ((int) TOTAL_HEAD_MOVEMENT));
        System.out.println("The Average head movement : " + (TOTAL_HEAD_MOVEMENT / visiter.length));

    }

}
