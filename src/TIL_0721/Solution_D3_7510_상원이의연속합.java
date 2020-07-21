package TIL_0721;
import java.util.*;
public class Solution_D3_7510_상원이의연속합 {
	static int T, N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			int count = 1;
			for(int i=1; i < N/2+1; i++) {
				int start = i;
				int remain = N-i;
				while(true) {
					start++;
					remain -= start;
					if(remain == 0) {
						count++;
						break;
					}
					if(remain < 0) break;
				}
			}
			System.out.println("#"+tc+" "+count);
		}
	}
}
