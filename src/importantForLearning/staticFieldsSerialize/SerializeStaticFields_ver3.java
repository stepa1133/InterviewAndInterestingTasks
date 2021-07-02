package importantForLearning.staticFieldsSerialize;

import java.io.*;

class ClassWithStatic3 implements Serializable {
    int i = 0;
    static String str = "first static text";

    public ClassWithStatic3(int i) {
        this.i = i;
    }

    public String toString(){
        return "Не статическая переменная i = "+i+"\nСтатическая переменная  str = "+str+"\n";
    }
}
public class SerializeStaticFields_ver3 {
    public static void main(String[] args) throws Exception {
        ClassWithStatic3 obj = new ClassWithStatic3(10);
        System.out.println(obj);
//        Не статическая переменная i = 10
//        Статическая переменная  str = first static text
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(outStream);
        oos.writeObject(obj);
        oos.writeObject(ClassWithStatic3.str);

        obj.i=9009;
        ClassWithStatic3.str="second static text";
        System.out.println(obj);
//        Не статическая переменная i = 9009
//        Статическая переменная  str = second static text

        ByteArrayInputStream inStream = new ByteArrayInputStream(outStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(inStream);
        obj =(ClassWithStatic3) ois.readObject();
        ClassWithStatic3.str= (String) ois.readObject();
        System.out.println(obj);
//        Не статическая переменная i = 10
//        Статическая переменная  str = first static text

    }
}
