package codingTest;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
//입력
//첫 번째 줄에는 성의 크기인 N, M 그리고 공주에게 걸린 저주의 제한 시간인 정수 T가 주어진다. 
//첫 줄의 세 개의 수는 띄어쓰기로 구분된다. (3 ≤ N, M ≤ 100, 1 ≤ T ≤ 10000)
//
//두 번째 줄부터 N+1번째 줄까지 성의 구조를 나타내는 M개의 수가 띄어쓰기로 구분되어 주어진다.
//0은 빈 공간, 1은 마법의 벽, 2는 그람이 놓여있는 공간을 의미한다. (1,1)과 (N,M)은 0이다.
//
//출력
//용사가 제한 시간 T시간 이내에 공주에게 도달할 수 있다면, 공주에게 도달할 수 있는 최단 시간을 출력한다.
//
//만약 용사가 공주를 T시간 이내에 구출할 수 없다면, "Fail"을 출력한다.
//
//예제 입력 1 
//6 6 16
//0 0 0 0 1 1
//0 0 0 0 0 2
//1 1 1 0 1 0
//0 0 0 0 0 0
//0 1 1 1 1 1
//0 0 0 0 0 0
//예제 출력 1 
//10
class node {
	int y;
	int x;
	node (int y, int x){
		this.y = y;
		this.x = x;
	}
}
public class codingTest6 {
	static int n,m,t;
	static boolean[][] visited;
	static int[][] map,arr;
	static Queue<node> q;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	// 1. 그람을 안구하고 마법벽을 피해서 가는방법., 그람까지의 거리를 gram_arr에 할당.
	private static int bfs(int y, int x) {
		q = new LinkedList<node>();
		visited = new boolean[n][m];
		visited[y][x] = true;
		//arr 초기화
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j]==1) {
					arr[i][j] = 0;
				}
				else {
					arr[i][j] = 1;
				}
			}
		}//for
		
		q.add(new node(y,x));
		while(!q.isEmpty()) {
			node qp = q.poll();
			int qy = qp.y;
			int qx = qp.x;
			for(int k = 0; k < 4; k++) {
				int ny = dy[k] + qy;
				int nx = dx[k] + qx;
				if(ny<0 || ny>=n || nx<0 || nx>=m || visited[ny][nx] || map[ny][nx] == 1) {
//					System.out.println(ny+" "+nx+" continue");
					continue;
				}
				if(arr[ny][nx] != 1) {
					arr[ny][nx] = Math.min(arr[qy][qx] + 1, arr[ny][nx]);
				}else {
					arr[ny][nx] = arr[qy][qx] + 1;
				}
//				//gram 까지의 거리
//				if(map[ny][nx] == 2) {
//					gram_arr = arr[ny][nx]-1;
//				}
				q.add(new node(ny,nx));
				visited[ny][nx] = true;
			}
		}//while

//		//확인.
//		for(int i = 0; i<n; i++) {
//			for(int j = 0; j<m; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
		return (arr[n-1][m-1]-1);
	}
	
	// 그람까지의 거리
	private static int gram(int y, int x) {
		int gram_arr = 0;
		q = new LinkedList<node>();
		visited = new boolean[n][m];
		visited[y][x] = true;
		//arr 초기화
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j]==1) {
					arr[i][j] = 0;
				}
				else {
					arr[i][j] = 1;
				}
			}
		}//for
		
		q.add(new node(y,x));
		Loop1:
		while(!q.isEmpty()) {
			node qp = q.poll();
			int qy = qp.y;
			int qx = qp.x;
			for(int k = 0; k < 4; k++) {
				int ny = dy[k] + qy;
				int nx = dx[k] + qx;
				if(ny<0 || ny>=n || nx<0 || nx>=m || visited[ny][nx] || map[ny][nx] == 1) {
//					System.out.println(ny+" "+nx+" continue");
					continue;
				}
				if(arr[ny][nx] != 1) {
					arr[ny][nx] = Math.min(arr[qy][qx] + 1, arr[ny][nx]);
				}else {
					arr[ny][nx] = arr[qy][qx] + 1;
				}
				//gram 까지의 거리
				if(map[ny][nx] == 2) {
					gram_arr = arr[ny][nx]-1;
					break Loop1;
				}
				q.add(new node(ny,nx));
				visited[ny][nx] = true;
			}
		}//while
		
		return gram_arr;
	}
	
	// 2. 그람을 구하고 마법벽을 뚫고 최단거리로 가는 방법.
	private static int gram_bfs(int y, int x) {
		int gram_arr = gram(0, 0);
		int count = (n-1-y) + (m-1-x);
		if(gram_arr == 0) {
			return 0;
		}
		else {
			return count+gram_arr;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n= Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		arr = new int[n][m];
		//gram위치
		int gram_i = 0;
		int gram_j = 0;
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
				if(map[i][j] == 2) {
					gram_i = i;
					gram_j = j;
				}
			}
		}//for
		int bfs_count = bfs(0,0);
		int gram_bfs_count = gram_bfs(gram_i, gram_j);//gram위치부터 마지막까지의 거리
		
//		System.out.println("bfscount>> "+bfs_count);
//		System.out.println("grambfscount>> "+gram_bfs_count);
		if(bfs_count == 0) {
			bfs_count = Integer.MAX_VALUE;
		}
		if(gram_bfs_count == 0) {
			gram_bfs_count = Integer.MAX_VALUE;
			
		}
		int short_arr = Math.min(bfs_count, gram_bfs_count);
		if(short_arr <= t) {
			System.out.println(short_arr);
		}
		else {
			System.out.println("Fail");
			
		}
	}
}
