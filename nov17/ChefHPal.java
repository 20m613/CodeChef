package cc.nov17;

public class ChefHPal {
	public static void main(String[] args) {
		String str="malayalasdam";
//		System.out.println("LPS length:  "+getLongestPalindrome(str).length());
		System.out.println(getMinLength("", 10, 5));

	}
	//lol O(aplha^n) too slow
	public static int getMinLength(String str, int n, int alpha){
		if(n==str.length()){
			//System.out.println("Str:  "+str);;
			return getLongestPalindrome(str).length();
		}
		
		int min=Integer.MAX_VALUE;
		char[] alphabets={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		for(int i=0;i<alpha;i++){
			int largestPalinLength=getMinLength(str+alphabets[i],n,alpha);
			min=min<largestPalinLength?min:largestPalinLength;
		}
		return min;
	}
	
	
	//Manacher's algo for Longest palindrome sequence
	public static String preProcess(String str)
    {
        int len = str.length();
        if (len == 0) 
            return "^$";
        String s = "^";
        for (int i = 0; i < len; i++)
            s += "#" + str.charAt(i);         
        s += "#$";
        return s;
    }
    public static String getLongestPalindrome(String str)
    {
       
        char[] s = preProcess(str).toCharArray();
        int N = s.length;
        int[] p = new int[N + 1];
        int id = 0, mx = 0;
        for (int i = 1; i < N - 1; i++) 
        {
             p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 0;
             while (s[i + 1 + p[i]] == s[i - 1 - p[i]]) 
                 p[i]++;
             if (i + p[i] > mx) 
             {
                 mx = i + p[i];
                 id = i;
             }
        }
        /** length of largest palindrome **/
        int maxLen = 0;
        /** position of center of largest palindrome **/
        int centerIndex = 0;
        for (int i = 1; i < N - 1; i++) 
        {
            if (p[i] > maxLen) 
            {
                maxLen = p[i];
                centerIndex = i;
            }
        }
        /** starting index of palindrome **/
        int pos = (centerIndex - 1 - maxLen)/2;
        return str.substring(pos , pos + maxLen);        
    }

}
