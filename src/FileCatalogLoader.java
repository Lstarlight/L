import java.io.*;
import java.util.StringTokenizer;


public class FileCatalogLoader{
       private final static String TICKET_PREFIX =  "Economy Class";
       
       private final static String BUSINESS_PREFIX =  "Business Class";

       private final static String FIRST_PREFIX = "First Class";
       
       private final static String DELIM = "_";

	   private BufferedReader reader;
       
       
	public Catalog loadCatalog(String fileName) 
			throws FileNotFoundException, IOException, DataFormatException {
		
		Catalog catalog = new Catalog();
		
		reader = new BufferedReader(new FileReader(fileName)  );
		
		String line = reader.readLine();
		
		while(line != null){
			Ticket ticket = null;
			
			if(line.startsWith(TICKET_PREFIX)){					
				 ticket = readTicket(line);
		    }else if(line.startsWith(BUSINESS_PREFIX)){				
				 ticket = readBusiness(line);  				
			}else if(line.startsWith(FIRST_PREFIX)){			
				 ticket = readFirst(line);			
			}else{
				
				throw new DataFormatException(line);
			}
			
			catalog.addTicket(ticket);
			
			line = reader.readLine();
			
		}
           reader.close();
		
		return catalog;
	}


	private Ticket readTicket(String line) throws DataFormatException {
		StringTokenizer tokenizer = new StringTokenizer(line, DELIM);
		
		if(tokenizer.countTokens() != 7){
			
			throw new DataFormatException(line);
		}else{
		try{	
			
			
			return new Ticket (tokenizer.nextToken(),  
		            		   tokenizer.nextToken(),
					           tokenizer.nextToken(),
					           tokenizer.nextToken(),
					           tokenizer.nextToken(),
			Double.parseDouble(tokenizer.nextToken()),
			  Integer.parseInt(tokenizer.nextToken()));
			
		} catch(NumberFormatException nfe){
       			
		    throw new DataFormatException(line);
		    }
		}
		
		
	}


    private Business readBusiness(String line) throws DataFormatException {
		StringTokenizer tokenizer = new StringTokenizer(line, DELIM);
		
        if(tokenizer.countTokens() != 8){
			
			throw new DataFormatException(line);
		}else{
			try{	
				
				return new Business (tokenizer.nextToken(),  
		            		   tokenizer.nextToken(),
					           tokenizer.nextToken(),
					           tokenizer.nextToken(),
					           tokenizer.nextToken(),
			Double.parseDouble(tokenizer.nextToken()),
			  Integer.parseInt(tokenizer.nextToken()),
			                   tokenizer.nextToken());
				
			} catch(NumberFormatException nfe){
	       			
			    throw new DataFormatException(line);
			    }
			}
	
	}


    private First readFirst(String line) throws DataFormatException {
		StringTokenizer tokenizer = new StringTokenizer(line, DELIM);
		
        if(tokenizer.countTokens() != 10){
			
			throw new DataFormatException(line);
		}else{
			try{	
						
			return new First  (tokenizer.nextToken(),  
		            		   tokenizer.nextToken(),
					           tokenizer.nextToken(),
					           tokenizer.nextToken(),
					           tokenizer.nextToken(),
			Double.parseDouble(tokenizer.nextToken()),
			  Integer.parseInt(tokenizer.nextToken()),
			                   tokenizer.nextToken(),
			  Integer.parseInt(tokenizer.nextToken()),
			                   tokenizer.nextToken());
			
			} catch(NumberFormatException nfe){
       			
			    throw new DataFormatException(line);
			    }
			}	
			
	}

	

}