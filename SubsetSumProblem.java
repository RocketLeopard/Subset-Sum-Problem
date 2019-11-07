import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SubsetSumProblem {
    private static int k = 0;
    private static boolean flag[];

    public static void main(String[] args) throws IOException {
        System.out.println("请输入数组的长度：");
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();

        System.out.println("请输入数组，空格隔开：");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bs = br.readLine();

        String[] sa = bs.split(" ");
        int[] ints = StringToInt(sa);
        if (ints.length != len) {
            System.out.println("数组长度不符合要求");
            return;
        }

        System.out.println("请输入固定和的值：");
        s = new Scanner(System.in);
        int sum = s.nextInt();

        flag = new boolean[len];
        fixedSum(ints, len, len, sum);
    }

    public static void fixedSum(int[] arr, int len, int vol, int sum) {
        if (sum <= 0 || vol <= 0) {
            return;
        }

        if (sum == arr[vol - 1]) {
            flag[vol - 1] = true;
            output(arr, len);
        }

        //考虑是否取第n个数
        flag[vol - 1] = true;
        fixedSum(arr, len, vol - 1, sum - arr[vol - 1]);

        // 第N个数不符合要求，在剩下N-1个数中求和
        flag[vol - 1] = false;
        fixedSum(arr, len, vol - 1, sum);
    }

    public static void output(int[] arr, int n) {
        for (int i = 0; i < n; ++i) {
            if (flag[i]) {
                System.out.print(arr[i] + ",");
            }
        }
        System.out.println("");
    }

    public static int[] StringToInt(String[] arrs) {
        int[] ints = new int[arrs.length];

        for (int i = 0; i < arrs.length; i++) {
            ints[i] = Integer.valueOf(arrs[i]);
        }

        return ints;
    }
}
