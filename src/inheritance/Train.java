package inheritance;

import java.util.ArrayList;

public class Train {
	ArrayList<TrainCar> trainCars;
	
	public Train(){
		trainCars = new ArrayList<TrainCar>();
	}
	public void addTrainCar(TrainCar car){
		trainCars.add(car);
	}
	@Override
	public String toString(){
		String output = "";
		for (TrainCar car : trainCars) {
			output += car.toString() + "\n";
		}
		return output;
	}
	public boolean contains(TrainCar tc){
		return trainCars.contains(tc);
	}
	
	public int getTotalWeight(){
		int totalWeight = 0;
		for (TrainCar tc : trainCars) {
			totalWeight += tc.getTotalWeight();
		}
		return totalWeight;
	}
	public int getPassengerCount(){
		int passengerCount = 0;
		for (TrainCar tc : trainCars) {
			if( tc instanceof PassengerCar)
				passengerCount += ((PassengerCar) tc).getPassengerCount();
		}
		return passengerCount;
	}
	public int getCargoWeight(){
		int cargoWeight = 0;
		for (TrainCar tc : trainCars) {
			if(tc instanceof CargoCar)
				cargoWeight += ((CargoCar) tc).getCargoWeight();
		}
		return cargoWeight;
	}
	
	public static void main(String[] args) {
		
		Train train = new Train();
		 
		
		train.addTrainCar(new PassengerCar(1500, 75));
		train.addTrainCar(new CargoCar(2000, 5000));
		
		System.out.println(train);
	}

}
