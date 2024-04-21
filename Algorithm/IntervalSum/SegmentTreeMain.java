class SegmentTree {
    int[] tree;
    int[] array;
    int n;

    public SegmentTree(int[] array) {
        this.array = array;
        this.n = array.length;
        this.tree = new int[4 * n];
        build(0, 0, n - 1);
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = array[start];
        } else {
            int mid = (start + end) / 2;
            build(2 * node + 1, start, mid);
            build(2 * node + 2, mid + 1, end);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    public void update(int index, int val) {
        update(0, 0, n - 1, index, val);
    }

    private void update(int node, int start, int end, int index, int val) {
        if (start == end) {
            array[start] = val;
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

public class SegmentTreeMain {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11};
        SegmentTree tree = new SegmentTree(array);

        System.out.println("Sum(1, 3) = " + tree.sum(1, 3));
        tree.update(2, 10);
        System.out.println("Sum(1, 3) = " + tree.sum(1, 3));
    }
}
