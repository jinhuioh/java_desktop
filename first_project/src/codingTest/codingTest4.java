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

class node{
	int y;
	int x;
	public node(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class codingTest4 {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	static int n;
	static int[] answer_list;
	static int[][] visited;
	static char[][] map;
	static Queue<node> q;

	private static void bfs() {
		while (!q.isEmpty()) {
			node qp = q.poll();
			for(int i = 0; i<4; i++) {
				int ny = qp.y + dy[i];
				int nx = qp.x + dx[i];
				
				if(ny < 0 || nx < 0 || ny>= n || nx >= n) continue;
				
				//흰 방
				if(map[ny][nx]=='1') {
					if(visited[ny][nx] > visited[qp.y][qp.x]) {
						visited[ny][nx] = visited[qp.y][qp.x];
						q.add(new node(ny, nx));
					}//if
				}//if
				
				//검은 방
				else {
					if(visited[ny][nx] > visited[qp.y][qp.x]+1) {
						visited[ny][nx] = visited[qp.y][qp.x]+1;
						q.add(new node(ny, nx));
					}//if
				}//else
			}//for
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					System.out.print(visited[i][j]);
				}
				System.out.println();
			}
			System.out.println();
		}//while
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		visited = new int[n][n];
		q = new LinkedList<node>();
		for(int i = 0; i<n; i++) {
			map[i] = br.readLine().toCharArray();//문자열 입력받고 한글자씩 저장하기
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}//for
		
		q.add(new node(0, 0));
		visited[0][0] = 0;
		
		bfs();
		
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				System.out.print(visited[i][j]);
			}
			System.out.println();
		}
		System.out.println(visited[n-1][n-1]);
	}
}