package Builder;

public interface BusName {

    String getBusName();

    // Builder pattern for BusName
    interface Builder {

        Builder setBusName(String busName);

        BusName build();
    }
}
