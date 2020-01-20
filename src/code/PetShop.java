package codein;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PetShop {
	private static String name;
	private static String address;
	private boolean isHasCustom;
	private static HashMap<Pet,Integer> pets;
	
	static{
		name = "Come Again";
		address = "Mianyang city, sichuan province";
		System.out.println("---------"+name+"PetShop¡ª¡ª"+address);
		Cat boSiCat = new Cat("001","Persian",0,3,"");
		Cat coffeCat = new Cat("002","Garfield",0,2,"");
		Dog haShiqi =  new Dog("003","Husky",0,2,"");
		Dog tianYuanQuan =  new Dog("004","Chinese garden dog",0,4,"");
		pets = new HashMap<Pet,Integer>();
		pets.put(boSiCat, boSiCat.getNum());
		pets.put(coffeCat,coffeCat.getNum());
		pets.put(haShiqi, haShiqi.getNum());
		pets.put(tianYuanQuan,tianYuanQuan.getNum());
	}
	
	public PetShop(String name, String address) {
		super();
		this.isHasCustom = false;
	}
	public PetShop() {
		this.isHasCustom = false;
	}
	/**
	 * Show pet
	 */
	public void showAllPet() {
		System.out.println("No. \t Type \t number");
		Set<Map.Entry<Pet,Integer>> entry = pets.entrySet();
		Iterator it = entry.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public Pet getPetById(String id) {
		if(id != null) {
			for(Pet p:pets.keySet()) {
				if(p.getId().equals(id)) {
					return p;
				}
			}
		}
		return null;
	}
	
	/**
	 * Pet store stock
	 */
	public boolean purchasePets(Pet pet) {
		Set<Map.Entry<Pet, Integer>> entry = pets.entrySet();
		Iterator it = entry.iterator();
		while(it.hasNext()) {
			if(it.next().equals(pet)) {
				pets.put(pet, pets.get(pet)+pet.getNum());
				return true;
			}
		}
		pets.put(pet, pet.getNum());
		return true;
	}
	/**
	 * 	Add pet
	 */
	public boolean addPetToShop(Pet pet) {
		if(pet == null)
			return false;
		if(pets.containsKey(pet)) {
			pets.put(pet, pets.get(pet)+pet.getNum());
			return true;
		}else {
			pets.put(pet, pet.getNum());
			return true;
		}
	}
	
	/**
	 * Selling pet
	 */
	public boolean removePetFromShop(Pet pet) {
		if(pet == null)
			return false;
		for(Pet p:pets.keySet()) {
			if(p.equals(pet) && pets.get(p) == pet.getNum()) {
				pets.remove(p);
				return true;
			}
			if(p.equals(pet) && pets.get(p) > pet.getNum()) {
				pets.put(pet, pets.get(p) - pet.getNum());
				return true;
			}
			if(p.equals(pet) && pets.get(p) < pet.getNum()) {
				return false;
			}
		}	
		return false;
	}
 
	/**
	 * Determine if customers are coming
	 * @return
	 */
	public boolean isHasCustom() {
		return isHasCustom;
	}
	
	public void setHasCustom(boolean isHasCustom) {
		this.isHasCustom = isHasCustom;
	}
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public String getAddress() {
		return address;
	}
 
	public void setAddress(String address) {
		this.address = address;
	}
	
	public HashMap<Pet,Integer> getPets() {
		return pets;
	}
}
