package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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
		//가장 큰 수를 골라서 옮겨가면 된다.         
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] map = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}//for
		
//		int[] indexarr = new int[n];
//		
//		for(int k=0; k<n; k++) {
//			indexarr[k] = k;
//		}
		//왼쪽부터 시작 초기값
		int index = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(index);
		//정답 변수
		int count = 0;
		int answer = 0;
		while(!q.isEmpty()) {
			//첫번째 위치의 인덱스값
			int now = q.poll();
			//해당위치의 값
			int visited = map[now];
			System.out.println("now 와 visited>>"+now+" "+visited);
			
			int[] max_num = new int[visited+1];//인덱스 배열//해당위치에서 이동할 수 있는 가장 큰 인덱스를 구하기 위함.
			for(int j = 1; j<= visited; j++) {
				max_num[j]= map[now + j];
				//이동한 위치 
				System.out.println("이동한 위치~~~~~~~~"+max_num[j]);
			}
			Arrays.sort(max_num);
			answer = map[now + max_num[max_num.length-1]];// 현재위치 + 가장 큰 값
			System.out.println("max넘의 길이"+max_num.length);
			System.out.println(max_num.length-1);
			System.out.println("maxnum의 마지막값인덱스"+max_num[max_num.length-1]);
			//이동할 위치 인덱스
			System.out.println("answer>> "+answer+"현재 인덱스값!!>> "+now + max_num[max_num.length-1]);
			//마지막이면 break
			if(answer == map[map.length-1]) {
				System.out.println("count>>"+count);
				break;
			}//if
			System.out.println("answer"+answer);
			q.add(answer);//이동할 위치
		}
	}

}
