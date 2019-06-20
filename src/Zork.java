

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Zork {
    //Variables
    private static boolean ghost = false;
    private static int userCoins = 0;
    private static int[] coins = {5,12,3,4,5,6,7,8};
    private static boolean [] item = {false,false,false,false,false,false,false,false};
    private static int direction = 1;
    private static boolean mystery = false;
    private static boolean play = true;
    private static int roomCount = 0;
    private static boolean found1 = false;
    private static boolean found2 = false;
    private static boolean found3 = false;
    private static boolean found4 = false;
    private static boolean found5 = false;
    private static boolean found6 = false;
    private static boolean found7 = false;
    private static boolean found8 = false;

    //Tools
    private static Scanner scan = new Scanner(System.in);
    private static Random rand = new Random();

    public static void main(String[]args) {

        //Game
    while(play) {
        switch (direction) {
            case 1:
                room1();
                break;
            case 2:
                room2();
                break;
            case 3:
                room3();
                break;
            case 4:
                room4();
                break;
            case 5:
                room5();
                break;
            case 6:
                room6();
                break;
            case 7:
                room7();
                break;
            case 8:
                room8();
                break;
            case 10:
                quit();
                break;
        }
    }

        }










       private static void room1(){
           if (!found1) {
               roomCount++;
           }
           found1 = true;
           System.out.println("You are standing in the foyer of an old house.\nYou see a dead scorpion.");

           //Coin Pickup
           if (coins[0] > 0) {
               System.out.printf("There are %d coins in this room! Would you like to pick them up? (Y/N) ", coins[0]);
               if (scan.nextLine().charAt(0) == 'y') {
                   userCoins += coins[0];
                   coins[0] = 0;
               }
           }
           //items[0] = "Dead scorpion";
           System.out.println("Exit 'n'orth to the 'front room'. \nExit the Game (Q).");

           String input= scan.nextLine().toLowerCase();
           if(input.equals("n") || input.equals("front room")){
               direction = 2;
           }
           //Spice this up
           else if(input.equals("q")){
               direction = 10;
               System.out.println("You were actually dead the whole time. Game has ended.");
           }


       }









       private static void room2(){
           if (!found2) {
               roomCount++;
           }
           found2 = true;


           System.out.println("You are standing in the front room.\nYou see a piano.");
           if (coins[1] > 0) {
               System.out.printf("There are %d coins in this room! Would you like to pick them up? (Y/N) ", coins[1]);
               if (scan.nextLine().charAt(0) == 'y') {
                   userCoins += coins[1];
                   coins[1] = 0;
               }
           }
           //items[1] = "Piano";

           while(true){
           System.out.println("Exit 'w'est to the 'library'. \nExit 'e'ast to the 'kitchen'. \nExit 's'outh to the 'foyer'. \nExit the Game (Q).");
           String input = scan.nextLine().toLowerCase();
           if(input.equals("w") || input.equals("library")){
               direction = 3;
               break;
           }
           else if(input.equals("e") || input.equals("kitchen")){
               direction = 4;
               break;
           }
           else if(input.equals("s") || input.equals("foyer")){
               direction = 1;
               break;
           }
           else if(input.equals("q")){
               System.out.println("You were actually dead the whole time. Game has ended.");
               direction =10;
               break;
           }else{
               System.out.println("That is not an option.");


       }}}
       private static void room3(){

           if (!found3) {
               roomCount++;
           }
           found3 = true;
           System.out.println("You are standing in a library.\nYou see spiders crawling on the bookshelves.");
           if (coins[2] > 0) {
               System.out.printf("There are %d coins in this room! Would you like to pick them up? (Y/N) ", coins[2]);
               if (scan.nextLine().charAt(0) == 'y') {
                   userCoins += coins[2];
                   coins[2] = 0;
               }
           }


           while(true){
           System.out.println("Exit 'e'ast to the 'front room'. \nExit 'n'orth to the 'dining room'. \nExit the Game (Q).");
           String input = scan.nextLine().toLowerCase();

           if(input.equals("e") || input.equals("front room")){
               direction = 2;
               break;
           }
           else if(input.equals("n") || input.equals("dining room")){
               direction = 5;
               break;
           }
           //Spice this up
           else if(input.equals("q")){
               System.out.println("You were actually dead the whole time. Game has ended.");
               direction = 10;
               break;
           }
           else{
               System.out.println("That is not an option");

       }}}
       private static void room4(){

            //Intro
            System.out.println("You enter the Kitchen");
            if(!item[3]){
            System.out.println("There are Bats flying all around!");}
            else{
                System.out.println("There are bat droppings everywhere...");
            }
            System.out.println("There is a door to the (W)est, and a door to the (N)orth");


            //Room count
            if (!found4) {
                roomCount++;
            }
            found4 = true;

            //Response
           while(true) {
               System.out.println("\nWhat would you like to do?");
               String input = scan.nextLine();
               if (input.equalsIgnoreCase("w")) {
                   direction = 2;
                   break;
               }
               if (input.equalsIgnoreCase("n")) {
                   direction = 7;
                   break;
               }
               if (input.equalsIgnoreCase("q")) {
                   System.out.println("You were actually dead the whole time. Game has ended.");
                   direction = 10;
                   break;

               }
               if(input.equalsIgnoreCase("catch bat") && !item[3]){
                   item[3] = true;
                   int bat = rand.nextInt(20);
                   System.out.println("You grab the bat and it drops "+ bat + " coins!");
                   System.out.println("All the bats seem to dissapear somewhere...");
               }
               else{
                   System.out.println("That is not an option.");

               }
           }
        }
        private static void room5 () {

            //Intro
            System.out.println("You enter the Dining Room");
            System.out.println("The room is very dusty.");
            if(!item[4]) {
                System.out.println("There is a large box on the table.");
            }else {
                System.out.println("There is a large empty box on the table");
            }
            System.out.println("There is a door to the (S)outh");

            //Room count
            if (!found5) {
                roomCount++;
            }
            found5 = true;

            //Response
            while (true){
                System.out.println("What would you like to do?");
            String input = scan.nextLine();
            if (input.equalsIgnoreCase("s")) {
                direction = 3;
                break;
            }
            if (input.equalsIgnoreCase("q")) {
                System.out.println("You were actually dead the whole time. Game has ended.");
                quit();
                break;

            }
            if(input. equalsIgnoreCase("open box")) {
                item[4]= true;
                int box = rand.nextInt(25);
                if (box <5) {
                    userCoins -= box;
                    System.out.println("You accidently drop " + box + " coins trying to open the empty box");
                } else {
                    userCoins += box;
                    System.out.println("You found " + box + " coins in the box");
                }
            }
            else{
                System.out.println("That is not an option.");

            }}
        }


        private static void room6 () {

            //Intro
            System.out.println("You enter the Vault");
            System.out.println("There are 3 Spooky Skeletons walking around");

            //Room Count
            if (!found6) {
                roomCount++;
            }
            found6 = true;

            //Secret Room Chance

            int secret = rand.nextInt(4);
            if (secret == 0 || mystery) {
                System.out.println("There is a door to the (E)ast");
                System.out.println("A (S)trange hole appears on the East wall");
                mystery = true;
            } else {
                System.out.println("There is a door to the (E)ast");
            }

            //Response

            while (true) {
                System.out.println("What would you like to do?");
                String input = scan.nextLine();
                if (input.equalsIgnoreCase("e")) {
                    direction = 7;
                    break;
                }
                if (input.equalsIgnoreCase("s") && (mystery)) {
                    direction = 8;
                    break;
                }
                if(input.equalsIgnoreCase("q")){
                    System.out.println("You were actually dead the whole time. Game has ended.");
                    direction = 10;
                    break;
                }
                else{
                    System.out.println("That is not an option.");
                }
            }
        }
        private static void room7(){

            System.out.println("You find yourself entering the old parlor. \nThere is a treasure chest in the middle of the room. \n");
            if (coins[6] > 0) {
                System.out.printf("There are %d coins in this room! Would you like to pick them up? (Y/N) ", coins[6]);
                if (scan.nextLine().charAt(0) == 'y') {
                    userCoins += coins[6];
                    coins[6] = 0;
                }
            }
            //item[6] = "Treasure chest";
            while(true) {
                System.out.println("Exit 'w'est to the 'vault'. \nExit 's'outh to the 'kitchen'. \nExit the Game (Q).");

                String input = scan.nextLine().toLowerCase();

                if (input.equals("s") || input.equals("kitchen")) {
                    direction = 4;
                    break;
                }if (input.equals("w") || input.equals("vault")) {
                    direction = 6;
                    break;
                }else{
                    System.out.println("That is not an option");
                }

            }

//            if (!found7) {
//                roomCount++;
//            }
//            found7 = true;
//
//            System.out.println("You have entered the parlor");
//            if(!item[6]){
//                System.out.println("There is a large Chest in the center of the room");
//            }
//            System.out.println("what would you like to do?");
//            String input =scan.nextLine();

        }
        private static void room8(){
            if (!found8) {
                roomCount++;
            }
            found8 = true;


            System.out.println("Where would you like to go?");
            direction = scan.nextInt();
            scan.nextLine();
        }
        private static void quit(){
            System.out.println("You found " + roomCount + " rooms.");
            System.out.println("you found coins " + userCoins);
            System.out.println("");

            //Decide if haunted
            int haunt = rand.nextInt(4);
            if(haunt ==0){
                ghost= true;
            }

            //Replay game
            System.out.println("Would you like to play again?");
            String reDo =scan.nextLine();
            if(reDo.equalsIgnoreCase("yes")){
                 userCoins = 0;
                 String dir;
                // coins = {1,2,3,4,5,6,7,8};
                 direction = 1;
                 mystery = false;
                 play = true;
                 roomCount = 0;
                 found1 = false;
                 found2 = false;
                 found3 = false;
                 found4 = false;
                 found5 = false;
                 found6 = false;
                 found7 = false;
                 found8 = false;

        }else { play = false;
                System.out.println("Goodbye.  Thank you for playing.");}

                //Haunting message
                if(!ghost){
                    System.out.println("There is a Spooky ghost folloing you....  Beware");
                }
    }
}
