package Models;

public class VipRoom extends Room {
    private Butler hasAButler;

    public VipRoom(int roomNumber, boolean isOccupied, double price, int floorNumber, String roomType, String[] members, String[] fridge, String startDate, String endDate) {
        super(roomNumber, isOccupied, price, floorNumber, roomType, members);
        this.fridge = fridge;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean checkDinnerService() {
        return hasAButler != null; // Example logic
    }

    public void reservePrivateEvent() {
        // Example logic
    }

    @Override
    public boolean checkAvailability() {
        return !isOccupied;
    }

    @Override
    public double calculateFee() {
        return price + (hasAButler != null ? hasAButler.getPrice() : 0);
    }
}
