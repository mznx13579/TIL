package DONOTUPLOAD;
import java.util.*;

public class 모래성쌓기_DONOTUPLOAD {
	static class Node {
		int r, c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	static int[] dr = {-1,-1,-1,0,1,1,1,0};
	static int[] dc = {-1,0,1,1,1,0,-1,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int[][] map = new int[H][W];
			for(int r =0 ; r<H; r++) {
				String str = sc.next();
				for(int c = 0; c< W; c++) {
					if(str.charAt(c) != '.') {
						map[r][c] = str.charAt(c)-'0';
					}
				}
			}
			Queue<Node> queue = new LinkedList<>();
			for(int r=0; r<H; r++) {
				for(int c=0; c<W; c++) {
					if(map[r][c] == 0) {
						for(int k=0; k<8; k++) {
							int nr = r + dr[k];
							int nc = c + dc[k];
							if(nr < 0 || nc < 0 || nr >=H || nc>=W) continue;
							if(map[nr][nc] > 0) {
								map[nr][nc]--;
								if(map[nr][nc] == 0) {
									map[nr][nc] = -1;
									queue.add(new Node(nr,nc));
								}
							}
						}
					}
				}
			}
			int ans = 0;
			while(!queue.isEmpty()) {
				int size = queue.size();
				for(int i=0; i<size; i++) {
					Node node = queue.poll();
					for(int k=0; k<8; k++) {
						int nr = node.r + dr[k];
						int nc = node.c + dc[k];
						if(nr < 0 || nc < 0 || nr >=H || nc>=W) continue;
						if(map[nr][nc] > 0) {
							map[nr][nc]--;
							if(map[nr][nc] == 0) {
								map[nr][nc] = -1;
								queue.add(new Node(nr,nc));
							}
						}
					}
				}
				ans++;
			}
			System.out.println("#"+tc+" "+ans);
		}
	}

}

/*
2
5 6
......
.939..
.3428.
.9393.
......
10 10
..........
.99999999.
.9.323239.
.91444449.
.91444449.
.91444449.
.91444449.
.91232329.
.99999999.
..........
*/