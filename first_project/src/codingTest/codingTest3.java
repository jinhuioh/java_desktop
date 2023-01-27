package codingTest;
import java.util.*;

public class codingTest3 {
	public static void main(String[] args) {
		int n = 5;
		int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		int k = 3;
		Solution s = new Solution();
		System.out.println(s.solution(n, road, k));
	
	
	    }
	}

class Solution{
	public int solution(int n, int[][] road, int k) {
		int[][] map = new int[n][n];
		
		//map입력받기
		for (int i = 0; i < map.length; i++) {
	        for (int j = 0; j < map.length; j++) {
	            if (i == j) {                                               
	                map[i][j] = 0;
	                continue;
	            }
	            map[i][j] = 500001;                                          
	        }
	    }
		
		 for(int i = 0; i<road.length; i++){
			 if(map[road[i][0]-1][road[i][1]-1]<road[i][2]) {
				 continue;
			 }
			 map[road[i][0]-1][road[i][1]-1] = road[i][2];
			 map[road[i][1]-1][road[i][0]-1] = road[i][2];
		 }
		
		 for (int p = 0; p < n; p++) {                                        
		        for (int i = 0; i < n; i++) {
		            for (int j = 0; j < n; j++) {
		                if (map[i][j] > map[i][p] + map[k][p]) {
		                    map[i][j] = map[i][p] + map[k][p];
		                }
		            }
		        }
		    }
		    
		    //배열 출력
//			for(int i = 0; i <N; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(map[i][j]);
//					System.out.print("\t");
//				}
//				System.out.print("\n");
//			}
		    
		    int count = 0;                                                      

		    for (int i = 0; i < map.length; i++) {
		        if (map[0][i] <= k) 
		            count++;
		    }
		    
		    return count;
		}
	}