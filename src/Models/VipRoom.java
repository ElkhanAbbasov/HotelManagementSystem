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
        return hasAButler != null; 
    }

    public void reservePrivateEvent() {
        
    }

    @Override
    public double calculateFee() {
        double totalFee = price; // Start with the base price of the room

        if (hasAButler != null) { 
            totalFee += hasAButler.getPrice(); // Add the butler's price if assigned
        }

        return totalFee; // Return the total fee
    }


	@Override
	public boolean discount() {
		int diff = super.findNumberOfDays();
		if (diff > 7 && diff < 10) {
			price *= 0.8;
		}
		else if (diff < 15) {
			price *= 0.7;
		}
		else if (diff < 20) {
			price *= 0.6;
		}
		else {
			return false;
		}
		return true;
	}
}
