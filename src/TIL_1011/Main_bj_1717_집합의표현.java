package TIL_1011;
import java.util.*;

public class Main_bj_1717_집합의표현 {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		arr = new int[n+1];
		for(int i=1; i<=n; i++) arr[i] = i;
		for(int i=0; i<m; i++) {
			int c, a, b;
			c = sc.nextInt();
			a = sc.nextInt();
			b = sc.nextInt();
			if(c == 0) {
				int x = find(a);
				int y = find(b);
				union(x, y);
			} else if(c == 1) {
				int x = find(a);
				int y = find(b);
				if( x == y) System.out.println("YES");
				else System.out.println("NO");
				
			}
		}
	}
	private static void union(int x, int y) {
		if( x == y) return;
		arr[x] = y;
	}
	private static int find(int num) {
		if(num == arr[num]) {
			return num;
		}
		return find(arr[num]);
	}
}
