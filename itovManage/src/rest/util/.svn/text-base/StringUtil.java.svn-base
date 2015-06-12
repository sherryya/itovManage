package rest.util;

public class StringUtil {
	public static boolean isNull(String s){
		if(s==null||"".equals(s.trim())){
			return true;
		}else{
			return false;
		}
	}
    public static String repNull(String param)
    {
        if(param == null)
            return "";
        else
            return param.trim();
    }
    public static int toInt(String s){
    	return Integer.parseInt(s);
    }
    public static long toLong(String s){
    	return Long.parseLong(s);
    }
    public static double toDouble(String s){
    	return Double.parseDouble(s);
    }
    
    public static String parseAndMatch(String str,String spliter,String code){
    	String oldStr = str;
    	String [] arr = oldStr.split(spliter);
    	if(arr.length>0){
    		for(String temp : arr){
    			if(code.equals(arr[0])){
    				return arr[1];
    			}
    		}
    	}
    	return null;
    }
    
}
