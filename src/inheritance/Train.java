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
	
	public static void main(String[] args) {
		
		Train train = new Train();
		 
		
		train.addTrainCar(new PassengerCar(1500, 75));
		train.addTrainCar(new CargoCar(2000, 5000));
		
		System.out.println(train);
	}

}
