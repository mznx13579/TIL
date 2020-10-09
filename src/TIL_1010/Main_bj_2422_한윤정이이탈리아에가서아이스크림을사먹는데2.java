package TIL_1010;
import java.util.*;

public class Main_bj_2422_한윤정이이탈리아에가서아이스크림을사먹는데2 {
	static int N, M;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][N];
		for(int i=0; i<M; i++) {
			int a, b;
			a = sc.nextInt();
			b = sc.nextInt();
			a--; b--;
			arr[a][b] = arr[b][a] = 1;
		}
		int ans = 0;
		for(int i=0; i<N-2; i++) {
			for(int j=i+1; j<N-1; j++) {
				for(int k=j+1; k<N; k++) {
					if(arr[i][j] == 1 || arr[i][k] == 1 || arr[j][k] == 1) continue;
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}
