package mypack;
import java.util.*;
public class pair_arlist_sort {
	static class Pair implements Comparable<Pair> {
		int num;
		int cnt;
		Pair(int num, int cnt){
			this.num = num;
			this.cnt = cnt;
		}
		
		public int compareTo(Pair a) {
			if(this.cnt < a.cnt) {
				return -1;
			}
			else if(this.cnt > a.cnt) {
				return 1;
			}
			else {
				if(this.num > a.num) return 1;
				else return -1;
			}
		}
	}
	public static void main(String[] args) {
		ArrayList<Pair> al = new ArrayList<>();
		al.add(new Pair(2, 1));
		al.add(new Pair(1, 2));
		al.add(new Pair(3, 1));
		al.add(new Pair(4, 2));
		al.add(new Pair(5, 3));
		Collections.sort(al);
		for(Pair p : al) {
			System.out.print(p.num +" "+p.cnt);
			System.out.println();
		}
	}
}
