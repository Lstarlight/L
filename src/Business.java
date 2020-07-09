
public class Business extends Ticket{
	
	private String Alwaysfood;

	public Business(String type, String day, String time, 
			        String route, String company, 
			        double price, int number,String food) {
	
		super(type, day, time, route, company, price, number);
		Alwaysfood = food;
	}
	
     public String getAlwaysfood(){
    	 return Alwaysfood;
     }
     
     public String toString(){
     	return gettype() + "_" + getDay()+ "_" + getTime()
                + "_" +getRoute() + "_" + getCompany() + "_" + getprice() + "_" + getnumber()
                + "_" + getAlwaysfood();
     }
     
     
     
}
