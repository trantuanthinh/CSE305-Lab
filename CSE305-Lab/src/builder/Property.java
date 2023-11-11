package builder;

public interface Property {
    Property setPropertyID(long propertyID);
    Property setDescription(String description);
    Property setRentalRate(float rentalRate);
    product.Property build();
}
