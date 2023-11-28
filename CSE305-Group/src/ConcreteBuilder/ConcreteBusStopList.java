package ConcreteBuilder;

import Builder.BusStop;
import Builder.BusStopList;
import java.util.ArrayList;
import java.util.List;

public class ConcreteBusStopList implements BusStopList {

    private List<BusStop> listBusStops;

    private ConcreteBusStopList(List<BusStop> listBusStops) {
        this.listBusStops = listBusStops;
    }

    @Override
    public List<BusStop> getBusStopList() {
        return this.listBusStops;
    }

    public static class Builder implements BusStopList.Builder {

        private List<BusStop> listBusStops = new ArrayList<>();

        @Override
        public Builder addBusStop(BusStop busStop) {
            this.listBusStops.add(busStop);
            return this;
        }

        @Override
        public BusStopList build() {
            return new ConcreteBusStopList(listBusStops);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (BusStop eachBusStop : this.listBusStops) {
            stringBuilder.append(eachBusStop.getName()).append(" -> ");
        }
        return stringBuilder.toString();
    }
}
