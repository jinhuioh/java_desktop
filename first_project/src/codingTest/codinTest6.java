package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class codinTest6 {
//	점프점프
//	문제
//	재환이가 1×N 크기의 미로에 갇혀있다. 미로는 1×1 크기의 칸으로 이루어져 있고, 각 칸에는 정수가 하나 쓰여 있다. i번째 칸에 쓰여 있는 수를 Ai라고 했을 때, 재환이는 Ai이하만큼 오른쪽으로 떨어진 칸으로 한 번에 점프할 수 있다. 예를 들어, 3번째 칸에 쓰여 있는 수가 3이면, 재환이는 4, 5, 6번 칸 중 하나로 점프할 수 있다.
//
//	재환이는 지금 미로의 가장 왼쪽 끝에 있고, 가장 오른쪽 끝으로 가려고 한다. 이때, 최소 몇 번 점프를 해야 갈 수 있는지 구하는 프로그램을 작성하시오. 만약, 가장 오른쪽 끝으로 갈 수 없는 경우에는 -1을 출력한다.
//
//	입력
//	첫째 줄에 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄에는 Ai (0 ≤ Ai ≤ 100)가 주어진다.
//
//	출력
//	재환이가 최소 몇 번 점프를 해야 가장 오른쪽 끝 칸으로 갈 수 있는지 출력한다. 만약, 가장 오른쪽 끝으로 갈 수 없는 경우에는 -1을 출력한다.
//
//	예제 입력 1 
//	10
//	1 2 0 1 3 2 1 5 4 2
//	예제 출력 1 
//	5
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int [n+1];
		long[] dp = new long[1101];//n의 범위 최대1000 + 점프의 최대값 100 + 1인덱스부터시작
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = Integer.MAX_VALUE;//int의 최대값 (2,147,483,647)으로 dp를 구성
			System.out.println(dp[i]);
		}
		dp[1]=0;//1번째는 0부터 시작 점프할때마다 +1 해줌
		
		for(int i=1; i<=n; i++) {
			//최소값으로 값 갱신이 안되었다면 continue ex) arr값이 0이면 for문을 안돌아서 최소값 갱신 안됨.
			if(dp[i] >= Integer.MAX_VALUE) continue; 
			for(int j=1; j<=arr[i]; j++) {
				//dp의 범위가 i를 벗어나면 전부 0 이 들어있으므로 최소값은 0이된다.
				dp[j+i] = Math.min(dp[i+j], dp[i]+1);//지금 위치의dp값과 이전값에 +1 한걸로 비교. 점프할때마다 +1됨.
				System.out.println("i>> "+i+" j>> "+j+" dp[j+i]>> "+dp[j+i]);
			}
		}//for
		if(dp[n] >= Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(dp[n]);
		}
	}

}
