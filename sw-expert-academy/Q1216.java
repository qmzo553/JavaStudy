import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1216 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= 10; test++) {
            sb.append("#").append(test).append(" ");

            int t = Integer.parseInt(br.readLine());
            char[][] arr = new char[100][100];
            int ans = 1;

            for(int i = 0; i < 100; i++) {
                String str = br.readLine();

                for(int j = 0; j < 100; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }

            for(int i = 0; i < 100; i++) {
                for(int j = 0; j < 100; j++) {
                    for(int k = j; k < 100; k++) {
                        if(arr[i][j] == arr[i][k]) {
                            boolean flag = true;

                            for(int g = 0; g < k - j; g++) {
                                if(arr[i][j + g] != arr[i][k - g]) {
                                    flag = false;
                                }
                            }

                            if(flag) {
                                ans = Math.max(ans, k - j + 1);
                            }
                        }
                    }
                }
            }

            for(int i = 0; i < 100; i++) {
                for(int j = 0; j < 100; j++) {
                    for(int k = j; k < 100; k++) {
                        if(arr[j][i] == arr[k][i]) {
                            boolean flag = true;

                            for(int g = 0; g < k - j; g++) {
                                if(arr[j + g][i] != arr[k - g][i]) {
                                    flag = false;
                                }
                            }

                            if(flag) {
                                ans = Math.max(ans, k - j + 1);
                            }
                        }
                    }
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
