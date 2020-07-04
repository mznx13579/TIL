package TIL_0704;

import java.util.*;

public class Main_bj_11727_2xn타일링2 {
	static int N;
	static int[] d;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		d = new int[N+1];
		System.out.println(go(N));
	}

	private static int go(int n) {
		if(n==1) return 1;
		if(n==2) return 3;
		if(d[n]>0) return d[n];
		d[n] = (go(n-1) + 2*go(n-2))%10007;
		return d[n];
	}
}
