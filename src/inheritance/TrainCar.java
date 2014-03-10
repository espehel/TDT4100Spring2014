package inheritance;

public class TrainCar {
	
	protected String type;
	protected int deadWeight;
	
	public TrainCar(int deadWeight){
		this.deadWeight = deadWeight;
		type = "traincar";
	}
	
	public void setDeadWeight(int deadWeight){
		this.deadWeight = deadWeight;
	}
	
	public int getDeadWeight() {
		return deadWeight;
	}
	public int getTotalWeight() {
		return deadWeight;

	}
	
	public String toString(){
		return "This is a " + type + ", and it weighs " + getTotalWeight() + " kg. ";
	}
	
}
