package Builder;

import java.util.List;

public interface BusRoute {

    int getRouteNumber();

    List<BusStop> getStops();

    // Builder pattern for BusRoute
    interface Builder {

        Builder setRouteNumber(int routeNumber);

        Builder addStop(BusStop stop);

        BusRoute build();
    }
}
