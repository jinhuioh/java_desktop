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
	 static int moveY[] = {-1,0,1,0,0,0};
	    static int moveX[] = {0,1,0,-1,0,0};
	    static int moveZ[] = {0,0,0,0,1,-1};
	    static int L,R,C;
	    static char arr[][][];
	    static int map[][][];
	    static boolean visit[][][],check=false;
	    static Po start, end;
	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        while(true) {
	            check = false;
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            if(!st.hasMoreTokens())
	                st = new StringTokenizer(br.readLine());
	            
	            L = Integer.parseInt(st.nextToken());
	            R = Integer.parseInt(st.nextToken());
	            C = Integer.parseInt(st.nextToken());
	            if(L==0 && R==0 && C==0) {
	                break;
	            }
	            arr = new char[L][R][C];
	            map = new int[L][R][C];
	            visit = new boolean[L][R][C];
	            
	            for(int l=0; l<L; l++) {
	                for(int r=0; r<R; r++) {
	                    String str = br.readLine();
	                    
	                    if(str.equals("")) 
	                        str = br.readLine();
	                        
	                    for(int c=0; c<C; c++) {
	                        char ch = str.charAt(c);
	                        if(ch == 'S') {
	                            start = new Po(c,r,l);
	                        }else if(ch == 'E') {
	                            end = new Po(c,r,l);
	                        }
	                        arr[l][r][c] = ch;
	                    }
	                }
	            }
	            
	            bfs(start);
	            if(!check) {
	                System.out.println("Trapped!");
	            }
	        }
	        
	        
	    }
	    public static void bfs(Po p) {
	        Queue<Po> queue = new LinkedList<>();
	        queue.add(p);
	        visit[p.z][p.y][p.x] = true;
	        
	        while(!queue.isEmpty()) {
	            Po tmp = queue.poll();
	            if(tmp.x == end.x && tmp.y == end.y && tmp.z == end.z) {
	                
	                System.out.println("Escaped in "+map[tmp.z][tmp.y][tmp.x]+" minute(s).");
	                check = true;
	                return;
	            }
	            
	            for(int d=0; d<6; d++) {
	                int newX = tmp.x + moveX[d];
	                int newY = tmp.y + moveY[d];
	                int newZ = tmp.z + moveZ[d];
	                
	                if(0<=newX && newX<C && 0<=newY && newY<R && 0<=newZ && newZ<L && !visit[newZ][newY][newX]) {
	                    if(arr[newZ][newY][newX]!='#') {
	                        visit[newZ][newY][newX] = true;
	                        map[newZ][newY][newX] = map[tmp.z][tmp.y][tmp.x] + 1;
	                        queue.add(new Po(newX,newY,newZ));
	                    }
	                }
	            }
	        }
	        
	    }
	    public static class Po{
	        int x;
	        int y;
	        int z;
	        public Po(int x,int y,int z) {
	            this.x=x;
	            this.y=y;
	            this.z=z;
	        }
	    }
	}