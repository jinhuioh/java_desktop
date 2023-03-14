package codingTest;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
//문제 : 컵홀더
//예제 입력 3 
//9
//SLLLLSSLL
//예제 출력 3 
//7

public class codingTest6 {
	static int answer;
	static long n,m;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		answer = 1;
		for(int i = 0; i<s.length(); i++) {
			char s_one = s.charAt(i);
			if (s_one =='S') answer++;
			else if(s_one == 'L') {
				i++;
				answer++;
			}
		}
		if(answer>n) {
			System.out.println(n);
		}else {
			System.out.println(answer);
		}
	}
}