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
    
    public void fillData(String input, String animalCategory) throws Exception {
    	ArrayList<String> animal = new ArrayList<String>(2);
    	animal.add(input);
    	animal.add(animalCategory);
    	data.add(animal);
    }
    
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
    
    public static void printData(String animalCategory) throws Exception {
    	for(ArrayList<String> animal: data){
    		if(animal.get(1) == animalCategory){
    			System.out.println(animal.get(0));
    		}
    	}
    }
}
