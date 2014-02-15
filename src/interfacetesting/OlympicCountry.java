package interfacetesting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class OlympicCountry implements Comparable<OlympicCountry> {
	private String name;
	private int goldMedals;
	private int silverMedals;
	private int bronzeMedals;
	
	public OlympicCountry(String name, int goldMedals, int silverMedals, int bronzeMedals){
		this.name = name;
		this.goldMedals = goldMedals;
		this.silverMedals = silverMedals;
		this.bronzeMedals = bronzeMedals;
	}
	
	public int getGoldMedals() {
		return goldMedals;
	}

	public int getSilverMedals() {
		return silverMedals;
	}

	public int getBronzeMedals() {
		return bronzeMedals;
	}

	public void setMedals(int gold, int silver, int bronze){
	this.goldMedals = gold;
	this.silverMedals = silver;
	this.bronzeMedals = bronze;
	}
	@Override
	public String toString(){
		return name + "\t: g: "+ goldMedals+", s: " + silverMedals + ", b: " + bronzeMedals;
	}
	//@Override
	public int compareTo(OlympicCountry o) {
		if(this.getGoldMedals() != o.getGoldMedals())
			return this.getGoldMedals() - o.getGoldMedals();
		else if(this.getSilverMedals() != o.getSilverMedals())
			return this.getSilverMedals() - o.getSilverMedals();
		else
			return this.getBronzeMedals() - o.getBronzeMedals();
	}
	
	public static void main(String[] args) {
		
		ArrayList<OlympicCountry> countries = new ArrayList<OlympicCountry>();
		
		countries.add(new OlympicCountry("Norway", 5, 3, 7));
		countries.add(new OlympicCountry("Sweden", 2, 9, 3));
		countries.add(new OlympicCountry("Finland", 9, 2, 1));
		countries.add(new OlympicCountry("Russia", 2, 9, 12));
		countries.add(new OlympicCountry("Denmark", 7, 1, 6));
		countries.add(new OlympicCountry("England", 5, 2, 10));
		countries.add(new OlympicCountry("Canada", 5, 0, 4));
		countries.add(new OlympicCountry("USA", 9, 2, 2));
		
		
		
		print(countries);
		Collections.sort(countries,new MedalComparer("descending"));
//		Collections.sort(countries);
		System.out.println("SORTED:");
		print(countries);
		
		OlympicCountry china = new OlympicCountry("China", 2, 4, 1);
		OlympicCountry japan = new OlympicCountry("Japan", 2, 5, 1);
		System.out.println(china.compareTo(japan));

	}
	
	public static void print(ArrayList<OlympicCountry> countries){
		for (OlympicCountry country : countries) {
			System.out.println(country);
		}
	}
	/*
	 dfg 
	 fgdf
	 */
	
}
