package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
//내가 만든 정처기 채점프로그램!
public class 정처기채점프로그램 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[10][19];
		int[][] my_map = new int[10][19];
//		① ③ ④ ④ ① ② ③ ④ ③ ④
//		② ② ① ④ ② ② ④ ③ ④ ③
//		② ④ ③ ② ③ ④ ④ ③ ① ④
//		② ① ③ ③ ④ ② ① ② ② ③
//		④ ③ ② ② ② ② ② ③ ③ ④
//		③ ② ③ ③ ② ④ ① ④ ③ ①
//		① ④ ③ ② ① ② ④ ③ ② ④
//		① ③ ① ④ ① ③ ① ② ③ ②
//		④ ③ ③ ③ ① ② ④ ④ ② ②
//		④ ① ① ④ ④ ④ ④ ③ ① ④
		System.out.println("정답을 입력해주세요(공백포함 10개씩 총 10줄 답지 복붙해주셈.)>> ");
		for(int i = 0; i<10; i++) {
			String s = br.readLine();
			for(int j = 0; j<19; j++) {
				char schar = s.charAt(j);
				if(schar =='①') {
					map[i][j]=1;
				}else if(schar =='③') {
					map[i][j]=3;
				}else if(schar =='④') {
					map[i][j]=4;
				}else if(schar==' '){
					map[i][j]= 0;
				}else {
					map[i][j]=2;
				}
			}
		}

		
//		for(int i = 0; i<10; i++) {
//			for(int j = 0; j<19; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}//for
		
		
		System.out.println("내 답을 입력해주세요(공백포함 10개씩 총 10줄  입력해주셈.)>> ");
		for(int i = 0; i<10; i++) {
			String s1 = br.readLine();
			for(int j = 0; j<19; j++) {
				 char s1char = s1.charAt(j);
				 if(s1char==' ') {
					 my_map[i][j]=0;
					 continue;
				 }
				my_map[i][j] = s1char-48;
			}
		}//for
		
	
		int c = 0;
		int p = 0;//각 과목 틀린거 카운트할 변수
		int pall = 0;//전체 몇개틀렸는지 카운트할 변수
		for(int k=1; k<=5; k++) {
			p=0;//초기화
			List<Integer> answer = new ArrayList<Integer>();//틀린번호 넣을 리스트
			for(int i =k*2-2; i<=k*2-1; i++) {
				for(int j = 0; j<19; j++) {
					if(my_map[i][j] != map[i][j]) {
						answer.add((i*10+((j+1)/2)+1));
//						System.out.print((i*10+((j+1)/2)+1) + "번 / ");
						c = 1;
						p++;
						pall++;
					}
				}
				
			}
			System.out.println(k+"과목 평균> "+(100-(p*5))+"점");
			System.out.print("오답:");
			for(int a: answer) {
				System.out.print(a+"번 ");
			}
			System.out.println();
			System.out.println();
		}
		
		if(c==0) {
			System.out.println("백점!");
			System.exit(0);
		}

		System.out.println("전체 평균>"+(100-pall)+"점");
	}

}
