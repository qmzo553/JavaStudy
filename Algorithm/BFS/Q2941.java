import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2941 {

    private static String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        for(int i = 0; i < arr.length; i++){
            if(input.contains(arr[i])){
                input = input.replace(arr[i], ":");
            }
        }

        System.out.println(input.length());
    }
}
