public class Reptile extends Animal {

    protected int reptileCount = 30;

    /**
     * constructor initialize reptile feature   
     * 
     * @param name the first {@code String}       
     * @param age the second {@code int}       
     * @param weight the third {@code int}
     * @param type the fourth {@code String}       
     * @param zone the fifth {@code String}       
     * @param ID the sixth {@code String}  
     */
    public Reptile(String name, int age, int weight, String type, String zone, String ID) throws Exception{
        super(name, age, weight, type, ID, zone, "Reptile");   
    }
}

class Crocodiles extends Reptile{
    String animalType = "Crocodiles";
    
    /**
     * constructor initialize crocodiles feature   
     * 
     * @param name the first {@code String}       
     * @param age the second {@code int}       
     * @param weight the third {@code int}
     * @param type the fourth {@code String}       
     * @param zone the fifth {@code String}       
     * @param ID the sixth {@code String}  
     */
    public Crocodiles(String name, int age, int weight, String type, String zone, String ID)throws Exception{
        super(name, age, weight, type, zone, ID);
    }
}

class Alligators extends Reptile{
    String animalType = "Alligators";
    
    /**
     * constructor initialize alligators feature   
     * 
     * @param name the first {@code String}       
     * @param age the second {@code int}       
     * @param weight the third {@code int}
     * @param type the fourth {@code String}       
     * @param zone the fifth {@code String}       
     * @param ID the sixth {@code String}  
     */
    public Alligators(String name, int age, int weight, String type, String zone, String ID)throws Exception{
        super(name, age, weight, type, zone, ID);
    }
}

class Lizards extends Reptile{
    String animalType = "Lizards";
    
    /**
     * constructor initialize lizards feature   
     * 
     * @param name the first {@code String}       
     * @param age the second {@code int}       
     * @param weight the third {@code int}
     * @param type the fourth {@code String}       
     * @param zone the fifth {@code String}       
     * @param ID the sixth {@code String}  
     */
    public Lizards(String name, int age, int weight, String type, String zone, String ID)throws Exception{
        super(name, age, weight, type, zone, ID);
    }
}