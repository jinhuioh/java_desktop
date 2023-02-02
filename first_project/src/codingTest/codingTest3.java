package codingTest;
import java.util.*;

public class codingTest3 {
	public static void main(String[] args) {
		int[] ingredient = {1, 1, 2, 3, 1, 2, 1, 2, 3, 1, 3, 1, 2, 3, 1, 1};
		Solution s = new Solution();
		System.out.println(s.solution(ingredient));
	    }
	}

class Solution {
	
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> inStack = new Stack<Integer>();
        
        for(int in : ingredient) {
        	inStack.push(in);
//        	System.out.println(inStack);
        	if(inStack.size() >= 4) {
        		
	        	if(inStack.get(inStack.size()-4)==1
	        			&& inStack.get(inStack.size()-3)==2
	        			&& inStack.get(inStack.size()-2)==3
	        			&& inStack.get(inStack.size()-1)==1) {
	        		
	        		answer++;
	        		inStack.pop();
	        		inStack.pop();
	        		inStack.pop();
	        		inStack.pop();
	        		
	        	}
        	}
        }
        
		return answer;
        
    }
}