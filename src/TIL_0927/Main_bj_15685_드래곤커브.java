package TIL_0927;
import java.util.*;

public class Main_bj_15685_드래곤커브 {
	static int N, x, y, d, g;
	static int[] dr = {0,-1,0,1};//우, 상, 좌, 하 
	static int[] dc = {1,0,-1,0};
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[101][101];
		for(int i=0; i<N; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			d = sc.nextInt();
			g = sc.nextInt();
			map[y][x] = 1;
			map[y+dr[d]][x+dc[d]] = 1;
			ArrayList<Integer> al = new ArrayList<>();
			al.add(d);
			MakeDragonCurve(al, y+dr[d], x+dc[d], g);
		}
		int cnt = 0;
		for(int r=0; r<100; r++) {
			for(int c=0; c<100; c++) {
				if(map[r][c] == 1 && map[r+1][c] == 1 && map[r][c+1] ==1 && map[r+1][c+1] ==1) cnt++;
			}
		}
		System.out.println(cnt);
	}
	private static void MakeDragonCurve(ArrayList<Integer> al, int end_r, int end_c, int g) {
		if(g == 0) return;
		int r = end_r;
		int c = end_c;
		ArrayList<Integer> tmp = new ArrayList<>();
		for(int x = al.size()-1; x>=0; x--) {
			int nr = r + dr[(al.get(x)+1)%4];
			int nc = c + dc[(al.get(x)+1)%4];
			tmp.add((al.get(x)+1)%4);
			map[nr][nc] = 1;
			r = nr;
			c = nc;
		}
		for(int x :tmp) al.add(x);
		MakeDragonCurve(al, r, c, g-1);
	}
	
}
