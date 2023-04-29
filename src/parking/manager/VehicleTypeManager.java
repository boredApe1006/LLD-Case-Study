package parking.manager;

public interface VehicleTypeManager {

    List<ParkingSpot> getParkingSpots();

    double getParkingFees(double durationInHours);
}
