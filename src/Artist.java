import java.io.*;
import java.util.*;

public class Artist{

	private String name;
	private String speciality;
	private String vitalStatus;
	private String artworkPriceRange;
	
	private ArrayList <Artist> ArtistList = new ArrayList <Artist>();
	FileWriter fw;
	PrintWriter pw;
	public void setName(String aName)
	{
		name = aName;
	}
	public String getName()
	{
		return name;
	}
	public void setSpeciality(String aSpeciality)
	{
		speciality = aSpeciality;
	}
	public String getSpeciality()
	{
		return speciality;
	}
	public void setVitalStatus(String AvitalStatus)
	{
		vitalStatus = AvitalStatus;
	}
	public String getVitalStatus()
	{
		return vitalStatus;
	}
	public void setArtworkPriceRange(String AartworkPriceRange)
	{
		artworkPriceRange = AartworkPriceRange;
	}
	public String getArtworkPriceRange()
	{
		return artworkPriceRange;
	}

	public Artist()
	{
		
	}
	public Artist(String Aname, String Aspeciality, String AvitalStatus, String AartworkPriceRange)
	{
		name = Aname;
		speciality = Aspeciality;
		vitalStatus = AvitalStatus;
		artworkPriceRange = AartworkPriceRange;
	}
	
	
	public void recordAArtist(Artist artist)throws IOException //Customer's data will be split by ','
	{
		//open customer text file and put data to customer text file 
		if(new File("C:\\Users\\60167\\Desktop\\Assignment\\artist.txt").isFile())
		{
			System.out.println("Artist file can be accessed");
			fw = new FileWriter("C:\\Users\\60167\\Desktop\\Assignment\\artist.txt",true);
			pw = new PrintWriter(fw);
			
			pw.println(artist.getName()+ "," + artist.getSpeciality() + "," + artist.getVitalStatus()+ "," + artist.getArtworkPriceRange());
		}
		fw.close();
		pw.close();
		//
		
	}
	public int getNumberOfArtist()
	{
		return ArtistList.size();
	}
	public Artist [] getArtistList() throws IOException//get artist list from the artist file then use ',' to split the artist's data
	{
		//get artist list from the artist file then use ',' to split the artist's data
		File in_artist_file = new File("C:\\Users\\60167\\Desktop\\Assignment\\artist.txt");
		Scanner cin = new Scanner(in_artist_file);
		Artist a;
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
                
                //add object to artist array list
                a = new Artist(name, speciality, vitalStatus,pricerange);
                ArtistList.add(a);
                //
            }
           
		}
		else
		{
			System.out.println("error: File not found");
		}
		cin.close();
		//
		
		
		// put array list to an array of objects
		int count = ArtistList.size();
		Artist [] list = new Artist[count];
		for(int i =0; i < getNumberOfArtist(); i++)
		{
			list[i] = ArtistList.get(i);
		}
		//
		
		return list;
	}
	public void deleteArtist(Artist artistToDelete) throws IOException {
		
		// get data from artist text file then put it into an array list
		File in_artist_file = new File("C:\\Users\\60167\\Desktop\\Assignment\\artist.txt");
		Scanner cin = new Scanner(in_artist_file);
		Artist a;
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
                
                //add object to artist array list
                a = new Artist(name, speciality, vitalStatus,pricerange);
                ArtistList.add(a);
                //
            }
           
		}
		else
		{
			System.out.println("error: File not found");
		}
		cin.close();
		//
		
		
		//put array list to an array of objects
		int count = ArtistList.size();
		Artist [] list = new Artist[count];
		for(int i =0; i < getNumberOfArtist(); i++)
		{
			list[i] = ArtistList.get(i);
		}
		//
		
		
		//delete chosen object from parameter
	    ArtistList.remove(artistToDelete);
	    //
	    
	    
	    //override the text file and put in new data from the modified array list
        PrintWriter pw = new PrintWriter("C:\\Users\\60167\\Desktop\\Assignment\\artist.txt");
	    
        Artist[] AT = ArtistList.toArray(new Artist[ArtistList.size()]);
	    
	    for(int i = 0;i < ArtistList.size();i++)
	    {
	    	pw.println(AT[i].getName()+ "," + AT[i].getSpeciality() + "," + AT[i].getVitalStatus());
	    }
	    pw.close();
	    //
	}
	
	public void modifyartist(String artist_name) throws IOException
	{
		
		//copy all info from text file array list
		File in_artist_file = new File("C:\\Users\\60167\\Desktop\\Assignment\\artist.txt");
		Scanner cin = new Scanner(in_artist_file);
		Artist a;
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
                a = new Artist(name, speciality, vitalStatus,pricerange);
                ArtistList.add(a);
            }
           
		}
		else
		{
			System.out.println("error: File not found");
		}
		cin.close();
		//
		
		
		//turn array list to an array of objects
		int count = ArtistList.size();
		Artist [] list = new Artist[count];
		for(int i =0; i < getNumberOfArtist(); i++)
		{
			list[i] = ArtistList.get(i);
		}
		//
		
		//change artist name from parameter to have no space and lowered to lower case
		Scanner changed_artist_name = new Scanner(artist_name);
		String modified_artist_name = "";
				
		while(changed_artist_name.hasNext())
		{
			modified_artist_name += changed_artist_name.next();
		}
		modified_artist_name = modified_artist_name.toLowerCase();
		// 
		
		
		//change the name that user want to modify from parameter to have no blank space and all to lower case
		int index = -1;
		for(int i = 0 ; i < count;i++)
		{
			String txt_artist_name = list[i].getName();
			Scanner change_txt_artist_name = new Scanner(txt_artist_name);
			String modified_change_tst_artist_name = "";
			while(change_txt_artist_name.hasNext())
			{
				modified_change_tst_artist_name += change_txt_artist_name.next();
			}
			modified_change_tst_artist_name = modified_change_tst_artist_name.toLowerCase();
			
			if(modified_change_tst_artist_name.equals(modified_artist_name))
			{
				index = i;
				break;
			}
			
		}
		//
		
		
		
		if(index != -1)
		{
			System.out.println("Which data of the artist you want to modify?");
			Scanner cin_choose_modify = new Scanner(System.in);
			boolean quit = false;
			
			while(quit != true)
			{
				System.out.println("1. Modify name.");
				System.out.println("2. Modify Specialty");
				System.out.println("3. Modify Vital Status.");
				System.out.println("4. Modify Price Range.");
				System.out.println("5. return");
				int choice = cin_choose_modify.nextInt();
				
				
				
				Scanner in_new_data = new Scanner(System.in);
				switch(choice)
				{
				case 1:
					System.out.println("New name?");
					String new_name = in_new_data.nextLine();
					list[index].setName(new_name);
					break;
				case 2:
					System.out.println("New Specialty?");
					String new_spec = in_new_data.nextLine();
					list[index].setSpeciality(new_spec);
					break;
				case 3:
					System.out.println("New Vital Status?");
					String new_vit_stat = in_new_data.nextLine();
					list[index].setVitalStatus(new_vit_stat);
					break;
				case 4:
					System.out.println("New Price Range?");
					String new_pri_ran = in_new_data.nextLine();
					list[index].setArtworkPriceRange(new_pri_ran);
					break;
				case 5:
					quit = true;
					break;
				default:
					System.out.println("Please input from 1 to 4");
					break;
				
				}
			}
			
		}
		
		
		//Override the artist file with a new artist data from an array of objects
		pw = new PrintWriter("C:\\Users\\60167\\Desktop\\Assignment\\artist.txt");
		
		for(int i = 0;i < list.length;i++)
		{
			pw.println(list[i].getName()+ "," + list[i].getSpeciality() + "," + list[i].getVitalStatus()+ "," + list[i].getArtworkPriceRange());
		}
		pw.close();
		//
		
		
	}
}
