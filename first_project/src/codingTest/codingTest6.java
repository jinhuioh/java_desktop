package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

//문제: 장군
//오랜만에 휴가를 나온 호근이는 문득 동아리방에 있는 장기가 하고 싶어졌다.
//하지만 장기를 오랫동안 하지 않은 탓인지 예전에는 잘 쓰던 상을 제대로 쓰는 것이 너무 힘들었다. 
//호근이를 위해 상을 어떻게 써야 할지 도와주자.
//
//입력
//첫 번째 줄에는 상의 위치를 의미하는 정수 R1, C1이 주어진다.
//
//두 번째 줄에는 왕의 위치를 의미하는 정수 R2, C2가 주어진다. 장기판에서 Ri (0 ≤ Ri ≤ 9)는 행을,
//Ci (0 ≤ Ci ≤ 8)는 열을 의미한다.
//
//왕은 항상 궁성에 자리 잡고 있으며, 상과 왕의 위치는 겹치지 않는다.
//
//출력
//상이 왕에게 도달할 수 있는 최소 이동 횟수를 출력한다. 만약 도달할 수 없다면 -1을 출력한다.
public class codingTest6 {
		public static void main(String[] args) throws IOException {
			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 int n = Integer.parseInt(br.readLine());
			 int[][] dp = new int[n+1][10];
			 
			 for(int i = 0; i<10; i++) {
				 dp[0][i] = 1;
			 }
			 
			 for(int i = 1; i<n+1; i++) {//i는 자리수를 뜻 함
				 for(int j = 0; j<10; j++) {//j는 i자릿수에서 첫번째값이 j일때 만들어질 수 있는 오르막의 수
					 for(int k = j; k<10; k++) {//만들어질 수 있는 오르막의 수는 i-1번째 행의 값들을 j부터 9까지 전부 더해주는 것이다.
						 dp[i][j] += dp[i-1][k];
						 dp[i][j] %= 10007;
					 }
				 }
			 }
			 System.out.println(dp[n][0] % 10007);
		}
		}