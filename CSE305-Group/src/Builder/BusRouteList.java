package Builder;

import java.util.List;

public interface BusRouteList {

    List<BusRoute> getBusRouteList();

    List<BusRoute> addBusRoute(BusRoute busRoute);

    // Builder pattern for BusRouteList
    interface Builder {

        Builder addRoute(BusRoute route);

        BusRouteList build();
    }
}
