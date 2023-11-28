package ConcreteBuilder;

import Builder.BusStop;

public class ConcreteBusStop implements BusStop {

    private String name;

    private ConcreteBusStop(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public static class Builder implements BusStop.Builder {

        private String name;

        @Override
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public BusStop build() {
            return new ConcreteBusStop(name);
        }
    }
}
