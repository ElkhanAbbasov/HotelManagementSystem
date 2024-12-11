package Comparator;

import java.util.Comparator;

import Models.Room;

public class RoomPriceComparator implements Comparator<Room>{

	@Override
	public int compare(Room o1, Room o2) {
		return Double.compare(o2.getPrice(), o1.getPrice());
	}

}