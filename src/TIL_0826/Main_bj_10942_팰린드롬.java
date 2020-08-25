package TIL_0826;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_10942_팰린드롬 {
	static int N;
	static int[] arr;
	static int M;
	static boolean[][] palin;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		palin = new boolean[N][N];
		for(int c=0; c<N; c++) {
			palin[c][c] = true;
		}
		for(int c=0; c<N-1; c++) {
			if(arr[c] == arr[c+1]) {
				palin[c][c+1] = true;
			}
		}
		for(int c=2; c<N; c++) {
			for(int r=0; r<N-c; r++) {
				if(arr[r] != arr[r+c]) {
					palin[r][r+c] = false;
					continue;
				}
				if(palin[r+1][r+c-1] == true ) {
					palin[r][r+c] = true;
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			S--; E--;
			if(palin[S][E] == true) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
		
	}
}
