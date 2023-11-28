package Builder;

import java.util.List;

public interface BusRouteList {

    List<BusRoute> getBusRouteList();

        // Builder pattern for BusRouteList
    interface Builder {

        Builder addRoute(BusRoute route);

        BusRouteList build();
    }
}
