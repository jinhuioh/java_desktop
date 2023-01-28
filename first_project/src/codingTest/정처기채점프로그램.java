package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;
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
//		1 2 3 4 5 6 7 8 9 10
//		③ ③ ④ ② ② ③ ① ③ ③ ①
//		11 12 13 14 15 16 17 18 19 20
//		① ④ ② ③ ① ③ ③ ② ④ ②
//		21 22 23 24 25 26 27 28 29 30
//		③ ④ ③ ② ④ ② ④ ① ① ③
//		31 32 33 34 35 36 37 38 39 40
//		③ ③ ④ ③ ④ ① ④ ④ ② ②
//		41 42 43 44 45 46 47 48 49 50
//		③ ④ ③ ② ④ ④ ① ① ④ ③
//		51 52 53 54 55 56 57 58 59 60
//		② ④ ④ ① ③ ① ② ④ ④ ④
//		61 62 63 64 65 66 67 68 69 70
//		① ③ ③ ① ③ ③ ③ ④ ② ④
//		71 72 73 74 75 76 77 78 79 80
//		① ③ ④ ① ③ ③ ③ ③ ③ ①
//		81 82 83 84 85 86 87 88 89 90
//		③ ② ④ ① ② ② ④ ④ ① ④
//		91 92 93 94 95 96 97 98 99 100
//		② ③ ③ ① ② ① ③ ③ ④ ①
		
//		3 3 4 2 2 1 1 3 3 1
//		1 4 2 3 1 3 3 2 4 2 
//		4 4 3 2 4 4 4 4 1 2 
//		3 4 4 3 3 1 4 4 2 2 
//		3 4 3 2 4 4 1 1 4 3
//		2 4 4 2 3 1 2 4 1 4
//		1 3 3 1 3 6 3 1 2 4
//		1 4 3 6 3 3 3 3 2 1 
//		3 2 3 1 2 2 4 4 1 4
//		2 3 3 1 2 4 3 1 4 1 
		System.out.println("정답을 입력해주세요(cbt답지 복붙!)>> ");
		for(int i = 0; i<10; i++) {
			String s = br.readLine();
			char sone = s.charAt(0);
			if(Character.isDigit(sone)) {
				s = br.readLine();
			}
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
		
		
		System.out.println("내 답을 입력해주세요(공백포함 10개씩 총 10줄  입력.)>> ");
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
		int notanswer = 0;//각 과목 틀린거 카운트할 변수
		int notanswer_all = 0;//전체 몇개틀렸는지 카운트할 변수
		for(int k=1; k<=5; k++) {
			notanswer=0;//초기화
			List<Integer> answer = new ArrayList<Integer>();//틀린번호 넣을 리스트
			for(int i =k*2-2; i<=k*2-1; i++) {
				for(int j = 0; j<19; j++) {
					if(my_map[i][j] != map[i][j]) {
						answer.add((i*10+((j+1)/2)+1));
//						System.out.print((i*10+((j+1)/2)+1) + "번 / ");
						c = 1;
						notanswer++;
						notanswer_all++;
					}
				}
				
			}
			System.out.println(k+"과목 평균> "+(100-(notanswer*5))+"점");
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

		System.out.println("전체 평균>"+(100-notanswer_all)+"점");
	}

}
