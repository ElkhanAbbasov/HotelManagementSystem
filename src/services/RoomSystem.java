package services;

import Models.Room;
import Models.TwoRoom;
import Models.VipRoom;
import Models.OneRoom;

import java.util.HashSet;
import java.util.TreeSet;

import Comparator.RoomPriceComparator;

public class RoomSystem {
    private static HashSet<Room> reserveList = new HashSet<>();

    public static boolean addReserve(int roomNumber, boolean isOccupied, int floorNumber, String bed, boolean extraBed, 
    		String[] members, String roomType, String startDate, String endDate, int butlerCount, String[] butlerType) {
        
    	if(roomType.equals("OneRoom")) {
    		OneRoom room = new OneRoom(roomNumber, isOccupied, floorNumber,roomType, members, bed, startDate, endDate);
    		room.calculateFee();
    		reserveList.add(room);
    	}else if(roomType.equals("TwoRoom")) {
    		
    		TwoRoom room = new TwoRoom(roomNumber, isOccupied, floorNumber,roomType, members, bed, startDate, endDate, extraBed);
    		room.calculateFee();
    		reserveList.add(room);
    	}else if(roomType.equals("VipRoom")) {
    		VipRoom room = new VipRoom(roomNumber, isOccupied, floorNumber,roomType, members, startDate, endDate, butlerCount, butlerType);
    		room.calculateFee();
    		reserveList.add(room);
    	}
    	
        return true;
    }
    
    public static String getRooms() {
    	 StringBuilder all = new StringBuilder();
    	    for (Room room : reserveList) {
    	        all.append(room.toString()).append("\n");
    	    }
    	    return all.toString();
    }

    public static boolean removeReserve(int roomNumber) {
        return reserveList.removeIf(room -> room.getRoomNumber() == roomNumber);
    }

    public static String getAvailableRooms() {
        StringBuilder availableRooms = new StringBuilder();
        for (Room room : reserveList) {
            if (!room.isOccupied()) {
                availableRooms.append(room.toString()).append("\n");
            }
        }
        return availableRooms.toString();
    }
    
    public static String sortByPrice()
	{
		String output="";
		TreeSet<Room> sortedPrice = new TreeSet<Room>(new RoomPriceComparator());
		sortedPrice.addAll(reserveList);
		for (Room r : sortedPrice) {
			output += r.toString()+"\n";
			
		}
		return output;
		
	}
    
    public static Room getSelectedRoom(int roomNumber) {
        for (Room room : reserveList) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

}
