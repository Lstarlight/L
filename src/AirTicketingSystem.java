import java.io.*;
import java.util.ArrayList;


public class AirTicketingSystem {
	
	private Catalog  catalog;
	private Sales  sales = new Sales();
	private Order order = new Order();
	private OutputOrder outputorder;
	
	private static BufferedReader  stdIn =
			new  BufferedReader(new  InputStreamReader(System.in));
	private static PrintWriter  stdOut =
			new  PrintWriter(System.out, true);
	private static PrintWriter  stdErr =
			new  PrintWriter(System.err, true);
   

	private void writeFile(String filename, String content)
			throws IOException {

			PrintWriter fileout = new PrintWriter( new FileWriter(filename)  );
		
		    fileout.println(content);
		    
		    fileout.close();
		
		}
	
	 public AirTicketingSystem(Catalog Catalog) {
		 
		this.catalog = Catalog;
	
	}
	
	public static void main(String[] args) throws IOException {
		
		Catalog catalog = null;

		if (args.length != 1) {
			stdErr.println("Air Tickrting System filename : ");
		} else {
			try {
				catalog =
					(new FileCatalogLoader()).loadCatalog(args[0]);
                  				
			} catch (FileNotFoundException nfe) {
				stdErr.println("The file doesn't exist");

				System.exit(1);

			} catch (DataFormatException dfe) {
				stdErr.println("The file contains wrong data" + dfe.getMessage());

				System.exit(1);
			}

			AirTicketingSystem  app = new AirTicketingSystem(catalog);

			app.run();
		}
	}

	
	private void run() throws IOException  {
      
	 stdOut.println("\nWelcome to the Airline Ticket System !\n");	
		int  choice = getChoice();

		while (choice != 0)  {
			if (choice == 1)  {
			    displayCatalog();			   
			} else if (choice == 2)  {
				FindTicket();					
			} else if (choice == 3)  {
				displayOrder();			
			} else if (choice == 4)  {
				BuyTicket();				
			} else if (choice == 5)  {
				OrderSave();
			} else if (choice == 6)  {
				displayAllOrders();
			} else if (choice == 7)  {
				setOutputOrder(GenerateOrder.getSingletonInstance());
				writeFile("order.dat",outputorder.OutputDate(sales));
				stdOut.println("The order has been saved to the \"order.dat\" file successfully");
			} else if (choice == 8)  {
				setOutputOrder(GenerateBill.getSingletonInstance());
				writeFile("bill.dat",outputorder.OutputDate(sales));
				stdOut.println("Your bill has been successfully generated in \"bill.dat\" file");
			} 

 			choice = getChoice();
		}
	}

	private int  getChoice() throws IOException  {

		int  input;

		do  {
			try  {
				stdErr.println();
				stdErr.print(  "[ע] Student Ticket 60% AND Disabled Soldier Ticket 50% \n"
						     + "[0]  Quit\n"
				             + "[1]  Display Catalog\n"
						     + "[2]  Get flight information\n" 
				             + "[3]  Display Order being purchased\n"
						     + "[4]  Buy Ticket\n"
				             + "[5]  Order Save\n"
						     + "[6]  Show all orders taken during this program run\n"
				             + "[7]  Generate orders for Managers in \"order.dat\" file\n"
						     + "[8]  Generate bills for customers in \"bill.dat\" file\n"
				             + "your choice is : ");
				stdErr.flush();

				input = Integer.parseInt(stdIn.readLine());

				stdErr.println();

				if (0 <= input && 8 >= input)  {
					break;
				} else {
					stdErr.println("Wrong choice : " + input);
				}
			} catch (NumberFormatException  nfe)  {
				stdErr.println(nfe);
			}
		}  while (true);

		return  input;
	}
	
	private void displayCatalog() {
		
		 int size = this.catalog.getNumberOfTicket();		

			if (size == 0) {
				stdOut.println("The catalog is empty");			
			} else {
				for (Ticket ticket : this.catalog) {
				    stdOut.println(ticket.gettype()+ "  " + 
							       ticket.getDay()+ "  " + ticket.getTime() + "  " +
					               ticket.getRoute() + "  "+ ticket.getprice());  
				}
			}
	}
	
	private void setOutputOrder(OutputOrder newobject){
		 
		outputorder = newobject ; 
		
	}

	private void FindTicket() throws IOException  {
	    
			stdErr.print("Plane route and Ticket type : ");
			stdErr.flush();
			
			ArrayList<Ticket> ticket = new ArrayList<Ticket>();
			 
			String b = stdIn.readLine();
			String c = stdIn.readLine();
			
			for(int i= 1 ; i < catalog.getNumberOfTicket() ; i++ ){
			   ticket = this.catalog.getTicket(b,c);
			}
	           if(ticket!=null){
	        	   for(Ticket ticket1 : ticket){		   	        		   
	             	 stdErr.println(ticket1.toString());	        	      
	        	   }
	           }				
			 else {	
				stdErr.println("There's no plane on this route");
			}
	}

	public void displayOrder() {

		int size = this.order.getNumberofitems();

		if (size == 0) {
			stdErr.println("Users haven't started buying tickets yet");
		} else {
			for (OrderItem  orderItem : order) {
				stdOut.println(orderItem.toString());
			}
			stdOut.println("Total: " + order.getTotalCost());
		}
	}
	
	public void BuyTicket()  throws IOException  {

		Ticket ticket = readTicket();
		String purchaser = readPurchaser();
		int quantity = readQuantity();		
		OrderItem orderitem = order.getOrderitem(ticket);

		if (orderitem == null) {
			order.addOrderitem(new OrderItem(quantity , ticket , purchaser));
			
			stdErr.println("The ticket " +"\"" + ticket.gettype() + "__"
			                +  ticket.getDay() + "__" + ticket.getTime()+ "__" 
			                + ticket.getRoute() +"\"" + " has been added");
		} else {
			orderitem.setQuantity(quantity);
			stdErr.println("The quantity of the ticket :" + ticket.gettype() +"__"
                            +  ticket.getDay() +"__" + ticket.getTime() + "__"
                            + ticket.getRoute() + " has been changed");
		}
	}

	public void OrderSave()  {

		if (order.getNumberofitems() > 0) {
			sales.addOrder(this.order);
			order = new Order();
			stdOut.println("The sale of the order has been registered");
		} else {
			stdErr.println("The order being purchased is empty");
		}
	}
	
	public void displayAllOrders() {

		int numOrders = this.sales.getNumberofOrders();

		if (numOrders != 0) {
			int orderNumber = 1;
			for (Order  order : this.sales) {

				stdOut.println("Order " + "[" + orderNumber++ + "]");

				for (OrderItem  orderItem : order) {
					stdOut.println("     " + orderItem.toString());
				}
				stdOut.println("   Total: " +  order.getTotalCost());
			}
		} else {
			stdErr.println("There are no finished orders yet ");
		}
	}
	
	
	private Ticket readTicket() throws IOException  {
	  do{
		   stdErr.print("Plane route and Ticket type : ");
		   stdErr.flush();
		
		   ArrayList<Ticket> ticket = new ArrayList<Ticket>();
		 
		   String b = stdIn.readLine();
		   String c = stdIn.readLine();
		
	     	for(int i= 1 ; i < catalog.getNumberOfTicket() ; i++ ){
	     	   ticket = this.catalog.getTicket(b,c);
	       	}
               if( ticket != null){
             	   for(Ticket ticket1 : ticket){		   	        		   
                  	 stdErr.println(ticket1.toString());	        	      
             	   }
        	do{
               stdErr.println("Day and Time :");
        	   
        	   String m = stdIn.readLine();
        	   String n = stdIn.readLine();
        	   Ticket ticket2 = null;
        	   
        	   for(Ticket ticket1: ticket){
        		  if(ticket1.getDay().equals(m)&&ticket1.getTime().equals(n))
        		     ticket2 = ticket1;
        		   }
        	   
           			if(ticket2 != null){
           				return ticket2;
           			}else{
                        stdErr.println("The plane on this route didn't take off at this time ");          				
           			}
           		  }while (true);	
               }else {	
			    stdErr.println("There's no plane on this route");
		      }
	  } while (true);       
    
	}
	
	 public String readPurchaser() throws IOException{
			String purchaser;

			do  {
     				stdErr.print("Your identity is : ");
					stdErr.flush();
					purchaser =stdIn.readLine();
					if ( purchaser.equals("Normal People")||
							purchaser.equals("Student") ||
							purchaser.equals("Disabled Soldier")) {

						return purchaser;

					} else  {
						stdErr.println("Please enter the correct identity !");
					}
				
			}  while (true);
		}

	 
		private int readQuantity() throws IOException  {
			int quantity;

			do  {
				try  {

					stdErr.print("How many tickets do you want : ");
					stdErr.flush();
					quantity = Integer.parseInt(stdIn.readLine());
					if (quantity > 0) {

						return quantity;

					} else  {
						stdErr.println("Please enter a correct number !");
					}
				} catch (NumberFormatException  nfe)  {
					stdErr.println(nfe);
				}
			}  while (true);
		}
		
		
		
		
}

