package utils;


public class Utils {
   
    public static boolean isNullOrEmpty(String s)
    {
        return (s == null || s.trim().isEmpty());
    }
 
    public static boolean isValidISBN(String s)
    {
    	if (s.length() != 10 && s.length() != 13)
    		return false;
    	return true;
    }
    
}