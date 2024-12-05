import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class CacheProxy {

    @SuppressWarnings("unchecked")
    public static <T> T create(T target) {
        Map<String, Object> cache = new HashMap<>();

        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    String key = method.getName() + (args != null ? args[0] : "");
                    if (cache.containsKey(key)) {
                        return cache.get(key);
                    }
                    Object result = method.invoke(target, args);
                    cache.put(key, result);
                    return result;
                });
    }
}
