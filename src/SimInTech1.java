public class SimInTech1 {
    static int rand6(){
        return  (int)(Math.random() * 6); //
    }

    static int rand2(){
        int num=rand6();
        if (num%2==0) return 0;
        else          return 1;
    }

    static int rand3(){
        int result=-1;
        int num = rand6();
        if ((num==0)|(num==1)) result=0;
        else if ((num==2)|(num==3)) result=1;
        else if ((num==4)|(num==5)) result=2;
        return  result;
    }


    static int rand12(){
        int result=-1;
        int firstNum=rand6();      // [0|1|2|3|4|5]
        int secondNum=rand2();     // [0|1]

        if (secondNum==0){
            result=firstNum;       // [0|1|2|3|4|5]
        }
        else if (secondNum==1){
            result=6+firstNum;     // [6|7|8|9|10|11]
        }
        return result;
    }

    static int rand29() {
        int result = -1;
        int random12 = rand12();   // [0|1|2|3|4|5|6| 7|8|9|10|11]
        int random3 = rand3();     // [0|1|2]

        if (random3 == 0) {
            result = random12;     // [0|1|2|3|4|5|6|7|8|9|10|11]
        }
        else if (random3 == 1) {
            result = random12 + 12;// [12|13|14|15|16|17|18|19|20|21|22|23]
        }
        else if (random3 == 2) {   // [24|25|26|27|28]
            while (random12 < 7) {
                random12 = rand12();
            }
            result = 17 + random12;
        }

        return result;
    }
    public static void main(String[] args) {
        for (int i = 0; i <500 ; i++) {
            System.out.println(rand29());
        }
    }
}
