package cc;
import java.util.*;
public class Salary {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(--t>=0){
			int n=sc.nextInt();
			int salary[]=new int[n];
			for(int i=0;i<n;i++)
				salary[i]=sc.nextInt();
			int increment=0;
			while(true){
				Arrays.sort(salary);
				int first=salary[0];
				int last=salary[n-1];
				if(first==last)
					break;
				
				int secondLast=salary[search(salary, 0, salary.length-1)-1];
				int incrementBy=last-secondLast;
				increment+=incrementBy;
				for(int i=0;i<n-1;i++)
					salary[i]+=incrementBy;
//				for(int i=0;i<n;i++)
//					System.out.print(salary[i]+"  ");
//				System.out.println();
			}
			System.out.println(increment);
		}
	}
	public static int search(int[] array, int start, int end){
		if(start==end)
			return start;
		if(start>end)
			return array.length-1;
		int mid=(start+end)/2;
		if(array[mid]==array[end]){
			if(array[mid-1]!=array[mid])
				return mid;
			return search( array, start, mid-1);
		}
		else{
			return search(array, mid+1, end);
		}
	}
}
