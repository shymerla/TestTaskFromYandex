import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m, q;
        String txt;
        n = scanner.nextInt();
        m = scanner.nextInt();
        q = scanner.nextInt();
        int[][] kolya = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                kolya[i][j] = 1;
            }
        }

        while (true) {
            try {
                txt = scanner.next();

                if (Objects.equals(txt, "DISABLE")) {
                    kolya[scanner.nextInt()][scanner.nextInt()] = 0;
                }
                if (Objects.equals(txt, "RESET")) {
                    int data = scanner.nextInt();
                    kolya[data][0] = kolya[data][0] + 1;
                    for (int i = 1; i <= m; i++) {
                        kolya[data][i] = 1;
                    }
                }
                if (Objects.equals(txt, "GETMAX")) {
                    int max = 1;
                    int maxx = 0;
                    int maxprint = 1;
                    for (int i = 1; i <= n; i++) {
                        for (int j = 1; j <= m; j++) {
                            maxx = maxx + kolya[i][j];
                        }
                        maxx = maxx * kolya[i][0];
                        if (maxx > max) {
                            max = maxx;
                            maxprint = i;
                        }
                        maxx = 0;
                    }
                    System.out.println(maxprint);
                }
                if (Objects.equals(txt, "GETMIN")) {
                    int min = 1000000;
                    int minn = 0;
                    int minprint = 1;
                    for (int i = 1; i <= n; i++) {
                        for (int j = 1; j <= m; j++) {
                            minn = minn + kolya[i][j];
                        }
                        minn = minn * kolya[i][0];
                        if (minn < min) {
                            min = minn;
                            minprint = i;
                        }
                        minn = 0;
                    }
                    System.out.println(minprint);
                }
                if (Objects.equals(txt, "-1")) {
                    break;
                }
            } catch (NoSuchElementException e) {
                break;
            }
        }
    }
}
