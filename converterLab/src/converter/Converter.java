package converter;

public interface Converter {
    Double covertToSI(String unitAndValue);
    Double fromCIToAny(String unit, double value);
    String getUnits();
}
