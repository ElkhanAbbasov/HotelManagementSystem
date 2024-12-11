package Models;

public class TwoRoom extends Room {
    private boolean extraBed;
    private String bed;
    private String[] bedType = {"Single", "King", "Queen"};

    public TwoRoom(int roomNumber, boolean isOccupied, double price, int floorNumber, String roomType, String[] members, String bed, String startDate, String endDate) {
        super(roomNumber, isOccupied, price, floorNumber, roomType, members);
        this.bed = bed;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public boolean checkAvailability() {
        return !isOccupied();
    }

    @Override
    public double calculateFee() {
        if(bed.equalsIgnoreCase(bedType[0])) {
        	price = (super.findNumberOfDays()) * 100;
        	return price;
        }else if(bed.equalsIgnoreCase(bedType[1])) {
        		price = (super.findNumberOfDays()) * 200;
        		return price;
        	}else if(bed.equalsIgnoreCase(bedType[1])) {
        		price = (super.findNumberOfDays()) * 150;
        		return price;
        	}
        return 0;
        }

	@Override
	public boolean discount() {
		if(super.findNumberOfDays() > 5) {
			double discount = (super.findNumberOfDays() - 5) * 0.20;
			price *= discount;
			return true;
		}
		return false;
	}
}
