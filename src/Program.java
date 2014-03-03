import java.util.Comparator;
import java.util.Date;



public class Program implements Comparator{
	public static void main(String[] args) {
		
		String name = "olanordmann@ntnu.no";
		String[] parts = name.split("[an]");
		
//		String dager = "MandagTirsdagOnsdagTorsdagFredagLordagSondag";
//		parts = dager.split("T...d..");
//		
//		String ntnu = "ntnu.no";
//		parts = ntnu.split("\\.");
		
		System.out.print("[");
		for (int i = 0; i < parts.length; i++) {
			System.out.print(parts[i] + ", ");
		}
		System.out.print("]");
			
	}

	@Override
	public int compare(Program o1, Program o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
