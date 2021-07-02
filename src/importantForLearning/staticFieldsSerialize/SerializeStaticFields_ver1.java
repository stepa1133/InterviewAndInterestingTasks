package importantForLearning.staticFieldsSerialize;

import java.io.*;

class ClassWithStatic1 implements Serializable {
    int i = 0;
    static String str = "first static text";

    public ClassWithStatic1(int i) {
        this.i = i;
    }

    public String toString(){
        return "Не статическая переменная i = "+i+"\nСтатическая переменная  str = "+str+"\n";
    }

    // Закомментируйте эти методы
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(str);
    }
    private void readObject(ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        str = (String) stream.readObject();
    }
    // Закомментируйте эти методы
}


public class SerializeStaticFields_ver1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClassWithStatic1 obj = new ClassWithStatic1(10);
        System.out.println(obj);
//        Не статическая переменная i = 10
//        Статическая переменная  str = first static text

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(outStream);
        oos.writeObject(obj);     // <- Записали объект obj в выходной поток

        obj.i = 999;
        obj.str ="second static text";
        System.out.println(obj); // <-  Изменили static String str, далее десериализуем ранее сериализованный объект
//        Не статическая переменная i = 999
//        Статическая переменная  str = second static text

        ByteArrayInputStream inStream = new ByteArrayInputStream(outStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(inStream);
        ClassWithStatic1 deserializeObj = (ClassWithStatic1) ois.readObject();

        System.out.println(deserializeObj);
//Если в класса ClassWithStatic1 нет методов private void writeObject(ObjectOutputStream stream)/private void readObject(ObjectInputStream stream)
//        Не статическая переменная i = 10
//        Статическая переменная  str = second static text
//Если в классе ClassWithStatic1 есть методы private void writeObject(ObjectOutputStream stream)/private void readObject(ObjectInputStream stream)
//        Не статическая переменная i = 10
//        Статическая переменная  str = first static text


    }
}
