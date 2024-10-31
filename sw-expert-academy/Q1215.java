import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1215 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= 10; test++) {
            sb.append("#").append(test).append(" ");

            int n = Integer.parseInt(br.readLine());
            char[][] arr = new char[8][8];
            int count = 0;

            for(int i = 0; i < 8; i++) {
                String str = br.readLine();
                for(int j = 0; j < 8; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }

            for(int i = 0; i < 8; i++) {
                for(int j = 0; j <= 8 - n; j++) {
                    StringBuilder row = new StringBuilder();
                    StringBuilder col = new StringBuilder();

                    for(int k = 0; k < n; k++) {
                        row.append(arr[i][j + k]);
                        col.append(arr[j + k][i]);
                    }

                    if(isVaild(row.toString())) {
                        count++;
                    }

                    if(isVaild(col.toString())) {
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    public static boolean isVaild(String str) {
        for(int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
