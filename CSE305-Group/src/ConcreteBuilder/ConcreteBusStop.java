package ConcreteBuilder;

import Builder.BusStop;

public class ConcreteBusStop implements BusStop {

    private String name;
    private String time;
    private double fare;

    private ConcreteBusStop(String name, String time, double fare) {
        this.name = name;
        this.time = time;
        this.fare = fare;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getTime() {
        return this.time;
    }

    @Override
    public double getFareTo(BusStop destination) {
        return this.fare;
    }

    public static class Builder implements BusStop.Builder {

        private String name;
        private String time;
        private double fare = Math.random() * 50;

        @Override
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public Builder setTime(String time) {
            this.time = time;
            return this;
        }

        @Override
        public BusStop build() {
            return new ConcreteBusStop(name, time, fare);
        }
    }
}
