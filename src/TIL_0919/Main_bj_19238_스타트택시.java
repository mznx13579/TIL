package TIL_0919;
import java.util.*;

public class Main_bj_19238_스타트택시 {
	static class Taxi {
		int r, c, f;
		boolean in;
		int sf, success;
		public Taxi(int r, int c, int f, boolean in, int sf, int success) {
			super();
			this.r = r;
			this.c = c;
			this.f = f;
			this.in = in;
			this.sf = sf;
			this.success = success;
		}
		@Override
		public String toString() {
			return "Taxi [r=" + r + ", c=" + c + ", f=" + f + ", in=" + in + ", sf=" + sf + ", success=" + success
					+ "]";
		}
		
		
	}
	static int N, M, F;
	static int[][] map;
	static boolean[][] visited;
	static int SR, SC;
	static int PR, PC, DR, DC;
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	static ArrayList<Taxi> destination;
	static PriorityQueue<Taxi> q;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		F = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		SR = sc.nextInt();
		SC = sc.nextInt();
		SR--; SC--;
		destination = new ArrayList<>();
		int x = 11;
		for(int i=0; i<M; i++) {
			PR = sc.nextInt();
			PC = sc.nextInt();
			DR = sc.nextInt();
			DC = sc.nextInt();
			map[--PR][--PC] = x++;
			DR--; DC--;
			destination.add(new Taxi(DR, DC, 0, false, 0, 0));
		}
		q = new PriorityQueue<Taxi>(new Comparator<Taxi>() {

			@Override
			public int compare(Taxi o1, Taxi o2) {
				if(o1.r == o2.r) {
					return o1.c-o2.c;
				}
				else return o1.r-o2.r;
			}
			
		});
		if(map[SR][SC] >= 11) {
			q.add(new Taxi(SR, SC, F, true, F, 0));
		}
		else {
			q.add(new Taxi(SR, SC, F, false, 0, 0));
		}
		int ans = -1;
		visited[SR][SC] = true;
		int destinationR = -1;
		int destinationC = -1;
		int xxx = -1;
		L:while(!q.isEmpty()) {
			Taxi t = q.poll();
			xxx = t.success;
			System.out.println(t.toString());
			if(t.success == destination.size()) {
				ans = t.f;
				break;
			}
			for(int k=0; k<4; k++) {
				int nr = t.r+dr[k];
				int nc = t.c+dc[k];
				if(0<=nr && nr < N && 0<=nc && nc < N && map[nr][nc] != 1 && visited[nr][nc] == false) {
					if(t.in == false && map[nr][nc] == 0) {
						visited[nr][nc] = true;
						if(t.f-1 < 0) {
							ans = -1;
							break L;
						}
						q.add(new Taxi(nr, nc, t.f-1, false, t.sf, t.success));
					}
					else if(t.in == false && map[nr][nc] >= 11) {
						q = new PriorityQueue<Taxi>(new Comparator<Taxi>() {

							@Override
							public int compare(Taxi o1, Taxi o2) {
								if(o1.r == o2.r) {
									return -o1.c-o2.c;
								}
								else return -o1.r-o2.r;
							}
							
						});
						visited = new boolean[N][N];
						visited[nr][nc] = true;
						int xx = (map[nr][nc]%10);
						if(t.f-1 < 0) {
							ans = -1;
							break L;
						}
						System.out.println(xx+"손님을 태움");
						q.add(new Taxi(nr,nc, t.f-1, true, t.f-1, t.success));
						destinationR = destination.get((map[nr][nc]%10)-1).r;
						destinationC = destination.get((map[nr][nc]%10)-1).c;
						map[nr][nc] = 0;
						break;
					}
					else if(t.in == true && map[nr][nc] == 0 && !(nr == destinationR && nc == destinationC)) {
						visited[nr][nc] = true;
						if(t.f-1 < 0) {
							ans = -1;
							break L;
						}
						q.add(new Taxi(nr,nc, t.f-1, true, t.sf, t.success));
					}
					else if(t.in == true && nr == destinationR && nc == destinationC) {
						q = new PriorityQueue<Taxi>(new Comparator<Taxi>() {
							@Override
							public int compare(Taxi o1, Taxi o2) {
								if(o1.r == o2.r) {
									return -o1.c-o2.c;
								}
								else return -o1.r-o2.r;
							}
							
						});
						visited = new boolean[N][N];
						visited[nr][nc] = true;
						if(t.f-1 < 0) {
							ans = -1;
							break L;
						}
						System.out.println("손님을 내림");
						q.add(new Taxi(nr, nc, (t.sf-(t.f-1))*2 + t.f-1 , false, 0, t.success+1));
						destinationC = -1;
						destinationR = -1;
						if(map[nr][nc]>=11) {
							int one = (t.sf-(t.f-1))*2 + t.f-1;
							int two = t.success+1;
							q = new PriorityQueue<Taxi>(new Comparator<Taxi>() {

								@Override
								public int compare(Taxi o1, Taxi o2) {
									if(o1.r == o2.r) {
										return -o1.c-o2.c;
									}
									else return -o1.r-o2.r;
								}
								
							});
							System.out.println("다시손님을태움");
							q.add(new Taxi(nr,nc,one,true,one,two));
							destinationR = destination.get((map[nr][nc]%10)-1).r;
							destinationC = destination.get((map[nr][nc]%10)-1).c;
							map[nr][nc] = 0;
						}
						break;
						
					}
				}
			}
		}
		if(xxx < destination.size()) {
			ans = -1;
		}
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] >= 11) {
					ans = -1;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}
