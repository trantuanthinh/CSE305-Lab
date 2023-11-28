package ConcreteBuilder;

import Builder.BusRoute;
import Builder.BusStop;
import java.util.ArrayList;
import java.util.List;

public class ConcreteBusRoute implements BusRoute {

    private int routeNumber;
    private List<BusStop> stops;

    private ConcreteBusRoute(int routeNumber, List<BusStop> stops) {
        this.routeNumber = routeNumber;
        this.stops = stops;
    }

    @Override
    public int getRouteNumber() {
        return this.routeNumber;
    }

    @Override
    public List<BusStop> getStops() {
        return this.stops;
    }

    public static class Builder implements BusRoute.Builder {

        private int routeNumber;
        private List<BusStop> stops = new ArrayList<>();

        @Override
        public Builder setRouteNumber(int routeNumber) {
            this.routeNumber = routeNumber;
            return this;
        }

        @Override
        public Builder addStop(BusStop stop) {
            this.stops.add(stop);
            return this;
        }

        @Override
        public BusRoute build() {
            return new ConcreteBusRoute(routeNumber, stops);
        }
    }
}
