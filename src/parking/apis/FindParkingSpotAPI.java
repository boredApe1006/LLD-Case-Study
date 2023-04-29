package parking.apis;

import parking.data.EntryPoint;
import parking.data.ParkingSpot;
import parking.data.SpotSelection;
import parking.data.VehicleType;
import parking.finder.ParkingSpotFinder;
import parking.manager.VehicleTypeManager;
import parking.manager.VehicleTypeManagerFactory;
import parking.selector.ParkingSpotSelector;
import parking.selector.SpotSelectorFactory;

public class FindParkingSpotAPI {

    public ParkingSpot findParkingSpot(EntryPoint entryPoint, VehicleType vehicleType, SpotSelection spotSelection) {

        VehicleTypeManager vehicleTypeManager = VehicleTypeManagerFactory.getVehicleTypeManager(vehicleType);
        ParkingSpotSelector parkingSpotSelector;
        if(spotSelection.equals(SpotSelection.RANDOM))
            parkingSpotSelector = SpotSelectorFactory.getRandomSelector();
        else if(spotSelection.equals(SpotSelection.NEAREST))
            parkingSpotSelector = SpotSelectorFactory.getNearestSelector(entryPoint);
        else
            throw new RuntimeException("");

       return new ParkingSpotFinder(vehicleTypeManager,parkingSpotSelector).findParkingSpot();
    }
}
