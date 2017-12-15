package cc.nov17;
import java.util.Scanner;

public class CSubQ {
	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		int N=0;
		if(sc.hasNextInt())
			N=sc.nextInt();
		int[] array=new int[N+1];
		int Q=0;
		if(sc.hasNextInt())
			Q=sc.nextInt();
		long L=0;
		if(sc.hasNextLong())
			L=sc.nextLong();
		long R=0;
		if(sc.hasNextLong())
			R=sc.nextLong();
		while(--Q>=0){
			int qType=0;
			if(sc.hasNextInt())
				qType=sc.nextInt();
			int l=0;
			if(sc.hasNextInt())
				l=sc.nextInt();
			int r=0;
			if(sc.hasNextInt())
				r=sc.nextInt();
			if(qType==1)
				array[l]=r;
			else{
				int gCount=0,sCount=0;
				int greater[]=new int[r-l+1];
				int smaller[]=new int[r-l+1];
				int total=0;
				for(int i=l;i<=r;i++){
					if(array[i]>R)
						greater[gCount++]=i;
					else if(array[i]<L)
						smaller[sCount++]=i;
				}
				//adding the number of sub-arrays that do not have elements greater than R in them
				if(gCount==0){
					int n=r-l+1;
					total+=(n*(n+1)/2);
				}
				else if(gCount==1){
					int n=greater[0]-l;
					total+=(n*(n+1)/2);
					n=r-greater[0];
					total+=(n*(n+1)/2);
				}
				else{
					int n=0;
					for(int i=1;i<gCount;i++){
						n=greater[i]-greater[i-1]-1;
						total+=(n*(n+1)/2);
					}
					n=greater[0]-l;
					total+=(n*(n+1)/2);
					n=r-greater[gCount-1];
					total+=(n*(n+1)/2);
				}
				//System.out.println(total);
				
				//have to subtract all the elements that are smaller than L
				if(sCount==0)
					System.out.println(total);
				
				else{
					if(sCount==1){
						total-=1;
						System.out.println(total);
					}
					else{
						int start=0,end=0;
						//System.out.println("sCount:  "+sCount);
						for(int i=0;i<sCount;i++){
							start=smaller[i];
							end=smaller[i];
							while(smaller[i]+1==smaller[i+1] ){
								i++;
								end++;
								if(i==sCount-1)
									break;
								//System.out.println("i:  "+i);
							}
							int n=end-start+1;
							total-=(n*(n+1)/2);
						}
						System.out.println(total);
					}
				}
			}
		}
		sc.close();
	}

}
