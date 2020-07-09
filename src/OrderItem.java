

public class OrderItem {
	private int quantity;
	private Ticket ticket;
	private String purchaser;  
	private double Discount ; 
   
	public OrderItem(int quantity, Ticket ticket, String purchaser) {
		super();
		this.quantity = quantity;
		this.ticket = ticket;
		this.purchaser = purchaser;
	}
	
	public Ticket getTicket(){
        return ticket;              
    }
    
    public int getQuantity(){
        return quantity;              
    }
    
    public String getpurchaser(){
    	return purchaser; 
    }
    
    void setQuantity(int newquantity){
    	this.quantity = newquantity ; 
    }
    
    
    
    public String toString(){
    	if(getpurchaser().equalsIgnoreCase("Student")){	
            return getQuantity() + "__"+ getpurchaser() + "__" + ticket.gettype() + "__" +
                ticket.getRoute() + "__" + ticket.getprice()	+ " (60%off means ¥Ú¡˘’€)";
        }else if (getpurchaser().equals("Disabled Soldier")){
        	return getQuantity() + "__"+ getpurchaser() + "__" + ticket.gettype() + "__" +
                    ticket.getRoute() + "__" + ticket.getprice()	+ " (50%off means ¥ÚŒÂ’€)";
        }else{
        	return getQuantity() + "__"+ getpurchaser() + "__" + ticket.gettype() + "__" +
                    ticket.getRoute() + "__" + ticket.getprice();
        }
    }
    
    public double getValue(){
    	if(getpurchaser().equalsIgnoreCase("Student")){
                 Discount = 0.6;    		
    	}else if (getpurchaser().equals("Disabled Soldier")){
    		Discount = 0.5;
    	}else if(getpurchaser().equals("Normal People")){
    		Discount = 1;
    	}
    	return getQuantity() * ticket.getprice() * getDiscount(); 
    }
    
    private double getDiscount() {
		return Discount;
	}
}   
    



