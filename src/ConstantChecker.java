import java.lang.reflect.Field;

public class ConstantChecker {
    public static void checkStringConstants(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == String.class && java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                try {
                    String value = (String) field.get(null);
                    if (!field.getName().equals(value)) {
                        System.out.println("Константа " + field.getName() + " не равна своему имени");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
