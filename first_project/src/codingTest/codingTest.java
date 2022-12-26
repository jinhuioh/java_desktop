package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class codingTest {
	//static=전역 , final=최종적인, 즉 수정불가능한 변수.
	//static final=상수

	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		//햄버거 분배
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		//사람 위치 인덱스만 넣는 리스트
		List<Integer> indexNum = new ArrayList<Integer>();
		//hp가들어가는 리스트
		char[] hpwords = new char[n];
		//햄버거를 먹을 수 있는 사람 수
		int answer = 0;
		
		String words = br.readLine();
		for(int i=0; i<n; i++) {
			char word = words.charAt(i);
			hpwords[i] = word;
//			System.out.println(hpwords[i]);
			if(word == 'P') {
				indexNum.add(i);
			}//if
		}//for
//		System.out.println(indexNum);
		for(int k1=0; k1<indexNum.size(); k1++) {
			//p가있는 인덱스 번호
			int pIndex = indexNum.get(k1);
//			System.out.println("사람 번호:"+pIndex+"===================================");
			//범위를 벗어나면 안됨
			int first = pIndex-k;
			int end = pIndex+k;
			if(first<0) {
				first=0;
			}//if
			if(end>=n) {
				end = n-1;
			}
			
			//햄버거를 선택했다면 1로 바꾸기
			int h = 0;
			//왼쪽
			//범위안에 햄버거가 있다면 선택한 햄버거의 글자를p로 바꾸고 answer증가
			Loop2:
			for(int l=first; l<pIndex; l++) {
//				System.out.println(l+"햄버거 있는지~~ l");
				if(hpwords[l]=='H') {
					answer++;
					hpwords[l]='p';
//					System.out.println(l+"번째 왼쪽 햄버거 선택"+"answer>>"+answer);
					h=1;
					break Loop2;
				}//if
			}//for
				//왼쪽안에 햄버거가 없다면 오른쪽 탐색
			
			//왼쪽에서 햄버거 선택 못했다면
			if(h==0) {
				//오른쪽
				for(int l2=pIndex+1; l2<=end; l2++) {
//					System.out.println(l2+"햄버거 있는ㄴ지 l2");
					if(hpwords[l2]=='H') {
						answer++;
						hpwords[l2]='p';
//						System.out.println(pIndex+"번재 사람에게 "+l2+"번째 오른쪽 햄버거 선택"+"answer>>"+answer);
						break;
					}//if
				}//for
			}//if
		}//for
		System.out.println(answer);
		
		
		
		
		
		
		
		
		
		
		
		//양한마리 양두마리
		
//		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	        StringBuilder sb = new StringBuilder();
//	        StringTokenizer st;
//
//	        int T = Integer.parseInt(br.readLine());
//	        for (int tc = 0; tc < T; tc++) {
//	            st = new StringTokenizer(br.readLine());
//	            int H = Integer.parseInt(st.nextToken());
//	            int W = Integer.parseInt(st.nextToken());
//	            boolean[][] map = new boolean[H][W];
//	            boolean[][] visit = new boolean[H][W];
//
//	            for (int i = 0; i < H; i++) {
//	                String input = br.readLine();
//	                for (int j = 0; j < W; j++) {
////	                #이면map에 true넣기
//	                    map[i][j] = input.charAt(j) == '#';
////	                    System.out.println(map[i][j]);
//	                }
//	            }
//	            //정답(result)를 sb를 이용하여 저장+개행 후 sysout으로 한개씩 출력해준다.
//	            sb.append(bfs(H, W, map, visit)).append("\n");
//	        }
//	        //append해준 마지막 개행을 제외 = setlength(sb의 길이 -1)
//	        sb.setLength(sb.length() - 1);
//	        System.out.println(sb);
//	    }//public
//
//	    private static int bfs(int H, int W, boolean[][] map, boolean[][] visit) {
//	        int result = 0;
//	        Queue<int[]> queue = new LinkedList<>();
//	        for (int i = 0; i < H; i++) {
//	            for (int j = 0; j < W; j++) {
//	            	
////	            	map이 true이고 visit이 true가 아니면 양이 있는곳을 세지 않는 것이므로 result증가
//	                if (map[i][j] && !visit[i][j]) {
//	                    result++;
//	                    //offer=add. 새로운 int배열에 i,j넣은것을 큐에 add해줌
//	                    queue.offer(new int[]{i, j});
////	                    visit을 true로 바꿈
//	                    visit[i][j] = true;
//	                    //동서남북으로 양 무리를 세어준다.
//	                    while (!queue.isEmpty()) {
//	                        int[] cur = queue.poll();
//
//	                        for (int d = 0; d < 4; d++) {
//	                            int nr = cur[0] + dr[d];
//	                            int nc = cur[1] + dc[d];
//
//	                            //그래프 범위를 벗어난다면 continue 
//	                            if (nr < 0 || nr >= H || nc < 0 || nc >= W || !map[nr][nc] || visit[nr][nc]) continue;
//	                           //그래프 범위를 벗어나지 않는다면 true로 바꾸고 queue에 이동할 수 있는 위치를 offer해준다.
//	                            visit[nr][nc] = true;
//	                            queue.offer(new int[]{nr, nc});
//	                        }//for
//	                    }//while
//	                }//if
//	            }//for
//	        }//for
//	        System.out.println("result>>"+result);
//	        return result;
//	    }//함수 끝
	}
	}