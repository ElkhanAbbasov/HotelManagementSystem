package Models;


public class Butler {
    private static String[] type = {"Party", "Drink", "Concierge"};
    private String typeOfButler;
    private double price;
    public Butler(String typeOfButler) {
		this.typeOfButler = typeOfButler;

	}
    
	

    public void calculatePrice() {
        
        if(typeOfButler.equals("Party")) {
        	price = 300;
        }else if(typeOfButler.equals("Drink")) {
        	price = 200;
        }else if(typeOfButler.equals("Concierge")) {
        	price = 150;
        }
    }

  

	public static String[] getType() {
		return type;
	}



	public void setType(String[] type) {
		this.type = type;
	}

	public double getPrice() {
        return price;
    }
}
