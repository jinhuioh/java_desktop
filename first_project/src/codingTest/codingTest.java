package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class codingTest {
	//static=전역 , final=최종적인, 즉 수정불가능한 변수.
	//static final=상수

	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		//탐색했는지 판단
		boolean[] visited = new boolean[n+1];
		//이중리스트만들기
		List<ArrayList<Integer>> map = new ArrayList<>();
		for(int j = 0; j<=n; j++) {
			map.add(new ArrayList<>());
		}
		
		for(int i = 0; i<m; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st1.nextToken());
			int p2 = Integer.parseInt(st1.nextToken());
			map.get(p1).add(p2);
			map.get(p2).add(p1);
		}//for
		//정답변수
		int answer = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		for(int k=1; k<=n; k++) {
			//방문한 적 있으면 패스
			if(visited[k]) {
				continue;
			}
			//숫자 1부터 탐색
			q.add(k);
			//1 방문 표시
			visited[k] = true;
			//정답 변수 증가
			answer ++;
				while(!q.isEmpty()) {
					//시작 숫자
					int qp = q.poll();
					for(int num: map.get(qp)) {//qp와 연결되어있는 숫자들
						//이미 방문한 곳이면 continue
						if(visited[num]) {
							continue;
						}
						//qp와 연결된 모든 숫자 방문 표시
						visited[num]=true;
						q.add(num);
					}
				}//while
		}//for
		System.out.println(answer);
	}
}