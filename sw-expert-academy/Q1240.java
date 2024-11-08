import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1240 {

    private static String[] nums = {"0001101", "0011001", "0010011", "01111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arr = new int[8];
            boolean flag = true;

            for(int i = 0; i < n; i++) {
                String code = br.readLine();

                int lastIndex = code.lastIndexOf("1");

                if(lastIndex == -1 || !flag) {
                    continue;
                } else {
                    code = code.substring(lastIndex - 55, lastIndex + 1);

                    for(int j = 0; j < 8; j++) {
                        String cnt = code.substring(j * 7, j * 7 + 7);

                        for(int k = 0; k < 10; k++) {
                            if(nums[k].equals(cnt)) {
                                arr[j] = k;
                                break;
                            }
                        }
                    }

                    int check = (arr[0] + arr[2] + arr[4] + arr[6]) * 3 + (arr[1] + arr[3] + arr[5]) + arr[7];
                    if(check % 10 == 0 && check > 0) {
                        flag = false;
                        int sum = 0;
                        for(int k = 0; k < 8; k++) {
                            sum += arr[k];
                        }

                        sb.append(sum).append("\n");
                    } else {
                        flag = false;
                        sb.append(0).append("\n");
                    }
                }
            }


        }

        System.out.println(sb);
    }
}
