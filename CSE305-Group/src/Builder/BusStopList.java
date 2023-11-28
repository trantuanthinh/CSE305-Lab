package Builder;

import java.util.List;

public interface BusStopList {

    List<BusStop> getBusStopList();

    // Builder pattern for BusStopList
    interface Builder {

        Builder addBusStop(BusStop busStop);

        BusStopList build();
    }
}
