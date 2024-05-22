package converter;

public class WeightConverter implements Converter {

    @Override
    public Double covertToSI(String value) {
        if (!value.isEmpty()) {
            String[] args = value.split(" ");
            if (args.length == 2) {
                String num = args[1];
                try {
                    switch (args[0]) {
                        case "мг": {
                            return Double.parseDouble(num) / 1000_000;
                        }
                        case "г": {
                            return Double.parseDouble(num) / 1000;
                        }
                        case "кг": {
                            return Double.parseDouble(num);
                        }
                        case "ц": {
                            return Double.parseDouble(num) * 100;
                        }
                        case "т": {
                            return Double.parseDouble(num) * 1000;
                        }
                        case "у": {
                            return Double.parseDouble(num) * 0.028349;
                        }
                        case "ф": {
                            return Double.parseDouble(num) * 0.453592;
                        }
                        default: {
                            System.out.println("Неверная еденица счисления");
                            return null;
                        }
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат числа");
                    return null;
                }
            }
        }
        return null;
    }

    @Override
    public Double fromCIToAny(String unit, double value) {
        if (!unit.isEmpty()) {
            switch (unit) {
                case "мг": {
                    return value * 1000_000;
                }
                case "г": {
                    return value * 1000;
                }
                case "кг": {
                    return value;
                }
                case "ц": {
                    return value / 100;
                }
                case "т": {
                    return value / 1000;
                }
                case "у": {
                    return value / 0.028349;
                }
                case "ф": {
                    return value / 0.453592;
                }
                default: {
                    System.out.println("Неверная еденица измерения");
                    return null;
                }
            }

        }

        return null;
    }

    public String getUnits() {
        String units = """
                мг - миллиграммы
                г - граммы
                кг - килограммы
                ц - центнеры
                т - тонны
                у - унции
                ф - фунты
                """;
        return units;
    }
}
