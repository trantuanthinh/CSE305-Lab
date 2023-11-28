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

    @Override
    public double getTotalFare() {
        double totalFare = 0;
        for (int i = 0; i < stops.size() - 1; i++) {
            totalFare += stops.get(i).getFareTo(stops.get(i + 1));
        }
        int decimalPlaces = 2;
        totalFare = Math.ceil(totalFare * Math.pow(10, decimalPlaces)) / Math.pow(10, decimalPlaces);
        return totalFare;
    }

    @Override
    public int getStopCount() {
        return stops.size();
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
            stops.add(stop);
            return this;
        }

        @Override
        public BusRoute build() {
            return new ConcreteBusRoute(routeNumber, stops);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (BusStop eachBusStop : this.stops) {
            stringBuilder.append(eachBusStop.getName()).append(" -> ");
        }
        return stringBuilder.toString();
    }

}
