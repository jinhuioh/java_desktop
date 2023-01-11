package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class codingTest4 {
//	문제
//	보물섬 지도를 발견한 후크 선장은 보물을 찾아나섰다. 보물섬 지도는 아래 그림과 같이 직사각형 모양이며 여러 칸으로 나뉘어져 있다. 각 칸은 육지(L)나 바다(W)로 표시되어 있다. 
//	이 지도에서 이동은 상하좌우로 이웃한 육지로만 가능하며, 한 칸 이동하는데 한 시간이 걸린다. 보물은 서로 간에 최단 거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 묻혀있다. 
//	육지를 나타내는 두 곳 사이를 최단 거리로 이동하려면 같은 곳을 두 번 이상 지나가거나, 멀리 돌아가서는 안 된다.
//	입력
//	첫째 줄에는 보물 지도의 세로의 크기와 가로의 크기가 빈칸을 사이에 두고 주어진다. 이어 L과 W로 표시된 보물 지도가 아래의 예와 같이 주어지며, 각 문자 사이에는 빈 칸이 없다. 보물 지도의 가로, 세로의 크기는 각각 50이하이다.
//
//	출력
//	첫째 줄에 보물이 묻혀 있는 두 곳 사이를 최단 거리로 이동하는 시간을 출력한다.
//
//	예제 입력 1 
//	5 7
//	WLLWWWL
//	LLLWLLL
//	LWLWLWW
//	LWLWLLL
//	WLLWLWW
//	예제 출력 1 
//	8
	
// 0,0부터 차례대로 탐색하면서 가장 최단거리인 최대값 구하기 
	static int n,m;
	static char[][] map;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	private static int bfs(int i, int j) {
//		System.out.println("ij>> "+i+" "+j);
		int count = 0;//최단거리 최대값 구할 변수
		arr = new int[n][m];//초기화
		visited = new boolean[n][m];//초기화
		visited[i][j] = true;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {i, j});
		while(!q.isEmpty()) {
			int y = q.peek()[0];
			int x = q.peek()[1];
			q.poll();
			for(int k = 0; k<4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if(ny<0 || ny>=n || nx<0 || nx>=m) continue;
				if(map[ny][nx]=='W' || visited[ny][nx]) continue;
				arr[ny][nx] = arr[y][x] + 1;
//				System.out.println("arr[ny][nx] "+" "+ny+" "+nx+" "+arr[ny][nx]);
				visited[ny][nx] = true;
				count = arr[ny][nx];
				q.add(new int[] {ny, nx});
			}
		}//while
//		System.out.println("count>> "+count);
		return count;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
	
		//map 입력받기
		for(int i = 0; i<n; i++) {
			String s = br.readLine();
			for(int j = 0; j<m; j++) {
				map[i][j] = s.charAt(j);
			}
		}//for
		
		int count_max = 0;
		//탐색시작
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j]=='W') continue;//땅이아니면 패스
				int count_bfs = bfs(i,j);
				count_max = Math.max(count_bfs, count_max);
			}
		}//for
		
		System.out.println(count_max);
	}
}
