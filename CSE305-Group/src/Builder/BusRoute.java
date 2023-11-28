package Builder;

import java.util.List;

public interface BusRoute {

    int getRouteNumber();

    List<BusStop> getStops();

    double getTotalFare();

    int getStopCount();

    // Builder pattern for BusRoute
    interface Builder {

        Builder setRouteNumber(int routeNumber);

        Builder addStop(BusStop stop);

        BusRoute build();
    }
}
