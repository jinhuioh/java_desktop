package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class codingTest {
	//static=전역 , final=최종적인, 즉 수정불가능한 변수.
	//static final=상수

	
	//병사 배치하기
//	문제
//	N명의 병사가 무작위로 나열되어 있다. 각 병사는 특정한 값의 전투력을 보유하고 있으며, 
//	병사를 배치할 때는 전투력이 높은 병사가 앞쪽에 오도록 내림차순으로 배치를 하고자 한다. 
//	다시 말해 앞쪽에 있는 병사의 전투력이 항상 뒤쪽에 있는 병사보다 높아야 한다.
//
//	또한 배치 과정에서는 특정한 위치에 있는 병사를 열외시키는 방법을 이용한다. 
//	그러면서도 남아있는 병사의 수가 최대가 되도록 하고 싶다.
//	입력
//	첫째 줄에 N이 주어진다. (1 ≤ N ≤ 2,000) 둘째 줄에 각 병사의 전투력이 공백을 기준으로 구분되어 차례대로 주어진다. 각 병사의 전투력은 10,000,000보다 작거나 같은 자연수이다.
//
//	출력
//	첫째 줄에 남아있는 병사의 수가 최대가 되도록 하기 위해서 열외해야 하는 병사의 수를 출력한다.
//
//	예제 입력 1 
//	7
//	15 11 4 8 5 2 4
//	예제 출력 1 
//	2
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] map = new int[n];
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		
		for(int i = n-1; i>=0; i--) {//거꾸로 입력받기
			map[i] = Integer.parseInt(st.nextToken());
		}//for
		
		for(int i = 1; i<n; i++) {
			for(int j = 0; j<i; j++) {
				if(map[i]>map[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}//for
		}//for

		//최대값 구하기
		int max = dp[0];
		for(int i = 1; i<n; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(n-max);
	}
}