package TIL_0721;
import java.util.*;

public class Solution_D3_5356_의석이의세로로말해요 {
	static int T;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			char[][] map = new char[5][15];
			for(int i=0; i<5; i++) {
				String str = sc.next();
				for(int j=0; j<str.length(); j++) {
					map[i][j] = str.charAt(j);
				}
			}
			String ans = "";
			for(int i=0; i<15; i++) {
				for(int j=0; j<5; j++) {
					if(map[j][i] =='\u0000') continue;
					ans += map[j][i]+"";
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
