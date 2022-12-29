package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//문제
//침투
//입력
//첫째 줄에는 격자의 크기를 나타내는  M (2 ≤ M ≤ 1,000) 과 N (2 ≤ N ≤ 1,000) 이 주어진다. M줄에 걸쳐서, N개의 0 또는 1 이 공백 없이 주어진다. 0은 전류가 잘 통하는 흰색, 1은 전류가 통하지 않는 검은색 격자임을 뜻한다.
//
//출력
//바깥에서 흘려준 전류가 안쪽까지 잘 전달되면 YES를 출력한다.
//
//그렇지 않으면 NO를 출력한다.

public class codingTest5 {
	static int[][] map;
	static boolean[][] visited;
	static int n, m;//m이 길이 n이 너비
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	private static void bfs(int j) {
 		Queue<int[]> q = new LinkedList<int[]>();
		//초기값 입력
		q.add(new int[] {0,j});
		visited[0][j] = true;
		while (!q.isEmpty()) {
			int y = q.peek()[0];
			int x = q.peek()[1];
			q.poll();
//			System.out.println("yx>> "+y+x);
			for(int k=0; k<4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				//범위를 벗어난다면 continue
				if(ny<0 || ny>=m || nx<0 || nx>=n || visited[ny][nx] || map[ny][nx] != 0) {
//					System.out.println("continue!!!nynx>> "+ny+" "+nx);
					continue;
				}//if
				
				//갱신
				visited[ny][nx]=true;
//				System.out.println("nynx>>>add "+ny+" "+nx);
				q.add(new int[] {ny, nx});
			}//for
		}//while
	}//private
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
		m = Integer.parseInt(st1.nextToken());//길이
		n = Integer.parseInt(st1.nextToken());//너비
		
		map = new int [m][n];
		visited = new boolean [m][n];
		
		for(int i=0; i<m; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j]= (int)(s.charAt(j)-'0');//전류가 지나갈 수 있는 곳
//				System.out.println(">>" + map[i][j]);
			}
		}//for
	
		String answer = "";
		for(int j=0; j<n; j++) {
			if(answer.equals("YES")) {
				System.out.println(answer);
				break;
				
			}
			if(!visited[0][j] && map[0][j]==0) {
				bfs(j);
			}//if
			//outside쪽에 나갈 수 있는 곳이 없다면
			
			//탈출했으면yes출력
			for (int l =0; l<n; l++) {
				if(visited[m-1][l] && map[m-1][l]==0) {
					answer = "YES";
				}
			}//for
	}//for
		if(!answer.equals("YES")) {
			System.out.println("NO");
		}
	}//public

}
