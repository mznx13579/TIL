package TIL_1011;
import java.util.*;

public class Main_bj_1976_여행가자 {
	static int n, m;
	static int[] arr;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = i;
		}
		map = new int[n][n];
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++){
				map[r][c] = sc.nextInt();
			}
		}
		for(int r=0; r<n; r++) {
			for(int c=r+1; c<n; c++) {
				if(map[r][c] == 1) {
					int x = find(r+1);
					int y = find(c+1);
					union(x, y);
				}
			}
		}
		int z = sc.nextInt();
		int p = find(z);
		for(int i=1; i<m; i++) {
			z = sc.nextInt();
			if(find(z) != p) {
				System.out.println("NO");
				System.exit(0);
			}
		}
		System.out.println("YES");
	}
	private static void union(int x, int y) {
		if(x==y) return;
		arr[x] = y;
		
	}
	private static int find(int i) {
		if(arr[i] == i) return i;
		else return arr[i] = find(arr[i]);
	}
}
