package inheritance;

public class PassengerCar extends TrainCar{
	
	private int passengerCount;
	private final int passengerWeight = 80;

	public PassengerCar(int deadWeight, int passengerCount) {
		super(deadWeight);
		type = "passenger car";
		this.passengerCount = passengerCount;
	}
	
	public int getPassengerCount(){
		return passengerCount;
	}
	public void setPassengerCount(int passengerCount){
		this.passengerCount = passengerCount;
	}
	
	@Override
	public int getTotalWeight(){
		return super.getTotalWeight() + (passengerCount*passengerWeight);
	}
	
	@Override
	public String toString(){
		return super.toString() + "It contains " + passengerCount + " passengers.";
	}

}
