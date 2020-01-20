package codein;

import java.util.ArrayList;
import java.util.List;

public class Pet {
	private String id;
	private String strain;
	private int loveNum;
	private int num;
	private String name;
	public static List<Pet> petSpecies;
 
	static {         
		petSpecies = new ArrayList<Pet>();
		petSpecies.add(new Pet("001","Persian",0,9999));
		petSpecies.add(new Pet("002","Garfield",0,9999));
		petSpecies.add(new Pet("003","Husky",0,9999));
		petSpecies.add(new Pet("004","Chinese garden dog",0,9999));
		petSpecies.add(new Pet("005","Chinese garden cat",0,9999));
		petSpecies.add(new Pet("006","Shepherd",0,9999));
		System.out.println("id \t type");
		for(Pet pet:petSpecies) {
			System.out.println(pet);
		}
	}
	
	public Pet(String id,String strain, int loveNum,int num) {
		this.strain = strain;
		this.id = id;
		this.loveNum = loveNum;
		this.num = num;
	}
 
	public Pet(){
	
	}
	
	public static Pet givePetToShop(String petId,int petNum) {
		Pet pet = null;
		for(Pet p:petSpecies) {
			if(p.getId().equals(petId)) {
				pet = p;
				pet.setNum(petNum);
				return pet;
			}
		}
		return pet;
	}
 
	public void eat() {
		System.out.println(strain+"eating happily");
	}
	
	@Override
	public String toString() {
		return this.id+"\t" + this.strain +"\t";
	}
	
	@Override
	public int hashCode() {
		return this.getId().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Pet) {
			Pet other  = (Pet)obj;
			if(this.getId().equals(other.getId())) {
				if(this.getStrain().equals(other.getStrain())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public int getNum() {
		return num;
	}
 
	public void setNum(int num) {
		this.num = num;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public String getId() {
		return id;
	}
 
	public void setId(String id) {
		this.id = id;
	}
 
	public String getStrain() {
		return strain;
	}
 
	public void setStrain(String strain) {
		this.strain = strain;
	}
 
	public int getLoveNum() {
		return loveNum;
	}
 
	public void setLoveNum(int loveNum) {
		this.loveNum = loveNum;
	}
 
	public void play() {
		System.out.println("The parent class's eat method is executed");
	}

}
