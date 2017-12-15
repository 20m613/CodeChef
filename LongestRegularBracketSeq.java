package cc;
import java.util.*;
//https://stackoverflow.com/questions/26643697/longest-subsequence-of-balanced-parentheses
public class LongestRegularBracketSeq {
	public static void main(String[] args) {
		Stack<Integer> st=new Stack<Integer>();
		String str;
		Scanner sc=new Scanner(System.in);
		str=sc.next();
		int length=str.length();
		int dp[]=new int[length];
		for(int index=0;index<length;index++)
			dp[index]=-1;
		for(int index=0;index<length;index++){
			if(str.charAt(index)=='(' )
				st.push(index);
			else if(!st.isEmpty()){
				int top=st.pop();
				dp[index]=top;
				if(top>0 && str.charAt(top-1)==')'){
					if(dp[top-1]!=-1){
						dp[index]=dp[top-1];
					}
				}
			}
		}
		int maxCount=0;
		int maxLength=0;
		for(int index=0;index<length;index++){
			if(maxLength==index-dp[index]+1)
				maxCount++;
			else if(maxLength<index-dp[index]+1)
				maxCount=1;
			if(dp[index]==Integer.MAX_VALUE)
				dp[index]=Integer.MIN_VALUE;
			if(dp[index]!=-1){
				maxLength=max(maxLength,index-dp[index]+1);
				System.out.println(str.substring(dp[index],index+1));
			}
		}
		System.out.println(maxLength+" "+maxCount);
	}
	public static int max(int x, int y){
		return x>y?x:y;
	}
	public static int min(int x, int y){
		return x<y?x:y;
	}
}
