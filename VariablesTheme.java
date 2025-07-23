import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class VariablesTheme {
    public static void main(String[] args) {
        final long startNano = System.nanoTime();
        final LocalTime startTime = LocalTime.now();

        System.out.println("1. ВЫВОД ASCII-ГРАФИКИ");
        System.out.println("                      /\\");
        System.out.println("   J    a   v     v  /  \\");
        System.out.println("   J   a a   v   v  /_( )\\");
        System.out.println("J  J  aaaaa   V V  /      \\");
        System.out.println(" JJ  a     a   V  /___/\\___\\");

        String textBlock = """
                         /\\
                   J    /  \\  v     v  a
                   J   /_( )\\  v   v  a a
                J  J  /      \\  V V  aaaaa
                 JJ  /___/\\___\\  V  a     a
                """;
        System.out.print(textBlock);

        System.out.println("\n2. РАСЧЕТ СТОИМОСТИ ТОВАРА");
        float pricePen = 105.5f;
        float priceBook = 235.23f;
        float discountPercent = 11f;
        float basePrice = pricePen + priceBook;
        System.out.println("Общая стоимость без скидки: " + basePrice + " руб.");
        float discountAmount = basePrice * discountPercent / 100;
        System.out.println("Сумма скидки: " + discountAmount + " руб.");
        float discountedPrice = basePrice - discountAmount;
        System.out.println("Стоимость со скидкой: " + discountedPrice + " руб.");

        BigDecimal pricePenBd = new BigDecimal("105.5");
        BigDecimal priceBookBd = new BigDecimal("235.23");
        BigDecimal discountedPercentBd = new BigDecimal("11");
        BigDecimal basePriceBd = pricePenBd.add(priceBookBd);
        System.out.println("\nОбщая стоимость без скидки: " + basePriceBd + " руб.");
        BigDecimal discountedAmountBd = (basePriceBd.multiply(discountedPercentBd))
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        System.out.println("Сумма скидки: " + discountedAmountBd + " руб.");
        BigDecimal discountedBasePriceBd = basePriceBd.subtract(discountedAmountBd);
        System.out.println("Стоимость со скидкой: " + discountedBasePriceBd + " руб.");

        System.out.println("\n3. ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ЯЧЕЕК В ТАБЛИЦЕ");
        int a1 = 2;
        int b1 = 5;
        System.out.println("Исходные значения: A1 = " + a1 + ", B1 = " + b1);

        // третья переменная
        int swap = a1;
        a1 = b1;
        b1 = swap;
        System.out.println("\nМетод: третья переменная");
        System.out.println("Результат: A1 = " + a1 + ", B1 = " + b1);

        // арифметический
        a1 += b1;
        b1 = a1 - b1;
        a1 -= b1;
        System.out.println("\nМетод: арифметический");
        System.out.println("Результат: A1 = " + a1 + ", B1 = " + b1);

        // побитовый
        a1 ^= b1;
        b1 ^= a1;
        a1 ^= b1;
        System.out.println("\nМетод: побитовый");
        System.out.println("Результат: A1 = " + a1 + ", B1 = " + b1);
        System.out.println();

        System.out.println("4. ДЕКОДИРОВАНИЕ СООБЩЕНИЯ");
        int code1 = 1055;
        int code2 = 1088;
        int code3 = 1080;
        int code4 = 1074;
        int code5 = 1077;
        int code6 = 1090;
        System.out.printf("%-6d%-6d%-6d%-6d%-6d%-6d%n", code1, code2, code3, code4, code5, code6);
        System.out.printf("%-6c%-6c%-6c%-6c%-6c%-6c%n", code1, code2, code3, code4, code5, code6);

        System.out.println("\n5. АНАЛИЗ КОДА ТОВАРА");
        int productCode = 123;
        int productCategory = productCode / 100;
        int productSubcategory = (productCode / 10) % 10;
        int productPackageType = productCode % 10;
        int checksum = productCategory + productSubcategory + productPackageType;
        int verificationCode = productCategory * productSubcategory * productPackageType;
        System.out.println("Код товара: " + productCode);
        System.out.println("     категория товара - " + productCategory);
        System.out.println("     подкатегория - " + productSubcategory);
        System.out.println("     тип упаковки - " + productPackageType);
        System.out.println("Контрольная сумма = " + checksum);
        System.out.println("Проверочный код = " + verificationCode);

        System.out.println("\n6. ТЕСТИРОВАНИЕ ДАТЧИКОВ ПЕРЕД ЗАПУСКОМ РАКЕТЫ");
        byte temperature = Byte.MAX_VALUE;
        System.out.println("""
                [Температура, °C]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(temperature, ++temperature, --temperature));

        short pressure = Short.MAX_VALUE;
        System.out.println("""
                [Давление, Па]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(pressure, ++pressure, --pressure));

        char systemCode = Character.MAX_VALUE;
        System.out.println("""
                [Код состояния, #]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted((int) systemCode, (int) (++systemCode), (int) (--systemCode)));

        int distance = Integer.MAX_VALUE;
        System.out.println("""
                [Расстояние, м]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(distance, ++distance, --distance));

        long time = Long.MAX_VALUE;
        System.out.println("""
                [Время, мс]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(time, ++time, --time));

        System.out.println("\n7. ВЫВОД ПАРАМЕТРОВ JVM И ОС");
        Runtime runtime = Runtime.getRuntime();
        double mb = 1024.0 * 1024;

        // количество ядер
        int cores = runtime.availableProcessors();

        // память
        double totalMb = runtime.totalMemory() / mb;
        double freeMb = runtime.freeMemory() / mb;
        double maxMb = runtime.maxMemory() / mb;
        double usedMb = (runtime.totalMemory() - runtime.freeMemory()) / mb;

        // вывод характеристик JVM
        System.out.printf("""
                Количество ядер: %d
                Выделенная память: %.1f Мб
                Свободная память: %.1f Мб
                Используемая память: %.1f Мб
                Максимально доступная для выделения память: %.1f Мб
                """, cores, totalMb, freeMb, usedMb, maxMb);

        // Параметры ОС
        String osDisk = System.getProperty("user.home").charAt(0) + ":";
        String osVersion = System.getProperty("os.name") + " " + System.getProperty("os.version");
        String javaVersion = System.getProperty("java.version");
        String pathSeparator = System.getProperty("file.separator");

        // Вывод характеристик ОС
        System.out.printf("""
                Системный диск: %s
                Версия ОС: %s
                Версия Java: %s
                Символ разделения пути (сепаратор): %s
                """, osDisk, osVersion, javaVersion, pathSeparator);

        System.out.println("\n8. ЗАМЕР ВРЕМЕНИ РАБОТЫ КОДА");
        LocalTime endTime = LocalTime.now();
        long endNano = System.nanoTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        System.out.println("Старт проверки: " + startTime.format(formatter));
        System.out.println("Финиш проверки: " + endTime.format(formatter));
        double timeSeconds = (endNano - startNano) / 1e9;
        System.out.printf("Время работы: %.3f сек\n", timeSeconds);
    }
}
