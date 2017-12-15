package cc;
import java.util.*;

public class MinimalString {

	public static void main(String[] args) {
		String s="acdb";
		Stack<Integer> u=new Stack<Integer>();
		u=getU(s);
		while(!u.isEmpty())
			System.out.print(u.pop());
			
		
	}
	public static Stack<Integer> getU(String s){
		Stack<Integer> u=new Stack<Integer>();
		Stack<Integer> t=new Stack<Integer>();
		int[] hash=new int[26];
		for(int i=0;i<26;i++)
			hash[i]=0;
		int length=s.length();
		for(int i=0;i<length;i++)
			hash[s.charAt(i)-'a']++;
		for(int i=0;i<length;i++){
			boolean allUsed=true;
			for(int j=s.charAt(i)-'a'-1;j>=0;j--){
				if(hash[j]!=0){					
					allUsed=false;
					break;
				}
			}
			if(allUsed){
				hash[i]-=1;
				u.push(s.charAt(i)-'a');
			}
			else{
				t.push(s.charAt(i)-'a');
			}
		}
		while(!t.isEmpty()){
			u.push(t.pop());
		}
		return u;
	}

}
