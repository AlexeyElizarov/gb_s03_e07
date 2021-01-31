import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Tester {


    static void start(Class... test_case_classes) {
        for (Class test_case: test_case_classes){
            run_test_case(test_case);
        }
    }

    static void start(String... test_case_names){
        for (String test_case_name: test_case_names){
            Class test_case_class = null;
            try {
                test_case_class = Class.forName(test_case_name);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (test_case_class != null) {
                run_test_case(test_case_class);
            }
        }
    }

    private static void run_test_case(Class test_case_class) {
        Method[] methods = test_case_class.getDeclaredMethods();
        List<Method> before = new ArrayList<>();
        List<Method> after = new ArrayList<>();
        List<Method> tests = new ArrayList<>();


        for (Method o : methods) {

            if(o.getAnnotation(BeforeSuite.class) != null) {
                before.add(o);
            }

            if (o.getAnnotation(AfterSuite.class) != null) {
                after.add(o);
            }

            if (o.getAnnotation(Test.class) != null) {
                tests.add(o);
            }
        }

        tests.sort((m1, m2) -> {
            Test ann1 = m1.getAnnotation(Test.class);
            Test ann2 = m2.getAnnotation(Test.class);
            Integer prio1 = ann1.priority();
            Integer prio2 = ann2.priority();
            return prio1.compareTo(prio2);
        });

        if (before.size() != 1 || after.size() != 1) {
            throw new RuntimeException("Check BeforeSuite or AfterSuite annotated methods. They must be in a single implementation.");
        }

        try {
            before.get(0).invoke(test_case_class.newInstance());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        for (Method test : tests) {
            try {
                System.out.printf("Running %s, %s, priority = %s\n", test_case_class, test.getName(), test.getAnnotation(Test.class).priority());
                test.invoke(test_case_class.newInstance());
            } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
            }
        }

        try {
            after.get(0).invoke(test_case_class.newInstance());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}




