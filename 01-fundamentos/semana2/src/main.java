import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero de la serie:");
        int serie = sc.nextInt();
        System.out.println("Ingrese el numero de la serie:");
        int serie2 = sc.nextInt();
        if (serie == serie2) {
        	System.out.println("El numero de la serie es igual");
        } else {
        	System.out.println("El numero de la serie es distinto");
        }
	}

}