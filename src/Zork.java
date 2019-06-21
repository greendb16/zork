

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Zork {

    //Variables
    private static String input;
    private static boolean key =false;
    private static int spooky;
    private static int totalSecrets;
    private static boolean[] secrets = {false, false, false, false, false, false, false, false};
    private static int loot;
    private static boolean ghost = false;
    private static int userCoins = 0;
    private static int[] coins = {5, 12, 3, 4, 5, 6, 7, 8};
    private static boolean[] item = {false, false, false, false, false, false, false, false};
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

    public static void main(String[] args) {

        intro();

        //Game
        while (play) {
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

    private static void intro() {
        System.out.println("Find as much gold as you can before leaving the mansion.\nThere are plenty of secrets abound...\nAre you ready?(Y/N)");
        while (true) {
            input = scan.nextLine();
            if (input.equalsIgnoreCase("y")) {
                break;
            }
            if (input.equalsIgnoreCase("n")) {
                System.out.println("Lets try that again.....\nAre you ready? (Y/N)");
            }
            if (input.equalsIgnoreCase("secrets")) {
                System.out.println("Hint:  All Secrets are 2 word entries.\nAre you ready to start?(Y/N)");

            } else {
                System.out.println("that is not an option.");
            }
        }
    }

    private static void room1() {
        //Room Count
        if (!found1) {
            roomCount++;
        }
        found1 = true;

        //Ghost
        spooky();
        if (spooky == 5) {
            return;
        }


        System.out.println("You are standing in the foyer of an old house.\nYou see a dead scorpion.");


        //Coin Pickup
//        if (coins[0] > 0) {
//            System.out.printf("There are %d coins in this room! Would you like to pick them up? (Y/N) ", coins[0]);
//            if (scan.nextLine().charAt(0) == 'y') {
//                userCoins += coins[0];
//                coins[0] = 0;
//            }
//        }
        System.out.println("There is a door to the (N)orth, leading to the Front Room.");
        while (true) {
            System.out.println("What would you like to do?");
            input = scan.nextLine();
            if (input.equals("n")) {
                direction = 2;
                break;
            }
            if (input.equals("q")) {
                direction = 10;
                break;
            }
            //Item 1 - Scorpion
            if (input.equalsIgnoreCase("search scorpion") && !item[0]) {
                //Secrets
                if (!secrets[0]) {
                    secrets[0] = true;
                    totalSecrets++;
                }

                item[0] = true;
                int sting = rand.nextInt(5);
                if (sting == 0) {
                    direction = 10;
                    System.out.println("Somehow the dead Scorpion stings you!!!!  You are dead!");
                    break;
                } else {
                    loot = (5 * sting);
                    userCoins += loot;
                    System.out.println("You find " + loot + " coins on the dead scorpian");
                    System.out.println("You now have " + userCoins + " coins.");
                }


            }
        }


    }


    private static void room2() {
        if (!found2) {
            roomCount++;
        }
        found2 = true;

        //Ghost
        spooky();
        if (spooky == 5) {
            return;
        }

        System.out.println("You are standing in the front room.\nThere is a large piano against one wall.");
        System.out.println("You see:\n A door to the (W)est to the Library. \nA door to the(E)ast to the Kitchen. \nAnd a door to the (S)outh to the Foyer.");
        while (true) {
            System.out.println("What would you like to do?");
            input = scan.nextLine();
            if (input.equalsIgnoreCase("w")) {
                direction = 3;
                break;
            }
            if (input.equalsIgnoreCase("e")) {
                direction = 4;
                break;
            }
            if (input.equalsIgnoreCase("s")) {
                direction = 1;
                break;
            }
            if (input.equals("q")) {
                direction = 10;
                break;

            }
            //item 2 - Piano
            if (input.equalsIgnoreCase("play piano")) {

                //Secrets
                if (!secrets[1]) {
                    secrets[1] = true;
                    totalSecrets++;
                }
                item[1] = true;
                if (ghost) {
                    System.out.println("The beautiful music seems to drive your haunter away.");
                    ghost = false;
                } else {
                    System.out.println("The music is very creepy.");
                }
            } else {
                System.out.println("That is not an option.");
            }
        }
    }

    private static void room3() {

        //Room count
        if (!found3) {
            roomCount++;
        }
        found3 = true;

        //Ghost
        spooky();
        if (spooky == 5) {
            return;
        }

        //Prompt
        if (!item[2]) {
            System.out.println("You find yourself in a fancy looking library.\nBut there are spiders crawling on all the bookshelves.");
        } else {
            System.out.println("You walk into a strangely empty library");
        }
        System.out.println("You See:\nA door to the (E)ast to the Front Room. \nAnd a door to the (N)orth to the Dining Room.");
//        if (coins[2] > 0) {
//            System.out.printf("There are %d coins in this room! Would you like to pick them up? (Y/N) ", coins[2]);
//            if (scan.nextLine().charAt(0) == 'y') {
//                userCoins += coins[2];
//                coins[2] = 0;
//            }
//        }


        while (true) {
            System.out.println("What would you like to do?");
            input = scan.nextLine();

            if (input.equalsIgnoreCase("e")) {
                direction = 2;
                break;
            }
            if (input.equalsIgnoreCase("n")) {
                direction = 5;
                break;
            }
            if (input.equalsIgnoreCase("q")) {
                direction = 10;
                break;
            }
            //item 2 - Spiders
            if (input.equalsIgnoreCase("Kill spiders") && !item[2]) {

                //Secrets
                if (!secrets[2]) {
                    secrets[2] = true;
                    totalSecrets++;
                }
                item[2] = true;
                loot = (rand.nextInt(20) + 1);
                System.out.println("You kill some of the spiders finding" + loot + "coins!\nYou now have " + userCoins +" coins.");
                System.out.println("The rest of the spiders disappear. You wonder where they went.....");
            } else {
                System.out.println("That is not an option");

            }
        }
    }


    private static void room4() {
        //Room count
        if (!found4) {
            roomCount++;
        }
        found4 = true;

        //Ghost
        spooky();
        if (spooky == 5) {
            return;
        }

        //Intro
        System.out.println("You enter the Kitchen");
        if (!item[3]) {
            System.out.println("There are Bats flying all around!");
        } else {
            System.out.println("There are bat droppings everywhere...");
        }
        System.out.println("You See:\nThere is a door to the (W)est to the Front Room, and a door to the (N)orth leading to the Parlour");


        //Response
        while (true) {
            System.out.println("\nWhat would you like to do?");
            input = scan.nextLine();
            if (input.equalsIgnoreCase("w")) {
                direction = 2;
                break;
            }
            if (input.equalsIgnoreCase("n")) {
                direction = 7;
                break;
            }
            if (input.equalsIgnoreCase("q")) {
                direction = 10;
                break;

            }

            //Item 3 - Bats
            if (input.equalsIgnoreCase("catch bats") && !item[3]) {
                //Secrets
                if (!secrets[3]) {
                    secrets[3] = true;
                    totalSecrets++;
                }
                item[3] = true;
                loot = rand.nextInt(20);
                userCoins += loot;
                System.out.println("You grab a bat and it drops " + loot + " coins!");
                System.out.println("you now have " + userCoins + " coins.\n");
                System.out.println("All the bats seem to disappear somewhere...");
            } else {
                System.out.println("That is not an option.");

            }
        }
    }


    private static void room5() {
        //Room count
        if (!found5) {
            roomCount++;
        }
        found5 = true;

        //Ghost
        spooky();
        if (spooky == 5) {
            return;
        }

        //Intro
        System.out.println("You enter the Dining Room\nThe room is very dusty.");
        if (!item[4]) {
            System.out.println("There is a large box on the table.");
        } else {
            System.out.println("There is a large empty box on the table");
        }
        System.out.println("You see: A door to the (S)outh leading back to the Library");


        //Response
        while (true) {
            System.out.println("What would you like to do?");
            input = scan.nextLine();
            if (input.equalsIgnoreCase("s")) {
                direction = 3;
                break;
            }
            if (input.equalsIgnoreCase("q")) {
                direction = 10;
                break;

            }
            //Item 5 - Box
            if (input.equalsIgnoreCase("open box") && !item[4]) {
                //Secrets
                if (!secrets[4]) {
                    secrets[4] = true;
                    totalSecrets++;
                }
                item[4] = true;
                loot = rand.nextInt(25);
                if (loot <= 5) {
                    userCoins -= loot;
                    System.out.println("You accidently drop " + loot + " coins trying to open the empty box");
                } else {
                    userCoins += loot;
                    System.out.println("You found " + loot + " coins in the box");
                }
            } else {
                System.out.println("That is not an option.");

            }
        }
    }


    private static void room6() {

        //Ghost
        spooky();
        if (spooky == 5) {
            return;
        }

        //Intro
        System.out.println("You enter the Vault");
        System.out.println("There are 3 Spooky Skeletons walking around!");

        //Room Count
        if (!found6) {
            roomCount++;
        }
        found6 = true;

        //Secret Room Chance

        int secret = rand.nextInt(4);
        if (secret == 0 || mystery) {
            System.out.println("There is a door to the (E)ast leading back to the Parlour");
            System.out.println("A (S)trange hole appears on the East wall");
            mystery = true;
        } else {
            System.out.println("There is a door to the (E)ast leading back to the Parlour");
        }

        //Response

        while (true) {
            System.out.println("What would you like to do?");
            input = scan.nextLine();
            if (input.equalsIgnoreCase("e")) {
                direction = 7;
                break;
            }
            if (input.equalsIgnoreCase("s") && (mystery)) {
                direction = 8;
                break;
            }
            if (input.equalsIgnoreCase("q")) {
                direction = 10;
                break;
            } if(input.equalsIgnoreCase("attack skeletons") && !item[5]){

                if (!secrets[5]) {
                    secrets[5] = true;
                    totalSecrets++;
                }
                item[5]=true;

                System.out.println("Which skeleton would you like to attack:\tTom, Big Steve, or Sally?");
                if(input.equalsIgnoreCase("tom")){
                    System.out.println("After a tough battle you defeat Tom!  He drops 30 coins\n The other skeletons make a hasty retreat.");
                    userCoins+=30;
                    System.out.println("You now have "+ userCoins+ " coins");
                }
                if(input.equalsIgnoreCase("sally")){
                    key = false;
                    System.out.println("You Easily defeat Sally.\t  She drops a strange giant key!");
                }
                if(input.equalsIgnoreCase("big Steve")){
                    System.out.println("You cant defeat Big Steve!!!!\nHe kills you easily.");
                    direction=10;
                    break;
                }
            }
            else {
                System.out.println("That is not an option.");
            }
        }
    }

    private static void room7() {
        //Room Count
        if (!found7) {
            roomCount++;
        }
        found7 = true;

        //Ghost
        spooky();
        if (spooky == 5) {
            return;
        }

        System.out.println("You find yourself entering the old parlor. \nThere is a Large Treasure Chest in the middle of the room. \n");
//        if (coins[6] > 0) {
//            System.out.printf("There are %d coins in this room! Would you like to pick them up? (Y/N) ", coins[6]);
//            if (scan.nextLine().charAt(0) == 'y') {
//                userCoins += coins[6];
//                coins[6] = 0;
//            }
//        }
        while (true) {
            System.out.println("You see:\nA door to the (W)est to the Vault. \nAnd a door to the (S)outh back to the Kitchen.");

            input = scan.nextLine();

            if (input.equals("s")) {
                direction = 4;
                break;
            }
            if (input.equals("w")) {
                direction = 6;
                break;
            }
            if (input.equalsIgnoreCase("q")) {
                direction = 10;
                break;
            }
            if(input.equalsIgnoreCase("open Chest")){

            }
                else {
                System.out.println("That is not an option");
            }

        }

    }

    private static void room8() {
        //Room Count
        if (!found8) {
            roomCount++;
        }
        found8 = true;

        //Ghost
        spooky();
        if (spooky == 5) {
            return;
        }

        //Prompt
        if (!item[7]) {
            System.out.println("You found the Treasure Room!!\n There are piles of gold Everywhere!!!");

            //Item 8
            while (true) {
                System.out.println("\n\n Would you like to pick them up? (Y/N)");
                input = scan.nextLine();
                if (input.equalsIgnoreCase("y")) {
                    userCoins += 100;
                    item[7] = true;
                    System.out.println("You pick up all the treasure and gain 100 gold!!");
                    System.out.println("There is a door to the (W)est.");
                    break;
                }
                if (input.equalsIgnoreCase("n")) {
                    System.out.println("You leave the gold alone.");
                    System.out.println("There is a door to the (W)est.");
                    break;
                } else {
                    System.out.println("That is not an option");
                }
            }
        } else {
            System.out.println("You enter the treasure room.....  But theres nothing here.\n");
            System.out.println("There is a door to the (W)est.");
        }


        //Response
        while (true) {
            System.out.println("What would you like to do?");
            input = scan.nextLine();
            if (input.equalsIgnoreCase("w")) {
                direction = 6;
                break;
            }

            if (input.equalsIgnoreCase("q")) {
                direction = 10;
                break;
            } else {
                System.out.println("That is not an option.");
            }
        }
    }


    private static void quit() {
        System.out.println("You found " + roomCount + " rooms.");
        System.out.println("you found " + userCoins + " coins.");
        System.out.println("You have found " + totalSecrets + "out of 8 secrets.");


        //Replay game
        haunt();
        System.out.println("Would you like to play again? (Y/N)");
        String reDo = scan.nextLine();

        while (true) {
            if (reDo.equalsIgnoreCase("y")) {
                userCoins = 0;
                // coins = {1,2,3,4,5,6,7,8};
                direction = 1;
                mystery = false;
                roomCount = 0;
                found1 = false;
                found2 = false;
                found3 = false;
                found4 = false;
                found5 = false;
                found6 = false;
                found7 = false;
                found8 = false;
                for (int i = 0; i < item.length; i++) {
                    item[i] = false;
                }
                break;

            }
            if (reDo.equalsIgnoreCase("n")) {
                play = false;
                System.out.println("Goodbye.  Thank you for playing.");
                break;
            } else {
                System.out.println("Try that again...... \nWould you like to play again? (Y/N)");
            }
        }

        //Haunting message
        if (!ghost) {
            System.out.println("There is a Spooky ghost following you....  Beware");
        }
    }

    private static void haunt() {
        int haunt = rand.nextInt(4);
        if (haunt == 0) {
            ghost = true;
        }
    }

    private static void spooky() {
        if (ghost) {
            spooky = rand.nextInt(7) + 1;
            switch (spooky) {
                case 1:
                    System.out.println("BOOOOOOOOO!!!!");
                    break;
                case 2:
                    System.out.println("GET OUT!!!!!!!");
                    break;
                case 3:
                    System.out.println("\"Youll never find the Treasure\" - Spooky ghost");
                    break;
                case 4:
                    System.out.println("MUAHAHAHAHAHAHA");
                    userCoins -= 5;
                    System.out.println("5 of your coins mysteriously disappear\nYou now have " + userCoins + " coins");
                    break;
                case 5:
                    System.out.println("Oh no you dont!");
                    direction = rand.nextInt(7) + 1;

                    System.out.println("Something weird happens....");
                    break;
                case 6:
                    System.out.println("Nobody likes you...");
                    break;
                case 7:
                    System.out.println("You'll be stuck here just like me");
                    break;
            }
        }
    }
}
