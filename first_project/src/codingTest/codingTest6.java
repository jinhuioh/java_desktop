package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

//호석이 두마리 치킨
public class codingTest6 {
	static int n,m;
	static final int INF = (int)1e9;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n+1][n+1];
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				if(i==j) {//자기자신과 같으면 거리가 0이므로 패스
					continue;
				}
				map[i][j] = INF;//그 외에는 무한으로 지정.
			}
		}//for
		
		//간선정보 입력받기
		for(int i = 0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			map[a][b] = map[b][a] = 1;
		}//for
		
		//플로이드 와샬 알고리즘
		for(int k = 1; k<=n; k++) {
			for(int i = 1; i<=n; i++) {
				for(int j = 1; j<=n; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}//for
		
		//두 점과 최소거리 초기값.
		int point1 = Integer.MAX_VALUE;
		int point2 = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				//2개의 지점 치킨집으로 선정
				int dis = distance(i, j);
				//더 작은 값을 찾으면 치킨집 장소와 최솟값 갱신
				if(min > dis) {
					point1 = i;
					point2 = j;
					min = dis;
				}
			}//for
		}//for
		System.out.println(point1+" "+point2+" "+min*2);
	}
	
	private static int distance(int x, int y) {
		int result = 0;
		// 각 점에서 2개의 치킨집으로 가는 거리. x치킨집과 y치킨집 중 최소값으로 result를 더해줌. 1부터 n까지의 도시 전부 누적 합.
		for(int i=1; i<=n; i++) {
			result += Math.min(map[x][i], map[y][i]);
		}
		return result;
	}
}