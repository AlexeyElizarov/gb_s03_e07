/*
+ Создать класс, который может выполнять «тесты»
+ В качестве тестов выступают классы с наборами методов с аннотациями @Test.
+ Для этого у него должен быть статический метод start().
+ Которому в качестве параметра передается
    + или объект типа Class,
    + или имя класса.
+ Из «класса-теста» вначале должен быть запущен метод с аннотацией @BeforeSuite, если такой имеется
+ Далее запущены методы с аннотациями @Test
+ А по завершению всех тестов – метод с аннотацией @AfterSuite.
+ К каждому тесту необходимо также добавить приоритеты (int числа от 1 до 10), в соответствии с которыми будет выбираться порядок их выполнения
+ Если приоритет одинаковый, то порядок не имеет значения.
+ Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном экземпляре, иначе необходимо бросить RuntimeException при запуске «тестирования».
 */


public class Main {
    public static void main(String[] args) {
        Tester.start(TestCaseA.class, TestCaseD.class);
        Tester.start("TestCaseB");
    }
}