package inheritance;

public class TrainCar {
	
	protected String type;
	protected int deadWeight;
//	protected TrainCar carInFront;
//	protected TrainCar carBehind;
	
	public TrainCar(int deadWeight){
		this.deadWeight = deadWeight;
		type = "traincar";
	}
	
	public int getDeadWeight() {
		return deadWeight;
	}
	public int getTotalWeight() {
		return deadWeight;

	}

//	public void connectToCarInFront(TrainCar inFront) {
//		this.carInFront = inFront;
//	}
//
//	public TrainCar getCarBehind() {
//		return carBehind;
//	}
//
//	public void connectToCarBehind(TrainCar behind) {
//		this.carBehind = behind;
//	}
	
	public String toString(){
		return "This is a " + type + ", and it weighs " + getTotalWeight() + " kg. ";
	}
	
}
