package ConcreteBuilder;

import Builder.BusRoute;
import Builder.BusRouteList;
import java.util.ArrayList;
import java.util.List;

public class ConcreteBusRouteList implements BusRouteList {

    private List<BusRoute> listRoutes;

    private ConcreteBusRouteList(List<BusRoute> listRoutes) {
        this.listRoutes = listRoutes;
    }

    @Override
    public List<BusRoute> getBusRouteList() {
        return this.listRoutes;
    }

    public static class Builder implements BusRouteList.Builder {

        private List<BusRoute> listRoutes = new ArrayList<>();

        @Override
        public Builder addRoute(BusRoute busRoute) {
            this.listRoutes.add(busRoute);
            return this;
        }

        @Override
        public BusRouteList build() {
            return new ConcreteBusRouteList(listRoutes);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (BusRoute eachBusRoute : this.listRoutes) {
            stringBuilder.append(eachBusRoute.getRouteNumber()).append(" ");
        }
        return stringBuilder.toString();
    }
}
