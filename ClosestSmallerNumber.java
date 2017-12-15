package cc;
import java.util.*;
public class ClosestSmallerNumber {

	public static void main(String[] args) {
		//int input[]={6,2,5,4,5,1,6};//n=7
		//int input[]={0,-1,0,0,1};
		//int input[]={10,9,8,7,6,5,4,3,2,1};
		//int input[]={1,2,3,4,5,6,7,8,9,10};
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		while(n!=0){
			int[] input=new int[n];
			int[] smallLeft=new int[n];
			int[] smallRight=new int[n];
			for(int i=0;i<n;i++)
				input[i]=sc.nextInt();
			getSmallerNumber(input,smallLeft,smallRight);
			System.out.println(getMaxArea(input,smallLeft, smallRight));
			n=sc.nextInt();
		}
	}
	//Not working for inputs with equal values
	public static void getSmallerNumber(int[] input, int[] smallLeft, int[] smallRight){
		Stack<Integer> st=new Stack<Integer>();
		int n=input.length;
		
		for(int i=0;i<n;i++){
			while(!st.isEmpty() && input[i]<=input[st.peek()])
				st.pop();
			
			if(st.isEmpty())
				smallLeft[i]=-1;
			else
				smallLeft[i]=st.peek();
			st.push(i);
		}
		st.clear();
		for(int i=n-1;i>=0;i--){
			while(!st.isEmpty() && input[i]<=input[st.peek()])
				st.pop();
			
			if(st.isEmpty())
				smallRight[i]=-1;
			else
				smallRight[i]=st.peek();
			st.push(i);
		}
		//return smallLeft;//closest Smaller element to the left
		//return smallRight;//closest Smaller element to the right
	}
	
	//Application HISTOGRA - spoj
	public static int getMaxArea(int[] input, int[] smallLeft, int[] smallRight){
		int n=smallLeft.length;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			int temp=(smallRight[i]-smallLeft[i]-1)*input[i];
			max=max>temp?max:temp;
		}
		return max;
	}
	
}
