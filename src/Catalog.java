import java.util.ArrayList;
import java.util.Iterator;

public class Catalog implements Iterable<Ticket>{
    private ArrayList<Ticket> tickets;

	public Catalog() { 	
		this.tickets = new ArrayList<Ticket>();
	}
	
	public void addTicket(Ticket newticket){
		tickets.add(newticket);
	}
	
	public ArrayList<Ticket> getTicket(String newroute,String newtype){
		
     	ArrayList<Ticket> ticket = new ArrayList<Ticket>();
		for(Ticket ticket1 : tickets){
			if(ticket1.getRoute().equals(newroute)){
				if(ticket1.gettype().equals(newtype)){
		           ticket.add(ticket1);
			}			
		}	 
	}
    	if(ticket.isEmpty()){
    		return null;
    	}else{	
           return ticket;
    }	
}
	
	
	public Iterator<Ticket> iterator(){
        return tickets.iterator();
     }
	
	public int getNumberOfTicket(){
      return tickets.size();
	}
	
	
}	