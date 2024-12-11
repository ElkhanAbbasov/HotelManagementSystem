package Models;

public class OneRoom extends Room {
    private String[] bedType;

    public OneRoom(int roomNumber, boolean isOccupied, double price, int floorNumber, String roomType, String[] members, String[] bedType, String startDate, String endDate) {
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
        return price; // Example logic
    }

    @Override
    public String toString() {
        return super.toString() + " OneRoom{" + "bedType=" + String.join(", ", bedType) + '}';
    }
}
