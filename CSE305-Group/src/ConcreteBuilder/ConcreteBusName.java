package ConcreteBuilder;

import Builder.BusName;

import java.util.ArrayList;
import java.util.List;

public class ConcreteBusName implements BusName {

    private String busName;

    private ConcreteBusName(String busName) {
        this.busName = busName;
    }

    @Override
    public String getBusName() {
        return this.busName;
    }

    public static class Builder implements BusName.Builder {

        private String busName = "";

        @Override
        public Builder setBusName(String busName) {
            this.busName = busName;
            return this;
        }

        @Override
        public BusName build() {
            return new ConcreteBusName(busName);
        }
    }

    @Override
    public String toString() {
        return busName.toString();
    }

}
