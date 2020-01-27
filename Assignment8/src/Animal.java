import java.util.ArrayList;

public abstract class Animal {
    protected String name;
    protected String type;
    protected int age;
    protected int weight;
    protected String ID;
    protected String zone;
    protected String animalCatagory; 
    public static ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    
    /**
     * constructor initialize animal feature   
     * 
     * @param name the first {@code String}       
     * @param age the second {@code int}       
     * @param weight the third {@code int}
     * @param type the fourth {@code String}       
     * @param ID the fifth {@code String}       
     * @param zone the sixth {@code String}
     * @param animalCatagory the seventh {@code String}    
     */
    public Animal(String name, int age, int weight, String type, String ID,  String zone, String animalCatagory) throws Exception{
        if(zone.equals(null))
            System.exit(0);
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.type = type;
        this.ID = ID;
        this.zone = zone;
        this.animalCatagory = animalCatagory;
        this.fillData(ID+"\t"+name+"\t\t"+age+"\t\t"+weight+"\t\t"+type+"\t\t"+zone, animalCatagory);
    }
    
    /**
     * This method is used to fill the data inside ArrayList.
     * @param input is information about animal of type string.
     * @param animalCategory is the category in which animal falls.
     * @throws Exception
     */
    public void fillData(String input, String animalCategory) throws Exception {
    	ArrayList<String> animal = new ArrayList<String>(2);
    	animal.add(input);
    	animal.add(animalCategory);
    	data.add(animal);
    }
    
    /**
     * This method is used to get zone of any animal.
     * @param animalCategory is the category in which animal falls.
     * @param id is the unique id of type string assigned to each animal.
     * @return value is the zone of type string
     */
    public static String getZone(String animalCategory, String id){
    	for(ArrayList<String> animal: data){
    		if(animal.get(1) == animalCategory){
    			String[] tmp_arr = animal.get(0).split("\t",0);
    			if(tmp_arr[0].contains(id)){
    				return tmp_arr[9];
    			}
    		}
    	}
    	return "Not Found";	
    }
    
    /**
     * This method is used to get type of the animal.
     * @param animalCategory is the category in which animal falls.
     * @param id is the unique id of type string assigned to each animal.
     * @return value is the type of animal.
     */
    public static String getType(String animalCategory, String id){
    	for(ArrayList<String> animal: data){
    		if(animal.get(1) == animalCategory){
    			String[] tmp_arr = animal.get(0).split("\t",0);
    			if(tmp_arr[0].contains(id)){
    				return tmp_arr[7];
    			}
    		}
    	}
    	return "Not Found";	
    }
    
    /**
     * This method is used to delete the record of any animal from ArrayList<>.
     * @param animalCategory is the category in which animal falls.
     * @param id is the unique id of type string assigned to each animal.
     * @return value is of type boolean that is true if successful deletion.
     * @throws Exception
     */
    public static boolean deleteData(String animalCategory, String id) throws Exception {
    	int count = 0;
    	for(ArrayList<String> animal: data){
    		if(animal.get(1) == animalCategory){
    			String[] tmp_arr = animal.get(0).split("\t",0);
    			if(tmp_arr[0].contains(id)){
    				data.remove(count);
    				return true;
    			}
    		}
    		count++;
    	}
    	return false;	
    }
    
    /**
     * This method is used to print the data.
     * @param animalCategory is the category for which data is to printed.
     * @throws Exception
     */
    public static void printData(String animalCategory) throws Exception {
    	System.out.println("ID\t\tname\t\tage\t\tweight\t\ttype\t\tzone");
    	for(ArrayList<String> animal: data){
    		if(animal.get(1) == animalCategory){
    			System.out.println(animal.get(0));
    		}
    	}
    }
}
