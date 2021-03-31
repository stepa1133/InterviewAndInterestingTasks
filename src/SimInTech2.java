public class SimInTech2 {
    static boolean PerfectNumber(int num){
        if(num<=0)return false;
        boolean result = false;
        int resultSum=0;

        for (int i = num-1; i >0 ; i--) {
            if(num%i==0) resultSum+=i;
        }

        if (resultSum==num) result=true;
        return result;
    }
    public static void main(String[] args) {
        for (int i = 0; i <2000000000; i++) {
            if (PerfectNumber(i)) System.out.println("Число -"+ i + " -идеальное");
        }
    }
}
