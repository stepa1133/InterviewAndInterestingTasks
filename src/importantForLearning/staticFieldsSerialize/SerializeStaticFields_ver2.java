package importantForLearning.staticFieldsSerialize;

import java.io.*;

class ClassWithStatic2 implements Serializable{
    int i = 0;
    static String str = "first static text";

    public ClassWithStatic2(int i) {
        this.i = i;
    }

    public String toString(){
        return "Не статическая переменная i = "+i+"\nСтатическая переменная  str = "+str+"\n";
    }
    // Закомментируйте эти методы
    public static void serializeStatic(ObjectOutputStream oos) throws IOException{
        oos.writeObject(str);
    }
    public static void deserializeStatic(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        str=(String)ois.readObject();
    }
    // Закомментируйте эти методы

}

public class SerializeStaticFields_ver2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClassWithStatic2 obj = new ClassWithStatic2(10);
        System.out.println(obj);
//        Не статическая переменная i = 10
//        Статическая переменная  str = first static text
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(outStream);
        ClassWithStatic2.serializeStatic(oos);
        oos.writeObject(obj);

        obj = new ClassWithStatic2(500);
        obj.str= "second static text";
        System.out.println(obj);
//        Не статическая переменная i = 500
//        Статическая переменная  str = second static text

        ByteArrayInputStream inStream = new ByteArrayInputStream(outStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(inStream);
        ClassWithStatic2.deserializeStatic(ois);
        obj = (ClassWithStatic2) ois.readObject();
        System.out.println(obj);


    }
}
