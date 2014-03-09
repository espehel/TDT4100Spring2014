package inheritance;

public class TrainCar {
	
	protected int weightLimit;
	protected int passengerLimit;
	protected int weight;
	protected int cargoWeight;
	protected int passengers;
	protected TrainCar carInFront;
	protected TrainCar carBehind;
	
	public TrainCar(int weight, int passengers){
		this.weightLimit = weight;
		this.passengers = passengers;
	}


	public int getWeightLimit() {
		return weightLimit;
	}


	public void setWeightLimit(int weightLimit) {
		this.weightLimit = weightLimit;
	}


	public int getPassengerLimit() {
		return passengerLimit;
	}


	public void setPassengerLimit(int passengerLimit) {
		this.passengerLimit = passengerLimit;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}


	public int getPassengers() {
		return passengers;
	}


	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}


	public TrainCar getCarInFront() {
		return carInFront;
	}

	public void connectToCarInFront(TrainCar inFront) {
		this.carInFront = inFront;
	}

	public TrainCar getCarBehind() {
		return carBehind;
	}

	public void connectToCarBehind(TrainCar behind) {
		this.carBehind = behind;
	}
	
	
	
}
