package codein;

public class Dog extends Pet {
	private String name;
	public Dog() {
 
	}
	
	public Dog(String id,String strain,int loveNum,int num,String name) {
		super(id,strain,loveNum,num);
		this.name = name;
	}
	
	@Override
	public void eat() {
		System.out.println("Dog"+name + ":is full, add 5 to LoveNum!");
		this.setLoveNum(this.getLoveNum()+5);
	}
	
	public void play() {
		System.out.println("Dog"+name+":have fun, add 10 to LoveNum!");
		this.setLoveNum(this.getLoveNum()+10);
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
}
