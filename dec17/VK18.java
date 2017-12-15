package cc.dec17;
import java.util.Scanner;
public class VK18 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		final int range=1001;
		int r=range;
		int c=range;
		
		int[] lookup=new int[range];
		lookup=fillRooms(r, c);
		int t=0;
		//System.out.println("enter t: ");
		if(sc.hasNext())
			t=sc.nextInt();
		while(--t>=0){
			int n=0;
			if(sc.hasNext())
				n=sc.nextInt();
			System.out.println(lookup[n]);
		}
		//System.out.println("DONE!!");
	}
	public static int[] fillRooms(int r, int c){
		int prev[]=new int[c];
		int current[]=new int[c];
		int[] lookup=new int[r];
		
		prev[1]=2;
		lookup[1]=2;
		for(int i=2;i<c;i++)
			prev[i]=calcDiamonds(1+i)*2;
		
		for(int i=2;i<r;i++){
			for(int j=i;j<c;j++){
				int roomNo=i+j;
				if(i==j){
					current[j]=calcDiamonds(roomNo)+prev[j]+prev[j-1];
					lookup[j]=current[j];
				}
				else
					current[j]=calcDiamonds(roomNo)*2+prev[j];
			}
			prev=current;
			current=new int[c];
		}
		return lookup;
	}
	public static int calcDiamonds(int roomNo){
		int t1=0;
		int t2=roomNo;
		int sumEven=0;
		int sumOdd=0;
		while(t2>0){
			t1=t2%10;
			if(t1%2==0)
				sumEven+=t1;
			else
				sumOdd+=t1;
			t2/=10;
		}
		return sumEven>sumOdd?sumEven-sumOdd:sumOdd-sumEven;
	}
}
