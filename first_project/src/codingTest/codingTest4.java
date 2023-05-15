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
//와드
//올해 휴가를 전부 써 버려 당장 판교로 돌아가야 하는 한별이는 돌아가기 위한 방법을 어떻게든 찾아보기 위해 이세계를 돌아다녀 보려고 한다.
//
//이세계는 
//$R\times C$의 격자로 되어 있다. 지금은 밤이어서 한별이는 자신이 위치한 칸 및 그 칸에서 위, 아래, 왼쪽 또는 오른쪽으로 인접한 칸만을 볼 수 있지만, 와드를 설치하면 조금 더 넓은 영역의 시야를 확보할 수 있다. 구체적으로는, 격자의 모든 칸은 각각 어떤 영역 하나에 속해 있는데, 와드를 놓으면 와드가 놓인 칸이 속한 영역에 있는 모든 칸을 볼 수 있게 된다.
//
//한별이의 여행 기록이 주어질 때 한별이가 얼마나 넓은 시야를 확보했을지 계산해 보자.
//
//입력
//첫 번째 줄에는 격자의 크기를 나타내는 두 정수 
//$R$과 
//$C$가 주어진다. (
//$1 \le R,C \le 1\,000$)
//
//다음 줄부터 
//$R$개의 줄에 걸쳐 격자의 정보가 주어진다. 각 줄은 
//$C$개의 알파벳 소문자로 이루어져 있으며, 위, 아래, 왼쪽 또는 오른쪽으로 인접해 있는 칸이 같은 문자라는 것은 두 칸이 같은 영역에 속해 있음을 의미한다.
//
//다음 줄에는 한별이가 이세계에 떨어진 위치를 나타내는 두 정수 
//$H_R$, 
//$H_C$가 주어진다. 이는 한별이가 위에서 
//$H_R$번째 줄, 왼쪽에서 
//$H_C$번째 칸에 떨어졌음을 의미한다. (
//$1 \le H_R \le R$, 
//$1 \le H_C \le C$)
//
//마지막 줄에는 한별이의 여행 기록을 나타내는 
//$200\,000$글자 이하의 문자열이 주어진다. 여행 기록의 각 문자는 U, D, L, R, W 중 하나로 이루어져 있으며, U, D, L, R은 각각 위, 아래, 왼쪽, 오른쪽으로 한 칸 이동했다는 뜻이고, W는 지금 있는 칸에 와드를 설치했다는 뜻이다. 한별이가 격자를 벗어나는 경우는 주어지지 않는다.
//
//출력
// 
//$R$개의 줄에 걸쳐 한별이의 시야를 출력한다. 각 줄은 
//$C$개의 문자로 되어 있어야 하며, 
//$R$번째 줄 
//$C$번째 문자가 .이라면 한별이의 시야에 해당 칸이 들어와 있다는 뜻이고 #이라면 그렇지 않다는 뜻이다.
//
//예제 입력 1 
//4 5
//aaabc
//dcbbc
//dccaa
//ddaaa
//3 4
//WLLLWUURRD
//예제 출력 1 
//##.##
//....#
//.#...
//.....

public class codingTest4 {
	static boolean[][] visited;
	static char[][] map,arr;
	static int n,m,start_y, start_x;
	static Queue<node> q = new LinkedList<node>();
	static String move;//이동 입력받기
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	
	private static void bfs() {
		//move에서 하나씩 떼어서 위치 이동시키고 만약 W라면 이전 거 위치 Q에 넣어서 map의 해당 위치와 알파벳이 같으면 arr .으로 갱신
		//move의 마지막 값이라면 이동시키고 동서남북으로 arr .처리
		
		//move 이용하여 start_x,y 이동
		for(int i = 0; i<move.length(); i++) {
			char move_one = move.charAt(i);
			if(move_one == 'W') {//와드 설치
				W_bfs(start_y, start_x);
			}//if
			else if(move_one == 'L') {
				start_x -= 1;
			}
			else if(move_one == 'R') {
				start_x += 1;
			}
			else if(move_one == 'U') {
				start_y -= 1;
			}
			else {
				start_y += 1;
			}//else
			//마지막 위치라면
			if(move_one == move.charAt(move.length()-1)) {
				arr[start_y][start_x] = '.';
				//동서남북 전부 .으로 바꿔줌.
				if(start_y-1 >= 0) arr[start_y-1][start_x] = '.';
				if(start_x-1 >= 0) arr[start_y][start_x-1] = '.';
				if(start_y+1 < n) arr[start_y+1][start_x] = '.';
				if(start_x+1 < m) arr[start_y][start_x+1] = '.';
			}
		}
	}
	
	private static void W_bfs(int start_y, int start_x) {
		//해당 위치 큐에 넣어서 map값이 같으면 전부 arr을 .로 변경
		q.add(new node(start_y, start_x));
		arr[start_y][start_x] ='.';
		while (!q.isEmpty()) {
			node qp = q.poll();
			for(int i = 0; i<4; i++) {
				int ny = dy[i] + qp.y;
				int nx = dx[i] + qp.x;
				if(ny<0 || nx<0 || ny>=n || nx>=m || arr[ny][nx]=='.') continue;
				if(map[qp.y][qp.x] == map[ny][nx]) {
					arr[ny][nx] = '.';
					q.add(new node(ny, nx));
				}
			}
		}//while
	}
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    
	    map = new char[n][m];
	    arr = new char[n][m];
	    //map 입력받기
	    for(int i = 0; i<n; i++) {
	    	String s = br.readLine();
	    	for(int j = 0; j<m; j++) {
	    		map[i][j] = s.charAt(j);
	    		arr[i][j] = '#'; 
	    	}//for
	    }//for
	    
	    //현재 위치 입력받기
	    st = new StringTokenizer(br.readLine());
	    start_y = Integer.parseInt(st.nextToken())-1;
	    start_x = Integer.parseInt(st.nextToken())-1;
	    
	    //이동 입력받기
	    move = br.readLine();
	    
	    //함수호출
	    bfs();
	    
	    //정답 출력
	    for(int i = 0; i<n; i++) {
	    	for(int j = 0; j<m; j++) {
	    		System.out.print(arr[i][j]);
	    	}
	    	System.out.println();
	    }
	}
}