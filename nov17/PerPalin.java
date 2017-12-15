package cc.nov17;
import java.util.*;
public class PerPalin {
	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		int t=0;
		if(sc.hasNextInt())
			t=sc.nextInt();
		while(--t>=0){
			int n=0;
			boolean possible=true;
			if(sc.hasNextInt())
				n=sc.nextInt();
			int p=0;
			if(sc.hasNextInt())
				p=sc.nextInt();
			if(p<=2)
				System.out.println("impossible");
			else if(n<p)
				System.out.println("impossible");
			else{	
				char[] palin=new char[p];	
				palin[0]='a';
				palin[p-1]='a';
				for(int i=1;i<p-1;i++)
					palin[i]='b';
				String str=new String(palin);
				for(int i=1;i<n;i+=p)
					System.out.print(str);
			}
		}
	}
}