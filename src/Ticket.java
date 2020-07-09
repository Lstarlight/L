
public class Ticket {
     private String type;
     private String Route;
     private String Day;
     private String Time;
     private String Company;
     private double price;
     private int number;
	 
     public Ticket(String type,String day, String time, String route,String company, double price,int number) {
		super();
		this.type = type;
		Route = route;
		Day = day;
		Time = time;
		Company = company;
		this.price = price;
		this.number = number; 
	}
     
     public String gettype(){
    	 return this.type;
     } 
	
     public String  getRoute()  {
 		return  this.Route;
 	}
     
     public String  getDay()  {
 		return  this.Day;
 	}
	
     public String  getTime()  {
 		return  this.Time;
 	}
     
     public String  getCompany()  {
 		return  this.Company;
 	}
	
     public double  getprice()  {
 		return  this.price;
 	}
	
     public int getnumber(){
    	 return this.number;
     }
     
    public String toString(){
    	return gettype() + "_" + getDay()+ "_" + getTime()
               + "_" +getRoute() + "_" + getCompany() + "_" + getprice() + "_" + getnumber();
    }
     
     
     
}
