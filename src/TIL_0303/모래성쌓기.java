package TIL_0303;
import java.util.*;
public class 모래성쌓기 {
	static int H;
	static int W;
	static char[][] arr;
	static int[] dr = {-1,1,0,0,-1,-1,1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();
			arr = new char[H][W];
			for(int i=0; i<H; i++) {
				String s = sc.next();
				for(int j=0; j<s.length(); j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			
		}
	}
}
