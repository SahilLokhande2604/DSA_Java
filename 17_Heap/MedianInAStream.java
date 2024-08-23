import java.util.*;

public class MedianInAStream {
    private int signum(int a, int b) {
        if (a == b) {
            return 0;
        } else if (a > b) {
            return 1;
        }
        return -1;
    }

    private void fastMedianInStream(int element, PriorityQueue<Integer> mini, PriorityQueue<Integer> maxi,
            int[] median) {
        switch (signum(maxi.size(), mini.size())) {
            case 0:
                if (element > median[0]) {
                    mini.add(element);
                    median[0] = mini.peek();
                    break;
                } else {
                    maxi.add(element);
                    median[0] = maxi.peek();
                    break;
                }

            case 1:
                if (element > median[0]) {
                    mini.add(element);
                    median[0] = (maxi.peek() + mini.peek()) / 2;
                    break;
                } else {
                    mini.add(maxi.remove());
                    maxi.add(element);
                    median[0] = (maxi.peek() + mini.peek()) / 2;
                    break;
                }

            case -1:
                if (element < median[0]) {
                    maxi.add(element);
                    median[0] = (maxi.peek() + mini.peek()) / 2;
                    break;
                } else {
                    maxi.add(mini.remove());
                    mini.add(element);
                    median[0] = (maxi.peek() + mini.peek()) / 2;
                    break;
                }

        }
    }

    public int[] medianInStream(int[] stream) {
        PriorityQueue<Integer> mini = new PriorityQueue<>();
        PriorityQueue<Integer> maxi = new PriorityQueue<>(Collections.reverseOrder());

        int[] ans = new int[stream.length];
        int[] median = { 0 };
        for (int i = 0; i < stream.length; i++) {
            fastMedianInStream(stream[i], mini, maxi, median);
            ans[i] = median[0];
        }

        return ans;

    }

    public void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        MedianInAStream mis = new MedianInAStream();
        System.out.println("Enter the size of stream");
        int size = sc.nextInt();
        System.out.println("Enter the stream");
        int[] stream = new int[size];
        for (int i = 0; i < size; i++) {
            stream[i] = sc.nextInt();
        }
        int[] ans = mis.medianInStream(stream);
        System.out.println("Median in the stream is ");
        mis.display(ans);

    }
}
