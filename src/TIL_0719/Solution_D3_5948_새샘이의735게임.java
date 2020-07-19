package TIL_0719;
import java.util.*;

public class Solution_D3_5948_새샘이의735게임 {
	static int T;
	static Set<Integer> set;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			arr = new int[7];
			set = new HashSet<>();
			for(int k=0; k<7; k++) {
				arr[k] = sc.nextInt();
			}
			Combination(new int[3], 0, 0);
			ArrayList list = new ArrayList<>(set);
			Collections.sort(list);
			System.out.println("#"+tc+" "+list.get(set.size()-5));
		}
	}
	private static void Combination(int[] ans, int idx, int r) {
		if(idx == ans.length) {
			int sum  = 0;
			for(int i=0; i<ans.length; i++) {
				sum += ans[i];
			}
			set.add(sum);
			return;
		}
		if(r == arr.length) return;
		ans[idx] = arr[r];
		Combination(ans, idx+1, r+1);
		Combination(ans, idx, r+1);
	}
}
