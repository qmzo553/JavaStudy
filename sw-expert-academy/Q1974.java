import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1974 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");

            int[][] arr = new int[9][9];
            int[] checkArr;
            boolean flag = true;

            for(int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 9; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < 9; i++) {
                checkArr = new int[10];
                for(int j = 0; j < 9; j++) {
                    checkArr[arr[i][j]] = 1;
                }

                for(int j = 1; j < 10; j++) {
                    if(checkArr[j] != 1) {
                        flag = false;
                        break;
                    }
                }

                if(!flag) {
                    break;
                }
            }

            if(!flag) {
                sb.append(0).append("\n");
                continue;
            }

            for(int i = 0; i < 9; i++) {
                checkArr = new int[10];
                for(int j = 0; j < 9; j++) {
                    checkArr[arr[j][i]] = 1;
                }

                for(int j = 1; j < 10; j++) {
                    if(checkArr[j] != 1) {
                        flag = false;
                        break;
                    }
                }

                if(!flag) {
                    break;
                }
            }

            if(!flag) {
                sb.append(0).append("\n");
                continue;
            }

            for(int i = 0; i < 3; i += 3) {
                checkArr = new int[10];
                for(int j = 0; j < 3; j += 3) {

                    for(int k = i; k < i + 3; k++) {
                        for(int l = j; l < j + 3; l++) {
                            checkArr[arr[k][l]] = 1;
                        }
                    }

                    for(int k = 1; k < 10; k++) {
                        if(checkArr[k] != 1) {
                            flag = false;
                            break;
                        }
                    }

                    if(!flag) {
                        break;
                    }
                }
            }

            if(flag) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }
}
