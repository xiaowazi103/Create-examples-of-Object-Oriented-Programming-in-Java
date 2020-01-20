package codein;

import java.util.Scanner;

public class Test {
	private static Scanner sc = new Scanner(System.in);// 实例化一个输入流对象
	 
	public static void main(String[] args) {
		PetShop shop = new PetShop();
		Master master = new Master("Mike");
		Pet pet = null;
		
		int circleNum = 0;
		int choiceNum = -1;
		String petId = "";
		while(choiceNum == -1) {
			circleNum++;
			if(circleNum == 1) {
				System.out.println("**Pet store stock**");
				new Pet();
			}
			System.out.println("choose：1、stock\t2、exit");
			choiceNum  = sc.nextInt();
			if(choiceNum == 1) {
				System.out.println("Please enter the id and number of pets to purchase");
				pet = Pet.givePetToShop(sc.next(), sc.nextInt());
				if(pet != null) {
					shop.addPetToShop(pet);
					System.out.println("Purchase success!");
					choiceNum = -1;
				}else {
					System.out.println("No such pets!");
					choiceNum = -1;
				}
			}else if(choiceNum == 2) {
				choiceNum = -2;
			}else {
				System.out.println("Incorrect input! Please choose again!");
			}
		}
        circleNum = 0;
		master.goPetShop(shop);
		while (shop.isHasCustom()) {
			circleNum++;
			if (circleNum == 1) {
				System.out.println(shop.getName() + ":welcome to" + master.getName());
			} else {
				System.out.println(shop.getName() + ":Please choose:1.Browse the pet\t2.Exit");
				choiceNum = sc.nextInt();
				if (choiceNum == 1) {
					master.scanPet(shop);
					System.out.println(shop.getName() + ":Please enter the serial number to select the pet you want:");
					petId = sc.next();
					pet = shop.getPetById(petId);
					if (pet == null) {
						System.out.println(shop.getName() + ":Please enter the correct number!");
					} else {
						System.out.println(shop.getName() + ":You select the" + pet + ",Have you confirmed the purchase?1.Confirm the purchase\t2.Think again");
						choiceNum = sc.nextInt();
						if (choiceNum == 1) {
							master.buyPet(pet, shop);
							System.out.println(shop.getName() + "Congratulations on your new pet!");
						}
					}
				} else if (choiceNum == 2) {
					master.outShop(shop);
					System.out.println(shop.getName() + ":Welcome to come again!");
					circleNum = 0;
				}
			}
		}
		System.out.println(master.getName()+ "left" + shop.getName() + "on the way home...");
		String petName = null;
		while (true) {
			circleNum++;
			if (circleNum == 1) {
				System.out.println(master.getName() + "Back to home");
				System.out.println(master.getName() + "Name your new pets!");
				for (Pet p : master.getMyPets()) {
					System.out.println("This pet is" + p.getStrain() + "And give him a name:");
					petName = sc.next();
					if (master.setNameToPet(pet, petName)) {
						System.out.println(pet.getName() + ": happy to have a new name! The LoveNum has increased" + pet.getLoveNum());
					}
				}
				System.out.println(master.getName() + ":All the pets have good names, they like me more!");
				System.out.println("Please choose operation :1. Play with pet \t2. Feed pet \t3. Get all pet information \t4. exit:");
				choiceNum = sc.nextInt();
			}
			if (choiceNum > 4 || choiceNum < 1) {
				System.out.println("Incorrect input!");
			} else {
				while (choiceNum == 1) {
					System.out.println(master.getName() + "Who will you play with first? Just call the roll:");
					pet = master.getMyPetByName(sc.next());
					master.playWithPet(pet);
					System.out.println("Please choose operation :1. Play with pet \t2. Feed pet \t3. Get all pet information \t4. exit:");
					choiceNum = sc.nextInt();
				}
				while (choiceNum == 2) {
					System.out.println(master.getName() + "Who will you play with first? Just call the roll:");
					pet = master.getMyPetByName(sc.next());
					master.feedPet(pet);
					System.out.println("Please choose operation :1. Play with pet \t2. Feed pet \t3. Get all pet information \t4. exit:");
					choiceNum = sc.nextInt();
				}
				while (choiceNum == 3) {
					master.scanMyPets();
					System.out.println("Please choose operation :1. Play with pet \t2. Feed pet \t3. Get all pet information \t4. exit:");
					choiceNum = sc.nextInt();
				}
				if (choiceNum == 4)
					break;
			}
		}
		System.out.println("Exit!");
	}
}
