import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6808 {

    private static int[] arr, brr, result;
    private static boolean[] card, visited;
    private static int win, lose;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");

            arr = new int[9];
            brr = new int[9];
            result = new int[9];
            card = new boolean[19];
            visited = new boolean[9];
            win = 0;
            lose = 0;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 9; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                card[arr[i]] = true;
            }

            int idx = 0;
            for(int i = 1; i < 19; i++) {
                if(!card[i]) {
                   brr[idx++] = i;
                }
            }

            match(0);

            sb.append(win).append(" ").append(lose).append("\n");
        }

        System.out.println(sb);
    }

    private static void match(int cnt) {
        if(cnt == 9) {
            int score1 = 0;
            int score2 = 0;

            for(int i = 0; i < 9; i++) {
                if(result[i] < arr[i]) {
                    score1 += result[i] + arr[i];
                } else if(result[i] > arr[i]) {
                    score2 += result[i] + arr[i];
                }
            }

            if(score1 > score2) {
                win++;
            } else {
                lose++;
            }

            return;
        }

        for(int i = 0; i < 9; i++) {
            if(visited[i]) {
                continue;
            }

            result[cnt] = brr[i];
            visited[i] = true;
            match(cnt + 1);
            visited[i] = false;
        }
    }
}
