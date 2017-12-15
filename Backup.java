package cc;

//Not completed.. think of the base cases
public class Backup {

	public static void main(String[] args) {
		int[] dist={1,3,4,6,12};
		int k=2,j=dist.length-1;
		System.out.println(minLength(dist, j, k));
	}
	public static int minLength(int[] dist, int j, int k){
		if(k==0)
			return 0;
		if(j==0)
			return  dist[1]-dist[0];//??
		if(j<0)
			return 0;
		return min(minLength(dist, j-1, k),minLength(dist, j-2, k-1)+(dist[j]-dist[j-1]));
	}
	public static int min(int x, int y){
		return x<y?x:y;
	}
}
