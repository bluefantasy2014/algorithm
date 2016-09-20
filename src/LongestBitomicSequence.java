public class LongestBitomicSequence {
	public static void main(String[] args){
//		int[] a = {1, 11, 2, 10, 4, 5, 2, 1}; 
//		int[] a = {12, 11, 40, 5, 3, 1};
		int[] a = {80, 60, 30, 40, 20, 10}; 
		System.out.println(LBS(a)); 
	}
	
	public static int LBS(int[] a) {
		int[] l = new int[a.length];  //store the length of LBS ending with a[i]
		int[] m = new int[a.length];  //store the mode(increase,decrease, or both) of the LBS for l[i]. 1:increase; 2:decrease; 0:both;
		
		l[0] = 1; m[0] = 0;
		
		for (int i = 1; i < a.length; ++i){ //calculate the value of l[i] for i in [1..n-1]
			for (int j = i-1; j>=0; j--){
				switch (m[j]){
					case 1: // increasing 
						if (l[j]+1 > l[i]){
							l[i] = l[j] + 1; 
							m[i] = (a[i]>a[j]) ? 1:2;  
						}
						break; 
					case 2: //decreasing
						if (a[i] < a[j] && l[j]+1 > l[i]){
							l[i] = l[j] + 1; 
							m[i] = 2; 
						}
						break; 
					case 0: //both are OK
						if (l[j]+1 > l[i]){
							l[i] = l[j] + 1;
							m[i] = (a[i]>a[j]) ? 1:2;
						}
				}
			}
		}
		return l[a.length-1]; 
	}
}
