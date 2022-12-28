package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
//트리의 부모 찾기
//문제
//루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.
//
//출력
//첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
public class codingTest3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> map = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			map.add(new ArrayList<>());
		}
		for(int i1=1; i1<n; i1++) { 	
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int p = Integer.parseInt(st.nextToken());//부모
			int k = Integer.parseInt(st.nextToken());//자식
			map.get(p).add(k);
			map.get(k).add(p);
			System.out.println(map);
		}//for
		
		boolean[] visited = new boolean[n+1];//방문했는지 채크
		int[] p = new int[n+1];//부모 노드 저장//정답이 되는 배열
	
		//bfs
//		1번부터 시작
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		while(!q.isEmpty()) {
			int v = q.poll();
			for(int nums: map.get(v)) {// v번째 인덱스의 자식을 nums변수에 하나씩 넣어줌
				if(!visited[nums]) {//자식을 방문한 적 없으면
					visited[nums]=true;
					//부모 지정
					p[nums] = v;
					//다음 자식으로 이동
					q.add(nums);
				}
			}
		}//while
		for(int i2=2; i2<=n; i2++) {
			System.out.println(p[i2]);
		}
		
	}//public
}
