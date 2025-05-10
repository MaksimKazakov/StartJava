import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class VariablesTheme {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        LocalTime startTime = LocalTime.now();
        final long startNano = System.nanoTime();
        System.out.println("Старт проверки: " + startTime.format(formatter));
        System.out.println();

        System.out.println("1. ВЫВОД ASCII-ГРАФИКИ");
        System.out.println("    J    a   v     v  a   ");
        System.out.println("    J   a a   v   v  a a  ");
        System.out.println("J   J  aaaaa   V V  aaaaa ");
        System.out.println(" J J  a     a   V  a     a");
        System.out.println();

        String textBlock = """
                J    a   v     v  a
                J   a a   v   v  a a
            J   J  aaaaa   V V  aaaaa
             J J  a     a   V  a     a
                """;
        System.out.print(textBlock);
        System.out.println();

        System.out.println("2. РАСЧЕТ СТОИМОСТИ ТОВАРА");
        float pricePenRub = 105.5f;
        float priceBookRub = 235.23f;
        float discountPercent = 11f;
        float totalPriceRub = pricePenRub + priceBookRub;
        System.out.println("Общая стоимость без скидки: " + totalPriceRub + " руб.");
        float discountAmountRub = totalPriceRub * discountPercent / 100;
        System.out.println("Сумма скидки: " + discountAmountRub + " руб.");
        float discountedTotalPriceRub = totalPriceRub - discountAmountRub;
        System.out.println("Стоимость со скидкой: " + discountedTotalPriceRub + " руб.");
        System.out.println();

        BigDecimal pricePenRubBd = new BigDecimal("105.5");
        BigDecimal priceBookRubBd = new BigDecimal("235.23");
        BigDecimal discountPercentBd = new BigDecimal("11");
        BigDecimal totalPriceRubBd = pricePenRubBd.add(priceBookRubBd);
        System.out.println("Общая стоимость без скидки: " + totalPriceRubBd + " руб.");
        BigDecimal discountAmountRubBd = (totalPriceRubBd.multiply(discountPercentBd))
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        System.out.println("Сумма скидки: " + discountAmountRubBd + " руб.");
        BigDecimal discountedTotalPriceRubBd = totalPriceRubBd.subtract(discountAmountRubBd);
        System.out.println("Стоимость со скидкой: " + discountedTotalPriceRubBd + " руб.");
        System.out.println();

        System.out.println("3. ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ЯЧЕЕК В ТАБЛИЦЕ");
        int cellA1Value = 2;
        int cellB1Value = 5;
        System.out.println("Исходные значения: A1 = " + cellA1Value + ", B1 = " + cellB1Value);

        // третья переменная
        int a1 = cellA1Value;
        int b1 = cellB1Value;
        int cellTempValue = a1;
        a1 = b1;
        b1 = cellTempValue;
        System.out.println("\nМетод: третья переменная");
        System.out.println("Результат: A1 = " + a1 + ", B1 = " + b1);

        // арифметический
        a1 = cellA1Value;
        b1 = cellB1Value;
        a1 += b1;
        b1 = a1 - b1;
        a1 -= b1;
        System.out.println("\nМетод: арифметический");
        System.out.println("Результат: A1 = " + a1 + ", B1 = " + b1);

        // побитовый
        a1 = cellA1Value;
        b1 = cellB1Value;
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
        System.out.printf("%-6c%-6c%-6c%-6c%-6c%-6c%n",
                (char) code1, (char) code2, (char) code3,
                (char) code4, (char) code5, (char) code6);
        System.out.println();

        System.out.println("5. АНАЛИЗ КОДА ТОВАРА");
        int productCode = 123;
        int categoryProduct = productCode / 100;
        int subcategoryProduct = (productCode / 10) % 10;
        int packageTypeProduct = productCode % 10;
        int controlSum = categoryProduct + subcategoryProduct + packageTypeProduct;
        int checkCode = categoryProduct * subcategoryProduct * packageTypeProduct;
        System.out.println("Код товара: " + productCode);
        System.out.println("     категория товара - " + categoryProduct);
        System.out.println("     подкатегория - " + subcategoryProduct);
        System.out.println("     тип упаковки - " + packageTypeProduct);
        System.out.println("Контрольная сумма = " + controlSum);
        System.out.println("Проверочный код = " + checkCode);
        System.out.println();

        System.out.println("6. ТЕСТИРОВАНИЕ ДАТЧИКОВ ПЕРЕД ЗАПУСКОМ РАКЕТЫ");
        byte temperature = Byte.MAX_VALUE;
        System.out.println("""
                [Температура, °C]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(
                temperature,
                (byte) (temperature + 1),
                (byte) ((byte) (temperature + 1) - 1)
        ));
        short pressure = Short.MAX_VALUE;
        System.out.println("""
                [Давление, Па]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(
                pressure,
                (short) (pressure + 1),
                (short) ((short) (pressure + 1) - 1)
        ));
        char systemCode = Character.MAX_VALUE;
        System.out.println("""
                [Код состояния, #]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(
                (int) systemCode,
                (int) (char) (systemCode + 1),
                (int) (char) ((char) (systemCode + 1) - 1)
        ));
        int distance = Integer.MAX_VALUE;
        System.out.println("""
                [Расстояние, м]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(
                distance,
                distance + 1,
                (distance + 1) - 1
        ));
        long time = Long.MAX_VALUE;
        System.out.println("""
                [Время, мс]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(
                time,
                time + 1,
                (time + 1) - 1
        ));
        System.out.println();

        System.out.println("7. ВЫВОД ПАРАМЕТРОВ JVM И ОС");
        Runtime runtime = Runtime.getRuntime();

        // количество ядер
        int cores = runtime.availableProcessors();

        // память
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long maxMemory = runtime.maxMemory();
        long usedMemory = totalMemory - freeMemory;

        // преобразование в Мб
        double totalMb = totalMemory / (1024.0 * 1024);
        double freeMb = freeMemory / (1024.0 * 1024);
        double usedMb = usedMemory / (1024.0 * 1024);
        double maxMb = maxMemory / (1024.0 * 1024);

        // вывод характеристик JVM
        System.out.printf("""
                Количество ядер: %d
                Выделенная память: %.1f Мб
                Свободная память: %.1f Мб
                Используемая память: %.1f Мб
                Максимально доступная для выделения память: %.1f Мб
                """, cores, totalMb, freeMb, usedMb, maxMb);
        System.out.println();

        // Параметры ОС
        String osDisk = System.getProperty("user.home").substring(0, 1) + ":";
        String osVersion = System.getProperty("os.name") + " " + System.getProperty("os.version");
        String javaVersion = System.getProperty("java.version");
        String pathSeparator = System.getProperty("path.separator");

        // Вывод характеристик ОС
        System.out.printf("""
                Системный диск: %s
                Версия ОС: %s
                Версия Java: %s
                Символ разделения пути (сепаратор): %s
                """, osDisk, osVersion, javaVersion, pathSeparator);
        System.out.println();

        System.out.println("8. ЗАМЕР ВРЕМЕНИ РАБОТЫ КОДА");
        LocalTime endTime = LocalTime.now();
        long endNano = System.nanoTime();
        System.out.println("Финиш проверки: " + endTime.format(formatter));
        double processingTimeSec = (endNano - startNano) / 1_000_000_000.0;
        System.out.printf("Время работы:   %.3f сек%n", processingTimeSec);
    }
}
