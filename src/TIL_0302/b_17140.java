package TIL_0302;

import java.util.*;
public class b_17140 {
	static int max_row; static int max_col;
	static class ValueComparator implements Comparator<Integer> {
		Map<Integer, Integer> base;
		public ValueComparator(Map<Integer, Integer> base) {
			this.base = base;
		}
		public int compare(Integer a, Integer b) {
			if(base.get(a) < base.get(b)) {
				return -1;
			}
			else if(base.get(a) > base.get(b)){
				return 1;
			}
			else {
				if(a>b) return 1;
				else return -1;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] ans = new int[100][100];
		int r = sc.nextInt(); int c = sc.nextInt(); int k = sc.nextInt();
		r--; c--;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				ans[i][j] = sc.nextInt();
			}
		}
		int t = 0;
		while(ans[r][c] != k) {
			t++;
			if(t > 100) {
				t = -1; 
				break;
			}
			int mode = modeSelect(ans);
			if(mode == 1) {
				ans = rSort(ans);
			}
			else if(mode == 2){
				ans = cSort(ans);
			}
		}
		System.out.println(t);
		
	}
	static int modeSelect(int[][] ans) {
		int row=0; int col=0;
		max_row = 0; max_col = 0;
		while(row < 100 && ans[row][0] != 0 ) {
			while(col < 100 && ans[row][col]!=0) {
				col++;
				if(max_col < col) max_col = col;
			}
			col = 0;
			row++;
		}
		row = 0; col = 0;
		while(col < 100 && ans[0][col] != 0) {
			while(row < 100 && ans[row][col] != 0) {
				row++;
				if(max_row < row) max_row = row;
			}
			row = 0;
			col++;
		}
		if(max_row >= max_col) return 1;
		else return 2;
	}
	static int[][] rSort(int[][] ans) {
		HashMap<Integer, Integer> m;
		int[][] tmp = new int[100][100];
		for(int i=0; i<max_row; i++) {
			m = new HashMap<>();
			ValueComparator bvc = new ValueComparator(m);
			TreeMap<Integer, Integer> sorted_map = new TreeMap<Integer, Integer>(bvc);
			for(int j=0; j<max_col; j++) {
				if(ans[i][j] == 0) continue;
				if(m.containsKey(ans[i][j])) {
					m.replace(ans[i][j], m.get(ans[i][j])+1);
				}
				else {
					m.put(ans[i][j], 1);
				}
			}
			sorted_map.putAll(m);
			int x = 0;
			for(Map.Entry<Integer, Integer> entry : sorted_map.entrySet()) {
				tmp[i][x] = entry.getKey();
				x++;
				tmp[i][x] = m.get(entry.getKey());
				x++;
			}
		}
		return tmp;
	}
	static int[][] cSort(int[][] ans) {
		HashMap<Integer, Integer> m;
		int[][] tmp = new int[100][100];
		for(int i=0; i<max_col; i++) {
			m = new HashMap<>();
			ValueComparator bvc = new ValueComparator(m);
			TreeMap<Integer, Integer> sorted_map = new TreeMap<Integer, Integer>(bvc);
			for(int j=0; j<max_row; j++) {
				if(ans[j][i] == 0) continue;
				if(m.containsKey(ans[j][i])) {
					m.replace(ans[j][i], m.get(ans[j][i])+1);
				}
				else {
					m.put(ans[j][i], 1);
				}
			}
			sorted_map.putAll(m);
			int x = 0;
			for(Map.Entry<Integer, Integer> entry : sorted_map.entrySet()) {
				tmp[x][i] = entry.getKey();
				x++;
				tmp[x][i] = m.get(entry.getKey());
				x++;
			}
		}
		return tmp;
	}
}

