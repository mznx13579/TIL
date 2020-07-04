package TIL_0704;
import java.util.*;

public class Main_bj_9095_123더하기 {
	static int T, N;
	static int[] d;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		d = new int[12];
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			System.out.println(go(N));
		}
	}
	private static int go(int n) {
		if(n==1) return 1;
		if(n==2) return 2;
		if(n==3) return 4;
		if(d[n]>0) return d[n];
		d[n] = go(n-1)+go(n-2)+go(n-3);
		return d[n];
	}
}
