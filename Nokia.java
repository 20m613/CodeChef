package cc;

public class Nokia {
	public static void main(String[] args) {
		int[] min=new int[51];
		int[] max=new int[51];
		int k=0;
		for(int i=1;i<51;i++){
			k=i/2;
			min[i]=min[k]+min[i-k-1]+i+1;
			max[i]=max[i-1]+i+1;
		}
		for(int i=0;i<51;i++)
			System.out.println("Min["+i+"]:  "+min[i]+"    max["+i+"]:  "+max[i]);
		

	}

}
