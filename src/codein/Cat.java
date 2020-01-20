package codein;

public class Cat extends Pet{
	private String name;
	public Cat() {
	}
	
	public Cat(String id,String strain,int loveNum,int num,String name) {
		super(id,strain,loveNum,num);
		this.name = name;
	}
	
	@Override
	public void eat() {
		System.out.println("Cat"+name + ":is full, add 5 to LoveNum!");
		this.setLoveNum(this.getLoveNum()+3);
	}
 
	@Override
	public void play() {
		System.out.println("Cat"+name+":have fun, add 5 to LoveNum!");
		this.setLoveNum(this.getLoveNum()+5);
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
}
