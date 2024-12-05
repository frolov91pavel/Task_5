import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Proxy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Metric {
}

class PerformanceProxy {

    @SuppressWarnings("unchecked")
    public static <T> T create(T target) {
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    if (method.isAnnotationPresent(Metric.class)) {
                        long start = System.nanoTime();
                        Object result = method.invoke(target, args);
                        long end = System.nanoTime();
                        System.out.println("Время выполнения метода: " + (end - start) + " нс");
                        return result;
                    }
                    return method.invoke(target, args);
                });
    }
}