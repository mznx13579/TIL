package TIL_0712;
import java.util.*;
public class Main_bj_1475_방번호 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int[] nums = new int[10];
		for(int i=0; i<str.length(); i++) {
			nums[str.charAt(i)-'0']++;
		}
		int total = str.length();
		int set = 0;
		while(true) {
			set++;
			boolean[] sticker = new boolean[10];
			for(int i=0; i<10; i++) {
				if(nums[i] > 0 && sticker[i] == false) {
					nums[i]--;
					sticker[i] = true;
					total--;
				}
			}
			if(sticker[9] ==false && nums[6] > 0) {
				sticker[9] = true;
				nums[6]--;
				total--;
			}
			if(sticker[6] == false && nums[9] > 0) {
				sticker[6] = true;
				nums[9]--;
				total--;
			}
			if(total == 0) break;
		}
		System.out.println(set);
	}
}
