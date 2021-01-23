package com.java.files;

public class BillCalculator {
	
	static float[] unit_rate = {3.05f,6.95f,9.90f,11.50f,12.50f};
	static float[] fac_rate = {0.5f,0.84f,1.07f,1.19f,1.26f};
	static float[] master_rate = {unit_rate[0]+fac_rate[0],unit_rate[1]+fac_rate[1],unit_rate[2]+fac_rate[2],unit_rate[3]+fac_rate[3],unit_rate[4]+fac_rate[4]};
	static float fixed_amount = 90f;
	static float tax_rate = 0.16f;
	
	
	public static void main(String[] args) {
	
		BillCalculator b = new BillCalculator();
		b.getBill(1245);

	}

	 public float calculateA(int unit) {
		 float amount =0;
		 if(unit>=100) {
		 amount = 100*master_rate[0];
		 }
		 else{
			 amount = unit*master_rate[0];
		 } 
		 return amount;
	 }
	 
	 public float calculateB(int unit) { 
		 float amount =0; 
		 if (unit>100&&unit<301)
		 {
			 amount = (unit-100)*master_rate[1];
		 }
		 else if(unit>300){
			 amount = 200*master_rate[1];
		 }
		 return amount;
	 }
	 
	 public float calculateC(int unit) {
		 float amount =0;	 
		 if (unit>300&&unit<501)
		 {
			 amount = (unit-300)*master_rate[2];
		 }
		 else if(unit>500){
			 amount = 300*master_rate[2];
		 }
		 return amount;
	 }
	 
	 public float calculateD(int unit) {
		 float amount =0;
		 if (unit>500&&unit<1001)
		 {
			 amount = (unit-500)*master_rate[3];
		 }
		 else if(unit>1000){
			 amount = (500*master_rate[3])+((unit-1000)*master_rate[4]);
		 }
		 return amount;
	 }
	 
	 public float[] getBill(int unit) {
		
		 float tatal_amount =0;
		 float amount = calculateA(unit)+calculateB(unit)+calculateC(unit)+calculateD(unit);
		 float wheeling_charge = unit * 1.28f;
		 float tax = (fixed_amount+amount+wheeling_charge)*tax_rate;
		 tatal_amount=fixed_amount+amount + wheeling_charge+tax;
		 
		 System.out.println("\nFixed Charges: "+fixed_amount);
		 System.out.println("Electricity and FAC charges: "+amount);
		 System.out.println("Wheeling charges: "+wheeling_charge);
		 System.out.println("Electrcity Tax: "+tax);
		 System.out.println("\nTotal Bill for "+unit+" unit:\n"+tatal_amount);
		 
		 float[] values = {fixed_amount,amount,wheeling_charge,tax,tatal_amount};
		 return values;

	 }
	 
}
