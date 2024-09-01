
import java.util.*;
import java.io.*;
public class Test3 {
	public static void main(String[] args) 
	{
        Scanner input = new Scanner(System.in);
        Boolean quit = false;
        int choice;
        Customer customer = new Customer();
        Artist artist = new Artist();
        Artwork artwork = new Artwork();
        do {
        	System.out.println("-----------------------------------");
            System.out.println("\t1. Add Info");
            System.out.println("\t2. Display List");
            System.out.println("\t3. Search Info");
            System.out.println("\t4. Modify Info");
            System.out.println("\t5. Delete Info");
            System.out.println("\t6. Exit");
            System.out.println("-----------------------------------");

            choice = input.nextInt();
            switch (choice) {
                case 1:
                    addInfo(customer, artist, artwork);
                    break;
                case 2:
                    displayList(customer, artist, artwork);
                    break;
                case 3:
                	searchInfo(customer, artist, artwork);
                	break;
                case 4:
                	modifyInfo(customer, artist, artwork);
                	break;
                case 5:
                	deleteInfo(customer, artist, artwork);
                	break;
                case 6:
                	quit = true;
                    break;
                default:
    	        	System.out.println("Please enter number from 1 to 6");
    	        	break;
            }
        } while (quit != true);
        
        
}
	


	public static void addInfo(Customer customer, Artist artist, Artwork artwork) 
	{
        Scanner input = new Scanner(System.in);
        int choice = 0;
        boolean quit = false;

        while (!quit) {
        	System.out.println("-----------------------------------");
            System.out.println("\t1. Add Customers");
            System.out.println("\t2. Add Artist");
            System.out.println("\t3. Add Artwork");
            System.out.println("\t4. Return");
            System.out.println("-----------------------------------");
            choice = input.nextInt();
            input.nextLine(); 

            switch (choice) {
                case 1: {
                    try
                    {
                    	String C_name, artistPreference;
                        int C_ContactNumber;
                        System.out.println("input name");
                        C_name = input.nextLine();
                        System.out.println("input preference");
                        artistPreference = input.nextLine();
                        System.out.println("input contact number");
                        C_ContactNumber = input.nextInt();
                        
                        Customer customers = new Customer(C_name, C_ContactNumber,artistPreference);
                    	customer.recordACustomer(customers);
                    }
                    catch(IOException IE)
                    {
                    	System.out.println("Error: " + IE.getMessage());
                    }
                    catch(Exception e)
                    {
                    	System.out.println("Error: " + e.getMessage());
                    }
                    
                }
                break;
                case 2: {
                	try
                	{
                		String A_name, speciality,artworkPriceRange;
                        String vital;
                        System.out.println("input name");
                        A_name = input.nextLine();
                        System.out.println("input speciality");
                        speciality = input.nextLine();
                        System.out.println("input vital status");
                        vital = input.nextLine();
                        System.out.println("input artwork price range");
                        artworkPriceRange = input.nextLine();
                        Artist artists = new Artist(A_name, speciality, vital,artworkPriceRange);
                        artist.recordAArtist(artists);
                	}
                	catch(IOException IE)
                    {
                    	System.out.println("Error: " + IE.getMessage());
                    }
                    catch(Exception e)
                    {
                    	System.out.println("Error: " + e.getMessage());
                    }
                    
                }
                break;
                case 3:
                {
                	try
                	{
                	String Art_name,Art_Artist_Name,Art_pur_date,Art_date_sold,Art_buyer_name;
                    double Art_price;
                    
                    System.out.println("input artwork name");
                    Art_name = input.nextLine();
                    System.out.println("input artwork price");
                    Art_price = input.nextDouble();
                    System.out.print("input artwork purchase date");
                    input.nextLine();
                    Art_pur_date = input.nextLine() ;
                    System.out.println("input artwork date sold");
                    Art_date_sold = input.nextLine();
                    System.out.println("input artwork buyer name");
                    Art_buyer_name = input.nextLine();
                    System.out.println("input artwork artist name");
                    Art_Artist_Name = input.nextLine();
                    Artwork artworks = new Artwork(Art_name, Art_price,Art_pur_date,Art_date_sold,Art_buyer_name,Art_Artist_Name);
                    artwork.recordAArtwork(artworks);
                	}
                	catch(IOException IE)
                    {
                    	System.out.println("Error: " + IE.getMessage());
                    }
                    catch(Exception e)
                    {
                    	System.out.println("Error: " + e.getMessage());
                    }
                    
                } 
                    break;
                case 4:
                	quit = true;
                	break;
            }
        }
        
    }
	
	public static void displayList(Customer customer, Artist artist, Artwork artwork) 
	{
        Scanner input = new Scanner(System.in);
        int choice = 0;
        boolean quit = false;

        while (!quit) {
        	System.out.println("-----------------------------------");
            System.out.println("\t1. List Customers");
            System.out.println("\t2. List Artist");
            System.out.println("\t3. List Artwork");
            System.out.println("\t4. Return");
            System.out.println("-----------------------------------");
            choice = input.nextInt();
            switch (choice) {
                case 1: {
                	try
                	{
                		File in_customer_file = new File("C:\\Users\\60167\\Desktop\\Assignment\\customer.txt");
                		File in_artwork_file = new File("C:\\Users\\60167\\Desktop\\Assignment\\artwork.txt");
                		Scanner cin_customer = new Scanner(in_customer_file);
                		Scanner cin_artwork = new Scanner(in_artwork_file); 
                		
                		int i = 1;
                		int count = 1;
                		if(in_customer_file.isFile() && in_artwork_file.isFile())
                		{
                            while(cin_customer.hasNextLine())
                            {
                            	String line = cin_customer.nextLine();
                                String[] tokens = line.split(",");
                                String name = tokens[0];
                                int contactNumber = Integer.parseInt(tokens[1]);
                                String artistPreference = tokens[2];
                                System.out.println("Customer " + i);
                                System.out.println("Name: " + name);
                                System.out.println("Contact Number: " + contactNumber);
                                System.out.println("Preference: " + artistPreference);
                                
                                Artwork[] artworkstosearch = artwork.getArtworkList();// it is used to get number of artwork as after it was invoked, method"getNumberOfartwork" will have a the value i need to use
                                
                                Scanner sea = new Scanner(name);
            	                String modified_customer_search = "";
            	                while(sea.hasNext())
            	                {
            	                	modified_customer_search += sea.next();
            	                }
            	                
            	                modified_customer_search = modified_customer_search.toLowerCase();
            	                
                                for(int j = 0;j < artwork.getNumberOfArtwork();j++)
                                {
                                	String artworkline = cin_artwork.nextLine(); // read from artwork file
                                    String[] artworktokens = artworkline.split(",");
                                	String artworkname = artworktokens[0];
                                	double price = Double.parseDouble(artworktokens[1]);
                                    String art_pur_date = artworktokens[2];
                                    String art_date_sold = artworktokens[3];
                                    String art_buyer_name = artworktokens[4];
                                    String Art_Artist_Name = artworktokens[5];
                                    
                                    
                                    // turn the names i got from artwork file to have no blank space and to lower case
                                	String file_artwork_buyer_name = art_buyer_name; 
            	                	String modified_file_artwork_buyer_name = "";
            	                	sea = new Scanner(file_artwork_buyer_name);
            	                	while(sea.hasNext())
            	                	{
            	                		modified_file_artwork_buyer_name += sea.next();
            	                	}
            	                	modified_file_artwork_buyer_name = modified_file_artwork_buyer_name.toLowerCase();
            	                	//
            	                	
            	                	
            	                	if(modified_file_artwork_buyer_name.equals(modified_customer_search))
            	                	{
            	                		System.out.println("Artwork purchased number " + count + " : " + artworkname);
            	                		count++;
            	                	}
            	                    
                                }
                                i++;
                                
                            }
                           
                		}
                		else
                		{
                			System.out.println("error: File not found");
                		}
                		cin_customer.close();
                		cin_artwork.close();
                		
                    }
                	
                	catch(IOException IE)
                    {
                    	System.out.println("Error: " + IE.getMessage());
                    }
                    catch(Exception e)
                    {
                    	System.out.println("Error: " + e.getMessage());
                    }
                    
                }
                break;
                case 2: {
                	try
                	{
                		File in_artist_file = new File("C:\\Users\\60167\\Desktop\\Assignment\\artist.txt");
                		Scanner cin = new Scanner(in_artist_file);
                		Customer c;
                		int i = 1;
                		if(in_artist_file.isFile())
                		{
                            while(cin.hasNextLine())
                            {
                            	String line = cin.nextLine();
                                String[] tokens = line.split(",");
                                String name = tokens[0];
                                String speciality = tokens[1];
                                String vitalStatus = tokens[2];
                                String pricerange = tokens[3];
                                System.out.println("Artist Name: " + name);
                                System.out.println("Artist Specialty: " + speciality);
                                System.out.println("Artist Vital Status: " + vitalStatus);
                                System.out.println("Artist's artwork price range: " + pricerange);
                            }
                           
                		}
                		else
                		{
                			System.out.println("error: File not found");
                		}
                		cin.close();
                	}
                	catch(IOException IE)
                    {
                    	System.out.println("Error: " + IE.getMessage());
                    }
                    catch(Exception e)
                    {
                    	System.out.println("Error: " + e.getMessage());
                    }
                }
                break;
                case 3:
                {
                	try
                	{
                		File in_artwork_file = new File("C:\\Users\\60167\\Desktop\\Assignment\\artwork.txt");
                		Scanner cin = new Scanner(in_artwork_file);
                		Customer c;
                		int i = 1;
                		if(in_artwork_file.isFile())
                		{
                            while(cin.hasNextLine())
                            {
                            	String line = cin.nextLine();
                                String[] tokens = line.split(",");
                            	String name = tokens[0];
                            	double price = Double.parseDouble(tokens[1]);
                                String art_pur_date = tokens[2];
                                String art_date_sold = tokens[3];
                                String art_buyer_name = tokens[4];
                                String Art_Artist_Name = tokens[5];
                                System.out.println("Artwork title: " + name);
                                System.out.println("Artwork price: " + price);
                                System.out.println("Artwork purchase date: " + art_pur_date);
                                System.out.println("Artwork date sold: " + art_date_sold);
                                System.out.println("Artwork buyer: " + art_buyer_name);
                                System.out.println("Artwork artist: " + Art_Artist_Name);
                            }
                           
                		}
                		else
                		{
                			System.out.println("error: File not found");
                		}
                		cin.close();
                	}
                	catch(IOException IE)
                    {
                    	System.out.println("Error: " + IE.getMessage());
                    }
                    catch(Exception e)
                    {
                    	System.out.println("Error: " + e.getMessage());
                    }
                }
                	break;
                case 4:
                	quit = true;
                    break;
                default:
                	System.out.println("Invalid input");
                	break;
            }
        }
        
    }
	

	public static void searchInfo(Customer customer, Artist artist, Artwork artwork)
	{
		Scanner input = new Scanner(System.in);
		int choice = 0;
		boolean quit = false;
		
		while(!quit)
		{
		System.out.println("-----------------------------------");
		System.out.println("\t1.search customer");
		System.out.println("\t2.search artist");
		System.out.println("\t3.search artwork");
		System.out.println("\t4.return");
		System.out.println("-----------------------------------");
		choice = input.nextInt();
		input.nextLine();
		switch(choice)
		{
		case 1:
		{
			try
			{
				
			System.out.println("Enter customer name to search: ");
		    String search = input.nextLine(); 
            Scanner sea = new Scanner(search);// turn the name i search to have no blank space and to lower case
            String modified_search = "";
            
            while(sea.hasNext())
            {
            	modified_search += sea.next();
            }
            
            modified_search = modified_search.toLowerCase();
            System.out.println(modified_search);
            
		    int index = -1;
		    Customer[] customerList = customer.getCustomerList();
		    
		    for (int i = 0; i < customer.getNumberOfCustomer(); i++)
		    {String file_customer_name = customerList[i].getName(); // turn the name i got from customer list to have no blank space and to lower case
        	String modified_file_customer_name = "";
        	sea = new Scanner(file_customer_name);
        	while(sea.hasNext())
        	{
        		modified_file_customer_name += sea.next();
        	}
        	modified_file_customer_name = modified_file_customer_name.toLowerCase();
        	
        	System.out.println(modified_file_customer_name);
            if (modified_search.equals(modified_file_customer_name)) {
                index = i;
                break;
            }
		    }
		    
		    if (index != -1)
		    {
		        System.out.println("Customer info is ");
                System.out.println("Name: " + customerList[index].getName());
                System.out.println("Contact Number: " + customerList[index].getContactNumber());
                System.out.println("Artist Preference: " + customerList[index].getArtistPreference());
                
        		File in_artwork_file = new File("C:\\Users\\60167\\Desktop\\Assignment\\artwork.txt");
        		Scanner cin_artwork = new Scanner(in_artwork_file); 
        		
        		String customer_name_list = customerList[index].getName();
        		Scanner customer_name = new Scanner(customer_name_list);
        		String modified_customer_name = "";
        		
        		while(customer_name.hasNext())
        		{
        			modified_customer_name += customer_name.next();        	
        			
        		}
        		modified_customer_name = modified_customer_name.toLowerCase();
        		
        		int count = 1;
        		if(in_artwork_file.isFile())
        		{
                    while(cin_artwork.hasNextLine())
                    {
                        Artwork[] artworkstosearch = artwork.getArtworkList();// it is used to get number of artwork as after it was invoked, method"getNumberOfartwork" will have a the value i need to use
                        
    	                
                        for(int j = 0;j < artwork.getNumberOfArtwork();j++)
                        {
                        	
                        	
                        	// read data from artwork file
                        	String artworkline = cin_artwork.nextLine(); 
                            String[] artworktokens = artworkline.split(",");
                        	String artworkname = artworktokens[0];
                        	double price = Double.parseDouble(artworktokens[1]);
                            String art_pur_date = artworktokens[2];
                            String art_date_sold = artworktokens[3];
                            String art_buyer_name = artworktokens[4];
                            String Art_Artist_Name = artworktokens[5];
                            //
                            
                            // turn the names i got from artwork file to have no blank space and to lower case
                        	String file_artwork_buyer_name = art_buyer_name;
    	                	String modified_file_artwork_buyer_name = "";
    	                	sea = new Scanner(file_artwork_buyer_name);
    	                	while(sea.hasNext())
    	                	{
    	                		modified_file_artwork_buyer_name += sea.next();
    	                	}
    	                	modified_file_artwork_buyer_name = modified_file_artwork_buyer_name.toLowerCase();
    	                	//
    	                	
							if(modified_file_artwork_buyer_name.equals(modified_customer_name))
    	                	{
    	                		System.out.println("Artwork purchased number " + count + " : " + artworkname);
    	                		count++;
    	                	}
							//
							
							
    	                    
                        }
                        
                    }
                 
        		}
        		else
        		{
        			System.out.println("error: File not found");
        		}
        		cin_artwork.close();
        		
		    }
		    else
		    {
		        System.out.println("Customer not found ");
		    }
			}
			catch(IOException IE)
            {
            	System.out.println("Error: " + IE.getMessage());
            }
            catch(Exception e)
            {
            	System.out.println("Error: " + e.getMessage());
            }
		}
		break;
		case 2:
		{
			try
			{
				System.out.println("Enter artist name to search: ");
				String search = input.nextLine(); 
				
				
				// turn the name i search to have no blank space and to lower case
                Scanner sea = new Scanner(search);
                String modified_search = "";
                while(sea.hasNext())
                {
                	modified_search += sea.next();
                }
                
                modified_search = modified_search.toLowerCase();
                //
                
                
			    int index = -1;
			    Artist[] artistList = artist.getArtistList();
			    for (int i = 0; i < artist.getNumberOfArtist(); i++)
			    {
			    	
			    	// turn the name i got from artist list to have no blank space and to lower case
			    	String file_artist_name = artistList[i].getName(); 
                	String modified_file_artist_name = "";
                	sea = new Scanner(file_artist_name);
                	while(sea.hasNext())
                	{
                		modified_file_artist_name += sea.next();
                	}
                	
                	modified_file_artist_name = modified_file_artist_name.toLowerCase();
                    //
                	
                	
                    if (modified_file_artist_name.equals(modified_search)) {
                    	
                        index = i;
                        break;
                    }
			       
			    }
			    if (index != -1)
			    {
			        System.out.println("Artist info is ");
	                System.out.println("Name: " + artistList[index].getName());
	                System.out.println("Speciality: " + artistList[index].getSpeciality());
	                System.out.println("Vital: " + artistList[index].getVitalStatus());
	                System.out.println("Artwork Price Range: " + artistList[index].getArtworkPriceRange());
			    }
			    else
			    {
			        System.out.println("Artist not found ");
			    }
			}
			catch(IOException IE)
            {
            	System.out.println("Error: " + IE.getMessage());
            }
            catch(Exception e)
            {
            	System.out.println("Error: " + e.getMessage());
            }
			
		}
		break;
		case 3:
		{
			try
			{
			System.out.println("Enter artwork name to search: ");
			String search = input.nextLine();
			
			
			// turn the name i search to have no blank space and to lower case
            Scanner sea = new Scanner(search);
            String modified_search = "";
            while(sea.hasNext())
            {
            	modified_search += sea.next();
            }
            
            modified_search = modified_search.toLowerCase();
            //
            
            
		    int index = -1;
		    Artwork[] artworkList = artwork.getArtworkList();
		    for (int i = 0; i < artwork.getNumberOfArtwork(); i++)
		    {
		    	
		    	
		    	// turn the name i got from artwork list to have no blank space and to lower case
		    	String file_artwork_name = artworkList[i].getTitle(); 
            	String modified_file_artwork_name = "";
            	sea = new Scanner(file_artwork_name);
            	while(sea.hasNext())
            	{
            		modified_file_artwork_name += sea.next();
            	}
            	modified_file_artwork_name = modified_file_artwork_name.toLowerCase();
            	//
            	
            	
                if (modified_file_artwork_name.equals(modified_search)) {
                	
                    index = i;
                    break;
                }
		    }
		    if (index != -1)
		    {
		        System.out.println("Artwork info is ");
                System.out.println("Name: " + artworkList[index].getTitle());
                System.out.println("Price: " + artworkList[index].getPrice());
                System.out.println("Date purchased: " + artworkList[index].getDatePurchase());
                System.out.println("Buyer: " + artworkList[index].getbuyername()); //need to change to getbuyername
                System.out.println("Artwork artist: " + artworkList[index].getArtistName());
		    }
		    else
		    {
		        System.out.println("Artwork not found ");
		    }
			}
			catch(IOException IE)
            {
            	System.out.println("Error: " + IE.getMessage());
            }
            catch(Exception e)
            {
            	System.out.println("Error: " + e.getMessage());
            }
		}
		break;
		case 4:
			quit = true;
			break;
		default:
        	System.out.println("Please enter number from 1 to 4");
        	break;
		}
		}
		input.close();
	}
	public static void modifyInfo(Customer customer, Artist artist, Artwork artwork)
	{
		Scanner input = new Scanner(System.in);
	    int choice1 = 0;
	    boolean quit = false;

	    while (!quit) {
	    	System.out.println("-----------------------------------");
	        System.out.println("\t1. Modify Customer");
	        System.out.println("\t2. Modify Artist");
	        System.out.println("\t3. Modify Artwork");
	        System.out.println("\t4. Return");
	        System.out.println("-----------------------------------");
	        choice1 = input.nextInt();
	        input.nextLine();
	        
	        switch(choice1){
	        case 1:
	        	try
	        	{
	        		Scanner in_customer_name = new Scanner(System.in);
	        		System.out.println("Enter the name of the customer that you want to modify");
	        		String name = in_customer_name.nextLine();
	        		customer.modifyCustomer(name);
	        	}
	        	catch(IOException IE)
	        	{
	        		System.out.println("Error: " + IE.getMessage());
	        	}
	        	catch(Exception e)
	        	{
	        		System.out.println("Error: " + e.getMessage());
	        	}
	        	break;
	        case 2:
	        	try
	        	{
	        		Scanner in_artist_name = new Scanner(System.in);
	        		System.out.println("Enter the name of the customer that you want to modify");
	        		String name = in_artist_name.nextLine();
	        		artist.modifyartist(name);
	        	}
	        	catch(IOException IE)
	        	{
	        		System.out.println("Error: " + IE.getMessage());
	        	}
	        	catch(Exception e)
	        	{
	        		System.out.println("Error: " + e.getMessage());
	        	}
	        	break;
	        case 3:
	        	try
	        	{
	        		Scanner in_artwork_name = new Scanner(System.in);
	        		System.out.println("Enter the name of the customer that you want to modify");
	        		String name = in_artwork_name.nextLine();
	        		
	        		artwork.modifyartwork(name);
	        	}
	        	catch(IOException IE)
	        	{
	        		System.out.println("Error: " + IE.getMessage());
	        	}
	        	catch(Exception e)
	        	{
	        		System.out.println("Error: " + e.getMessage());
	        	}
	        	break;
	        case 4:
	        	quit = true;
	        	break;
	        default:
	        	System.out.println("Please enter number from 1 to 4");
	        	break;
	        }
	    }
	    
	        
	}
	public static void deleteInfo(Customer customer, Artist artist, Artwork artwork) {
	    Scanner input = new Scanner(System.in);
	    int choice = 0;
	    boolean quit = false;

	    while (!quit) {
	    	System.out.println("-----------------------------------");
	        System.out.println("\t1. Delete Customer");
	        System.out.println("\t2. Delete Artist");
	        System.out.println("\t3. Delete Artwork");
	        System.out.println("\t4. Return");
	        System.out.println("-----------------------------------");
	        choice = input.nextInt();
	        input.nextLine();

	        switch (choice) {
	            case 1: {
	            	try
	            	{
	            	System.out.println("Enter customer name to delete: ");
	                String search = input.nextLine(); // turn the name i search to have no blank space and to lower case
	                Scanner sea = new Scanner(search);
	                String modified_search = "";
	                while(sea.hasNext())
	                {
	                	modified_search += sea.next();
	                }
	                
	                modified_search = modified_search.toLowerCase();
	                System.out.println(modified_search);
	                int index = -1;
	                Customer[] customerList = customer.getCustomerList();
	                
	                for (int i = 0; i < customer.getNumberOfCustomer(); i++) {
	                	String file_customer_name = customerList[i].getName(); // turn the name i got from customer list to have no blank space and to lower case
	                	String modified_file_customer_name = "";
	                	sea = new Scanner(file_customer_name);
	                	while(sea.hasNext())
	                	{
	                		modified_file_customer_name += sea.next();
	                	}
	                	modified_file_customer_name = modified_file_customer_name.toLowerCase();
	                	System.out.println(modified_file_customer_name);
	                    if (modified_search.equals(modified_file_customer_name)) {
	                        index = i;
	                        break;
	                    }
	                }
	                if (index != -1) {
	                	
	                    customer.deleteCustomer(customerList[index]);
	                    System.out.println("Customer deleted.");
	                }else {
	                    System.out.println("Customer not found.");
	                }
	                
	            	}
	            	catch(IOException IE)
                    {
                    	System.out.println("Error: " + IE.getMessage());
                    }
                    catch(Exception e)
                    {
                    	System.out.println("Error: " + e.getMessage());
                    }
	            }
	            break;
	            case 2: {
	            	try
	            	{
	            	System.out.println("Enter artist name to delete: ");
	                String search = input.nextLine(); // turn the name i search to have no blank space and to lower case
	                Scanner sea = new Scanner(search);
	                String modified_search = "";
	                while(sea.hasNext())
	                {
	                	modified_search += sea.next();
	                }
	                
	                modified_search = modified_search.toLowerCase();
	                
	                
	                int index = -1;
	                Artist[] artistList = artist.getArtistList();
	                for (int i = 0; i < artist.getNumberOfArtist(); i++) {
	                	String file_artist_name = artistList[i].getName(); // turn the name i got from artist list to have no blank space and to lower case
	                	String modified_file_artist_name = "";
	                	sea = new Scanner(file_artist_name);
	                	while(sea.hasNext())
	                	{
	                		modified_file_artist_name += sea.next();
	                	}
	                	
	                	modified_file_artist_name = modified_file_artist_name.toLowerCase();
	                    if (modified_file_artist_name.equals(modified_search)) {
	                    	
	                        index = i;
	                        break;
	                    }
	                }
	                
	                if (index != -1) { // index is not the default value,-1, statement will be executed
	                    artist.deleteArtist(artistList[index]);
	                    System.out.println("Artist deleted.");
	                } else {
	                    System.out.println("Artist not found.");
	                }
	            	}
	            	catch(IOException IE)
                    {
                    	System.out.println("Error: " + IE.getMessage());
                    }
                    catch(Exception e)
                    {
                    	System.out.println("Error: " + e.getMessage());
                    }
	            }
	            break;
	            case 3: {
	            	try
	            	{
	            		System.out.println("Enter artwork name to delete: ");
	                String search = input.nextLine();// turn the name i search to have no blank space and to lower case
	                Scanner sea = new Scanner(search);
	                String modified_search = "";
	                while(sea.hasNext())
	                {
	                	modified_search += sea.next();
	                }
	                
	                modified_search = modified_search.toLowerCase();
	                
	                int index = -1;
	                Artwork[] artworkList = artwork.getArtworkList();
	                for (int i = 0; i < artwork.getNumberOfArtwork(); i++) {
	                	
	                	// turn the name i got from artwork list to have no blank space and to lower case
	                	String file_artwork_name = artworkList[i].getTitle(); 
	                	String modified_file_artwork_name = "";
	                	sea = new Scanner(file_artwork_name);
	                	while(sea.hasNext())
	                	{
	                		modified_file_artwork_name += sea.next();
	                	}
	                	modified_file_artwork_name = modified_file_artwork_name.toLowerCase();
	                	//
	                	
	                	
	                    if (modified_file_artwork_name.equals(modified_search)) {
	                    	
	                        index = i;
	                        break;
	                    }
	                }
	                if (index != -1) {
	                    artwork.deleteArtwork(artworkList[index]);
	                    System.out.println("Artwork deleted.");
	                } else {
	                    System.out.println("Artwork not found.");
	                }
	            	}
	            	catch(IOException IE)
                    {
                    	System.out.println("Error: " + IE.getMessage());
                    }
                    catch(Exception e)
                    {
                    	System.out.println("Error: " + e.getMessage());
                    }
	            }
	            break;
	            case 4:
	                quit = true;
	                break;
	            default:
    	        	System.out.println("Please enter number from 1 to 4");
    	        	break;
	        }
	    }
	    input.close();
	}
	
}
