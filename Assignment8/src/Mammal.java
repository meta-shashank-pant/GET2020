public class Mammal extends Animal{

    protected int mammalCount = 30;

    /**
     * constructor initialize mammal feature   
     * 
     * @param name the first {@code String}       
     * @param age the second {@code int}       
     * @param weight the third {@code int}
     * @param type the fourth {@code String}       
     * @param zone the fifth {@code String}       
     * @param ID the sixth {@code String}  
     */
    public Mammal(String name, int age, int weight, String type, String zone, String ID) throws Exception{
        super(name, age, weight, type, ID, zone, "Mammal");         
    }
}

class Lion extends Mammal{
    String animalType = "Lion";
    
    /**
     * constructor initialize lion feature   
     * 
     * @param name the first {@code String}       
     * @param age the second {@code int}       
     * @param weight the third {@code int}
     * @param type the fourth {@code String}       
     * @param zone the fifth {@code String}       
     * @param ID the sixth {@code String}  
     */
    public Lion(String name, int age, int weight, String type,  String zone, String ID) throws Exception{
        super(name, age, weight, type, zone, ID);
    }
}

class Tiger extends Mammal{
    String animalType = "Tiger";
    
    /**
     * constructor initialize tiger feature   
     * 
     * @param name the first {@code String}       
     * @param age the second {@code int}       
     * @param weight the third {@code int}
     * @param type the fourth {@code String}       
     * @param zone the fifth {@code String}       
     * @param ID the sixth {@code String}  
     */
    public Tiger(String name, int age, int weight, String type,  String zone, String ID) throws Exception{
        super(name, age, weight, type, zone, ID);
    }
}

class Bear extends Mammal{
    String animalType = "Bear";
    
    /**
     * constructor initialize bear feature   
     * 
     * @param name the first {@code String}       
     * @param age the second {@code int}       
     * @param weight the third {@code int}
     * @param type the fourth {@code String}       
     * @param zone the fifth {@code String}       
     * @param ID the sixth {@code String}  
     */
    public Bear(String name, int age, int weight, String type,  String zone, String ID) throws Exception{
        super(name, age, weight, type, zone, ID);
    }
}