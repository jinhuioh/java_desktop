package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//방문길이 프로그래머스
//class indexclass{
//	int y;
//	int x;
//	int z;
//	indexclass(int y, int x, int z){
//		this.y = y;
//		this.x = x;
//		this.z = z;
//	}
//}

public class codingTest4 {
//	static int[] dx = {0,0,1,-1};
//	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String dirs = br.readLine();
		boolean[][][] visited = new boolean[11][11][4];
		Queue<int[]> q = new LinkedList<int[]>();
//		int[][] map = new int[11][11];
		
		//dirs를 숫자로 바꾸어  q에 넣기
		for(int i=0; i<dirs.length(); i++) {
			char sone = dirs.charAt(i);
			if(sone=='U') {
				q.add(new int[] {1, 0, 0});
			}
			else if(sone=='L') {
				q.add(new int[] {0,-1, 1});
			}
			else if (sone=='D') {
				q.add(new int[] {-1, 0, 2});
			}
			else {
				q.add(new int[] {0, 1, 3});
			}
		}
		//map 위치 초기값.5,5부터 시작!
		int b = 5;
		int a = 5;
		int answer = 0;
		while (!q.isEmpty()) {
			int y = q.peek()[0];
			int x = q.peek()[1];
			int z = q.peek()[2];
			
			q.remove();
			
			
			int ny = y + b;
			int nx = x + a;
			
			if(ny<0 || nx<0 || ny>=11 || nx>=11) continue; 
			
			if(!visited[ny][nx][z]) {
				visited[ny][nx][z] = true;
				if(z==0) {
					visited[b][a][2] = true;
				}
				else if(z==1) {
					visited[b][a][3] = true;
				}
				else if(z==2) {
					visited[b][a][0] = true;
				}
				else {
					visited[b][a][1] = true;
				}
				answer++;
			}
			b = ny;
			a = nx;//위치 갱신
			
		}
		System.out.println(answer);
//		return answer;
	}
}