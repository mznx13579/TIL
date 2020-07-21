package TIL_0721;
import java.util.*;

public class Solution_D3_9480_민정이와광직이의알파벳공부 {
	static int TC,N;
	static String[] arr;
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TC = sc.nextInt();
		for(int tc = 1; tc<=TC; tc++) {
			N = sc.nextInt();
			arr = new String[N];
			count = 0;
			for(int i=0; i<N; i++) {
				arr[i] = sc.next();
			}
			Subset(new boolean[N], 0);
			System.out.println("#"+tc+" "+count);
		}
	}
	private static void Subset(boolean[] ans, int idx) {
		if(idx == ans.length) {
			int[] x = new int[26];
			for(int i=0; i<ans.length; i++) {
				if(!ans[i]) {
					for(int j=0; j<arr[i].length(); j++) {
						x[arr[i].charAt(j)-'a']++;
					}
				}
			}
			Arrays.sort(x);
			if(x[0]!= 0) count++;
			return;
		}
		ans[idx] = true;
		Subset(ans, idx+1);
		ans[idx] = false;
		Subset(ans, idx+1);
	}
}
