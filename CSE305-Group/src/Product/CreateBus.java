package Product;

import Builder.BusRoute;
import Builder.BusRouteList;
import Builder.BusStop;
import Builder.BusStopList;
import ConcreteBuilder.ConcreteBusRoute;
import ConcreteBuilder.ConcreteBusRouteList;
import ConcreteBuilder.ConcreteBusStop;
import ConcreteBuilder.ConcreteBusStopList;

public class CreateBus {

    static BusStopList busStopList;
    static BusRouteList busRouteList;

    static {
        // Create Bus Stops
        BusStop bs1 = new ConcreteBusStop.Builder()
                .setName("HCM")
                .setTime("08:00 AM")
                .build();

        BusStop bs2 = new ConcreteBusStop.Builder()
                .setName("Binh Duong")
                .setTime("08:30 AM")
                .build();

        BusStop bs3 = new ConcreteBusStop.Builder()
                .setName("Da Nang")
                .setTime("09:00 AM")
                .build();

        BusStop bs4 = new ConcreteBusStop.Builder()
                .setName("Hai Phong")
                .setTime("09:30 AM")
                .build();

        BusStop bs5 = new ConcreteBusStop.Builder()
                .setName("Can Tho")
                .setTime("10:00 AM")
                .build();

        BusStop bs6 = new ConcreteBusStop.Builder()
                .setName("Quang Ninh")
                .setTime("10:30 AM")
                .build();

        BusStop bs7 = new ConcreteBusStop.Builder()
                .setName("Hue")
                .setTime("11:00 AM")
                .build();

        BusStop bs8 = new ConcreteBusStop.Builder()
                .setName("Dak Lak")
                .setTime("11:30 AM")
                .build();

        BusStop bs9 = new ConcreteBusStop.Builder()
                .setName("Vung Tau")
                .setTime("12:00 PM")
                .build();

        BusStop bs10 = new ConcreteBusStop.Builder()
                .setName("Kien Giang")
                .setTime("12:30 PM")
                .build();

        BusStop bs11 = new ConcreteBusStop.Builder()
                .setName("Bac Ninh")
                .setTime("01:00 PM")
                .build();

        BusStop bs12 = new ConcreteBusStop.Builder()
                .setName("Hoa Binh")
                .setTime("01:30 PM")
                .build();

        BusStop bs13 = new ConcreteBusStop.Builder()
                .setName("Nam Dinh")
                .setTime("02:00 PM")
                .build();

        BusStop bs14 = new ConcreteBusStop.Builder()
                .setName("Phu Yen")
                .setTime("02:30 PM")
                .build();

        BusStop bs15 = new ConcreteBusStop.Builder()
                .setName("Tuyen Quang")
                .setTime("03:00 PM")
                .build();

        BusStop bs16 = new ConcreteBusStop.Builder()
                .setName("Bac Lieu")
                .setTime("03:30 PM")
                .build();

        BusStop bs17 = new ConcreteBusStop.Builder()
                .setName("Quang Ngai")
                .setTime("04:00 PM")
                .build();

        BusStop bs18 = new ConcreteBusStop.Builder()
                .setName("Lang Son")
                .setTime("04:30 PM")
                .build();

        BusStop bs19 = new ConcreteBusStop.Builder()
                .setName("Thai Binh")
                .setTime("05:00 PM")
                .build();

        BusStop bs20 = new ConcreteBusStop.Builder()
                .setName("Ben Tre")
                .setTime("05:30 PM")
                .build();

        // Create Bus Stop List
        busStopList = new ConcreteBusStopList.Builder()
                .addBusStop(bs1)
                .addBusStop(bs2)
                .addBusStop(bs3)
                .addBusStop(bs4)
                .addBusStop(bs5)
                .addBusStop(bs6)
                .addBusStop(bs7)
                .addBusStop(bs8)
                .addBusStop(bs9)
                .addBusStop(bs10)
                .addBusStop(bs11)
                .addBusStop(bs12)
                .addBusStop(bs13)
                .addBusStop(bs14)
                .addBusStop(bs15)
                .addBusStop(bs16)
                .addBusStop(bs17)
                .addBusStop(bs18)
                .addBusStop(bs19)
                .addBusStop(bs20)
                .build();

        // Create Bus Routes
        BusRoute route101 = new ConcreteBusRoute.Builder()
                .setRouteNumber(101)
                .addStop(bs1)
                .addStop(bs2)
                .addStop(bs3)
                .addStop(bs4)
                .addStop(bs5)
                .build();

        BusRoute route102 = new ConcreteBusRoute.Builder()
                .setRouteNumber(102)
                .addStop(bs2)
                .addStop(bs6)
                .addStop(bs7)
                .addStop(bs8)
                .build();

        BusRoute route103 = new ConcreteBusRoute.Builder()
                .setRouteNumber(103)
                .addStop(bs1)
                .addStop(bs9)
                .addStop(bs10)
                .addStop(bs11)
                .build();

        BusRoute route104 = new ConcreteBusRoute.Builder()
                .setRouteNumber(104)
                .addStop(bs3)
                .addStop(bs4)
                .addStop(bs5)
                .addStop(bs12)
                .addStop(bs13)
                .addStop(bs14)
                .build();

        BusRoute route105 = new ConcreteBusRoute.Builder()
                .setRouteNumber(105)
                .addStop(bs4)
                .addStop(bs5)
                .addStop(bs15)
                .addStop(bs16)
                .addStop(bs17)
                .build();

        BusRoute route106 = new ConcreteBusRoute.Builder()
                .setRouteNumber(106)
                .addStop(bs6)
                .addStop(bs7)
                .addStop(bs8)
                .addStop(bs18)
                .addStop(bs19)
                .addStop(bs20)
                .build();

        BusRoute route107 = new ConcreteBusRoute.Builder()
                .setRouteNumber(107)
                .addStop(bs9)
                .addStop(bs10)
                .addStop(bs11)
                .addStop(bs1)
                .addStop(bs2)
                .addStop(bs3)
                .build();

        BusRoute route108 = new ConcreteBusRoute.Builder()
                .setRouteNumber(108)
                .addStop(bs11)
                .addStop(bs12)
                .addStop(bs13)
                .addStop(bs14)
                .addStop(bs15)
                .addStop(bs16)
                .build();

        BusRoute route109 = new ConcreteBusRoute.Builder()
                .setRouteNumber(109)
                .addStop(bs14)
                .addStop(bs15)
                .addStop(bs16)
                .addStop(bs17)
                .addStop(bs18)
                .addStop(bs19)
                .build();

        BusRoute route110 = new ConcreteBusRoute.Builder()
                .setRouteNumber(110)
                .addStop(bs17)
                .addStop(bs18)
                .addStop(bs19)
                .addStop(bs20)
                .addStop(bs1)
                .addStop(bs2)
                .addStop(bs3)
                .build();

        // Create Bus Route List
        busRouteList = new ConcreteBusRouteList.Builder()
                .addRoute(route101)
                .addRoute(route102)
                .addRoute(route103)
                .addRoute(route104)
                .addRoute(route105)
                .addRoute(route106)
                .addRoute(route107)
                .addRoute(route108)
                .addRoute(route109)
                .addRoute(route110)
                .build();
    }

    public static BusStopList getBusStopList() {
        return CreateBus.busStopList;
    }

    public static BusRouteList getBusRouteList() {
        return CreateBus.busRouteList;
    }
}
