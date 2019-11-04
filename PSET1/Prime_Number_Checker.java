public class PrimeNumberChecker{
    public static int isPrime(int num){
        int i = 2;
        while(i <= num/2){
            if(num % i == 0) {
                return 0;
            }
            i++;
        }
        return 1;
    }
}
