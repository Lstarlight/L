
public class GenerateOrder implements OutputOrder {

	private final static String NEW_LINE = System.getProperty("line.separator"); 
    
	static private GenerateOrder singletonInstance = null ;
	
	private GenerateOrder(){} 
	
	static public GenerateOrder getSingletonInstance(){
       
	    if(singletonInstance == null){ 	
		    singletonInstance = new GenerateOrder();
	    }
	    
	    return singletonInstance ; 
	}	
	
	@Override
	public String OutputDate(Sales sales) {
		
		String output = "";
		
		int number = 0;
		
		  for(Order order : sales){		  
			  
			     
		         output += "------------------------------------"+ NEW_LINE;	
		         output += "Order "+ NEW_LINE ;  
			     
			     for(OrderItem orderitem : order){
			    	 
			    	 output += orderitem.toString() + NEW_LINE;
			     
			     }
			     
			       output += NEW_LINE;
			       output +="TotalCost = " + order.getTotalCost() + NEW_LINE;
			       number++;  
		  }
		
		     output += NEW_LINE + "这次保存共保存了" + number +"个订单。"
		               + NEW_LINE + NEW_LINE;
		
		return output;
	}

}
