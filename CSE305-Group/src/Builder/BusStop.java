package Builder;

public interface BusStop {

    String getName();

    // Builder pattern for BusStop
    interface Builder {

        Builder setName(String name);

        BusStop build();
    }
}
