package Models;


public class Butler {
    private String[] type = {"Party", "Drink", "Concierge"};
    private String typeOfButler;
    private double price;
    public Butler(String typeOfButler, double price) {
		this.typeOfButler = typeOfButler;
		this.price = price;
	}
    
	

    public double calculatePrice(String serviceType) {
        // Example logic based on service type
        return price;
    }

  

	public void setType(String[] type) {
		this.type = type;
	}

	public double getPrice() {
        return price;
    }
}
