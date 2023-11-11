package director;

import builder.RentalContract;

public class RentalContractDirector {
    private RentalContract rentalContractBuilder;

    public RentalContractDirector(RentalContract rentalContractBuilder) {
        this.rentalContractBuilder = rentalContractBuilder;
    }

    public product.RentalContract constructRentalContract() {
        return rentalContractBuilder.build();
    }
}
