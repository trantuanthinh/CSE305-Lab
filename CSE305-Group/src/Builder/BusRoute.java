package Builder;

import java.util.List;

public interface BusRoute {

    int getRouteNumber();

    BusName getBusName();

    List<BusStop> getStops();

    double getTotalFare();

    int getStopCount();

    // Builder pattern for BusRoute
    interface Builder {

        Builder setRouteNumber(int routeNumber);

        Builder setBusName(BusName busName);

        Builder addStop(BusStop stop);

        BusRoute build();
    }
}
