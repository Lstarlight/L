import java.util.ArrayList;
import java.util.Iterator;

public class Sales implements Iterable<Order> {
	private ArrayList<Order> order;
	
	public Sales() {
		this.order = new ArrayList<Order>() ;
	}

	public Iterator<Order> iterator(){
        return order.iterator();
     }

    public int getNumberofOrders(){
    	return order.size();
    }

    public void addOrder(Order neworder){
    	order.add(neworder);
    }

}
