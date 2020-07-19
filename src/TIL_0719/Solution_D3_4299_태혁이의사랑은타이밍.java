package TIL_0719;
import java.util.*;
public class Solution_D3_4299_태혁이의사랑은타이밍 {
	static int T, D, H, M;
//	1H = 60 M, 1D = 24H = 24*60 = 1440
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int start = 11*24*60 + 11*60 + 11;
			D = sc.nextInt();
			H = sc.nextInt();
			M = sc.nextInt();
			int end = D*24*60 + H*60 + M;
			if( start > end) {
				System.out.println("#"+tc+" "+-1);
			}
			else {
				System.out.println("#"+tc+" "+(end - start));
			}
		}
	}
}
