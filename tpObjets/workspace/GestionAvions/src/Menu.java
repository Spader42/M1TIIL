import java.util.Scanner;


public class Menu {
	Menu(){
		
	}
	
	void start(){
		while(true){
			System.out.println("----------Gestion client----------");
			System.out.println("1 - Ajouter   client");
			System.out.println("2 - Supprimer client");
			System.out.println("3 - Afficher  client");
			@SuppressWarnings("resource")
			Scanner keyboard = new Scanner(System.in);
			String line;	
			line = keyboard.nextLine();
			int x = Integer.parseInt(line);
			switch(x){
			case 1:
				
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				break;	
			}
		}
	}
}
