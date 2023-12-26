package Annotations;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Main {

    @SuppressWarnings({"unchecked"})
    void testSuppressWarning() {
        Map testMap = new HashMap();

        testMap.put(1, "item1");
        testMap.put(2, "item2");

    }

    @MyAnnotation.ImportantMethod
    public void testPrint() {
        System.out.println("This is a test print method");
    }

    public static void main(String[] args) {

        Main m1 = new Main();
        m1.testSuppressWarning();

        Method[] methods = m1.getClass().getMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            System.out.println(method.getName());
            if (method.isAnnotationPresent(MyAnnotation.ImportantMethod.class)) {
                System.out.println(method.getName() + " is an important method");
            }
        }


    }
}
