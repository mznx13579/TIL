import java.util.*;

public class l5 {
	public static void main(String[] args) {
		String[] companies = {"A fabdec 2", "B cebdfa 2", "C ecfadb 2"};
		String[] applicants = {"a BAC 1", "b BAC 3", "c BCA 2", "d ABC 3", "e BCA 3", "f ABC 2"};
		String[] answer = new String[companies.length];
		char[][] c_table = new char[companies.length][applicants.length+1];
		HashMap<Character, Integer> c_map = new HashMap<>();
		char[][] a_table = new char[applicants.length][companies.length+1];
		HashMap<Character, Integer> a_map = new HashMap<>();
		for(int i=0; i<companies.length; i++) {
			String tmp = companies[i];
			String[] sp = tmp.split(" ");
			c_table[i][0] = sp[0].charAt(0);
			for(int j=1; j<=applicants.length; j++) {
				c_table[i][j] = sp[1].charAt(j-1);
			}
			c_map.put(sp[0].charAt(0), Integer.parseInt(sp[2]));
		}
		for(int i=0; i<applicants.length; i++) {
			String tmp = applicants[i];
			String[] sp = tmp.split(" ");
			a_table[i][0] = sp[0].charAt(0);
			for(int j=1; j<=Integer.parseInt(sp[2]); j++) {
				a_table[i][j] = sp[1].charAt(j-1);
			}
			a_map.put(sp[0].charAt(0), Integer.parseInt(sp[2]));
			System.out.println(Arrays.toString(a_table[i]));
		}
		
		ArrayList<Character> rejected = new ArrayList<>();
		int round = 1;
		for(int i=0; i<companies.length; i++) {
			ArrayList<Character> apply = new ArrayList<>();
			for(int j=0; j<applicants.length; j++) {
				if(a_table[j][round] == '\u0000') continue;
				else if(a_table[j][round] == c_table[i][0]) {
					apply.add(a_table[j][0]);
				}
			}
			for(int j=1; j<=applicants.length; j++) {
				
			}
			
		}
	}
}
