package Models;

public class TwoRoom extends Room {
    private boolean extraBed;
    private String[] bedType;

    public TwoRoom(int roomNumber, boolean isOccupied, double price, int floorNumber, String roomType, String[] members, String[] bedType, String startDate, String endDate) {
        super(roomNumber, isOccupied, price, floorNumber, roomType, members);
        this.bedType = bedType;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public boolean checkAvailability() {
        return !isOccupied;
    }

    @Override
    public double calculateFee() {
        return price + (extraBed ? 50 : 0); // Example logic
    }
}
