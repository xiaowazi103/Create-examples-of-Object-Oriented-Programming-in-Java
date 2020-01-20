package codein;

import java.util.ArrayList;
import java.util.List;

public class Master {
	private String name;
	List<Pet> myPets;
	
	public Master() {
		myPets = new ArrayList<Pet>();
	}
	
	public Master(String name) {
		myPets = new ArrayList<Pet>();
		this.name = name;
	}
	
	public boolean goPetShop(PetShop shop) {
		shop.setHasCustom(true);
		return true;
	}
	
	public void scanPet(PetShop shop) {
		if(goPetShop(shop)) {
			shop.showAllPet();
		}else {
			System.out.println("Temporarily unable to view pets!");
		}
	}

	public void outShop(PetShop shop) {
		shop.setHasCustom(false);
	}
	
	public  boolean updateMyPets(Pet pet) {
		for(int i = 0;i < myPets.size();i++) {
			if(myPets.get(i).equals(pet)) {
				myPets.get(i).setName(pet.getName());
				myPets.get(i).setNum(pet.getNum());
				myPets.get(i).setLoveNum(pet.getLoveNum());
				return true;
			}
		}
		return false;
	}

	public boolean setNameToPet(Pet pet,String name) {
		if(pet != null && name != null) { 
			pet = getPetStrain(pet);
			pet.setName(name);
			pet.setLoveNum(50);
			updateMyPets(pet);
			return true;
			}
		return false;
	}

	public boolean buyPet(Pet pet,PetShop shop) {
		if(pet != null) {
			pet.setNum(1);
			myPets.add(pet);
			shop.removePetFromShop(pet);
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Feeding
	 */
	public boolean feedPet(Pet pet) {
		if(pet!= null) {
			 getPetStrain(pet).eat();
			 return true;
		}
		return false;
	}
	
	//Paly with pet
	public boolean playWithPet(Pet pet) {
		if(pet!= null) {
			 getPetStrain(pet).play();
			 return true;
		}
		return false;
	}
	//View the pet information you have
	public boolean scanMyPets() {
		if(myPets.size()==0) {
			return false;
		}
		System.out.println("id \t type \t name \t LoveNum");
		for(Pet p:myPets) {
			System.out.print(p.getId()+"\t"+p.getStrain()+"\t"+p.getName()+"\t"+p.getLoveNum()+"\n");
		}
		return true;
	}
	
	//View a pet's intimacy value
	public void loveNumWithPet(String name) {
		Pet pet = getMyPetByName(name);
		System.out.println(pet.getName() + ": our LoveNum is"+pet.getLoveNum());
	}
	
	//Find pets by name
	public Pet getMyPetByName(String petName) {
		for(Pet pet:myPets) {
			if(pet.getName().equals(petName)) {
				return pet;
			}
		}
		return null;
	}
	
	public Pet getPetStrain(Pet pet) {
		if(pet.getStrain().equals("Persian")||pet.getStrain().equals("Garfield")) {
			return((Cat)(pet));
		}
		if(pet.getStrain().equals("Husky")||pet.getStrain().equals("Chinese garden dog")) {
			return((Dog)(pet));
		}
		return  null;
	}
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public List<Pet> getMyPets() {
		return myPets;
	}
 
	public void setMyPets(List<Pet> myPets) {
		this.myPets = myPets;
	}
}
