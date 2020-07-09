package TIL_0709;
import java.util.*;

public class Solution_D3_5215_햄버거다이어트 {
	static int T, N, L;
	static int Ti, Ki;
	static int max;
	static Hamburger[] arr;
	static class Hamburger {
		int mat;
		int cal;
		public Hamburger(int mat, int cal) {
			this.mat = mat;
			this.cal = cal;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			max = 0;
			N = sc.nextInt();
			L = sc.nextInt();
			arr = new Hamburger[N];
			for(int i=0; i<N; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[i] = new Hamburger(x, y);
			}
			Subset(new boolean[N], 0);
			System.out.println("#"+tc+" "+max);
		}
	}
	private static void Subset(boolean[] ans, int idx) {
		if(idx == ans.length) {
			int matsum = 0;
			int calsum = 0;
			for(int i=0; i<ans.length; i++) {
				if(ans[i]) {
					matsum += arr[i].mat;
					calsum += arr[i].cal;
				}
			}
			if(calsum <= L && max < matsum) {
				max = matsum;
			}
			return;
		}
		ans[idx] = true;
		Subset(ans, idx+1);
		ans[idx] = false;
		Subset(ans, idx+1);
	}
}
