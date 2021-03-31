public class SimInTech3 {
    static double Interpolation(double[] X,double [] Y, double x){
        if(X.length!=Y.length) System.exit(0);         //Если длина массива X не равна длине массива Y, то завершаем работу программы
        if((x<X[0])|(x>X[X.length-1])) System.exit(0); //Если x для которого нужно найти y не соответсвует условию (Xmin <= x <= Xmax), то завершаем работу программы
//Определим в какой промежуток попадает наш х. И Определим индекс промежутка, в который попадает наш х
        double firstX=0;
        double secondX=0;
        int index =0;
        for (int i = 0; i <X.length-1 ; i++) {
            if((x>=X[i])&(x<=X[i+1])){
                firstX=X[i];   //Нижняя граница промежутка
                secondX=X[i+1];//Верхняя шраница промежутка
                index=i;       //Индекс
            }
        }
//Далее найдем соответсвующий промежуток для y
        double firstY=Y[index];
        double secondY=Y[index+1];
//Из уравнения прямой найдем коэффициент а
        double a =(secondY-firstY)/(secondX-firstX);
//Из уравнения прямой найдем коэффициент b
        double b = firstY-a*firstX;
        return a*x+b;
    }
    public static void main(String[] args) {
        System.out.println(Interpolation(new double[]{0, 2, 3, 3.5},new double[]{-1, 0.2, 0.5, 0.8},1));

    }

}
