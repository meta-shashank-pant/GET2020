public class Bird extends Animal{
    
    protected int birdCount = 30;
    
    /**
     * constructor initialize bird feature   
     * 
     * @param name the first {@code String}       
     * @param age the second {@code int}       
     * @param weight the third {@code int}
     * @param type the fourth {@code String}       
     * @param zone the fifth {@code String}       
     * @param ID the sixth {@code String}  
     */
    public Bird(String name, int age, int weight, String type, String zone, String ID) throws Exception{
        super(name, age, weight, type, ID, zone, "Bird");
    }
}

class Owl extends Bird {
    String animalType = "Owl";
    
    /**
     * constructor initialize owl feature   
     * 
     * @param name the first {@code String}       
     * @param age the second {@code int}       
     * @param weight the third {@code int}
     * @param type the fourth {@code String}       
     * @param zone the fifth {@code String}       
     * @param ID the sixth {@code String}  
     */
    public Owl(String name, int age, int weight, String type, String zone, String ID)throws Exception{
        super(name, age, weight, type, zone, ID);
    }
}

class Parrot extends Bird{
    String animalType = "Parrot";
    
    /**
     * constructor initialize parrot feature   
     * 
     * @param name the first {@code String}       
     * @param age the second {@code int}       
     * @param weight the third {@code int}
     * @param type the fourth {@code String}       
     * @param zone the fifth {@code String}       
     * @param ID the sixth {@code String}  
     */
    public Parrot(String name, int age, int weight, String type, String zone, String ID)throws Exception{
        super(name, age, weight, type, zone, ID);
    }
}

class Peacock extends Bird{
    String animalType = "Peacock";
    
    /**
     * constructor initialize peacock feature   
     * 
     * @param name the first {@code String}       
     * @param age the second {@code int}       
     * @param weight the third {@code int}
     * @param type the fourth {@code String}       
     * @param zone the fifth {@code String}       
     * @param ID the sixth {@code String}  
     */
    public Peacock(String name, int age, int weight, String type, String zone, String ID)throws Exception{
        super(name, age, weight, type, zone, ID);
    }
}