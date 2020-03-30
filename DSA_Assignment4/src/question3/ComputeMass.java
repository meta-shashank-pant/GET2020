package question3;

import java.util.HashMap;

public class ComputeMass {
	private HashMap<Character, Integer> mass = new HashMap<>();
	private int totalMass = 0, current_index = 0;
	//constructor
	public ComputeMass() {
		// TODO Auto-generated constructor stub
		mass.put('C', 12);
		mass.put('H', 1);
		mass.put('O', 16);
	}
	
	public int getMass(String compound, int index) {
		int total = 0;
		if(index == compound.length())
			return 0;
		else{
			for(int i = index; i < compound.length(); i++){
				current_index = i;
				if(compound.charAt(i) == 'C' || compound.charAt(i) == 'H' || compound.charAt(i) == 'O'){
					// if numeric multiplier lies after the element and not after the bracket.
					if((i+1) < compound.length() && (compound.charAt(i+1) >= 49 && compound.charAt(i+1) <= 57)){
						total += mass.get(compound.charAt(i)) * (compound.charAt(i+1) - 48);
						i += 1;
					}
					else
						total += mass.get(compound.charAt(i));
					//System.out.println("Current element: "+compound.charAt(i)+" total mass: "+total);
				}else if(compound.charAt(i) == '('){
					int tmp = getMass(compound,i+1);
					System.out.println("Mass of inner bracket element is "+tmp);
					total += tmp;
					i = current_index+1;
				}else if(compound.charAt(i) == ')'){
					if(compound.charAt(i+1) >= 49 && compound.charAt(i+1) <= 57){
						return total * (compound.charAt(i+1) - 48);
					}else
						return total;
				}
					
			}
		}
		
		return total;
	}
}
