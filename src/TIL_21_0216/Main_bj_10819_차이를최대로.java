package TIL.src.TIL_21_0216;

import java.util.*;

public class Main_bj_10819_차이를최대로 {
  static boolean[] check;
  static int[] arr;
  static int max;
  static int N;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    arr = new int[N];
    check = new boolean[N];
    max = 0;
    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }
    Permutation(new int[arr.length], 0);
    System.out.println(max);
  }

  private static void Permutation(int[] ans, int idx) {
    if (idx == ans.length) {
      int tmp = 0;
      for (int i = 0; i < N - 1; i++) {
        tmp += Math.abs(ans[i] - ans[i + 1]);
      }
      if (tmp > max)
        max = tmp;
      return;
    }
    for (int i = 0; i < arr.length; i++) {
      if (!check[i]) {
        check[i] = true;
        ans[idx] = arr[i];
        Permutation(ans, idx + 1);
        check[i] = false;
      }
    }
  }
}
