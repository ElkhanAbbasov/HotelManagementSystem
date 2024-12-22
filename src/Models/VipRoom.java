package Models;

import java.util.ArrayList;

public class VipRoom extends Room {
    private ArrayList<Butler> butlers= new ArrayList<Butler>();
    private int butlerCount = 0;
    private String[] butlerType = new String[butlerCount];
    

    public VipRoom(int roomNumber, boolean isOccupied, int floorNumber, String roomType, String[] members, String startDate, String endDate, int butlerCount, String butlerType[]) {
        super(roomNumber, isOccupied, floorNumber, roomType, members);
       
        this.startDate = startDate;
        this.endDate = endDate;
        this.butlerCount = butlerCount;
        this.butlerType = butlerType;
    }

    @Override
    public String toString() {
    	String all = super.toString()  + "Butlers:\n";
    	for(int i = 0; i < butlers.size(); i++) {
    		all += butlers.get(i) + "\n";
    	}
    			
		return all + "Butler Count = " + butlerCount;
	}



	public void reserveButlers() {
    	Butler b = null;
        for(int i = 0; i < butlerCount; i++) {
        	b = new Butler(butlerType[i]);
        	butlers.add(b);
        }
    }

    @Override
    public double calculateFee() {
        double totalFee = price; // Start with the base price of the room
        for(int i = 0; i < butlers.size(); i++) {
        	butlers.get(i).calculatePrice();
        	totalFee += butlers.get(i).getPrice();
        	System.out.println(totalFee);
        }
        
        price = totalFee;
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
