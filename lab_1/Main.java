package Lab1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Hero hero = new Hero("Mario");
        Hero hero = new Hero();

        System.out.println("Hero name : " + hero.getName());
        System.out.println("Start Point №1");
        System.out.println(hero.getName() + " is going on a journey, specify the method of movement:");
        System.out.println("Press 'f' for fly, 'w' for walk, 'r' for ride a horse, 'm' for moving, any key for exit");

        Scanner scanner = new Scanner(System.in);
        char selectChar;

        boolean nPoint = true;

        while (true) {
            selectChar = scanner.next().charAt(0);
            switch (selectChar){
                case 'm':
                    if (hero.getMovement()==null){
                        System.out.println("Specify the method of movement, please");
                        continue;
                    }
                    break;
                case 'f':
                    hero.setMovement(new Fly());
                    break;
                case 'w':
                    hero.setMovement(new Walk());
                    break;
                case 'r':
                    hero.setMovement(new RideHorse());
                    break;
                default:
                    System.out.println("The end of the journey");
                    scanner.close();
                    return;
            }
            System.out.println("Course to point №" + (nPoint ? 2 : 1));
            nPoint = !(nPoint);
            hero.move();
        }
    }
}