package TIL_0718;
/*
 * GCF
 * 783
 * 98654
 * ACDEB
 * 
 * ABCDEFG
 * 9876543
 * */
import java.util.*;
public class Main_bj_1339_단어수학 {
	
	static int N;
	static HashMap<Character, Integer> alphabet;
	static String[] arr;
	static Set<Character> set;
	static int[] number;
	static boolean[] check;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new String[N];
		set = new HashSet<>();
		max = 0;
		for(int i=0; i<N; i++) {
			String str = sc.next();
			arr[i] = str;
			for(int j=0; j<str.length(); j++) {
				set.add(str.charAt(j));
			}
		}
		alphabet = new HashMap<>();
		int x=0;
		for(Character s : set) {
			alphabet.put(s, x++);
		}
		number = new int[set.size()];
		check = new boolean[set.size()];
		for(int i=0; i<set.size(); i++) {
			number[i] = 9-i;
		}
		Permutation(new int[set.size()], 0);
		System.out.println(max);
	}
	private static void Permutation(int[] ans, int idx) {
		if(idx == ans.length) {
			int sum =0;
			for(int i=0; i<N; i++) {
				int num = ans[alphabet.get(arr[i].charAt(0))];
				if(arr[i].length()>1) {
					for(int j=1; j<arr[i].length(); j++) {
						num*=10;
						num += ans[alphabet.get(arr[i].charAt(j))];
					}
				}
				sum += num;
			}
			if(max < sum) max = sum;
			return;
		}
		for(int i=0; i<ans.length; i++) {
			if(!check[i]) {
				ans[idx] = number[i];
				check[i] = true;
				Permutation(ans, idx+1);
				check[i] = false;
			}
		}
	}
}
