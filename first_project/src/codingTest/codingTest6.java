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
public class codingTest6 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] DR = {0,0,-1,1};
    private static final int[] DC = {-1,1,0,0};
    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                if (Integer.parseInt(st.nextToken()) == 0)
                    map[i][j] = true;
            }
        }

        int answer = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!map[i][j]) continue;
                answer++;
                Queue<int[]> q = new ArrayDeque<>();
                q.add(new int[]{i,j});
                map[i][j] = true;
                while (!q.isEmpty()) {
                    int cr = q.peek()[0];
                    int cc = q.poll()[1];
                    for (int d = 0; d < 4; d++) {
                        int nr = cr+DR[d];
                        int nc = cc+DC[d];
                        //음수라면.즉 행 또는 열이 0인 경우 반대편으로 넘겨주기
                        if (nr<0) nr+=r;
                        if (nc<0) nc+=c;
                        //map범위를 넘는다면. 즉 행또는 열이 마지막 줄이라면 0번째값도 방문처리 해야함.
                        nr%=r;
                        nc%=c;

                        if (!map[nr][nc]) continue;
                        map[nr][nc] = false;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new codingTest6().solution();
    }
}