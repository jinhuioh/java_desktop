package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

//농장관리
//농부 민식이가 관리하는 농장은 N×M 격자로 이루어져 있다. 민식이는 농장을 관리하기 위해 산봉우리마다 경비원를 배치하려 한다. 이를 위해 농장에 산봉우리가 총 몇 개 있는지를 세는 것이 문제다.
//
//산봉우리의 정의는 다음과 같다. 산봉우리는 같은 높이를 가지는 하나의 격자 혹은 인접한 격자들의 집합으로 이루어져 있다. (여기서 "인접하다"의 정의는 X좌표 차이와 Y좌표 차이 모두 1 이하일 경우로 정의된다.) 또한 산봉우리와 인접한 격자는 모두 산봉우리의 높이보다 작아야한다.
//
//문제는 격자 내에 산봉우리의 개수가 총 몇 개인지 구하는 것이다.
//
//입력
//첫째 줄에 정수 N(1 < N ≤ 100), M(1 < M ≤ 70)이 주어진다. 둘째 줄부터 N+1번째 줄까지 각 줄마다 격자의 높이를 의미하는 M개의 정수가 입력된다. 
//격자의 높이는 500보다 작거나 같은 음이 아닌 정수이다.
//
//출력
//첫째 줄에 산봉우리의 개수를 출력한다.

//예제 입력 1 
//8 7
//4 3 2 2 1 0 1
//3 3 3 2 1 0 1
//2 2 2 2 1 0 0
//2 1 1 1 1 0 0
//1 1 0 0 0 1 0
//0 0 0 1 1 1 0
//0 1 2 2 1 1 0
//0 1 1 1 2 1 0
//예제 출력 1 
//3
class node1{
	int y,x;
	node1(int y, int x){
		this.y = y;
		this.x = x;
	}
}
public class codingTest6 {
	static int[][] map,arr;
	static boolean[][] visited, visited_arr;
	static int n,m;
	static Queue<node1> q;
	static int[] dx = {0,0,1,1,-1,-1,1,-1};
	static int[] dy = {1,-1,1,-1,-1,1,0,0};
	
	private static int bfs(int i, int j) {
		visited = new boolean[n][m];
		q = new LinkedList<node1>();
		q.add(new node1(i, j));
		visited[i][j] = true;
		
		int count = 0;
		while (!q.isEmpty()) {
			node1 qp = q.poll();
			int y = qp.y;
			int x = qp.x;
			for(int k = 0; k<8; k++) {
				int ny = dy[k] + y;
				int nx = dx[k] + x;
				
				if(ny<0 || nx<0 || ny>=n || nx>=m || visited[ny][nx]) continue;
				
				if(map[ny][nx] > map[y][x]) {//만약 이동한 값이 크면
					count = 1;
				}

				if(map[y][x]==map[ny][nx]) {//이동한 값이 같은 값이면
					q.add(new node1(ny, nx));
					visited[ny][nx] = true;
				}//if
			}
		}//while
		return count; 
	}
	
	private static void arr_bfs(int i, int j) {//arr갱신
		q = new LinkedList<node1>();
		q.add(new node1(i, j));
		arr[i][j] = 1;
		while (!q.isEmpty()) {
			node1 qp = q.poll();
			int y = qp.y;
			int x = qp.x;
			for(int k = 0; k<8; k++) {
				int ny = dy[k] + y;
				int nx = dx[k] + x;
				
				if(ny<0 || nx<0 || ny>=n || nx>=m) continue;
				
				if(visited[ny][nx]) {
					arr[ny][nx] = 1;
				}
			}
		}//while
	}
	
	private static void count_bfs(int i, int j) {
		visited_arr[i][j] = true;
		q = new LinkedList<node1>();
		q.add(new node1(i, j));
		while (!q.isEmpty()) {
			node1 qp = q.poll();
			int y = qp.y;
			int x = qp.x;
			for(int k = 0; k<8; k++) {
				int ny = dy[k] + y;
				int nx = dx[k] + x;
				
				if(ny<0 || nx<0 || ny>=n || nx>=m || visited_arr[ny][nx]) continue;
				
				if(arr[ny][nx]==1) {
//					System.out.println(ny+" "+nx+">> 1이므로 visitedarr갱신!!");
					visited_arr[ny][nx] = true;
					q.add(new node1(ny, nx));
				}
			}
		}//while
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		arr = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}//for
		}//for

		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				int count = bfs(i, j);//count가 1이면 산봉우리가 아니므로 arr갱신 안함.
				if(count == 0) {
					arr_bfs(i, j);
				}
			}//for
		}//for
	
//		for(int i = 0; i<n; i++) {
//			for(int j = 0; j<m; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
		
		visited_arr = new boolean[n][m];
		int answer = 0;
		//arr의 1이 되는 봉우리가 몇개인지 세기
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(!visited_arr[i][j] && arr[i][j] == 1) {
					count_bfs(i, j);
//					System.out.println(i+" "+j+"일때 answer++");
					answer++;
				}
			}//for
		}//for
		System.out.println(answer);
	}
}