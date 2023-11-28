package Builder;

public interface BusStop {

    String getName();

    String getTime();

    double getFareTo(BusStop destination);

    // Builder pattern for BusStop
    interface Builder {

        Builder setName(String name);

        Builder setTime(String time);

        BusStop build();
    }
}
