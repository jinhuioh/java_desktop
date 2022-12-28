package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//문제
//영우는 개구리다 개굴개굴개굴
//
//영우는 지금 n개의 돌이 일렬로 놓여있는 돌다리에 있다. 그리고 돌다리의 돌에는 숫자가 하나씩 적혀있다. 영우는 이 숫자가 적혀있는 만큼 왼쪽이나 오른쪽으로 점프할 수 있는데, 이때 돌다리 밖으로 나갈 수는 없다.
//
//영우는 이 돌다리에서 자기가 방문 가능한 돌들의 개수를 알고 싶어한다. 방문 가능하다는 것은 현재위치에서 다른 돌을 적절히 밟아 해당하는 위치로 이동이 가능하다는 뜻이다.
//
//현재 위치가 주어졌을 때, 영우가 방문 가능한 돌들의 개수를 출력하시오.
//
//입력
//첫 번째 줄에는 돌다리의 돌 개수 n이 주어진다.(1≤n≤100,000) 돌의 번호는 왼쪽부터 1번에서 n번이다. 다음 줄에는 그 위치에서 점프할 수 있는 거리 Ai가 주어진다.(1≤Ai≤100,000)
//
//다음 줄에는 출발점 s가 주어진다.(1≤s≤n)
//
//출력
//영우가 방문 가능한 돌들의 개수를 출력하시오.

public class codingTest5 {
	static int t,s; 
	static int[] map;
	static boolean[] visited;
	static int[] dx = {-1,1};//좌우로만 이동
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		s = Integer.parseInt(br.readLine());//출발점
		
		map = new int[t+1];
		visited = new boolean[t+1];
		
		for(int i=1; i<=t; i++) {
			int one = Integer.parseInt(st.nextToken());
			map[i] = one;
		}//for
		
		//시작위치 true
		visited[s] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		//q 초기값 입력
		q.add(s);
		while (!q.isEmpty()) {
			//개구리의 현재 위치
			int qone = q.poll();
//			System.out.println("qone 개구리 위치>> "+qone);
			//왼쪽과 오른쪽으로 이동
			for(int j=0; j<2; j++) {
				int x1 = qone + dx[j]*map[qone];
				//범위를 벗어나거나 이미 true인 경우 continue
				if(x1<1 || x1>t || visited[x1]) {
					continue;
				}//if
//				System.out.println("x1해당위치에서 이동할 수 있는 인덱스>> "+x1);
				//간적없는 갈 수 있는 범위이면 true로 변경
				visited[x1]=true;
				//개구리 위치 이동
				q.add(x1);
			}//for
		}//while
		
		int count = 0;
		for(int l=0; l<visited.length; l++) {
			if(visited[l]==true) {
//				System.out.println("count세기 l>> " + l);
				count++;
			}
		}//for
		System.out.println(count);
	}

}
