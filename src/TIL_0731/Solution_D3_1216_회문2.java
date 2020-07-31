package TIL_0731;
import java.util.*;

public class Solution_D3_1216_회문2 {
	static int T;
	static char[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc<=10; tc++) {
			T = sc.nextInt();
			arr = new char[100][100];
			for(int r=0; r<100; r++) {
				String str = sc.next();
				for(int c=0; c<100; c++) {
					arr[r][c] = str.charAt(c);
				}
			}
			int max = 0;
			for(int r=0; r<100; r++) {
				for(int start=0; start<100; start++) {
					for(int end=start; end<100; end++) {
						String emptyStr = "";
						for(int x = start; x<end; x++) {
							emptyStr+=arr[r][x]+"";
						}
						String reverseStr ="";
						for(int x = emptyStr.length()-1; x>=0; x--) {
							reverseStr += emptyStr.charAt(x)+"";
						}
						int cnt = 0;
						if(emptyStr.equals(reverseStr)) cnt = emptyStr.length();
						if(cnt > max) max = cnt;
					}
				}
			}
			for(int c=0; c<100; c++) {
				for(int start=0; start<100; start++) {
					for(int end=start; end< 100; end++) {
						String emptyStr = "";
						for(int x = start; x<end; x++) {
							emptyStr+=arr[x][c]+"";
						}
						String reverseStr ="";
						for(int x = emptyStr.length()-1; x>=0; x--) {
							reverseStr += emptyStr.charAt(x)+"";
						}
						int cnt = 0;
						if(emptyStr.equals(reverseStr)) cnt = emptyStr.length();
						if(cnt > max) max = cnt;
					}
				}
			}
			System.out.println("#"+tc+" "+max);
		}
	}
}
