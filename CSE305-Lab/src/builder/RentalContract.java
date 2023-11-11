package builder;

public interface RentalContract {
    RentalContract setContractID(long contractID);
    RentalContract setPropertyID(long propertyID);
    RentalContract setTenantID(long tenantID);
    RentalContract setStartDate(String startDate);
    RentalContract setEndDate(String endDate);
    RentalContract setRentAmount(float rentAmount);
    product.RentalContract build();
}
