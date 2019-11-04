public class Fibonacci{
    
    public static String fibonacci( int n ){
        String fibString = "";
        int fibArray[] = new int[n];
        for (int i = 0; i<n;i++){
            if (i==0){
                fibArray[i] = 0;
            }else if (i==1){
                fibArray[i] = 1;
            }else{
                fibArray[i] = fibArray[i-1] + fibArray[i-2];
            }
        }
        for(int i=0;i<n;i++){
            fibString += fibArray[i] + ",";
        }
        return fibString.substring(0, fibString.length()-1);  
    }
}
