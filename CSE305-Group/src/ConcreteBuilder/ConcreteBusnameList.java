package ConcreteBuilder;

import Builder.BusName;
import Builder.BusNameList;
import java.util.ArrayList;
import java.util.List;

public class ConcreteBusNameList implements BusNameList {

    private List<BusName> listBusName;

    private ConcreteBusNameList(List<BusName> listRoutes) {
        this.listBusName = listRoutes;
    }

    @Override
    public List<BusName> addBusName(BusName busName) {
        this.listBusName.add(busName);
        return this.listBusName;
    }

    @Override
    public List<BusName> getBusNameList() {
        return this.listBusName;
    }

    public static class Builder implements BusNameList.Builder {

        private List<BusName> listBusName = new ArrayList<>();

        @Override
        public Builder addBusName(BusName busName) {
            this.listBusName.add(busName);
            return this;
        }

        @Override
        public BusNameList build() {
            return new ConcreteBusNameList(listBusName);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (BusName eachBusName : this.listBusName) {
            stringBuilder.append(eachBusName.getBusName()).append(" ");
        }
        return stringBuilder.toString();
    }
}
