package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
//입력(내일 다른 풀이 찾아보기!!(2023/03/01))
//첫 번째 줄부터 다섯 개의 줄에 걸쳐 보드의 각 칸에 적혀있는 수가 순서대로 주어진다. i번째 줄의 j번째 수는 보드의 (i - 1)번째 행, (j - 1)번째 열에 적혀있는 수를 나타낸다. 보드의 각 칸에 적혀 있는 수는 -1, 0, 1, 2, 3, 4, 5, 6중 하나이다.
//
//다음 줄에 학생의 현재 위치 r, c가 빈칸을 사이에 두고 순서대로 주어진다.
//
//출력
//학생이 현재 위치 (r, c)에서 시작하여 1, 2, 3, 4, 5, 6이 적혀 있는 칸을 순서대로 방문하는 최소 이동 횟수를 출력한다. 학생이 현재 위치 (r, c)에서 시작하여 1, 2, 3, 4, 5, 6이 적혀 있는 칸을 순서대로 방문할 수 없는 경우 -1을 출력한다.
//
//제한
//0 ≤ r, c ≤ 4
//학생의 현재 위치 (r, c)에는 0이 적혀 있다.
//1, 2, 3, 4, 5, 6이 적혀 있는 칸이 1개씩 주어진다.
//
//예제 입력 2 
//0 0 1 0 0
//0 0 2 0 0
//0 0 3 0 0
//0 0 4 6 0
//0 0 5 -1 0
//0 1
//예제 출력 2 
//7
class node1{
	int y,x;
	node1(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
public class codingTest6 {
    static int start_one,start_i;//1있는 위치가 방문되면 1로 바꿈, i번째에서 i+1로 갈 수 있으면 1로 바꿈.
    static int[][] map;
    static boolean[][] visited;
    static Queue<node1> q;
    static int[] dy = {0,0,1,-1};
    static int[] dx = {-1,1,0,0};
    
    private static int start_bfs(int s_y, int s_x) {
    	int[][] arr = new int[5][5];
    	visited = new boolean[5][5];
    	for(int i = 0; i<5; i++) {
    		for(int j = 0; j<5; j++) {
    			if(map[i][j] == -1) {
    				arr[i][j] =-1;
    				continue;
    			}
    			if(map[i][j] == 1) {
    				arr[i][j] = 1;
    				continue;
    			}
    			arr[i][j] = (int)1e9;
    		}
    	}
    	
    	int count = 0;
    	q = new LinkedList<node1>();
    	q.add(new node1(s_y, s_x));
    	arr[s_y][s_x] = 0;
    	visited[s_y][s_x] = true;
    	Loop1:
    	while (!q.isEmpty()) {
			node1 qp = q.poll();
			for(int k = 0; k<4; k++) {
				int ny = qp.y + dy[k];
				int nx = qp.x + dx[k];
				if(ny<0 || nx<0 || ny>=5 || nx>=5 || map[ny][nx]==-1 || visited[ny][nx]) {
					continue;
				}
				
				if(arr[ny][nx] == 1) {
					 count =arr[qp.y][qp.x] + 1;
					start_one = 1;
					break Loop1;
				}
				arr[ny][nx] = Math.min(arr[qp.y][qp.x] + 1, arr[ny][nx]);
				visited[ny][nx] = true;
				q.add(new node1(ny, nx));
			}
		}
    	return count;//시작위치부터 1까지의 최소거리 리턴
	}
    
    //i부터i+1까지 가는데 걸리는 최소 거리 값.
    private static int count_bfs(int c) {
		int count = 0;
		int[][] arr = new int[5][5];
    	visited = new boolean[5][5];
    	q = new LinkedList<node1>();
    	for(int i = 0; i<5; i++) {
    		for(int j = 0; j<5; j++) {
    			if(map[i][j] == -1) {
    				arr[i][j] =-1;
    				continue;
    			}
    			if(map[i][j] == c) {
    				arr[i][j] = 0;
    				q.add(new node1(i, j));
    				visited[i][j] = true;
    				continue;
    			}
    			if(map[i][j] == c+1) {
    				arr[i][j] = c+1;
    				continue;
    			}
    			
    			arr[i][j] = (int)1e9;
    		}
    	}
    	
    	Loop1:
    	while (!q.isEmpty()) {
			node1 qp = q.poll();
			for(int k = 0; k<4; k++) {
				int ny = qp.y + dy[k];
				int nx = qp.x + dx[k];
				if(ny<0 || nx<0 || ny>=5 || nx>=5 || map[ny][nx]==-1 || visited[ny][nx]) {
					continue;
				}
				
				if(arr[ny][nx] == c+1) {
					 count =arr[qp.y][qp.x] + 1;
					start_i = 1;
					break Loop1;
				}
				arr[ny][nx] = Math.min(arr[qp.y][qp.x] + 1, arr[ny][nx]);
				visited[ny][nx] = true;
				q.add(new node1(ny, nx));
			}
		}
    	return count;//시작위치부터 다음 숫자까지의 최소거리 리턴
	}
    
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	map = new int[5][5];
    	
//    	map입력받기
    	for(int i = 0; i<5; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j = 0; j<5; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}//for
    	
    	//시작위치 입력받기
    	StringTokenizer st1  = new StringTokenizer(br.readLine());
    	int s_y = Integer.parseInt(st1.nextToken());
    	int s_x = Integer.parseInt(st1.nextToken());
    	//시작위치부터 1까지의 거리 계산
    	start_one = 0;//시작위치가 1까지 이동가능하면 1로 바꿈.
    	int start_count = start_bfs(s_y, s_x);//1까지의 최소거리
//    	System.out.println(start_count+" "+ start_one);
    	if(start_one==0) {
    		System.out.println(-1);
    		System.exit(0);//프로그램 완전종료
    	}//if
    	
//    	i에서 i+1까지의 최소거리 구하기
    	int i_count = 0;
    	for(int i = 1; i<6; i++) {
    		start_i = 0;
    		i_count += count_bfs(i);//다음 값으로 갈 수 있으면 start_i를 1로 변경해줌.
    		if(start_i == 0) {
    			System.out.println(-1);
        		System.exit(0);//프로그램 완전종료
    		}
    	}//for
    	//결과
    	System.out.println(i_count+start_count);
    	
    }
}