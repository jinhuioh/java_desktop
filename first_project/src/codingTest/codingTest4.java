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

//탈출
//문제
//사악한 암흑의 군주 이민혁은 드디어 마법 구슬을 손에 넣었고, 그 능력을 실험해보기 위해 근처의 티떱숲에 홍수를 일으키려고 한다. 이 숲에는 고슴도치가 한 마리 살고 있다. 고슴도치는 제일 친한 친구인 비버의 굴로 가능한 빨리 도망가 홍수를 피하려고 한다.
//
//티떱숲의 지도는 R행 C열로 이루어져 있다. 비어있는 곳은 '.'로 표시되어 있고, 물이 차있는 지역은 '*', 돌은 'X'로 표시되어 있다. 비버의 굴은 'D'로, 고슴도치의 위치는 'S'로 나타내어져 있다.
//
//매 분마다 고슴도치는 현재 있는 칸과 인접한 네 칸 중 하나로 이동할 수 있다. (위, 아래, 오른쪽, 왼쪽) 물도 매 분마다 비어있는 칸으로 확장한다. 물이 있는 칸과 인접해있는 비어있는 칸(적어도 한 변을 공유)은 물이 차게 된다. 물과 고슴도치는 돌을 통과할 수 없다. 또, 고슴도치는 물로 차있는 구역으로 이동할 수 없고, 물도 비버의 소굴로 이동할 수 없다.
//
//티떱숲의 지도가 주어졌을 때, 고슴도치가 안전하게 비버의 굴로 이동하기 위해 필요한 최소 시간을 구하는 프로그램을 작성하시오.
//
//고슴도치는 물이 찰 예정인 칸으로 이동할 수 없다. 즉, 다음 시간에 물이 찰 예정인 칸으로 고슴도치는 이동할 수 없다. 이동할 수 있으면 고슴도치가 물에 빠지기 때문이다. 
//
//입력
//첫째 줄에 50보다 작거나 같은 자연수 R과 C가 주어진다.
//
//다음 R개 줄에는 티떱숲의 지도가 주어지며, 문제에서 설명한 문자만 주어진다. 'D'와 'S'는 하나씩만 주어진다.
//
//출력
//첫째 줄에 고슴도치가 비버의 굴로 이동할 수 있는 가장 빠른 시간을 출력한다. 만약, 안전하게 비버의 굴로 이동할 수 없다면, "KAKTUS"를 출력한다.
//
//예제 입력 1 

// 일단 물 증가시키고 다음에 s이동시킴 s가 d로 갈 수 있으면 최종적으로 answer출력 해당 과정 돌때마다 시간(answer) 증가/
// x는 돌, 별은 물.

//3 3
//D.*
//...
//.S.
//예제 출력 1 
//3
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
	static int n,m;
	static char[][] map;
	static Queue<node> q_s, q_water;

	//물 증가 함수
	private static void water_bfs(Queue<node> q_water) {
		Queue<node> q = new LinkedList<node>();//q에 물로 바뀐 부분을 넣어서 while문이 끝난 후 q_water에 넣어준다.
		while (!q_water.isEmpty()) {
			node qp = q_water.poll();
			int y = qp.y;
			int x = qp.x;
			for(int i = 0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny>=0 && nx>=0 && ny<n && nx<m && map[ny][nx] !='D' && map[ny][nx] !='X') {
					map[ny][nx] = '*';
					q.add(new node(ny, nx));
				}//if
			}//for
		}//while
		
		//q_water갱신
		while (!q.isEmpty()) {
			node qp1 = q.poll();
			q_water.add(qp1);
		}
	}
	
	private static int s_bfs(Queue<node> q_s) {
		int answer = 0;
		Queue<node> q = new LinkedList<node>();
		
		while (!q_s.isEmpty()) {
			node qp = q_s.poll();
			int y = qp.y;
			int x = qp.x;
			//만약 해당 위치가 *이면 continue 이동했지만 이미 물에 잠긴 것이므로.
			if(map[y][x]=='*') {
				continue;
			}
			
			for(int i = 0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny>=0 && nx>=0 && ny<n && nx<m && map[ny][nx] !='*' && map[ny][nx] !='X') {
					if(map[ny][nx] =='D') {
						answer = 1;
					}
					map[ny][nx] = 'S';
					q.add(new node(ny, nx));
				}//if
			}//for
		}
		//고슴도치 위치 갱신
		while (!q.isEmpty()) {
			node qp1 = q.poll();
			q_s.add(qp1);
		}
		return answer;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		q_s = new LinkedList<node>();
		q_water = new LinkedList<node>();
		
//		map 입력받기
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				char s_char = s.charAt(j);
				if(s_char=='S') {
					q_s.add(new node(i, j));
				}
				if(s_char=='*') {
					q_water.add(new node(i, j));
				}
				map[i][j] = s.charAt(j);
			}
		}//for
		
		int time = 0;
		int s_node = 0;
		while (true) {
//		s의 위치와 d의 위치가 같기 전까지 while문 들리기 //s_bfs의 리턴값이 1이면 s의 위치와 d의 위치가 같은것으로 판단하고 while문 종료
			if(s_node==1) {
				System.out.println(time);
				break;
			}//if
			time++;
			//고슴도치 이동 함수//이동할 수 있는 곳은 전부 S로 갱신.
			s_node = s_bfs(q_s);
			//물증가 시키는 함수
			water_bfs(q_water);
		
			//만약 q들이 비어있으면 KAKTUS출력
			if(q_s.isEmpty() && q_water.isEmpty()) {
				System.out.println("KAKTUS");
				System.exit(0);
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.out.println();
		}//while
		
	}
}