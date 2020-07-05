package TIL_0227;

import java.util.HashSet;
import java.util.Scanner;
//a n t i c
public class b_1062 {
	static String[] words;
	static HashSet<Character> s = new HashSet<>();
	static char[] chars;
	static char[] ans;
	static int max = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		words = new String[n];
		for(int i=0; i<n; i++) {
			String str = sc.next();
			words[i] = str.substring(4, str.length()-4);
		} //  r h e l o 중에 k - 5 를 선택 하고 이것들을 순회하면서 선택된애들이 포함되어 있으면 카운트 늘
		
		for(int i=0; i<n; i++) {
			String tmp = words[i];
			for(int j=0; j<tmp.length(); j++) {
				if(tmp.charAt(j) == 'a' || tmp.charAt(j) == 'n'|| tmp.charAt(j) == 't'|| tmp.charAt(j) == 'i'|| tmp.charAt(j) == 'c') continue;
				s.add(tmp.charAt(j));
			}
		}
		chars = new char[s.size()];
		int x = 0;
		for(char c : s) {
			chars[x] = c;
			x++;
		}
		if(k-5 < 0 ) {
			System.out.println(0);
		}
		else if (k-5 > s.size()){
			System.out.println(n);
			
		}
		else {
			Combination(new char[k-5], 0, 0);
			System.out.println(max);
		}
		
	}
	
	static void Combination(char[] ans, int idx, int r) {
		if(r == ans.length) {
			int cnt = 0;
			for(int i=0; i<words.length; i++) {
				boolean[] check = new boolean[words[i].length()];
				for(int j=0; j<words[i].length(); j++) {
					if(words[i].charAt(j) == 'a' || words[i].charAt(j) == 'n' || words[i].charAt(j)=='t' || words[i].charAt(j) == 'i' || words[i].charAt(j)=='c') check[j] = true;
					for(int l=0; l<ans.length; l++) {
						if(words[i].charAt(j) == ans[l]) check[j] = true;
					}
				}
				boolean flag = true;
				for(int j=0; j<words[i].length(); j++) {
					if(!check[j]) {
						flag = false;
						break;
					}
				}
				if(flag == true) cnt++;
			}
			if(max < cnt) max = cnt;
			return;
		}
		if(idx == s.size()) return;
		ans[r] = chars[idx];
		Combination(ans, idx+1, r+1);
		Combination(ans, idx+1, r);
	}
	
}


