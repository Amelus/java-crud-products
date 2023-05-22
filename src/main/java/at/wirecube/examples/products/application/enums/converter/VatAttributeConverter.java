package at.wirecube.examples.products.application.enums.converter;

import at.wirecube.examples.products.application.enums.Vat;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class VatAttributeConverter implements AttributeConverter<Vat, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Vat vat) {
        if (vat == null) {
            return null;
        }

        switch (vat) {
            case LOW:
                return 10;
            case MIDDLE:
                return 18;
            case HIGH:
                return 20;
            default:
                throw new IllegalStateException("Unexpected value: " + vat);
        }
    }

    @Override
    public Vat convertToEntityAttribute(Integer integer) {
        if (integer == null) {
            return null;
        }

        switch (integer) {
            case 10:
                return Vat.LOW;
            case 18:
                return Vat.MIDDLE;
            case 20:
                return Vat.HIGH;
            default:
                throw new IllegalStateException("Unexpected value: " + integer);
        }
    }
}
