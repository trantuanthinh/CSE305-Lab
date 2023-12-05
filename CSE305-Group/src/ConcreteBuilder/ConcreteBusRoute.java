package ConcreteBuilder;

import Builder.BusRoute;
import Builder.BusStop;
import Builder.BusName;

import java.util.ArrayList;
import java.util.List;

public class ConcreteBusRoute implements BusRoute {

    private int routeNumber;
    private List<BusStop> stops;
    private BusName busName;

    private ConcreteBusRoute(int routeNumber, List<BusStop> stops, BusName busName) {
        this.routeNumber = routeNumber;
        this.stops = stops;
        this.busName = busName;
    }

    @Override
    public int getRouteNumber() {
        return this.routeNumber;
    }

    @Override
    public List<BusStop> getStops() {
        return this.stops;
    }

    public BusName getBusName() {
        return this.busName;
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
        private BusName busName;

        @Override
        public Builder setRouteNumber(int routeNumber) {
            this.routeNumber = routeNumber;
            return this;
        }

        @Override
        public Builder setBusName(BusName busName) {
            this.busName = busName;
            return this;
        }

        @Override
        public Builder addStop(BusStop stop) {
            stops.add(stop);
            return this;
        }

        @Override
        public BusRoute build() {
            return new ConcreteBusRoute(routeNumber, stops, busName);
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
