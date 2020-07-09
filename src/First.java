
public class First extends Business{
	
	private int ExclusiveStewardess;
	private String other;
	
	public First(String type, String day, String time, String route, 
			     String company, double price, int number,
			     String food, int exclusiveStewardess, String other) {
		
		super(type, day, time, route, company, price, number, food);
		
		ExclusiveStewardess = exclusiveStewardess;
		this.other = other;
	}

	public int getExclusiveStewardess(){
		return ExclusiveStewardess;
	}
	
	public String getother(){
		return other;		
	}
	
	 public String toString(){
	     	return gettype() + "_" + getDay()+ "_" + getTime()
	                + "_" +getRoute() + "_" + getCompany() + "_" + getprice() + "_" + getnumber()
	                + "_" + getAlwaysfood() + "_" + getExclusiveStewardess() + "_" + getother();
	     }	
}
