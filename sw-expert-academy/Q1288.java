import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1288 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");

            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[10];
            int count = 1;

            while(true) {
                int num = count * n;
                int temp = num;

                while(num > 0) {
                    arr[num % 10]++;
                    num /= 10;
                }

                boolean flag = true;
                for(int number : arr) {
                    if(number == 0) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    sb.append(temp).append("\n");
                    break;
                }

                count++;
            }
        }

        System.out.println(sb);
    }
}
