import java.util.HashSet;
import java.util.Set;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class BooleanParenthestion {
	public static void main(String[] args) throws ScriptException{
		String[] a = {"","false","false","true"};
		String[] o = {"","&&","||"}; 
		Set<String> res = f(a,o,1,a.length-1); 
		
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript"); 
//	    String expr = "((TRUE && TRUE) || (TRUE && FALSE))".toLowerCase();
//	    Boolean result = (Boolean)engine.eval(expr);
	    
		for (String s:res){
			System.out.println(s + ":" +  (Boolean)engine.eval(s)); 
		}
	}
	
	static Set<String> f(String[] a,String[] o, int i, int j){
		Set<String> s =  new HashSet<String>();
		
		if (i==j){
			s.add(a[i]); 
			return s; 
		}
		
		Set<String> s1 =  new HashSet<String>();
		Set<String> s2 =  new HashSet<String>();
		for (int k=i; k<j;++k){
			s1 = f(a,o,i,k); 
			s2 = f(a,o,k+1,j);
			
			//merge s1 and s2 to form the final set
			for(String is1 : s1){
				for (String is2 : s2){
					s.add("(" + is1 + o[k] +is2 + ")"); 
				}
			}
		}
		return s; 
	} 
}
