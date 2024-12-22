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
        return "Room\n" +
                "roomNumber=" + getRoomNumber() +
                "\nisOccupied=" + isOccupied() +
                "\nprice=" + price +
                "\nfloorNumber=" + floorNumber +
                "\nroomType='" + roomType;
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
		int days = 0;
		if(startArr[1] == endArr[1]) {
			days = Integer.parseInt(endArr[0]) - Integer.parseInt(startArr[0]);
		}else {
			days += 30 * (Integer.parseInt(endArr[1]) - Integer.parseInt(startArr[1]));
			days -= Integer.parseInt(endArr[0]) - Integer.parseInt(startArr[0]);
		}
		
		return days;
 	}
	
	public int compareTo(Room o) {
		return Double.compare(this.price, o.price); 
	}
}
