package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class codingTest2 {
	//상하좌우 좌표 생성
	 static final int[] dx = {-1, 0, 1, 0};
	 static final int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		//양한마리 양두마리.. 너비우선탐색
//		입력
//		첫 번째 줄은 테스트 케이스의 수를 나타나는 T를 입력받는다.
//
//		이후 각 테스트 케이스의 첫 번째 줄에서는 H,W 를 입력받는다. H는 그리드의 높이이고, W는 그리드의 너비이다. 이후 그리드의 높이 H 에 걸쳐서 W개의 문자로 이루어진 문자열 하나를 입력받는다. 
//
//		0 < T ≤ 100
//		0 < H, W ≤ 100
//		출력
//		각 테스트 케이스마다, 양의 몇 개의 무리로 이루어져 있었는지를 한 줄에 출력하면 된다. 
//		입력예제:
//		2
//		4 4
//		#.#.
//		.#.#
//		#.##
//		.#.#
//		3 5
//		###.#
//		..#..
//		#.###
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
//			높이와 너비 입력
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			boolean[][] graph1 = new boolean[H][W];
			boolean[][] graph2 = new boolean[H][W];
			
			for(int k=0; k<H; k++) {
				//#.입력받기
				String Words = br.readLine();
				for(int l=0; l<W; l++) {
					//샵이면 graph1에 true넣기
					graph1[k][l] = Words.charAt(l)=='#';
				}//for
			}//for
//			함수호출해서 count계산하기. 
			//stringbuilder에 정답 append하기!!
			sb.append(bfs(H,W,graph1,graph2)).append("\n");
		}//for
		sb.setLength(sb.length()-1);//마지막 개행 빼기! 필요없음
		System.out.println(sb);
	}//public
	
	//함수생성 graph2로 count할 함수
	private static int bfs(int H, int W, boolean[][] graph1, boolean[][] graph2) {
		//양 무리 세기 변수
		int count = 0;
		//큐
		Queue<int[]> queue = new LinkedList<>(); 
		for(int k=0; k<H; k++) {
			for(int l=0; l<W; l++) {
				if(graph1[k][l] && !graph2[k][l]) {
					count++;
					graph2[k][l]=true;
					//큐에 값 넣어주기//큐를 쓰는 이유는 result1에서 true인 경우의 위치값(k,l)만 빼서 해당 위치값으로부터 동서남북으로  true인 경우를 계산해야하기 때문!
					queue.offer(new int[] {k,l});
					
					//동서남북으로 전부 true로 바꾸기//while문 안돌리면 동서남북4군데 1번만 돌기 때문에 1칸을 넘어가는 범위에 대해서는 계산이 안된다.
					//따라서 큐로 값을 받은 후 while로 graph1의 false전까지 전부 graph2를 true로 바꾸어주면 된다. 
					while (!queue.isEmpty()) {
                        int[] cur = queue.poll();

                        for (int d = 0; d < 4; d++) {
                            int ny = cur[0] + dy[d];
                            int nx = cur[1] + dx[d];

                            //그래프 범위를 벗어난다면 continue 
                            //그래프의 범위가 0부터 시작하므로 가장 끝 자리는  W-1과 H-1이다. 따라서nx >= W ,ny >= H 인 경우 continue해줘야한다.
                            if (ny < 0 || ny >= H || nx < 0 || nx >= W || !graph1[ny][nx] || graph2[ny][nx]) continue;
                           //그래프 범위를 벗어나지 않는다면 true로 바꾸고 queue에 이동할 수 있는 위치를 offer해준다.
                            graph2[ny][nx] = true;
                            queue.offer(new int[]{ny, nx});
							}//for
					}//WHile
					
				}//if
			}//for
		}//for
		return count;
	}//함수

}
