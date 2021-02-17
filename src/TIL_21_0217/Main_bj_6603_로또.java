package TIL_21_0217;

import java.util.*;

public class Main_bj_6603_로또 {
  static int k;
  static int[] arr;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      k = sc.nextInt();
      if (k == 0)
        break;
      arr = new int[k];
      for (int i = 0; i < k; i++) {
        arr[i] = sc.nextInt();
      }
      Combination(new int[6], 0, 0);
      System.out.println();
    }
  }

  private static void Combination(int[] ans, int idx, int r) {
    if (r == ans.length) {
      for (int i = 0; i < 6; i++) {
        System.out.print(ans[i] + " ");
      }
      System.out.println();
      return;
    }
    if (idx == arr.length)
      return;
    ans[r] = arr[idx];
    Combination(ans, idx + 1, r + 1);
    Combination(ans, idx + 1, r);
  }
}
