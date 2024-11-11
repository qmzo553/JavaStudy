import java.util.Scanner;

public class Q1217 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int test = 1; test <= 10; test++) {
            int t = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
            int ans = n;

            for(int i = 1; i < m; i++) {
                ans *= n;
            }

            String output = String.format("#%d %d", test, ans);
            System.out.println(output);
        }
    }
}
