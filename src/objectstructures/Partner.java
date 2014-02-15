package objectstructures;

import java.util.ArrayList;

public class Partner {
	
	private String name;
	private Partner partner;
	
	public Partner(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public Partner getPartner(){
		return partner;
	}
	public void setPartner(Partner partner){
		//vi slaar opp :(
		if(partner == null){
			Partner exPartner = this.partner;
			this.partner = null;
			if(exPartner != null)
				exPartner.setPartner(null);
		}
		else{
			//hvis jeg ikke har en partner
			if(this.partner == null){
				this.partner = partner;
			}
			//jeg bytter partner
			else if (partner != this.partner){
				this.partner.setPartner(null);
				this.partner = partner;
			}
			//sett meg som partner hos min partner
			if(partner != null && partner.getPartner() != this)
				partner.setPartner(this);
		}
	}
	
	@Override
	public String toString(){
		return name;
	}
	public static void main(String[] args) {
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(new Partner(""));
		list.add("ef");
		for (Object object : list) {
			
		}
	}
}
