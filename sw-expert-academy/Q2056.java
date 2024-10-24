import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2056 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int count = 1;

        while(t-- > 0) {
            sb.append("#").append(count++).append(" ");
            String str = br.readLine();

            String year = str.substring(0, 4);
            String month = str.substring(4, 6);
            String day = str.substring(6, 8);

            if(validateYear(year) && validateMonth(month) && validateDay(month, day)) {
                sb.append(year).append("/").append(month).append("/").append(day).append("\n");
            } else {
                sb.append(-1).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean validateYear(String year) {
        return !year.equals("0000");
    }

    public static boolean validateMonth(String month) {
        int num = Integer.parseInt(month);
        return 0 < num && num <= 12;
    }

    public static boolean validateDay(String month, String day) {
        int num = Integer.parseInt(day);
        if(Integer.parseInt(month) == 2) {
            return 0 < num && num <= 28;
        }

        return 0 < num && num <= 31;
    }
}
