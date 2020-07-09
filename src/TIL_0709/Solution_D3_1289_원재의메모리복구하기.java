package TIL_0709;
import java.util.*;

public class Solution_D3_1289_원재의메모리복구하기 {
	static int T;
	static String CODE;
	static int[] origin;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			CODE = sc.next();
			origin = new int[CODE.length()];
			for(int i=0; i<CODE.length(); i++) {
				origin[i] = CODE.charAt(i)-'0';
			}
			
			int[] dft = new int[CODE.length()];
			int cnt = 0;
			for(int i=0; i<CODE.length(); i++) {
				if(origin[i] != dft[i]) {
					cnt++;
					for(int j=i; j<CODE.length(); j++) {
						dft[j] = origin[i];
					}
				}
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}
}
