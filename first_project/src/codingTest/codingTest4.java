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

//미로만들기
//문제
//n×n 바둑판 모양으로 총 n2개의 방이 있다. 일부분은 검은 방이고 나머지는 모두 흰 방이다. 검은 방은 사면이 벽으로 싸여 있어 들어갈 수 없다. 서로 붙어 있는 두 개의 흰 방 사이에는 문이 있어서 지나다닐 수 있다.
//윗줄 맨 왼쪽 방은 시작방으로서 항상 흰 방이고, 아랫줄 맨 오른쪽 방은 끝방으로서 역시 흰 방이다.
//
//시작방에서 출발하여 길을 찾아서 끝방으로 가는 것이 목적인데, 아래 그림의 경우에는 시작방에서 끝 방으로 갈 수가 없다. 부득이 검은 방 몇 개를 흰 방으로 바꾸어야 하는데 되도록 적은 수의 방의 색을 바꾸고 싶다.
//입력
//첫 줄에는 한 줄에 들어가는 방의 수 n(1 ≤ n ≤ 50)이 주어지고, 다음 n개의 줄의 각 줄마다 0과 1이 이루어진 길이가 n인 수열이 주어진다. 0은 검은 방, 1은 흰 방을 나타낸다.
//
//출력
//첫 줄에 흰 방으로 바꾸어야 할 최소의 검은 방의 수를 출력한다.
//
//예제 입력 1 
//8
//11100110
//11010010
//10011010
//11101100
//01000111
//00110001
//11011000
//11000111
//예제 출력 1 
//2

//1. map입력 배열 0은 지나갈수 있는 흰색, 1은 검정색으로 입력. (문제랑 반대)0이면 continue할 예정.
//2. 블랙 개수에 따라 나누어주고 나머지는 0으로 이루어져있는 arr배열. 1번째 블럭뭉탱이는 전부 1로만, 2번째 하얀 블럭들은 모두 2로만 ....마지막 블럭까지 이루어져있음.
//3. 최단거리들을 넣을 배열 갱신 answer_list. 배열의 크기는visited에서 구함.
//4. 최종적으로 answer_list의 마지막 값이 답
class bfs_xy{
	int y;
	int x;
	public bfs_xy(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class codingTest4 {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	static int n;
	static int[] answer_list;
	static int[][] map,arr;
	static boolean[][] visited;
	
	private static void arr_bfs(int y, int x, int c) {
		Queue<bfs_xy> q = new LinkedList<bfs_xy>();
		q.add(new bfs_xy(y, x));
		visited[y][x] = true;
		arr[y][x] = c;
		while (!q.isEmpty()) {
			bfs_xy qp = q.poll();
			int yq = qp.y;
			int xq = qp.x;
			for(int i = 0; i<4; i++) {
				int ny = yq + dy[i];
				int nx = xq + dx[i];
				
				if(ny<0 || nx<0 || ny>= n || nx >= n || visited[ny][nx]) continue;
				
				if(map[ny][nx]==0) {//0이 지나갈 수 있는 흰색 벽
					arr[ny][nx] = arr[y][x];
					visited[ny][nx] = true;
					q.add(new bfs_xy(ny, nx));
				}
			}//for
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		arr = new int[n][n];
		//1.
		for(int i = 0; i<n; i++) {
			String s = br.readLine();
			for(int j = 0; j<n; j++) {
				char s_one = s.charAt(j);
				if(s_one=='1') {
					map[i][j] = 0;
				}
				else {
					map[i][j] = 1;
				}
			}//for
		}//for
		
//		arr 갱신
		visited = new boolean[n][n];
		int c = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(!visited[i][j] && map[i][j]==0){
					c++;
					arr_bfs(i, j, c);
				}
			}
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
	}
}