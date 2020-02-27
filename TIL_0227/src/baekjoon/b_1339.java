package baekjoon;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class b_1339 {
   static int[] num = {0,1,2,3,4,5,6,7,8,9};

   static String[] ans;
   static char[] arr;
   static int[] result;
   static long[] summ;

   static int max =0;
   static HashMap<Character, Integer> map = new HashMap<Character, Integer>();
   public static void main(String[] args) throws FileNotFoundException     {
      System.setIn(new FileInputStream("단어수학.txt"));
      Scanner sc = new Scanner(System.in);
      HashSet<Character> s = new HashSet<Character>();

      long start = System.currentTimeMillis();

      int N = sc.nextInt();
      ans = new String[N];
      for (int i = 0; i < N; i++) {
         String ss = sc.next();
         ans[i] = ss;
         for (int j = 0; j < ss.length(); j++) {
            s.add(ss.charAt(j));
         }
      }

      arr = new char[s.size()];
      result= new int[s.size()];
      summ= new long[ans.length];
      
      int i = 0;
      for (Character c : s) {
         arr[i] = c;
         i++;
      }
      comb(0,0);

      System.out.println(max);
      long end = System.currentTimeMillis();

      System.out.println( "실행 시간 : " + ( end - start )/1000.0 );
   }

   static void comb(int idx, int s_idx) {
      if (result.length == s_idx) {
         perm(result, 0);
         return;
      }
      if (num.length == idx) return;
      result[s_idx] = num[idx];
      comb(idx+1, s_idx+1);
      comb(idx+1, s_idx);
   }

   static void perm(int[] result, int idx) {
      if (result.length == idx) {
         makeInt();
         int sum = 0;
         for (int i = 0; i < summ.length; i++) {
            sum+=summ[i];
         }
         max = Math.max(max, sum);
         return;
      }

      for (int i = idx; i < result.length; i++) {
         swap(idx, i);
         perm(result, idx+1);
         swap(idx, i);
      }
   }

   static void swap(int a, int b) {
      int tmp = result[a];
      result[a] = result[b];
      result[b] = tmp;
   }
   
   static void makeInt() {
      map.clear();
      for (int i = 0; i < result.length; i++) {
         map.put(arr[i], result[i]);
      }
      for (int i = 0; i < ans.length; i++) {
         long tmp = 0;
         for (int j = ans[i].length()-1, k = 0; j >= 0 && k<ans[i].length(); j--, k++) {
            tmp += Math.pow(10,j)*map.get(ans[i].charAt(k));
         }
         summ[i] = tmp;
      }
   }
}