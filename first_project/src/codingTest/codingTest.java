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

	//상자 쌓기
//	8
//	1 6 2 5 7 3 5 6
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] map = new int[n];
		
		for(int i = 0; i<n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}//for

		//탐색시작
		int[] dp = new int[n];
		//dp배열의 모든 값을 1로 초기화
		Arrays.fill(dp, 1);
		int answer = 0;
		
		for(int i = 0; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(map[i]> map[j]) {//현재값보다 이전값이 더 크면 연산 안하므로 패스
					//지금 위치값 vs 더 작은거 까지 계산한거에+1
					System.out.println("i>> "+i+" j>> "+j+" dpi>> "+dp[i]+" dp[j]+1>> "+(dp[j]+1));
					dp[i] = Math.max(dp[i], dp[j]+1);
					
				}
			}//for
			answer = Math.max(answer, dp[i]);
		}//for
		System.out.println(answer);
	}
}