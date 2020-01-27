import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public interface Zone {
    
    public static final HashMap<String, List<String>> zoo = new HashMap<String, List<String>>()
                        {/**
							 * 
							 */
							private static final long serialVersionUID = 1L;

						{put("Mammal", new ArrayList<String>(Arrays.asList("Zone 1","Zone 2")));
                          put("Reptile", new ArrayList<String>(Arrays.asList("Zone 3")));
                          put("Bird", new ArrayList<String>(Arrays.asList("Zone 4","Zone 5")));}};
    boolean hasCanteen();
    boolean hasPark();
}

class ZoneOne implements Zone{
    public final String zoneCategory = "Mammal"; 
    public int cageNumber = 10;
    public int numberOfAnimal = 7;
    public String zoneName = "Zone 1";
    protected HashMap<String, List<Integer>> zone = new HashMap<String, List<Integer>>(){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{									//Arrays.asList(current number of animals, current number of cages)
        put("Lion", new ArrayList<Integer>(Arrays.asList(3, 5)));
        put("Bear", new ArrayList<Integer>(Arrays.asList(2, 3)));
        put("Tiger", new ArrayList<Integer>(Arrays.asList(2, 2)));
        }};
        
    //single object for class ZoneOne
    public static ZoneOne zo = new ZoneOne(); 
    
    private ZoneOne(){}
    
    /**
     * this function use to return single object   
     * 
     * @param no parameter        
     * @return ZoneOne object
     */
    public static ZoneOne getInstance(){
        return zo;
    }
    
    public void removedAnimal(String type){
    	zone.put(type, new ArrayList<Integer>(Arrays.asList((zone.get(type).get(0)-1),(zone.get(type).get(1)))));
    	this.numberOfAnimal--;
    }
    
    /**
     * this function use to return the zone name   
     * 
     * @param  type the first {@code string}        
     * @return String value
     */
    public String set(String type)throws IOException{
        boolean flag = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        if(zone.containsKey(type)){
            if(zone.get(type).get(0) == zone.get(type).get(1)){
                System.out.println("Space of cages are full in Zone One\n "
                        + "You want to - \n 1) Add cage\n 2) Move Zone Two\n "
                        + "3) Exit\n");
                do{
                    switch(Integer.parseInt(br.readLine())){
                    case 1 :
                        zone.put(type, new ArrayList<Integer>(Arrays.asList((zone.get(type).get(0)),(zone.get(type).get(1)+1))));
                        System.out.println((zone.get(type).get(0))+" "+(zone.get(type).get(1)));
                        this.cageNumber += 1;
                        flag = false;
                        break;
                    case 2 :
                        ZoneTwo z2 = ZoneTwo.getInstance();
                        return z2.set(type);
                    case 3 : 
                        System.exit(0);
                        break;
                    default :
                        System.out.println("Wrong input... try again\n"
                                + "Enter");
                    }
                }while(flag);
                this.numberOfAnimal += 1;   
            }
            zone.put(type, new ArrayList<Integer>(Arrays.asList(zone.get(type).get(0)+1,zone.get(type).get(1))));
            System.out.println(this.numberOfAnimal);
            System.out.println(String.format("%25s %25s %25s","Type of animal","Number of animal", "number of cage" ));
            for (HashMap.Entry<String, List<Integer>> entry : zone.entrySet())  
                System.out.println(String.format("%25s %25s %25s",entry.getKey(),entry.getValue().get(0),entry.getValue().get(1)));   
        }
        else
            System.out.println("Animal are not in this zone");
 
        return zoneName;
    }
    
    /**
     * this function use to show that zone contain canteen or not   
     * 
     * @param no parameter        
     * @return boolean value
     */
    public boolean hasCanteen(){
        return true;
    }
    
    /**
     * this function use to show that zone contain park or not   
     * 
     * @param no parameter        
     * @return boolean value
     */
    public boolean hasPark(){
        return true;
    }   
}

class ZoneTwo implements Zone{
    public final String zoneCategory = "Mammal";
    public int cageNumber = 10;
    private int numberOfAnimal = 6;
    public String zoneName = "Zone 2";
    
    protected HashMap<String, List<Integer>> zone = new HashMap<String, List<Integer>>(){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
        put("Lion", new ArrayList<Integer>(Arrays.asList(2, 3)));
        put("Bear", new ArrayList<Integer>(Arrays.asList(2, 3)));
        put("Tiger", new ArrayList<Integer>(Arrays.asList(2, 4)));
    }};
    
    //single object for class ZoneTwo
    public static ZoneTwo zo = new ZoneTwo();
    
    public ZoneTwo(){}
    
    /**
     * this function use to return single object   
     * 
     * @param no parameter        
     * @return ZoneTwo object
     */
    public static ZoneTwo getInstance(){
        return zo;
    }
    
    public void removedAnimal(String type){
    	zone.put(type, new ArrayList<Integer>(Arrays.asList((zone.get(type).get(0)-1),(zone.get(type).get(1)))));
    	this.numberOfAnimal--;
    }
    
    /**
     * this function use to return the zone name   
     * 
     * @param  type the first {@code string}        
     * @return String value
     */
    public String set(String type)throws IOException{
        boolean flag = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        if(zone.containsKey(type)){
            if(zone.get(type).get(0) == zone.get(type).get(1)){
                System.out.println("Space of cages are full in Zone Two\n "
                        + "You want to - \n 1) Add cage\n 2) Move Zone One\n "
                        + "3) Exit\n");
                do{
                    switch(Integer.parseInt(br.readLine())){
                    case 1 :
                        zone.put(type, new ArrayList<Integer>(Arrays.asList((zone.get(type).get(0)),(zone.get(type).get(1)+1))));
                        System.out.println((zone.get(type).get(0))+" "+(zone.get(type).get(1)));
                        this.cageNumber += 1;
                        flag = false;
                        break;
                    case 2 :
                        ZoneOne z1 = ZoneOne.getInstance();
                        return z1.set(type);
                    case 3 : 
                        System.exit(0);
                        break;
                    default :
                        System.out.println("Wrong input... try again\n"
                                + "Enter");
                    }
                }while(flag);
                this.numberOfAnimal += 1; 
            }
            zone.put(type, new ArrayList<Integer>(Arrays.asList(zone.get(type).get(0)+ 1,zone.get(type).get(1))));
            System.out.println(this.numberOfAnimal);
            System.out.println(String.format("%25s %25s %25s","Type of animal","Number of animal", "number of cage" ));
            for (HashMap.Entry<String, List<Integer>> entry : zone.entrySet())  
                System.out.println(String.format("%25s %25s %25s",entry.getKey(),entry.getValue().get(0),entry.getValue().get(1)));   
        }
        else
            System.out.println("Animal are not in this zone");
        return zoneName;
    }
    
    /**
     * this function use to show that zone contain canteen or not   
     * 
     * @param no parameter        
     * @return boolean value
     */
    public boolean hasCanteen(){
        return true;
    }
    
    /**
     * this function use to show that zone contain park or not   
     * 
     * @param no parameter        
     * @return boolean value
     */
    public boolean hasPark(){
        return true;
    }
}

class ZoneThird implements Zone{
    public final String zoneCategory = "Reptile";
    public int cageNumber = 6;
    private int numberOfAnimal = 3;
    public String zoneName = "Zone 3";
    
    protected HashMap<String, List<Integer>> zone = new HashMap<String, List<Integer>>(){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
        put("Crocodiles", new ArrayList<Integer>(Arrays.asList(1, 2)));
        put("Alligators", new ArrayList<Integer>(Arrays.asList(1, 2)));
        put("Lizards", new ArrayList<Integer>(Arrays.asList(1, 2)));
        }};
    
    //single object for class ZoneThird    
    public static ZoneThird zo = new ZoneThird();

    public ZoneThird() {}

    /**
     * this function use to return single object   
     * 
     * @param no parameter        
     * @return ZoneThird object
     */
    public static ZoneThird getInstance() {
        return zo;
    }
    
    public void removedAnimal(String type){
    	zone.put(type, new ArrayList<Integer>(Arrays.asList((zone.get(type).get(0)-1),(zone.get(type).get(1)))));
    	this.numberOfAnimal--;
    }
    
    /**
     * this function use to return the zone name   
     * 
     * @param  type the first {@code string}        
     * @return String value
     */
    public String set(String type)throws IOException{
        boolean flag = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        if(zone.containsKey(type)){
            if(zone.get(type).get(0) == zone.get(type).get(1)){
                System.out.println("Space of cages are full in Zone Third\n "
                        + "You want to - \n 1) Add cage\n 2) Exit\n");
                do{
                    switch(Integer.parseInt(br.readLine())){
                    case 1 :
                        zone.put(type, new ArrayList<Integer>(Arrays.asList((zone.get(type).get(0)),(zone.get(type).get(1)+1))));
                        System.out.println((zone.get(type).get(0))+" "+(zone.get(type).get(1)));
                        this.cageNumber += 1;
                        flag = false;
                        break;
                    case 2 : 
                        System.exit(0);
                        break;
                    default :
                        System.out.println("Wrong input... try again\n"
                                + "Enter");
                    }
                }while(flag);
                this.numberOfAnimal += 1; 
            }
            zone.put(type, new ArrayList<Integer>(Arrays.asList(zone.get(type).get(0) + 1,zone.get(type).get(1))));
            System.out.println(this.numberOfAnimal);
            System.out.println(String.format("%25s %25s %25s","Type of animal","Number of animal", "number of cage" ));
            for (HashMap.Entry<String, List<Integer>> entry : zone.entrySet())  
                System.out.println(String.format("%25s %25s %25s",entry.getKey(),entry.getValue().get(0),entry.getValue().get(1)));  
        }
        else
            System.out.println("Animal are not in this zone");
        return zoneName;
    }     
    
    /**
     * this function use to show that zone contain canteen or not   
     * 
     * @param no parameter        
     * @return boolean value
     */
    public boolean hasCanteen(){
        return true;
    }
    
    /**
     * this function use to show that zone contain park or not   
     * 
     * @param no parameter        
     * @return boolean value
     */
    public boolean hasPark(){
        return true;
    }
}

class ZoneFour implements Zone{
    public final String zoneCategory = "Bird";
    public int cageNumber = 10;
    private int numberOfAnimal = 7;
    public String zoneName = "Zone 4";
    
    protected HashMap<String, List<Integer>> zone = new HashMap<String, List<Integer>>(){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
        put("Owl", new ArrayList<Integer>(Arrays.asList(1, 2)));
        put("Parrot", new ArrayList<Integer>(Arrays.asList(3, 4)));
        put("Peacock", new ArrayList<Integer>(Arrays.asList(3, 4)));
    }};
    
    //single object for class ZoneFour
    public static ZoneFour zo = new ZoneFour();

    public ZoneFour() {}

    /**
     * this function use to return single object   
     * 
     * @param no parameter        
     * @return ZoneFour object
     */
    public static ZoneFour getInstance() {
        return zo;
    }
    
    public void removedAnimal(String type){
    	zone.put(type, new ArrayList<Integer>(Arrays.asList((zone.get(type).get(0)-1),(zone.get(type).get(1)))));
    	this.numberOfAnimal--;
    }
    
    /**
     * this function use to return the zone name   
     * 
     * @param  type the first {@code string}        
     * @return String value
     */
    public String set(String type)throws IOException{
        boolean flag = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        if(zone.containsKey(type)){
            if(zone.get(type).get(0) == zone.get(type).get(1)){
                System.out.println("Space of cages are full in Zone Four\n "
                        + "You want to - \n 1) Add cage\n 2) Move Zone Five\n "
                        + "3) Exit\n");
                do{
                    switch(Integer.parseInt(br.readLine())){
                    case 1 :
                        zone.put(type, new ArrayList<Integer>(Arrays.asList((zone.get(type).get(0)),(zone.get(type).get(1)+ 1))));
                        System.out.println((zone.get(type).get(0))+" "+(zone.get(type).get(1)));
                        this.cageNumber += 1;
                        flag = false;
                        break;
                    case 2 :
                        ZoneFive z5 = ZoneFive.getInstance();
                        return z5.set(type);
                    case 3 : 
                        System.exit(0);
                        break;
                    default :
                        System.out.println("Wrong input... try again\n"
                                + "Enter");
                    }
                }while(flag);
                this.numberOfAnimal += 1; 
            }
            zone.put(type, new ArrayList<Integer>(Arrays.asList(zone.get(type).get(0)+ 1,zone.get(type).get(1))));
            System.out.println(this.numberOfAnimal);
            System.out.println(String.format("%25s %25s %25s","Type of animal","Number of animal", "number of cage" ));
            for (HashMap.Entry<String, List<Integer>> entry : zone.entrySet())  
                System.out.println(String.format("%25s %25s %25s",entry.getKey(),entry.getValue().get(0),entry.getValue().get(1)));
        }
        else
            System.out.println("Animal are not in this zone");
        return zoneName;
    }  
    
    /**
     * this function use to show that zone contain canteen or not   
     * 
     * @param no parameter        
     * @return boolean value
     */
    public boolean hasCanteen(){
        return true;
    }
    
    /**
     * this function use to show that zone contain park or not   
     * 
     * @param no parameter        
     * @return boolean value
     */
    public boolean hasPark(){
        return true;
    }
}

class ZoneFive implements Zone{
    public final String zoneCategory = "Bird";
    public int cageNumber = 6;
    private int numberOfAnimal = 3;
    public String zoneName = "Zone 5";
    
    protected HashMap<String, List<Integer>> zone = new HashMap<String, List<Integer>>(){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
        put("Owl", new ArrayList<Integer>(Arrays.asList(1, 2)));
        put("Parrot", new ArrayList<Integer>(Arrays.asList(1, 2)));
        put("Peacock", new ArrayList<Integer>(Arrays.asList(1, 2)));
        }};
    
    //single object for class ZoneFive    
    public static ZoneFive zo = new ZoneFive();

    public ZoneFive() {}

    /**
     * this function use to return single object   
     * 
     * @param no parameter        
     * @return ZoneFive object
     */
    public static ZoneFive getInstance() {
        return zo;
    }
    
    public void removedAnimal(String type){
    	zone.put(type, new ArrayList<Integer>(Arrays.asList((zone.get(type).get(0)-1),(zone.get(type).get(1)))));
    	this.numberOfAnimal--;
    }
        
    /**
     * this function use to return the zone name   
     * 
     * @param  type the first {@code string}        
     * @return String value
     */
    public String set(String type)throws IOException{
        boolean flag = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        if(zone.containsKey(type)){
            if(zone.get(type).get(0) == zone.get(type).get(1)){
                System.out.println("Space of cages are full in Zone One\n "
                        + "You want to - \n 1) Add cage\n 2) Move Zone Five\n "
                        + "3) Exit\n");
                do{
                    switch(Integer.parseInt(br.readLine())){
                    case 1 :
                        zone.put(type, new ArrayList<Integer>(Arrays.asList((zone.get(type).get(0)),(zone.get(type).get(1)+1))));
                        System.out.println((zone.get(type).get(0))+" "+(zone.get(type).get(1)));
                        this.cageNumber += 1;
                        flag = false;
                        break;
                    case 2 :
                        ZoneFour z4 = ZoneFour.getInstance();
                        return z4.set(type);
                    case 3 : 
                        System.exit(0);
                        break;
                    default :
                        System.out.println("Wrong input... try again\n"
                                + "Enter");
                    }
                }while(flag);
                this.numberOfAnimal += 1; 
            }
            zone.put(type, new ArrayList<Integer>(Arrays.asList(zone.get(type).get(0)+ 1,zone.get(type).get(1))));
            System.out.println(this.numberOfAnimal);
            System.out.println(String.format("%25s %25s %25s","Type of animal","Number of animal", "number of cage" ));
            for (HashMap.Entry<String, List<Integer>> entry : zone.entrySet())  
                System.out.println(String.format("%25s %25s %25s",entry.getKey(),entry.getValue().get(0),entry.getValue().get(1)));
        }
        else
            System.out.println("Animal are not in this zone");
        return zoneName;
    } 
    
    /**
     * this function use to show that zone contain canteen or not   
     * 
     * @param no parameter        
     * @return boolean value
     */
    public boolean hasCanteen(){
        return true;
    }
    
    /**
     * this function use to show that zone contain park or not   
     * 
     * @param no parameter        
     * @return boolean value
     */
    public boolean hasPark(){
        return true;
    }
}