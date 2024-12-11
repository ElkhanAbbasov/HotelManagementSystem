package Models;

public class OneRoom extends Room {
    private String[] bedType = {"Futon", "Water", "Round"};
    private String bed;
    
    public OneRoom(int roomNumber, boolean isOccupied, double price, int floorNumber, String roomType, String[] members, String bed, String startDate, String endDate) {
        super(roomNumber, isOccupied, price, floorNumber, roomType, members);
        this.bed = bed;
        this.startDate = startDate;
        this.endDate = endDate;
    }


    @Override
    public double calculateFee() {
    	if(bed.equalsIgnoreCase(bedType[0])) {
        	price = (super.findNumberOfDays()) * 60;
        	return price;
        }else if(bed.equalsIgnoreCase(bedType[1])) {
        		price = (super.findNumberOfDays()) * 55;
        		return price;
        	}else if(bed.equalsIgnoreCase(bedType[2])) {
        		price = (super.findNumberOfDays()) * 65;
        		return price;
        	}
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " OneRoom{" + "bedType=" + String.join(", ", bedType) + '}';
    }

	@Override
	public boolean discount() {
		int diff = super.findNumberOfDays();
		if (diff > 7 && diff < 10) {
			price *= 0.9;
		}
		else if (diff < 15) {
			price *= 0.8;
		}
		else if (diff < 20) {
			price *= 0.7;
		}
		else {
			return false;
		}
		return true;
	}
}
