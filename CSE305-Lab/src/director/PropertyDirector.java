package director;

import builder.Property;

public class PropertyDirector {
    private Property propertyBuilder;

    public PropertyDirector(Property propertyBuilder) {
        this.propertyBuilder = propertyBuilder;
    }

    public product.Property constructProperty() {
        return propertyBuilder.build();
    }
}
