package Builder;

import java.util.List;

public interface BusNameList {

    List<BusName> getBusNameList();

    List<BusName> addBusName(BusName busName);

    // Builder pattern for BusNameList
    interface Builder {

        Builder addBusName(BusName busName);

        BusNameList build();
    }
}
