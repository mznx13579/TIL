package TIL_0927;
import java.util.*;

public class Main_bj_3568_iSharp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] slice = str.split(" ");
		for(int i=1; i<slice.length; i++) {
			String tmp = slice[i];
			tmp = tmp.substring(0, tmp.length()-1);
			String tmp2 = "";
			String x = "";
			for(int j = tmp.length()-1; j>=0; j--) {
				if((tmp.charAt(j)>='a' && tmp.charAt(j)<='z') || (tmp.charAt(j)>='A' && tmp.charAt(j)<='Z')) {
					x += tmp.charAt(j)+"";
				}
				else if(tmp.charAt(j)=='[') {
					tmp2 += ']'+"";
				}
				else if(tmp.charAt(j)==']') {
					tmp2 += '['+"";
				}
				else tmp2 += tmp.charAt(j)+"";
			}
			tmp2 +=" ";
			for(int j = x.length()-1; j>=0; j--) {
				tmp2 += x.charAt(j)+"";
			}
			tmp2 +=";";
			slice[i] = tmp2;
		}
		for(int i=1; i<slice.length; i++) {
			System.out.println(slice[0]+slice[i]);
		}
	}
}
