package runner;

import converter.AreaConverter;
import converter.Converter;
import converter.LengthConverter;
import converter.WeightConverter;

import java.util.Scanner;

public class Runner {
    private Scanner scanner;
    private Converter lengthConverter;
    private Converter weightConverter;
    private Converter areaConverter;

    //Иницилизация полей и начало чтения комманд
    public void start() {
        this.lengthConverter = new LengthConverter();
        this.weightConverter = new WeightConverter();
        this.areaConverter = new AreaConverter();
        this.scanner = new Scanner(System.in);
        read();
    }

    //Чтение строк из консоли
    private void read() {
        String line;
        String cases = """
                1 - конвертировать длину
                2 - конвертировать площадь
                3 - конвертировать массу
                exit - закончить работу
                """;
        System.out.println(cases);
        while (!(line = scanner.nextLine()).equals("exit")) {
            System.out.println("Введите еденицы измерения числа, которое хотите конвертировать: ");
            switch (line) {
                case "1": {
                    execute(lengthConverter);
                    break;
                }

                case "2": {
                    execute(areaConverter);
                    break;
                }

                case "3": {
                    execute(weightConverter);
                    break;
                }
                default: {
                    System.out.println("Неверная команда");
                }
            }

            System.out.println(cases);
        }
    }

    //Конвертация в зависимости от выбранной величины
    private void execute(Converter converter) {
        String line;
        System.out.println(converter.getUnits());
        System.out.println("Формат ввода: еденицы измерения + число ");
        line = scanner.nextLine();
        Object siNumber;
        if ((siNumber = converter.covertToSI(line)) != null) {
            System.out.println("Введите еденицы измерения числа, которое хотите получить: ");
            System.out.println(converter.getUnits());
            line = scanner.nextLine();
            Object result;
            if ((result = converter.fromCIToAny(line, (double) siNumber)) != null) {
                System.out.print("Результат: ");
                System.out.println(result + "\n");
            }
        }
    }

}
