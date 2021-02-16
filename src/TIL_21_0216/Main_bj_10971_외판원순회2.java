package TIL.src.TIL_21_0216;

import java.util.*;

public class Main_bj_10971_외판원순회2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] a = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = sc.nextInt();
      }
    }
    int[] d = new int[n];
    for (int i = 0; i < n; i++) {
      d[i] = i;
    }
    int ans = Integer.MAX_VALUE;

    do {
      boolean ok = true;
      int sum = 0;
      for (int i = 0; i < n - 1; i++) {
        if (a[d[i]][d[i + 1]] == 0) {
          ok = false;
        } else {
          sum += a[d[i]][d[i + 1]];
          if (ans > sum) {
            ans = sum;
          }
        }
      }
    } while (next_permutation(d));
  }

  private static boolean next_permutation(int[] a) {
    int i = a.length - 1;
    while (i > 0 && a[i - 1] >= a[i]) {
      i -= 1;
    }
    if (i <= 0) {
      return false;
    }
    int j = a.length - 1;
    while (a[j] <= a[i - 1]) {
      j -= 1;
    }
    int temp = a[i - 1];
    a[i - 1] = a[j];
    a[j] = temp;

    j = a.length - 1;
    while (i < j) {
      temp = a[i];
      a[i] = a[j];
      a[j] = temp;
      i += 1;
      j += 1;
    }
    return true;
  }
}
