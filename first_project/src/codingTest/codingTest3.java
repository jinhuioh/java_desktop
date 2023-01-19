package codingTest;
//문제 : 상범빌딩
//입력
//입력은 여러 개의 테스트 케이스로 이루어지며, 각 테스트 케이스는 세 개의 정수 L, R, C로 시작한다. L(1 ≤ L ≤ 30)은 상범 빌딩의 층 수이다. R(1 ≤ R ≤ 30)과 C(1 ≤ C ≤ 30)는 상범 빌딩의 한 층의 행과 열의 개수를 나타낸다.
//
//그 다음 각 줄이 C개의 문자로 이루어진 R개의 행이 L번 주어진다. 각 문자는 상범 빌딩의 한 칸을 나타낸다. 금으로 막혀있어 지나갈 수 없는 칸은 '#'으로 표현되고, 비어있는 칸은 '.'으로 표현된다. 당신의 시작 지점은 'S'로 표현되고, 탈출할 수 있는 출구는 'E'로 표현된다. 각 층 사이에는 빈 줄이 있으며, 입력의 끝은 L, R, C가 모두 0으로 표현된다. 시작 지점과 출구는 항상 하나만 있다.
//
//출력
//각 빌딩에 대해 한 줄씩 답을 출력한다. 만약 당신이 탈출할 수 있다면 다음과 같이 출력한다.
//
//Escaped in x minute(s).
//여기서 x는 상범 빌딩을 탈출하는 데에 필요한 최단 시간이다.
//
//만일 탈출이 불가능하다면, 다음과 같이 출력한다.
//
//Trapped!
//예제 입력 1 
//3 4 5
//S....
//.###.
//.##..
//###.#
//
//#####
//#####
//##.##
//##...
//
//#####
//#####
//#.###
//####E
//
//1 3 3
//S##
//#E#
//###
//
//0 0 0
import java.util.List;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

import javax.management.Query;
import javax.swing.JPopupMenu.Separator;
public class codingTest3 {
	static int l,r,c;//층수,행,열
	static char[][][] map;
	static int[][][] arr;
	static boolean[][][] visited;
	static int[] dz = {-1,1,0,0,0,0};
	static int[] dy = {0,0,1,-1,0,0};
	static int[] dx = {0,0,0,0,-1,1};
	
	private static int bfs(int i, int j, int k) {
		int answer = 0;
		int end = 0;
		visited[i][j][k] = true;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {i,j,k});
		Loop1 :
		while (!q.isEmpty()) {
			int z = q.peek()[0];
		    int y = q.peek()[1];
	        int x = q.peek()[2];
	        q.poll();
			for(int i1 = 0; i1<6; i1++) {
				int nz = z + dz[i1];
				int ny = y + dy[i1];
				int nx = x + dx[i1];
				
				if(nz>=0 && nz<l && ny>=0 && ny<r && nx>=0 && nx<c && map[nz][ny][nx]=='E') {
					arr[nz][ny][nx] = arr[z][y][x] + 1;//값 갱신
					answer = arr[nz][ny][nx];
//					System.out.println("nzyx>> "+nz+" "+ny+" "+nx+"여기방문..");
					end = 1;
					break Loop1;
				}
				if(nz>=0 && nz<l && ny>=0 && ny<r && nx>=0 && nx<c && !visited[nz][ny][nx] && map[nz][ny][nx]=='.') {
					q.add(new int[] {nz,ny,nx});
					visited[nz][ny][nx] = true;
//					System.out.println("zyx>> "+z+" "+y+" "+x);
//					System.out.println("nzyx>> "+nz+" "+ny+" "+nx+"가 . 입니다");
					arr[nz][ny][nx] = arr[z][y][x] + 1;
//					answer = arr[nz][ny][nx];
//					System.out.println(answer);
				}//if
			}//for
		}//while
		if(end!=1) {
			answer = 0;
		}
		return answer;
	}
	
    public static void main(String[] args) throws IOException {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  
	   while (true) {
		   StringTokenizer st = new StringTokenizer(br.readLine());
		   if(st.countTokens()==0) {
			   st = new StringTokenizer(br.readLine());
		   }
		   l = Integer.parseInt(st.nextToken());
		   r = Integer.parseInt(st.nextToken());
		   c = Integer.parseInt(st.nextToken());

		   if(l==0 && r==0 && c==0) {
			   System.exit(0);
		   }
		   map = new char[l][r][c];
		   arr = new int[l][r][c];
		   visited = new boolean[l][r][c];
		   //start부분을 넣을 큐
		   Queue<int[]> q = new LinkedList<int[]>();
		   for(int i = 0; i<l; i++) {
			   for(int j = 0; j<r; j++) {
				   String s = br.readLine();
				   if(s.equals("")) {
					   s = br.readLine();//한 줄 공백이 들어오면 다시 한 줄 입력 받음
				   }
				   for(int k = 0; k<c; k++) {
					   map[i][j][k] = s.charAt(k);
					   //만약 s가 입력되면 큐에 넣어준다.
					   if(map[i][j][k]=='S') {
						   q.add(new int[] {i,j,k});
					   }
				   }//for
			   }//for
		   }//for
		   
		   //출구찾기
		   int z = q.peek()[0];
		   int y = q.peek()[1];
		   int x = q.peek()[2];
		   int answer = bfs(z,y,x);
		   if(answer==0) {
			   System.out.println("Trapped!");
		   }
		   else {
			   System.out.println("Escaped in " +answer+ " minute(s).");
		   }
	   }//while
	   
    }
}
   