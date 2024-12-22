package Models;

import java.util.Objects;

import interfaces.RoomInterface;

public abstract class Room implements RoomInterface, Comparable<Room>{
    protected int roomNumber;
    protected boolean isOccupied;
    protected double price = 0;
    protected int floorNumber;
    protected String roomType;
    protected String[] members;
    protected String[] fridge;	
    protected String startDate;
    protected String endDate;

    public Room(int roomNumber, boolean isOccupied, int floorNumber, String roomType, String[] members) {
        this.setRoomNumber(roomNumber);
        this.setOccupied(isOccupied);
        this.price = price;
        this.floorNumber = floorNumber;
        this.roomType = roomType;
        this.members = members;
    }

    public void releaseRoom() {
        this.setOccupied(false);
    }

    public abstract double calculateFee();

    public void calculateFloorNumber(int roomNumber) {
        this.floorNumber = roomNumber / 100; // Example logic
    }

    @Override
    public String toString() {
        return "\nRoom Number: " + getRoomNumber() +
               "\nIs Occupied: " + isOccupied() +
               "\nPrice: $" + price +
               "\nFloor Number: " + floorNumber +
               "\nRoom Type: " + roomType +
               "\nMembers: " + formatMembers();
    }

    
    private String formatMembers() {
        String all = "";
        
        for (int i = 0 ; i < members.length; i++) {
        	if (members[i] != null) {
        		all += members[i] + " ";
        	}
        }
        
        return all;
    }


   

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(roomNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return roomNumber == other.roomNumber;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public int findNumberOfDays() {
	    String[] startArr = startDate.split("\\.");
	    String[] endArr = endDate.split("\\.");
	    
	    int startDay = Integer.parseInt(startArr[0]);
	    int startMonth = Integer.parseInt(startArr[1]);
	    int endDay = Integer.parseInt(endArr[0]);
	    int endMonth = Integer.parseInt(endArr[1]);
	    
	    int days = 0;

	    // Same month calculation
	    if (startMonth == endMonth) {
	        days = endDay - startDay;
	    } else if (startMonth < endMonth) {
	        // Different months calculation
	        days += (30 - startDay) + endDay; // Days in the first and last month
	        days += 30 * (endMonth - startMonth - 1); // Days for intermediate months
	    } else {
	        // Handle case when startMonth > endMonth (invalid input)
	        System.out.println("Invalid date range: Start date is after end date.");
	        return -1;
	    }

	    System.out.println("Total days: " + days);
	    return days;
	}

	
	public int compareTo(Room o) {
		return Double.compare(this.price, o.price); 
	}
}
