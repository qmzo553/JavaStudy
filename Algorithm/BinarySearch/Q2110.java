import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2110 {

    public static int n, c;
    public static int[] house;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        house = new int[n];

        for(int i = 0; i < n; i++){
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int min = 1;
        int max = house[n - 1] - house[0] + 1;
        while(min < max){
            int mid = min + (max - min) / 2;

            if(install(mid) < c) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }

    private static int install(int distance) {

        int count = 1;
        int last = house[0];

        for(int i = 1; i < house.length; i++) {

            int locate = house[i];

            if(locate - last >= distance) {
                count++;
                last = locate;
            }
        }

        return count;
    }
}
