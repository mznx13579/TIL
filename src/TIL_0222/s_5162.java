package TIL_0222;

import java.util.*;

public class s_5162 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(a > b) {
				int tmp = a;
				a = b;
				b = tmp;
			}
			int sum = 0;
			sum += c/a;
			c -= (c/a)*a;
			sum += c/b;
			System.out.println("#"+tc+" "+sum);
		}
	}
}
