package director;

import builder.PropertyOwner;

public class PropertyOwnerDirector {
    private PropertyOwner propertyOwnerBuilder;

    public PropertyOwnerDirector(PropertyOwner propertyOwnerBuilder) {
        this.propertyOwnerBuilder = propertyOwnerBuilder;
    }

    public product.PropertyOwner constructPropertyOwner() {
        return propertyOwnerBuilder.build();
    }
}
