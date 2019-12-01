package googleplacesapiclient;

class Utils {
    
    public static boolean isDouble(String str) {
        
        try {
            Double.valueOf(str);
            return true;
        }
        catch (NumberFormatException e) {
            
            return false;
        }
    };
    
    public static boolean isInteger(String str) {
        
        try {
            Integer.valueOf(str);
            return true;
        }
        catch (NumberFormatException e) {
            
            return false;
        }
    };
}
