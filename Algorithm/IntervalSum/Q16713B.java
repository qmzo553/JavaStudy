import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16713B {

    public static int n, q;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        SegmentTreeXOR xor = new SegmentTreeXOR(arr);


        int start, end;
        int result = 0;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            result = result ^ xor.xor(start, end);
        }

        System.out.println(result);
    }
}

class SegmentTreeXOR {

    int[] arr;
    int[] tree;
    int n;

    public SegmentTreeXOR(int[] arr) {
        this.arr = arr;
        this.n = arr.length;
        this.tree = new int[4 * n];
        build(0, 0, n - 1);
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(2 * node + 1, start, mid);
            build(2 * node + 2, mid + 1, end);
            tree[node] = tree[2 * node + 1] ^ tree[2 * node + 2];
        }
    }

    public void update(int index, int val) {
        update(0, 0, n - 1, index, val);
    }

    private void update(int node, int start, int end, int index, int val) {
        if (start == end) {
            arr[start] = val;
            tree[node] = val;
        } else {
            int mid = (start + end) / 2;
            if(start <= index && index <= mid) {
                update(2 * node + 1, start, mid, index, val);
            } else {
                update(2 * node + 2, mid + 1, end, index, val);
            }

            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    public int sum(int l, int r) {
        return sum(0, 0, n - 1, l , r);
    }

    public int xor(int l, int r) {
        return xor(0, 0, n - 1, l, r);
    }

    private int xor(int node, int start, int end, int l, int r) {
        if(r < start || end < l) {
            return 0;
        }
        if(l <= start && r >= end) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        int leftXOR = xor(2 * node + 1, start, mid, l, r);
        int rightXOR = xor(2 * node + 2, mid + 1, end, l, r);
        return leftXOR + rightXOR;
    }

    private int sum(int node, int start, int end, int l, int r) {
        if(r < start || end < l) {
            return 0;
        }
        if(l <= start && r >= end) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        int leftSum = sum(2 * node + 1, start, mid, l, r);
        int rightSum = sum(2 * node + 2, mid + 1, end, l, r);
        return leftSum + rightSum;
    }
}
