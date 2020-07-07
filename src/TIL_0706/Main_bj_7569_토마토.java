package TIL_0706;
import java.util.*;
public class Main_bj_7569_토마토 {
	static int[][][] map;
	static int[][][] dist;
	static int M, N, H;
	static int[] dr = {-1,1,0,0,0,0};
	static int[] dc = {0,0,-1,1,0,0};
	static int[] dz = {0,0,0,0,-1,1};
	static class Pair {
		int r, c, z;
		public Pair(int r, int c, int z) {
			this.r = r;
			this.c = c;
			this.z = z;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();
		map = new int[H][N][M];
		dist = new int[H][N][M];
		int tomato = 0;
		Queue<Pair> q = new LinkedList<>();
		for(int z=0; z<H; z++) {
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					map[z][r][c] = sc.nextInt();
					if(map[z][r][c] == 1) {
						q.add(new Pair(r,c,z));
					}
					if(map[z][r][c] == 0) tomato++;
				}
			}
		}
		int dd = 0;
		if(tomato == 0) {
			System.out.println(0);
		}
		else {
			while(!q.isEmpty()) {
				Pair p = q.poll();
				for(int k=0; k<6; k++) {
					int nr = p.r + dr[k];
					int nc = p.c + dc[k];
					int nz = p.z + dz[k];
					if(0<=nr && nr < N && 0<=nc && nc<M && 0<=nz && nz<H && map[nz][nr][nc] == 0 && dist[nz][nr][nc] == 0) {
						dist[nz][nr][nc] = dist[p.z][p.r][p.c]+1; 
						q.add(new Pair(nr,nc,nz));
						tomato--;
						dd = dist[nz][nr][nc];
					}
				}
			}
			if(tomato>0) System.out.println(-1);
			else System.out.println(dd);
		}
	}
}
