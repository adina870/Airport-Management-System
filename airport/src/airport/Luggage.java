package airport;

public class Luggage {

	private String luggageID;
	private double weight; //make exceptions class if weight is passed allowed level
	private boolean isCheckedIn;
	private Passengers owner;
	
	public Luggage(String luggageID, double weight, boolean isCheckedIn, Passengers owner) {
		this.luggageID = luggageID;
		this.weight = weight;
		this.isCheckedIn = isCheckedIn;
		this.owner = owner;
	}
	
	public Luggage() {
		this.luggageID = "No luggage ID yet";
		this.weight = 0.0;
		this.isCheckedIn = false;
		this.owner = null;
	}
	
	public Luggage(Luggage other) {
		this.luggageID = other.luggageID;
		this.weight = other.weight;
		this.isCheckedIn = other.isCheckedIn;
		this.owner = other.owner;
	}
	
	public String getLuggageID() {
		return this.luggageID;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public boolean getIsCheckedIn() {
		return this.isCheckedIn;
	}
	
	public Passengers getOwner() {
		return this.owner;
	}
	
	public void setLuggageID(String luggageID) {
		this.luggageID = luggageID;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void setIsCheckedIn(boolean isCheckedIn) {
		this.isCheckedIn = isCheckedIn;
	}
	
	public void setOwner(Passengers owner) {
		this.owner = owner;
	}
	
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		
		if (getClass() != other.getClass()) {
			return false;
		}
		
		Luggage other2 = (Luggage) other;
		return this.luggageID.equals(other2.luggageID) && (this.weight == other2.weight) && 
				(this.isCheckedIn == other2.isCheckedIn) && (this.owner == other2.owner);
	}
	
	@Override
	public String toString() {
		return "Luggage ID: " + this.luggageID + "\n Weight: " + this.weight + "\n Checked In?: " + this.isCheckedIn + "\n Owner: " + (this.owner !=null ? owner.getName() + "(Passport: " + owner.getPassportNumber() + ")" : "N/A") + "\n";
	}
	
	
}
