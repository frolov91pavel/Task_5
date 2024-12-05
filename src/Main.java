
public class Main {
    public static void main(String[] args) {

        Calculator calculator = new CalculatorImpl("1.0.0");

        // Вывод всех методов класса, включая приватные
        System.out.println("// Вывод всех методов класса, включая приватные");
        ReflectionUtils.printAllMethods(CalculatorImpl.class);
        System.out.println("------------------------------------------------");

        System.out.println("// Вывод всех геттеров класса");
        // Вывод всех геттеров класса
        GetterUtils.printAllGetters(CalculatorImpl.class);
        System.out.println("------------------------------------------------");

        System.out.println("// Проверка String констант");
        // Проверка String констант
        ConstantChecker.checkStringConstants(MyConstants.class);
        System.out.println("------------------------------------------------");

        System.out.println("// Реализация кэширующего прокси");
        // Реализация кэширующего прокси
        CacheProxy cacheProxy = new CacheProxy();
        Calculator cachedCalculator = cacheProxy.create(calculator);

        System.out.println(cachedCalculator.calc(5)); // Первый вызов
        System.out.println(cachedCalculator.calc(5)); // Кэшированный вызов
        System.out.println("------------------------------------------------");

        System.out.println("// Реализация аннотации и прокси");
        // Реализация аннотации и прокси
        PerformanceProxy performanceProxy = new PerformanceProxy();
        Calculator performanceCalculator = performanceProxy.create(calculator);

        System.out.println(performanceCalculator.calc(5));
        System.out.println("------------------------------------------------");

        System.out.println("// Реализация BeanUtils");
        // Реализация BeanUtils
        Source source = new Source();
        source.setName("Test");

        Destination destination = new Destination();

        BeanUtils.assign(destination, source);
        System.out.println(destination.getName()); // Вывод: Test
        System.out.println("------------------------------------------------");
    }
}