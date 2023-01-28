package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;



public class codingTest7 {
	
	public static void main(String[] args) throws IOException {
			
	}

}

//괄호문제
class Solution1 {
  public int solution(String s) {
      int answer = 0;
      String str=s;
      
      for(int i=0;i<s.length();i++){
          char temp=str.charAt(0);
          str=str.substring(1)+temp;
          if(isCorrect(str)){
              answer++;
          }
      }
      
      return answer;
  }
  
  public boolean isCorrect (String str){
      Stack<Character> s = new Stack<>();
      
      char[] arr = str.toCharArray();
      
      for(char data:arr){
          if(s.isEmpty()){
              s.push(data);
          }
          else if(s.peek()=='['&&data==']'){
              s.pop();
          }
          else if(s.peek()=='('&&data==')'){
              s.pop();
          }
          else if(s.peek()=='{'&&data=='}'){
              s.pop();
          }
          else{
              s.push(data);
          }
      }
      
      if(s.isEmpty()){
          return true;
      }
      
      return false;
  }
}
