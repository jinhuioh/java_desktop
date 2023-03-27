package codingTest;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
//알고리즘 수업 - 너비 우선 탐색 2

//입력
//첫째 줄에 정점의 수 N (5 ≤ N ≤ 100,000), 간선의 수 M (1 ≤ M ≤ 200,000), 시작 정점 R (1 ≤ R ≤ N)이 주어진다.
//
//다음 M개 줄에 간선 정보 u v가 주어지며 정점 u와 정점 v의 가중치 1인 양방향 간선을 나타낸다. (1 ≤ u < v ≤ N, u ≠ v) 모든 간선의 (u, v) 쌍의 값은 서로 다르다.
//
//출력
//첫째 줄부터 N개의 줄에 정수를 한 개씩 출력한다. i번째 줄에는 정점 i의 방문 순서를 출력한다. 시작 정점의 방문 순서는 1이다. 시작 정점에서 방문할 수 없는 경우 0을 출력한다.
//
//예제 입력 1 
//5 5 1
//1 4
//1 2
//2 3
//2 4
//3 4
//예제 출력 1 
//1
//3
//4
//2
//0
public class codingTest6 {
	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, M, R;
	private static List<Integer> []list;
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		list=new ArrayList[N+1];
		for(int i=1;i<=N;i++) list[i]=new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
//		System.out.println(list);
		for(int i=1;i<=N;i++) Collections.sort(list[i], Collections.reverseOrder());
//		System.out.println(list);
		bfs(R);
	}

	private static void bfs(int x) {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(x);
		
		boolean []visited=new boolean[N+1];
		visited[x]=true;
		
		int cnt=0;
		int []order=new int[N+1];
		while(!queue.isEmpty()) {
			int q=queue.poll();
			cnt++;
			order[q]=cnt;
			
			for(int i:list[q]) {
				if(!visited[i]) {
					visited[i]=true;
					queue.add(i);
				}
			}
		}
		
		for(int i=1;i<=N;i++) System.out.println(order[i]);
	}
	
}