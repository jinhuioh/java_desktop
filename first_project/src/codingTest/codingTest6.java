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
class node1{
	int y;
	int x;
	node1(int y, int x){
		this.y = y;
		this.x = x;
	}
}
public class codingTest6 {
	static int n,m,k;
	static List<List<Integer>> nodeList = new ArrayList<>(); 
	static List<List<Integer>> answerList = new ArrayList<>(); 
	static Queue<node1> q = new LinkedList<node1>();
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
	
		for(int i = 0; i<=n; i++) {
			nodeList.add(new ArrayList<Integer>());
			
		}
		//m개의 간선 연결
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			nodeList.get(p).add(q);
			nodeList.get(q).add(p);
		}
		System.out.println(nodeList);
		
		for(int i = 0; i<=n; i++) {
			answerList.add(new ArrayList<Integer>());
		}
		int count= 1;
		answerList.get(1).add(1);
		for(int i = 0; i<nodeList.get(1).size(); i++) {
			answerList.get(nodeList.get(1).get(i)).add(++count);
		}
		System.out.println(answerList);
	}
}