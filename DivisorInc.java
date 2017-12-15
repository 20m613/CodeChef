package cc;
import java.util.*;
//A programmer started to cuss,
//'cause getting to sleep was a fuss.
//As he lay there awake in his bed,
//Looping around and 'round in his head,
//Was: while(!asleep()) sheep++;

public class DivisorInc {
	public static void main(String[] args) {
		int n=4;
		int m=24;
		System.out.println(countOperations(n, m));
	}

	//Wow... Visited array is used to not to update the value of count if aux is possible with less number of steps
	public static int countOperations(int n, int m){
		Queue<nCount> q=new LinkedList<nCount>();
		int count=0;
		boolean visited[]=new boolean[100001];
		for(int i=0;i<100001;i++)
			visited[i]=false;
		nCount ob=new nCount(n,0);
		q.add(ob);
		while(!q.isEmpty()){
			nCount ob2=q.poll();
			int aux=ob2.n;
			count=ob2.count;
//			if(aux==m)
//				return count;
			
			for(int i=2;i*i<=aux;i++){
				if(aux%i==0 && (aux+i) <=m){
					if(!visited[aux+i]){
						nCount ob3=new nCount(aux+i,count+1);
						q.add(ob3);
						visited[aux+i]=true;
					}
				}
				if(aux%(aux/i)==0 && aux+(aux/i)<=m){
					if(!visited[aux+(aux/i)]){
						nCount ob4=new nCount(aux+aux/i,count+1);
						q.add(ob4);
						visited[aux+aux/i]=true;
					}
				}
				if(aux==m)
					return count;
			}
		}
		return -1;
	}
	

	
	
	
//  Too Slowwwwwwwwwwww....................	
//	public static boolean countOperations(int n, int m){
//		if(n>m)
//			return false;
//		if(n==m)
//			return true;
//		
//		int count =0;
//		int div[]=generateDivisors(n);
//		int length=0;
//		for(int i=0;i<div.length;i++){
//			if(div[i]==-1)
//				break;
//			length++;
//		}
//		boolean returnVal=false;
//		for(int i=0;i<length;i++){
//			returnVal=countOperations(n+div[i],m);
//		}
//		return returnVal;
//	}
	
	public static int[] generateDivisors(int n){
		int sqrt=(int)Math.sqrt(n);
		int[] divisors=new int[sqrt*2];
		for(int i=0;i<sqrt*2;i++)
			divisors[i]=-1;
		int count=0;
		for(int i=2;i<=sqrt;i++){
			if(n%i==0){
				divisors[count++]=i;
				if(i!=sqrt)//sqrt gets appended twice otherwise
					divisors[count++]=n/i;
			}
		}
		return divisors;
	}
}
class nCount{
	int n=0;
	int count=0;
	public nCount(int n, int count){
		this.n=n;
		this.count=count;
	}
}
