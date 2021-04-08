## Тестовые задачи с собеседований. И просто интересные задачи. (_Interesting tasks and tasks from interview_)
### src
1. **_SimInTech1._** Дана функция rand6(), которая равновероятно возвращает значения целых чисел от 0 до 5. Реализовать функции rand2(), rand12(), rand29().
2. **_SimInTech2._** Пусть «Идеальное» число – это такое натуральное число, которое равно сумме его положительных делителей, кроме самого числа. Делитель числа x – это такое число, на которое можно поделить X без остатка. Напишите алгоритм функции, который возвращает ИСТИНА, если число «Идеальное», и возвращает ЛОЖЬ в противном случае. Как Вы бы протестировали данный алгоритм?
3. **_SimInTech3._** Функция Y(X) задана в табличном виде: есть отсортированный массив X типа double и соответствующий ему массив Y типа double. Напишите алгоритм интерполяции, который определит y от заданного x, где Xmin <= x <= Xmax.
4. **_RussianGoogleTask1_** Cуществует **_n_**-ое кол-во бескончено больших бочек, которые располагаются в одну линию. Изначально в каждой бочке находится некоторое количество бензина. Так как Вы страдаете конченной формой перфекционизма, Вам очень хочется, чтобы в каждой бочке было одинаковое количество бензина. Но, аппарат разливающий бензин по бочкам несовершенен. За один раз он способен разлить по одному литру кислоты в каждый из первых **_k(1<=k<=n)_** бочек. При этом, для разных операций **_k_** могут быть разными. Так как бензин - очень дорогая жидкость, выливать его из бочек запрещается. Можно ли уравнять объемы бензина в бочках, и если это возможно, то посчитать минимальное количество операций, которое потребуется для того чтобы этого достичь. **Формат ввода:** Первая строка содержит число **_n_** (от 1 до 100 000) - количество бочек. Во второй строке содержится **_n_** целых чисел разделенных пробелом, где каждое число означает начальный объем бензина в каждой бочке. **_Формат вывода:_** -1 если невозможно уровнять объем бензина. Или минимальное количество операций, для того чтобы уравнять объёмы бензина в бочках

### importantForLearning/staticFieldsSerialize
При сериализации объектов какого-либо класса, статические поля не сериализуются(не записываются в выходной поток). Поэтому рассмотрим три версии программного кода, которые позволяют сериализовать статические переменные.
* **_SerializeStaticFields_ver1_** Способ, предложенный в комментариях на курсах в JavaRush (20 уровень 4 лекция https://javarush.ru/tasks/com.javarush.task.task20.task2009#discussion). При сериализации/десериализации  при вызове соответственно objectOutputStream.writeObject(объект_для_сериализации)/objectInputStream.readObject() происходит проверка наличия у сериализуемого/десериализуемого экземпляра класса наличия методов _сериализуемый_объект.writeObject(ObjectOutputStream stream)/десериализуемый_объект.readObject(ObjectInputStream stream)_. И если эти методы найдены в сериализуемом/десериализуемом объектах, то выполняются именно эти методы, а не методы _objectOutputStream.writeObject()/objectInputStream.readObject()_
* **_SerializeStaticFields_ver2_** Способ согласно ресурсу http://javateaching.blogspot.com/2011/12/serialization-static-field.html . В сериализуемом/десериализуемом классе нужно добавить методы _public static void serializeStatic(ObjectOutputStream oos) / public static void deserializeStatic(ObjectInputStream ois)_ , которые будут вызываться для сериализации/десериализации статических переменных. Соответственно при десериализации нужно учитывать какая последовательность была при сериализации. В нашем случае мы сериализовали статическую переменную(ые), а затем объект. Соответственно десериализация должна происходить в той же последовательности 