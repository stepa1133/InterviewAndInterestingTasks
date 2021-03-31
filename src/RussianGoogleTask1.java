import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RussianGoogleTask1 {
    static ArrayList<Integer>   quantityTanks = new ArrayList<>();
    static ArrayList<Integer[]> volumeInTanks = new ArrayList<>();

    static void GasolineTanks(File inputFile, File outputFile) throws Exception{
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Блок чтения с файла и сохранения списанных даннх в quantityTanks volumeInTanks
        BufferedReader input = new BufferedReader(new FileReader(inputFile));

        while(input.ready()){
            quantityTanks.add(Integer.parseInt(input.readLine()));

            String [] strArray = input.readLine().split(" ");
            Integer [] arrayInteger = new Integer[strArray.length];
            for (int i = 0; i < arrayInteger.length ; i++) {
                arrayInteger[i]=Integer.parseInt(strArray[i]);
            }
            volumeInTanks.add(arrayInteger);
            input.readLine();
        }
        input.close();
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Блок алгоритма и записи результатов в файл
        StringBuilder results=new StringBuilder();
l1:
        while (!quantityTanks.isEmpty()){
            int n = quantityTanks.remove(0);
            Integer [] arrayVolumeInTanks= volumeInTanks.remove(0);

            for (int i = 0; i <arrayVolumeInTanks.length-1; i++) {
                if(arrayVolumeInTanks[i]>arrayVolumeInTanks[i+1]){
                    results.append("-1");
                    results.append("\n");
                    continue l1;
                }
            }

            Integer [] copyArrayVolumeInTanks = Arrays.copyOf(arrayVolumeInTanks,arrayVolumeInTanks.length);
            Arrays.sort(copyArrayVolumeInTanks);
            int min = copyArrayVolumeInTanks[0];
            int max = copyArrayVolumeInTanks[copyArrayVolumeInTanks.length-1];

            results.append(max-min);
            results.append("\n");
        }


        BufferedWriter outStream = new BufferedWriter(new FileWriter(outputFile));
        outStream.write(results.toString());
        outStream.close();



    }

    public static void main(String[] args) throws Exception{
        GasolineTanks(new File("C:/Users/Админ/IdeaProjects/InterviewAndInterstingTasks/inputRussianGoogleTask1.txt"),new File("C:/Users/Админ/IdeaProjects/InterviewAndInterstingTasks/outputRussianGoogleTask1.txt"));
    }
}
