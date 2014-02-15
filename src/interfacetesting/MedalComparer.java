package interfacetesting;

import java.util.Comparator;

public class MedalComparer implements Comparator<OlympicCountry>{
	
	private boolean ascending;
	private boolean descending;
	
	public MedalComparer(String order){
		ascending = order.toUpperCase().equals("ASCENDING");
		descending = order.toUpperCase().equals("DESCENDING");
	}

	@Override
	public int compare(OlympicCountry o1, OlympicCountry o2) {
		OlympicCountry a;
		OlympicCountry b;
		
		if(descending){
			a = o2;
			b = o1;
		}
		else{
			a = o1;
			b = o2;
		}
			
		if(a.getGoldMedals() != b.getGoldMedals())
			return a.getGoldMedals() - b.getGoldMedals();
		else if(a.getSilverMedals() != b.getSilverMedals())
			return a.getSilverMedals() - b.getSilverMedals();
		else
			return a.getBronzeMedals() - b.getBronzeMedals();
	}
}
