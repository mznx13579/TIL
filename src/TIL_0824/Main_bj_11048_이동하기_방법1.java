package TIL_0824;
import java.util.*;
public class Main_bj_11048_이동하기_방법1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] a = new int[N+1][M+1];
		int[][] d = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				d[i][j] = Math.max(d[i-1][j], d[i][j-1]);
				d[i][j] = Math.max(d[i-1][j-1], d[i][j]);
				d[i][j] += a[i][j];
			}
		}
		System.out.println(d[N][M]);
	}
}
