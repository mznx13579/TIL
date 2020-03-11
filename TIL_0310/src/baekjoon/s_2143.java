package baekjoon;
import java.util.*;
public class s_2143 {

	/*
	 * 1 3 1 2
	 * 
	 * 1				= 1 o
	 * 1 + 3			= 4 o
	 * 1 + 3 + 1		= 5 o
	 * 1 + 3 + 1 + 2	= 7 o
	 * 3				= 3 o
	 * 3 + 1			= 4 o
	 * 3 + 1 + 2		= 6 o
	 * 1				= 1 o
	 * 1 + 2			= 3 0
	 * 2				= 2 0
	 * 
	 * 		1 1 2 3 3 4 4 5 6 7
	 * 숫자  1 2 3 4 5 6 7
	 * 갯수  2 1 2 2 1 1 1
	 * 
	 * 		1 2 3 4 5 6 
	 * 숫자  1 2 3 4 5 6
	 * 갯수  1 1 1 1 1 1
	 * 
	 * 1 3 2
	 * 1				= 1
	 * 1 + 3			= 4
	 * 1 + 3 + 2		= 6
	 * 3				= 3
	 * 3 + 2			= 5
	 * 2				= 2
	 */
	static int T;
	static int n;
	static int m;
	static int[] a;
	static int[] b;
	static ArrayList<Integer> al;
	static ArrayList<Integer> bl;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		n = sc.nextInt();
		a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		m = sc.nextInt();
		b = new int[m];
		for(int i=0; i<m; i++) {
			b[i] = sc.nextInt();
		}
		
		//누적합 구하기
		al = new ArrayList<Integer>();
		bl = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			int sum = 0;
			for(int j=i; j<n; j++) {
				sum+=a[j];
				al.add(sum);
			}
		}
		for(int i=0; i<m; i++) {
			int sum = 0;
			for(int j=i; j<m; j++) {
				sum+=b[j];
				bl.add(sum);
			}
		}
		Collections.sort(al);
		Collections.sort(bl);
		
		HashMap<Integer, Integer> m1 = new HashMap<>();
		for(int x : al) {
			if(m1.containsKey(x)) {
				m1.put(x, m1.get(x)+1);
			} else {
				m1.put(x, 1);
			}
		}
		
		
		long ans = 0;
		for(int x : bl) {
			if(m1.containsKey(T-x)) {
				ans+=m1.get(T-x);
			}
		}
		System.out.println(ans);
		
	}
}
