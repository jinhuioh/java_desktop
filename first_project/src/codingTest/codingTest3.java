package codingTest;

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
//
public class codingTest3 {
   public static void main(String[] args) throws IOException {

   //거리가 k이하인 트리 노드에서 사과 수확하기
      BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine()," ");
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      
      List<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
      for(int j=0; j<n; j++) {
    	  map.add(new ArrayList<Integer>());
      }
      for(int i=0; i<n-1; i++) {
    	 StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
         int p1 = Integer.parseInt(st1.nextToken());
         int p2 = Integer.parseInt(st1.nextToken());
         map.get(p1).add(p2);//부모에 연결된 자식 넣기
      }//for
      
      //사과 개수 입력
      StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
      int[] arr = new int[n];
      for(int i=0; i<n; i++) {
    	  arr[i] = Integer.parseInt(st2.nextToken());
      }//for
      

      
      int index = 0;
      Queue<Integer> q1 = new LinkedList<Integer>();
      q1.add(0);
      //해당 자식의 부모를 넣기
      int[] indexarr = new int[n];
      indexarr[0] = 0;
      for(int i=0; i<n; i++) {
    	  int q1poll = q1.poll();
    	  for(int nums: map.get(q1poll)) {
    		  indexarr[nums] = i;
    		  System.out.println(nums+" 번째 indexarr의 값은>> "+i);
    		  q1.add(nums);
    	  }
      }//for
      //방문했는지 채크
      boolean[] visited = new boolean[n];
      
      //0부터 탐색 시작!!!
      int answer = arr[0];//사과 개수의 초기값 0번째 루트부터 센다.
      Queue<Integer> q = new LinkedList<Integer>();
      q.add(0);
      visited[0] = true;
      
      //k번만큼 for문 돌림
      while(index<=k) {
    	  index++;
    	  int qpoll = q.poll();
    	  visited[qpoll] = true;
    	  for(int num: map.get(qpoll)) {//현재 위치에 담긴 숫자들
    		  if(visited[num]) {
    			  continue;
    		  }
    		  //사과 개수 세기
    		  answer += arr[num];
    		  visited[num] = true;
    		  System.out.println("index>> "+index);
    		  System.out.println("num>> "+num);
    		  System.out.println("answer>> "+answer);
    		  q.add(num);
    	  }//for
      }//for
      System.out.println(answer);
   }

}
   