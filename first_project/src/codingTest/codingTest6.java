package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
//도넛행성
//입력
//첫 번째 줄에 
//$N$과 
//$M$이 공백을 사이에 두고 주어진다.
//
//두 번째 줄부터 
//$N$개의 줄에 걸쳐 
//$N \times M$개의 칸에 대한 정보가 주어진다. 두 번째 줄에서부터 
//$i$번째 줄에 주어지는 
//$j$번째 정수는 칸 
//$(i-1, j-1)$에 대한 정보이다. 만약 0이라면 비어 있는 것이고, 1이라면 숲으로 막혀 있는 것이다.
//
//출력
//탐험할 수 있는 구역의 개수를 출력한다.
//
//제한
// 
//$2 \le N \le 1\,000$ 
// 
//$2 \le M \le 1\,000$ 
//예제 입력 1 
//5 6
//1 1 1 1 1 1
//1 0 0 0 1 1
//1 1 1 1 0 0
//1 1 1 1 0 0
//1 1 1 1 1 1
//예제 출력 1 
//2
class node1{
	int y,x;
	node1(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
public class codingTest6 {
    static int n,m;
    static boolean[][] map;
    static Queue<node1> q = new LinkedList<node1>();
    static int[] dy = {0,0,1,-1};
    static int[] dx = {-1,1,0,0};
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	map = new boolean[n][m];
    	
//    	map입력받기
    	for(int i = 0; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j<m; j++) {
    			if(Integer.parseInt(st.nextToken())==0) map[i][j] = true;//비어있으면 true 로 변경해줌
    		}
    	}//for
    	
    	
    	int answer = 0;
    	for(int i = 0; i<n; i++) {
    		for(int j = 0; j<m; j++) {
    			if(map[i][j]) {
    				answer++;
    				
    				q.add(new node1(i, j));
    				map[i][j] = true;
    				while (!q.isEmpty()) {
						//동서남북으로 채크
    					node1 qp = q.poll();
    					int y = qp.y;
    					int x = qp.x;
    					for(int k = 0; k<4; k++) {
    						int ny = y + dy[k];
    						int nx = x + dx[k];
    						//만약 음수면 반대쪽으로 이동
    						if(ny<0) {
    							ny = ny+n;
    						}
    						if(nx<0) {
    							nx = nx+m;
    						}
    						//만약 n,m보다 크다면 나머지로 계산.
    						ny = ny % n;
    						nx = nx % m;
    						if(map[ny][nx]) {
    							map[ny][nx] = false;
    							q.add(new node1(ny, nx));
    						}
    					}//for
					}//while
    			}//if
    		}//for
    	}//for
    	System.out.println(answer);
    }
}