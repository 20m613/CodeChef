package cc.dec17;
import java.util.Scanner;
public class CPLAY {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			String str="";
			String winner="";
			boolean decider=false;
			if(sc.hasNext())
				str=sc.next();
			int teamA[]=new int[20];
			int teamB[]=new int[20];
			int aCounter=0;
			int bCounter=0;
			int goalA=0;
			int goalB=0;
			int remainingShots=0;
			int shotsTakenA=0;
			int shotsTakenB=0;
			int remainingA=0;
			int remainingB=0;
			for(int i=0;i<10;i++){
				if(i%2==0)
					goalA+=str.charAt(i)-'0';
				else
					goalB+=str.charAt(i)-'0';
				int temp=i/2;
				
				if(temp*2==i)
					shotsTakenA++;
				else
					shotsTakenB++;
				remainingA=5-shotsTakenA;
				remainingB=5-shotsTakenB;
				remainingShots=remainingA+remainingB;
				
				int diff=0;
				if(goalA>goalB){
					diff=goalA-goalB;
					if(diff>remainingB){
						decider=true;
						winner="TEAM-A";
						System.out.println(winner+" "+(shotsTakenA+shotsTakenB));
						break;
					}
				}
				else if(goalB>goalA){
					diff=goalB-goalA;
					if(diff>remainingA){
						decider=true;
						winner="TEAM-B";
						System.out.println(winner+" "+(shotsTakenA+shotsTakenB));
						break;
					}
				}
			}
			
			int min=shotsTakenA+shotsTakenB;
			if(!decider){
				for(int i=10;i<20;i++){
					
					if(i%2==0){
						if(str.charAt(i)=='0' && str.charAt(i+1)=='1'){
							decider=true;
							winner="TEAM-B";
							System.out.println(winner+" "+(i+2));
							break;
						}
						else if(str.charAt(i)=='1' && str.charAt(i+1)=='0'){
							decider=true;
							winner="TEAM-A";
							System.out.println(winner+" "+(i+2));
							break;
						}
					}
				}
			}
			if(!decider)
				System.out.println("TIE");
		}
	}
	public static int max(int x, int y){
		return x>y?x:y;
	}
	public static int min(int x, int y){
		return x<y?x:y;
	}

}
