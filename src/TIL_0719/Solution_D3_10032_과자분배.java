package TIL_0719;
import java.util.*;

public class Solution_D3_10032_과자분배 {
	static int T, N, K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			if(N%K == 0) {
				System.out.println("#"+tc+" "+"0");
			}
			else {
				System.out.println("#"+tc+" "+"1");
			}
		}
	}
}
