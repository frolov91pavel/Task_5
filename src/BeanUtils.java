import java.lang.reflect.Method;

public class BeanUtils {
    public static void assign(Object to, Object from) {
        Method[] fromMethods = from.getClass().getMethods();
        Method[] toMethods = to.getClass().getMethods();

        for (Method getter : fromMethods) {
            if (getter.getName().startsWith("get") && getter.getParameterCount() == 0) {
                String setterName = "set" + getter.getName().substring(3);
                for (Method setter : toMethods) {
                    if (setter.getName().equals(setterName) && setter.getParameterCount() == 1 &&
                            setter.getParameterTypes()[0].isAssignableFrom(getter.getReturnType())) {
                        try {
                            setter.invoke(to, getter.invoke(from));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}