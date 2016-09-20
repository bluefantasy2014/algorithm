
public class BooleanParenthestion1 {
	public static void main(String[] args){
//		String[] a = {"","T","T","F","T"};
//		String[] o = {"","|","&","^"}; 
		String[] a = {"","T","F"};
		String[] o = {"","^"}; 
		System.out.println(f(a,o)); 
	}
	
	static int f(String[] a,String[] o){
		TFNode[][] res = new TFNode[a.length][a.length];
		
		TFNode node = null; 
		for (int round=1; round<a.length; ++round){  // round
			for(int i=1,j=round; i<=a.length-round; ++i,++j){ // compute res[i,j], i<=j. 
   			    node = new TFNode(); 
				if (i==j){ 
				   if (a[i].equals("T")) 
					   node.t = 1; 
				   else 
				       node.f = 1;
			   } else{
				   TFNode tmp =  null; 
				   for (int k=i;k<j;++k){ //k in [i..j-1]
					   // res[i][k] op res[k+1][j]
					   tmp = cal(res[i][k],res[k+1][j],o[k]); 
					   node.merge(tmp);
				   }
			   }
			  res[i][j] = node; 
			}
		}
		
		print(res); 
		return res[1][a.length-1].t; 
	}
	
	public static void print(TFNode[][] a){
		StringBuffer sb = null; 
		for (int i=1; i<a[1].length; ++i){
			sb = new StringBuffer();
			for (int j=i; j<a[1].length; ++j){
				sb.append("T:" + a[i][j].tCount() + "F:" + a[i][j].fCount() + " "); 
			}
			System.out.println(sb.toString()); 
		}
	}
	
	public static TFNode cal(TFNode p1, TFNode p2,String o ){
		TFNode ret = new TFNode(); 
		switch (o){
			case "&":
				ret.t = p1.tCount()*p2.tCount();  
				ret.f = p1.tCount()*p2.fCount() + p1.fCount()*p2.tCount();
				break; 
			case "|":
				ret.t = (p1.tCount()+ p1.fCount())*(p2.tCount()+p2.fCount()) - p1.fCount()*p2.fCount(); 
				ret.f = p1.fCount()*p2.fCount();
				break; 
			case "^":
				ret.t = p1.tCount()*p2.fCount() + p1.fCount()*p2.tCount() ;
				ret.f = p1.tCount()*p2.tCount() + p1.fCount()*p2.fCount() ;
				break; 
		}
		
		return ret;  
	}
	
	public static class TFNode{
		public int t = 0; 
		public int f = 0; 
		
		boolean isT(){
			return t>0; 
		}
		
		int tCount(){
			return t; 
		}
		
		boolean isF(){
			return f>0; 
		}
		
		int fCount(){
			return f; 
		}
		
		void merge(TFNode n){
			this.f += n.f; 
			this.t += n.t; 
		}
	}
}
