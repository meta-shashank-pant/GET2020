import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Main {
    static int countID;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;

        do{
        System.out.print("Main menu : \n1) Add Animal \n2) Delete Animal "
                + "\n3) Show Zoo Stats \n4) Exit\n");

            System.out.print("Select Your Option : ");
            switch (Integer.parseInt(br.readLine())) {
            case 1:
                addition();
                break;
            case 2:
                delete();
                break;
            case 3:
                showStatus();
                break;
            case 4:
                flag = false;
                break;    
            default:
                System.out.println("Wrong input.... Try again");
            }
        }while(flag);
    }
    
    /**
     * this function show the data of animal   
     * 
     * @param no parameter       
     * @return no return type
     */
    public static void showStatus()throws Exception{
        boolean flag = true;
        int temp1;
        System.out.println("Show status of : \n 1) Mammal \n 2) Reptile \n "
                + "3) Bird \n 4) Go Back");
        do{
            System.out.println("Select your option : ");
            temp1 = Integer.parseInt(br.readLine());
            System.out.println("ZOO MANAGEMENT SYSTEM");
            
            switch(temp1){
            case 1 : 
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("MAMMAL : \tName\t\tAge\t\tWeight\t\tType\t\tZone");
                System.out.println("-------------------------------------------------------------------------------");
                Animal.printData("Mammal");
                break;
                
            case 2 : 
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("REPTILE : \tName\t\tAge\t\tWeight\t\tType\t\tZone");
                System.out.println("-------------------------------------------------------------------------------");
                Animal.printData("Reptile");
                break;

            case 3 : 
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("BIRD : \tName\t\tAge\t\tWeight\t\tType\t\tZone");
                System.out.println("-------------------------------------------------------------------------------");
                Animal.printData("Bird");
                break;
            case 4:
            	flag = false;
            	break;
            default :
                System.out.println("Wrong input.... try again");
            }
        }while(flag);
    }
    
    /**
     * this function use to delete animal data   
     * 
     * @param no parameter       
     * @return no return type
     */
    public static void delete() throws NumberFormatException{
        boolean flag = true, isDeleted;
        String animalCategory, id;
        
        System.out.println("Show status of : \n 1) Mammal \n 2) Reptile \n "
                + "3) Bird \n 4) Exit");
        do{
            System.out.println("Select your option : ");
            
            //select file name
            try {
				switch (Integer.parseInt(br.readLine())) {
				case 1: 
					animalCategory = "Mammal";
					Animal.printData(animalCategory);
					System.out.print("Enter animal id: ");
					id = br.readLine();
					isDeleted = Animal.deleteData(animalCategory, id);
					if(isDeleted)
						System.out.println("Successfully Removal!!!");
					else
						System.out.println("Animal not found!!!");
				    flag = false;
				    break;

				case 2:
					animalCategory = "Reptile";
					Animal.printData(animalCategory);
					System.out.print("Enter animal id: ");
					id = br.readLine();
					isDeleted = Animal.deleteData(animalCategory, id);
					if(isDeleted)
						System.out.println("Successfully Removal!!!");
					else
						System.out.println("Animal not found!!!");
				    flag = false;
				    break;

				case 3:
				    animalCategory = "Bird";
					Animal.printData(animalCategory);
					System.out.print("Enter animal id: ");
					id = br.readLine();
					isDeleted = Animal.deleteData(animalCategory, id);
					if(isDeleted)
						System.out.println("Successfully Removal!!!");
					else
						System.out.println("Animal not found!!!");
				    flag = false;
				    break;
				case 4:
				    System.exit(0);
				default:
				    System.out.println("Wrong input.... try again");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }while(flag);
    }

    /**
     * take name of animal   
     * 
     * @param no parameter       
     * @return String value
     */
    public static String name() throws IOException {
        System.out.print("Enter name of animal : ");
        return br.readLine();
    }

    /**
     * take age of animal   
     * 
     * @param no parameter       
     * @return int value
     */
    public static int age() throws IOException {
        do {
            try {
                System.out.print("Enter age of animal : ");
                return Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Number Format Exception " + e.getMessage());
            }
        } while (true);
    }

    /**
     * take weight of animal   
     * 
     * @param no parameter       
     * @return int value
     */
    public static int weight() throws IOException {
        do {
            try {
                System.out.print("Enter weight of animal : ");
                return Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Number Format Exception " + e.getMessage());
            }
        } while (true);
    }

    /**
     * give random ID of animal   
     * 
     * @param no parameter       
     * @return String value
     */
    public static String id(String animalCatagory, String animalType) {
        Random random = new Random(); 
        return animalCatagory + animalType + random.nextInt(1000);
    }
    
    /**
     * check zone have space to add animal or not  
     * 
     * @param animalCatagory is the first {@code String}
     * @param type is the first {@code String}
     * 
     * @return String value
     */
    public static String zone(String animalCatagory, String type) throws IOException{
        int serialNumber = 0;

        //contain zone list
        List<String> list = new ArrayList<String>();
        
        //in this hashmap string contain category and list<String> contain zone
        for(HashMap.Entry<String, List<String>> entry : Zone.zoo.entrySet()){
            if(animalCatagory.equalsIgnoreCase(entry.getKey())){
                for(String s : entry.getValue()){
                    serialNumber++;
                    System.out.println(String.format("%-5s%-10s",serialNumber,s));
                    list.add(s);
                }
                do {
                    try {

                        String s = list
                                .get(Integer.parseInt(br.readLine()) - 1);
                        switch (s.charAt(s.length() - 1)) {
                        case '1':
                            ZoneOne z1 = ZoneOne.getInstance();
                            return z1.set(type);
                            
                        case '2':
                            ZoneTwo z2 = ZoneTwo.getInstance();
                            return z2.set(type);
                            
                        case '3':
                            ZoneThird z3 = ZoneThird.getInstance();
                            return z3.set(type);
                            
                        case '4':
                            ZoneFour z4 = ZoneFour.getInstance();
                            return z4.set(type);
                            
                        case '5':
                            ZoneFive z5 = ZoneFive.getInstance();
                            return z5.set(type);
                            
                        default:
                            System.out.println("Wrong input.. try again");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Number Format Exception "
                                + e.getMessage());
                    }
                } while (true);
            }
        }
        return null;
    }
   
    /**
     * this function use to create mammal category animal object 
     * 
     * @param no parameter
     * @return no return value
     * @throws Exception 
     * @throws IOException 
     */
    public static void selectMammal() throws NumberFormatException {

        boolean flag = true;

        System.out.print("Select animal type : \n1) Lion "
                + "\n2) Bear \n3) Tiger\n");
        do {
            System.out.print("Select Your Option : ");
            try {
				switch (Integer.parseInt(br.readLine())) {
				case 1:
				    new Lion(name(), age(), weight(), "Lion", zone("Mammal", "Lion"), id("M", "Lion"));
				    flag = false;
				    break;
				case 2:
				    new Bear(name(), age(), weight(), "Bear", zone("Mammal", "Bear"), id("M", "Bear"));
				    flag = false;
				    break;
				case 3:
				    new Tiger(name(), age(), weight(), "Tiger", zone("Mammal", "Tiger"), id("M", "Tiger"));
				    flag = false;
				    break;
				default:
				    System.out.println("Wrong input.... Try again");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } while (flag);
    }
    
    /**
     * this function use to create reptile category animal object 
     * 
     * @param no parameter
     * @return no return value
     */
    public static void selectReptile() throws Exception {

        boolean flag = true;

        System.out.print("Select animal type : \n1) Crocodiles "
                + "\n2) Alligators \n3) Lizards\n");
        do {
            System.out.print("Select Your Option : ");
            switch (Integer.parseInt(br.readLine())) {
            case 1:
                new Crocodiles(name(), age(), weight(), "Crocodiles", zone("Reptile", "Crocodiles"), id("R", "Crocodiles"));
                flag = false;
                break;
            case 2:
                new Alligators(name(), age(), weight(), "Alligators", zone("Reptile", "Alligators"), id("R", "Alligators"));
                flag = false;
                break;
            case 3:
                new Lizards(name(), age(), weight(), "Lizards", zone("Reptile", "Lizards"), id("R", "Lizards"));
                flag = false;
                break;
            default:
                System.out.println("Wrong input.... Try again");
            }
        } while (flag);
    }
    
    /**
     * this function use to create bird category animal object 
     * 
     * @param no parameter
     * @return no return value
     */
    public static void selectBird() throws Exception {

        boolean flag = true;

        System.out.print("Select animal type : \n1) Owl "
                + "\n2) Alligators \n3) Lizards\n");
        do {
            System.out.print("Select Your Option : ");
            switch (Integer.parseInt(br.readLine())) {
            case 1:
                new Owl(name(), age(), weight(), "Owl", zone("Bird", "Owl"), id("B", "Owl"));
                flag = false;
                break;
            case 2:
                new Parrot(name(), age(), weight(), "Parrot", zone("Bird", "Parrot"), id("B", "Parrot"));
                flag = false;
                break;
            case 3:
                new Peacock(name(), age(), weight(), "Peacock", zone("Bird", "Peacock"), id("B", "Peacock"));
                flag = false;
                break;
            default:
                System.out.println("Wrong input.... Try again");
            }
        } while (flag);
    }
    
    /**
     * this function use to select which type of category select 
     * 
     * @param no parameter
     * @return String value
     */
    public static void addition()throws NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;

        System.out.println("Select animal type : \n1) Mammal "
                + "\n2) Reptile \n3) Bird");
        do {
            System.out.print("Select Your Option : ");
            try {
				switch (Integer.parseInt(br.readLine())) {
				case 1:
				    selectMammal();
				    flag = false;
				    break;
				case 2:
				    selectReptile();
				    flag = false;
				    break;
				case 3:
				    selectBird();
				    flag = false;
				    break;
				default:
				    System.out.println("Wrong input.... Try again");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } while (flag);
    }
}
