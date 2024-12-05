import java.lang.reflect.Method;

public class ReflectionUtils {

    public static void printAllMethods(Class<?> clazz) {
        while (clazz != null) {
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
            clazz = clazz.getSuperclass(); // Переход к родительскому классу
        }
    }

}