package converter;


public class LengthConverter implements Converter{
    @Override
    public Double covertToSI(String value) {
        if (!value.isEmpty()) {
            String[] args = value.split(" ");
            if (args.length == 2) {
                String num = args[1];
                try {
                    switch (args[0]) {
                        case "мм": {
                            return Double.parseDouble(num)/1000;
                        }
                        case "см": {
                            return Double.parseDouble(num)/100;
                        }
                        case "дм": {
                            return Double.parseDouble(num)/10;
                        }
                        case "км": {
                            return Double.parseDouble(num)*1000;
                        }
                        case "мили": {
                            return Double.parseDouble(num)/1609.34;
                        }
                        case "ар": {
                            return Double.parseDouble(num)/0.7112;
                        }
                        case "м": {
                            return Double.parseDouble(num);
                        } default: {
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
                    return value * 1000;
                }
                case "см": {
                    return value * 100;
                }
                case "дм": {
                    return value * 10;
                }
                case "км": {
                    return value / 1000;
                }
                case "мили": {
                    return value * 1609.34;
                }
                case "ар": {
                    return value * 0.7112;
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
