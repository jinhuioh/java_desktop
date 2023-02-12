package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
//입력 : 숨바꼭질
//재서기는 수혀니와 교외 농장에서 숨바꼭질을 하고 있다. 농장에는 헛간이 많이 널려있고 재서기는 그 중에 하나에 숨어야 한다.
//헛간의 개수는 N(2 <= N <= 20,000)개이며, 1 부터 샌다고 하자.  
//
//재서기는 수혀니가 1번 헛간부터 찾을 것을 알고 있다. 모든 헛간은 M(1<= M <= 50,000)개의 양방향 길로 이어져 있고, 
//그 양 끝을 A_i 와 B_i(1<= A_i <= N; 1 <= B_i <= N; A_i != B_i)로 나타낸다. 
//또한 어떤 헛간에서 다른 헛간으로는 언제나 도달 가능하다고 생각해도 좋다. 
//
//재서기는 발냄새가 지독하기 때문에 최대한 냄새가 안나게 숨을 장소를 찾고자 한다. 
//냄새는 1번 헛간에서의 거리(여기서 거리라 함은 지나야 하는 길의 최소 개수이다)가 멀어질수록 감소한다고 한다. 재서기의 발냄새를 최대한 숨길 수 있는 헛간을 찾을 수 있게 도와주자!
//첫 번째 줄에는 N과 M이 공백을 사이에 두고 주어진다.
//
//이후 M줄에 걸쳐서 A_i와 B_i가 공백을 사이에 두고 주어진다.
//
// 
//
//출력
//출력은 한줄로 이루어지며, 세 개의 값을 공백으로 구분지어 출력해야한다. 
//
//첫 번째는 숨어야 하는 헛간 번호를(만약 거리가 같은 헛간이 여러개면 가장 작은 헛간 번호를 출력한다), 두 번째는 그 헛간까지의 거리를, 세 번째는 그 헛간과 같은 거리를 갖는 헛간의 개수를 출력해야한다.
//
//예제 입력 1 
//6 7
//3 6
//4 3
//3 2
//1 3
//1 2
//2 4
//5 2
//예제 출력 1 
//4 2 3

class node{
	int y;
	int x;
	node(int y, int x){
		this.y = y;
		this.x = x;
	}
}

public class codingTest4 {
	static List<List<Integer>> node_list;
	static boolean[] visited;
	static int n,m;
	static int[] maxIdx = new int[3];
	static Queue<node> q = new LinkedList<node>();
	
	private static void bfs() {
		
	}
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    StringBuilder sb = new StringBuilder();
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    
	    node_list = new ArrayList<>();
	    visited = new boolean[n+1];
	    
	    for(int i=0; i<n+1; i++) {
	    	node_list.add(new ArrayList<Integer>());
	    }//for
	    
	    for(int i = 0; i<m; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int y = Integer.parseInt(st.nextToken());
	    	int x = Integer.parseInt(st.nextToken());
	    	node_list.get(y).add(x);
	    	node_list.get(x).add(y);
	    }//for
	    
	    q.add(new node(1, 0));
	    visited[1] = true;
	    
	    while (!q.isEmpty()) {
			node now = q.poll();
			
			//최대거리 계산
			if(now.x > maxIdx[1]) {//1부터의 거리가 이전 노드 번호의 1부터의 거리보다 크다면 갱신!!
				maxIdx[0] = now.y;//노드 번호
				maxIdx[1] = now.x;//1부터의 거리
				maxIdx[2] = 1;//최대 거리 카운트 개수
			}
			else if(now.x == maxIdx[1]) {//1부터의 거리가 이전 노드 번호의 1부터의 거리와 같다면
				maxIdx[2]++;//최대거리 카운트 개수 증가!!
				maxIdx[0] = Math.min(maxIdx[0], now.y);//노드 번호는 최소값으로 바꿈
			}
			for(int k : node_list.get(now.y)) {//방문표시
				if(visited[k]) {
					continue;
				}
				visited[k] = true;
				q.add(new node(k, now.x+1));//큐에 값 넣어서 다음 노드로 이동.
			}
		}//while
	    
	    for(int idx : maxIdx) {
	    	sb.append(idx).append(" ");
	    }
	    System.out.println(sb);
	    //다음 노드 탐색
	}
}