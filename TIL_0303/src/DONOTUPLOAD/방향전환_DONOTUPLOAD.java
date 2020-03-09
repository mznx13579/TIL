package DONOTUPLOAD;
import java.util.*;
public class 방향전환_DONOTUPLOAD {
	static class Point {
		int x, y, cnt;
		boolean dir;
		Point(int x, int y, int cnt, boolean dir){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}
	}
	static int sx;
	static int sy;
	static int fx;
	static int fy;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			sx = sc.nextInt() + 100;
			sy = sc.nextInt() + 100;
			fx = sc.nextInt() + 100;
			fy = sc.nextInt() + 100;
			Queue<Point> queue = new LinkedList<>();
			boolean[][][] visited = new boolean[201][201][2];
			queue.add(new Point(sx, sy, 0, true));
			queue.add(new Point(sx, sy, 0, false));
			visited[sx][sy][0] = true;
			visited[sx][sy][1] = true;
			
			while(!queue.isEmpty()) {
				Point point = queue.poll();
				if(point.x == fx && point.y == fy) {
					System.out.println("#"+tc+" "+point.cnt);
					break;
				}
				if(point.dir) {
					for(int d = 0; d < 2; d++) {
						int nx = point.x + dx[d];
						int ny = point.y + dy[d];
						if(nx < 0 || ny < 0 || nx > 200 || ny > 200) continue;
						if(visited[nx][ny][0]) continue;
						queue.add(new Point(nx,ny,point.cnt+1, !point.dir));
						visited[nx][ny][0] = true;
						
					}
				}
				else {
					for(int d = 2; d < 4; d++) {
						int nx = point.x + dx[d];
						int ny = point.y + dy[d];
						if(nx < 0 || ny < 0 || nx > 200 || ny > 200) continue;
						if(visited[nx][ny][1]) continue;
						queue.add(new Point(nx,ny,point.cnt+1, !point.dir));
						visited[nx][ny][1] = true;
					}
				}
			}
			
		}
	}
}
