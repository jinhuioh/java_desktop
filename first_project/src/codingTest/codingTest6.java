package codingTest;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
//문제 : 약수구하기

public class codingTest6 {
	static int n,k;
	static List<Integer> num_list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		num_list = new ArrayList<>();
		for(int i = 1; i<=n; i++) {
			if(n%i==0) {
				num_list.add(i);
			}
		}//for
		if(k<=num_list.size()) {
			System.out.println(num_list.get(k-1));
		}
		else {
			System.out.println(0);
		}
		
	}
}