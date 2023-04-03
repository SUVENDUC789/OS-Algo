public class Main {

    private static int abs(int n) {
        if (n < 0)
            n = n * (-1);
        return n;
    }

    public static void main(String[] args) {
        int process[] = { 4,40,11,35,7,14 };
        // int total_track = 200;
        int READ_WRITE_HEAD = 15;

        double total_head_movemenet = 0;
        // double avg_head_movement = 0;

        for (int i = 0; i < process.length - 1; i++) {
            total_head_movemenet += (abs(process[i] - process[i + 1]));
        }
        total_head_movemenet += abs(process[0] - READ_WRITE_HEAD);

        System.out.println("The Total head movement : " + ((int) total_head_movemenet));
        System.out.println("The Average head movement : " + (total_head_movemenet / (process.length)));
    }

}