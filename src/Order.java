import java.util.ArrayList;
import java.util.Iterator;

public class Order implements Iterable<OrderItem> {
     private ArrayList<OrderItem> orderitems;

	public Order() {
		super();
		orderitems = new ArrayList<OrderItem>() ;
	}
     
	public void addOrderitem(OrderItem orderitem){
         orderitems.add(orderitem);
	}

	public void removeOrderitem(OrderItem orderitem){
        orderitems.remove(orderitem);
	}
 
     public OrderItem getOrderitem(Ticket ticket){
          for(OrderItem orderitem : orderitems){
        	 if(orderitem.getTicket().equals(ticket)) 
        	   return orderitem;
          }
         return null; 
     }
     
     public Iterator<OrderItem> iterator(){
        return orderitems.iterator();
     }
     
     public int getNumberofitems(){
    	 return orderitems.size();
     } 
     
     public double getTotalCost(){
    	double Totalcost = 0; 
    	  for(OrderItem orderitem : orderitems){
    		  Totalcost = Totalcost + orderitem.getValue() ;
    	  }	 
    	 return Totalcost;
     }
     
}    