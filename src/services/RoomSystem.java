package services;

import Models.Room;
import Models.OneRoom;

import java.util.HashSet;

public class RoomSystem {
    private HashSet<Room> reserveList = new HashSet<>();

    public boolean addReserve(int roomNumber, boolean isOccupied, int floorNumber, String[] members, String roomType) {
        Room room = new OneRoom(roomNumber, isOccupied, 100.0, floorNumber, roomType, members, new String[]{"Single"}, "", "");
        return reserveList.add(room);
    }

    public boolean removeReserve(int roomNumber) {
        return reserveList.removeIf(room -> room.roomNumber == roomNumber);
    }

    public String getAvailableRooms() {
        StringBuilder availableRooms = new StringBuilder();
        for (Room room : reserveList) {
            if (!room.isOccupied) {
                availableRooms.append(room.toString()).append("\n");
            }
        }
        return availableRooms.toString();
    }
}
