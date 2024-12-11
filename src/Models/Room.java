package Models;

import interfaces.RoomInterface;

public abstract class Room implements RoomInterface {
    protected int roomNumber;
    protected boolean isOccupied;
    protected double price;
    protected int floorNumber;
    protected String roomType;
    protected String[] members;
    protected String[] fridge;
    protected String startDate;
    protected String endDate;

    public Room(int roomNumber, boolean isOccupied, double price, int floorNumber, String roomType, String[] members) {
        this.roomNumber = roomNumber;
        this.isOccupied = isOccupied;
        this.price = price;
        this.floorNumber = floorNumber;
        this.roomType = roomType;
        this.members = members;
    }

    public abstract boolean checkAvailability();

    public void releaseRoom() {
        this.isOccupied = false;
    }

    public abstract double calculateFee();

    public void calculateFloorNumber(int roomNumber) {
        this.floorNumber = roomNumber / 100; // Example logic
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", isOccupied=" + isOccupied +
                ", price=" + price +
                ", floorNumber=" + floorNumber +
                ", roomType='" + roomType + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(roomNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Room room = (Room) obj;
        return roomNumber == room.roomNumber;
    }
}
