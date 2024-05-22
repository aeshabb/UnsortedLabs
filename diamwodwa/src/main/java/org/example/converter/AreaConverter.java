package org.example.converter;

import static java.lang.Math.pow;

public class AreaConverter implements Converter {
    @Override
    public Double covertToSI(String value) {
        if (!value.isEmpty()) {
            String[] args = value.split(" ");
            if (args.length == 2) {
                String num = args[1];
                try {
                    switch (args[0]) {
                        case "мм": {
                            return Double.parseDouble(num) / pow(1000, 2);
                        }
                        case "см": {
                            return Double.parseDouble(num) / pow(100, 2);
                        }
                        case "дм": {
                            return Double.parseDouble(num) / pow(10, 2);
                        }
                        case "км": {
                            return Double.parseDouble(num) * pow(1000, 2);
                        }
                        case "мили": {
                            return Double.parseDouble(num) / pow(1609.34, 2);
                        }
                        case "ар": {
                            return Double.parseDouble(num) / pow(0.7112, 2);
                        }
                        case "м": {
                            return Double.parseDouble(num);
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
                case "мм": {
                    return value * pow(1000, 2);
                }
                case "см": {
                    return value * pow(100, 2);
                }
                case "дм": {
                    return value * pow(10, 2);
                }
                case "км": {
                    return value / pow(1000, 2);
                }
                case "мили": {
                    return value * pow(1609.34, 2);
                }
                case "ар": {
                    return value * pow(0.7112, 2);
                }
                case "м": {
                    return value;
                } default: {
                    System.out.println("Неверная еденица измерения");
                    return null;
                }
            }

        }
        return null;
    }

    public String getUnits() {
        String units = """
                мм - миллиметры
                см - сантиметры
                дм - дециметры
                м - метры
                км - километры
                мили - мили
                ар - аршин
                """;
        return units;
    }
}
