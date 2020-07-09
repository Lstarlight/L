
public class GenerateBill implements OutputOrder{
	
	private final static String NEW_LINE = System.getProperty("line.separator"); 
    
	static private GenerateBill singletonInstance = null ;
	
	private GenerateBill(){} 
	
	static public GenerateBill getSingletonInstance(){
       
	    if(singletonInstance == null){ 	
		    singletonInstance = new GenerateBill();
	    }
	    
	    return singletonInstance ; 
	}
		
	
	@Override
	public String OutputDate(Sales sales) {
		
		String output = "";
		
		  for(Order order : sales){		  
			  
		         output +=  "-------------------------------"+ NEW_LINE;	
			     output += " Your bill" + NEW_LINE;
			     output += "quantity   purchaser        route                 unit-price     "
			    		    + NEW_LINE;
			         for(OrderItem orderitem: order){
			        	 Ticket ticket = orderitem.getTicket();
			        	 
			        	 output += orderitem.getQuantity()+ "                 " 
			        	         + orderitem.getpurchaser(); 
			             
			             for(int i = 1; i < 16 - orderitem.getpurchaser().length(); i++ ){
			            	 output += " ";
			             }
			             output += ticket.getRoute();
			             for(int i = 1; i < 22 - ticket.getRoute().length(); i++ ){
			            	 output += " ";
			             }
			        	 output += ticket.getprice();
			        	 if(orderitem.getpurchaser().equals("Student")){
			        		 output += "(60%off)" + NEW_LINE;
			        	 }else if(orderitem.getpurchaser().equals("Disabled Soldier")){
			        		 output += "(50%off)" + NEW_LINE;
		 	        	 }else{
                             output += NEW_LINE; 			       
			        	 }
			         }		        			 
			        			 
			       output += NEW_LINE;
			       output +="You need to pay " + order.getTotalCost() + " yuan in total." 
			                 + NEW_LINE + NEW_LINE ;
			         
		  }	
		
		return output;
	}

}
