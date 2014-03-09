package inheritance;

public class CargoCar extends TrainCar {
	
	int cargoWeight;

	public CargoCar(int deadWeight, int cargoWeight) {
		super(deadWeight);
		type = "cargo car";
		this.cargoWeight = cargoWeight;
	}
	
	
	@Override
	public int getTotalWeight(){
		return super.getTotalWeight() + deadWeight;
	}
	
	@Override
	public String toString(){
		return super.toString() + "It's cargo weighs " + deadWeight + " kg.";
	}

}
