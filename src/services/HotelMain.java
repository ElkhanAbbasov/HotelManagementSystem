package services;

public class HotelMain {

	public static void main(String[] args) {
		String[] arr = {"hello", "salam"};
		
		RoomSystem.addReserve(1, true, 1, "Water", false, arr, "OneRoom", "01.01.2006", "05.02.2006", 2, "Party");
		RoomSystem.addReserve(2, true, 1, "Water", false, arr, "OneRoom", "01.01.2006", "05.01.2006", 2, "Party");
		System.out.println(RoomSystem.getRooms());
		System.out.println(RoomSystem.sortByPrice());
		
	}

}
