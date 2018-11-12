/* This class must instantiate a Grid object and use its methods to let the player pick a game grid,
update the game grid according to player input, print a feedback grid for the player, and check if
the player has sunk all the ships. See the Sample I/O in the assignment brief for details on what you
you should print to the console */

import java.util.Scanner;


public class Battleship {
    public static void main(String[] args) {

        int shots = 12;
        int tries = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Pick your grid (1-4):");
        int seed = scan.nextInt();
        Grid choice = new Grid(seed);
        System.out.println("The battle begins!");

        while (shots > 0 && choice.checkGrid()) {
            System.out.println("You have " + shots + " shots remaining.");
            System.out.println("choose your square:");

            String ab = scan.next();

            int x = Character.getNumericValue(ab.charAt(0));
            int y = Character.getNumericValue(ab.charAt(1));

            choice.checkGrid();
            --shots;
            tries++;


            String outcome = choice.fire(x, y);
            System.out.println(outcome);
            choice.fire(x, y);
            choice.printGrid();


        }
        if (shots == 0) {
            System.out.println("You're out of ammunition! Game Over!");

        }else {
            System.out.println("You won! and in only "+tries+" shots!");
        }
    }
}

