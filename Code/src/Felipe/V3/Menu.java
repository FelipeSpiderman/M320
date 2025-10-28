package Felipe.V3;

import java.util.ArrayList;
import java.util.Scanner;

class Menu {
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> characters = new ArrayList<>();

        System.out.println("How many characters would you like to create? ");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.println("Choose character " + (i + 1) + " (1: Warrior, 2: Rogue): ");
            int characterChoice = scanner.nextInt();
            Character c = (characterChoice == 1) ? new Warrior() : new Rogue();
            characters.add(c);

            System.out.println("Choose weapon for " + (i + 1) + " (1: Axe, 2: DaggerRogue, 3: DaggerWarrior): ");
            int weaponChoice = scanner.nextInt();
            switch (weaponChoice) {
                case 1: c.setWeaponBehavior(new AxtKrieger()); break;
                case 2: c.setWeaponBehavior(new DolchMagier()); break;
                case 3: c.setWeaponBehavior(new DolchKrieger()); break;
                default: System.out.println("Ungültige Wahl!");
            }
        }

        System.out.println("Selected characters and weapons:");
        for (Character c : characters) {
            c.fight();
        }   

        scanner.close();
    }
}
