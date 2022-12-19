package quizGame;

import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);

    private MoneyTable moneyTable = new MoneyTable();

    private boolean isWinner = false;

    public void run() {
        int choice;

        do {
            DisplayQuiz.printMenu();
            System.out.print("Type option here: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    printQuestion();
                    break;
                case 2:
                    DisplayQuiz.printRules();
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println();
            }
        } while (choice != 3);
    }

    //Show the different questions by respectively themes
    public void printQuestion() {
        printThemes();
        moneyTable.printCurrentLevel(moneyTable.getCurrentLevel());
        System.out.print("Option:");
        int choice = scanner.nextInt();

        if (choice == 1) {
            choice1();
        }
        if (choice == 2) {
            choice2();
        }
        if (choice == 3) {
            choice3();
        }
        if (choice == 4) {
            choice4();
        }
    }

    //print message and consequences if the answer is wrong
    public void wrongAnswer() {
        moneyTable.decreaseLevel();
        if (moneyTable.getCurrentLevel() == 0) {
            isWinner = false;
            System.out.println("Wʀᴏɴɢ Aɴsᴡᴇʀ!! :(  Yᴏᴜ ʟᴏsᴛ ᴛʜᴇ ɢᴀᴍᴇ (╥︣ . ╥᷅)  Tᴏᴅᴀʏ ʏᴏᴜ ᴅᴏɴ'ᴛ ᴛᴀᴋᴇ ᴛʜᴇ ᴍᴏɴᴇʏ ᴛᴏ ʏᴏᴜʀ ʜᴏᴍᴇ !");
            System.out.print("Press any key to return: ");
            new Scanner(System.in).nextLine();
            run();
        }
        if (moneyTable.getCurrentLevel() >= 1) {
            isWinner = false;
            System.out.println("\uD835\uDDB6\uD835\uDDCB\uD835\uDDC8\uD835\uDDC7\uD835\uDDC0 \uD835\uDDA0\uD835\uDDC7\uD835\uDDCC\uD835\uDDD0\uD835\uDDBE\uD835\uDDCB !! :( \uD835\uDDD2\uD835\uDDC8\uD835\uDDCE \uD835\uDDC1\uD835\uDDBA\uD835\uDDCF\uD835\uDDBE \uD835\uDDBD\uD835\uDDCB\uD835\uDDC8\uD835\uDDC9\uD835\uDDC9\uD835\uDDBE\uD835\uDDBD \uD835\uDDBA \uD835\uDDC5\uD835\uDDBE\uD835\uDDCF\uD835\uDDBE\uD835\uDDC5. (︡❛ ͜ʖ❛︠)");
            moneyTable.printCurrentLevel(moneyTable.getCurrentLevel());
            System.out.print("You are now at " + moneyTable.getMoneyLevel(moneyTable.getCurrentLevel()) + " level. Lets continue the game...");
            System.out.println("Press any key to continue:");
            new Scanner(System.in).nextLine();

            printQuestion();
        }
    }

    //print message and consequences if the answer is right
    public void rightAnswer() {
        if (moneyTable.getCurrentLevel() == moneyTable.getMoneyLevel().length) {
            isWinner = true;
            System.out.println("You won 50 000 euros !! CONGRATS! \uD83C\uDF7E  \uD83C\uDF89");
            System.out.print("Press any key to return: ");
            scanner.nextLine();
            run();
        }
        moneyTable.increaseLevel();
        System.out.println("\uD835\uDDA2\uD835\uDDAE\uD835\uDDAD\uD835\uDDA6\uD835\uDDB1\uD835\uDDA0\uD835\uDDB3\uD835\uDDB4\uD835\uDDAB\uD835\uDDA0\uD835\uDDB3\uD835\uDDA8\uD835\uDDAE\uD835\uDDAD\uD835\uDDB2 !! \uD835\uDDB8\uD835\uDDAE\uD835\uDDB4\uD835\uDDB1 \uD835\uDDA0\uD835\uDDAD\uD835\uDDB2\uD835\uDDB6\uD835\uDDA4\uD835\uDDB1 \uD835\uDDA8\uD835\uDDB2 \uD835\uDDA2\uD835\uDDAE\uD835\uDDB1\uD835\uDDB1\uD835\uDDA4\uD835\uDDA2\uD835\uDDB3! (︡^ ͜ʖ^︠)");
        System.out.println("You are now on level " + moneyTable.getMoneyLevel(moneyTable.getCurrentLevel()));
        moneyTable.printCurrentLevel(moneyTable.getCurrentLevel());
        System.out.println("Press any key to continue:");
        scanner.nextLine();
        printQuestion();
    }

    //for theme 1, question 1
    public void choice1Case1() {
        System.out.println(" Complete the phrase: The ________ system has a set of organs responsible for transporting substances throughout our body.");
        System.out.println("🄰. Cardiovascular\t\t\t\uD83C\uDD31. Muscular");
        System.out.println("\uD83C\uDD32. Circulatory\t\t\t\t\t\uD83C\uDD33. Skeletal");
        System.out.println("What is the right answer? ...A, B, C, or D?");
        System.out.println("Do you want to use Help? Press 'H' if the answer is yes or any other key if answer is no:");
        String choice5 = scanner.next();
        if (choice5.equalsIgnoreCase("h")) {
            System.out.println("What is the help you want to use?\n\t1- The opinion of the audience (\uD83D\uDC68)\n\t2- The half and half (\uD835\uDFE7\uD835\uDFE2/\uD835\uDFE7\uD835\uDFE2)\n\t3- The call to a friend (\uD83D\uDCDE)");
            System.out.print("Help: ");
            int option = scanner.nextInt();
            if (option == 1) {

                int a = 10 - (int) (Math.random() * 5);
                int b = 11 - (int) (Math.random() * 5);
                int c = 44 - (int) (Math.random() * 5);
                int d = 35 - (int) (Math.random() * 5);

                System.out.println("[Option A] - " + a + "%");
                System.out.println("[Option B] - " + b + "%");
                System.out.println("[Option C] - " + c + "%");
                System.out.println("[Option D] - " + d + "%");

                int sum = a + b + c + d;

                int difference = 100 - sum;

                System.out.println(difference + "% didn't vote.");

                System.out.println("The audience done his job... What is your answer?");
            }

            if (option == 2) {
                System.out.println(" Complete the phrase: The ________ system has a set of organs responsible for transporting substances throughout our body.");
                System.out.println("🄰. \t\t\t\t\t\uD83C\uDD31. Muscular");
                System.out.println("\uD83C\uDD32. Circulatory\t\t\t\t\t\uD83C\uDD33. ");
                System.out.println("the computer eliminated A and D. What is your answer?");
            }

            if (option == 3) {
                System.out.println("Lets call to your friend...");
                System.out.println(".");
                System.out.println(".");
                System.out.println(".");

                System.out.println("Hello José, can you tell me what is the right answer?\nThe question is...\n" +
                        "Complete the phrase: The ________ system has a set of organs responsible for transporting substances throughout our body." +
                        "a - Cardiovascular, b - Muscular, c - Circulatory, d - Skeletal");
                System.out.println("José:  \"Hello my friend, i think C is the right answer\"");
                System.out.println("Thanks José...");
                System.out.println("So , \n" +
                        "what will your answer be?");
            }
        } else {
            System.out.println("Well,i hope you know the answer.");
        }
        System.out.print("answer: ");
        String choice1 = scanner.next();
        if (choice1.equalsIgnoreCase("b")) {
            System.out.println("🄰. Cardiovascular " + Colors.ANSI_RED_BACKGROUND + "\t\t\t\t\t\uD83C\uDD31. Muscular" + Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD32. Circulatory" + Colors.ANSI_RESET + "\t\t\t\t\t\uD83C\uDD33. Skeletal");
            wrongAnswer();
        }
        if (choice1.equalsIgnoreCase("c")) {
            System.out.println("🄰. Cardiovascular\t\t\t\t\t\t\uD83C\uDD31. Muscular");
            System.out.println(Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD32.Circulatory" + Colors.ANSI_RESET + "\t\t\t\t\t\uD83C\uDD33. Skeletal");
            rightAnswer();
        }
        if (choice1.equalsIgnoreCase("d")) {
            System.out.println("🄰. Cardiovascular\t\t\t\t\t\uD83C\uDD31. Muscular");
            System.out.println(Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD32.Circulatory\t\t\t\t\t" + Colors.ANSI_RESET + Colors.ANSI_RED_BACKGROUND + "\uD83C\uDD33. Skeletal" + Colors.ANSI_RESET);
            wrongAnswer();
        }
        if (choice1.equalsIgnoreCase("a")) {
            System.out.println(Colors.ANSI_RED_BACKGROUND + "🄰. Cardiovascular " + Colors.ANSI_RESET + "\t\t\t\t\t\uD83C\uDD31. Muscular");
            System.out.println(Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD32.Circulatory" + Colors.ANSI_RESET + "\t\t\t\t\t\uD83C\uDD33. Skeletal");
            wrongAnswer();
        }
    }

    //for theme 1, question 2
    public void choice1Case2() {
        System.out.println("Which of the following does not correspond to the respiratory system?");
        System.out.println("🄰. Pharynx\t\t\t\t\t\uD83C\uDD31. Trachea");
        System.out.println("\uD83C\uDD32. Lungs\t\t\t\t\t\uD83C\uDD33. Mouth");
        System.out.println("What is the right answer? ...A, B, C, or D?");
        System.out.println("Do you want to use Help? Press 'H' if the answer is yes:");
        String choice5 = scanner.next();
        if (choice5.equalsIgnoreCase("h")) {
            System.out.println("What is the help you want to use?\n\t1- The opinion of the audience (\uD83D\uDC68)\n\t2- The half and half (\uD835\uDFE7\uD835\uDFE2/\uD835\uDFE7\uD835\uDFE2)\n\t3- The call to a friend (\uD83D\uDCDE)");
            System.out.print("Help: ");
            int option = scanner.nextInt();
            if (option == 1) {
                int c = 9 - (int) (Math.random() * 5);
                int b = 11 - (int) (Math.random() * 5);
                int d = 45 - (int) (Math.random() * 5);
                int a = 35 - (int) (Math.random() * 5);

                System.out.println("[Option A] - " + a + "%");
                System.out.println("[Option B] - " + b + "%");
                System.out.println("[Option C] - " + c + "%");
                System.out.println("[Option D] - " + d + "%");

                int sum = a + b + c + d;

                int difference = 100 - sum;

                System.out.println(difference + "% didn't vote.");

                System.out.println("The audience done his job... What is your answer?");
            }

            if (option == 2) {
                System.out.println("Which of the following does not correspond to the respiratory system?");
                System.out.println("🄰. \t\t\t\t\t\uD83C\uDD31. Trachea");
                System.out.println("\uD83C\uDD32. \t\t\t\t\t\uD83C\uDD33. Mouth");
                System.out.println("the computer eliminated A and C. What is your answer?");
            }

            if (option == 3) {
                System.out.println("Lets call to your friend...");
                System.out.println(".");
                System.out.println(".");
                System.out.println(".");

                System.out.println("Hello Maycon, can you tell me what is the right answer?\nThe question is...\n" +
                        "Which of the following does not correspond to the respiratory system?" +
                        "a - Pharynx, b -  Trachea, c - Lungs, d - Mouth");
                System.out.println("Maycon:  \"Hello my friend, i think D is the right answer\"");
                System.out.println("Thanks Maycon...");
                System.out.println("So , \n" +
                        "what will your answer be?");
            }
        } else {
            System.out.println("Well,i hope you know the answer.");
        }
        System.out.print("answer: ");
        String choice2 = scanner.next();
        if (choice2.equalsIgnoreCase("b")) {
            System.out.println("🄰. Pharynx " + Colors.ANSI_RED_BACKGROUND + "\t\t\t\t\t\uD83C\uDD31. Trachea" + Colors.ANSI_RESET);
            System.out.println("\uD83C\uDD32. Lungs\t\t\t\t\t" + Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD33. Mouth" + Colors.ANSI_RESET);
            wrongAnswer();
        }
        if (choice2.equalsIgnoreCase("c")) {
            System.out.println("🄰. Pharynx\t\t\t\t\t\uD83C\uDD31. Trachea");
            System.out.println(Colors.ANSI_RED_BACKGROUND + "\uD83C\uDD32. Lungs\t\t\t\t\t" + Colors.ANSI_RESET + Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD33. Mouth" + Colors.ANSI_RESET);
            wrongAnswer();
        }
        if (choice2.equalsIgnoreCase("a")) {
            System.out.println(Colors.ANSI_RED_BACKGROUND + "🄰. Pharynx\t\t\t\t\t" + Colors.ANSI_RESET + "\uD83C\uDD31. Trachea");
            System.out.println("\uD83C\uDD32. Lungs\t\t\t\t\t" + Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD33. Mouth" + Colors.ANSI_RESET);
            wrongAnswer();
        }
        if (choice2.equalsIgnoreCase("d")) {
            System.out.println("🄰. Pharynx\t\t\t\t\t\uD83C\uDD31. Trachea");
            System.out.println("\uD83C\uDD32. Lungs\t\t\t\t\t" + Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD33. Mouth" + Colors.ANSI_RESET);
            rightAnswer();
        }
    }

    //for theme 1, question 3
    public void choice1Case3() {
        System.out.println("How many colors can the human eye distinguish? ");
        System.out.println("🄰. 5.3 millions to 9.5 millions\t\t\uD83C\uDD31. 2.3 millions to 7.5 millions of colors");
        System.out.println("\uD83C\uDD32. 3000 to 5000 colors\t\t\t\t\t\uD83C\uDD33. 75 colors");
        System.out.print("What is the right answer? ...A, B, C, or D?");
        System.out.println("Do you want to use Help? Press 'H' if the answer is yes or any other key if answer is no:");
        String choice5 = scanner.next();
        if (choice5.equalsIgnoreCase("h")) {
            System.out.println("What is the help you want to use?\n\t1- The opinion of the audience (\uD83D\uDC68)\n\t2- The half and half (\uD835\uDFE7\uD835\uDFE2/\uD835\uDFE7\uD835\uDFE2)\n\t3- The call to a friend (\uD83D\uDCDE)");
            System.out.print("Help: ");
            int option = scanner.nextInt();
            if (option == 1) {
                int c = 9 - (int) (Math.random() * 5);
                int b = 40 - (int) (Math.random() * 5);
                int d = 12 - (int) (Math.random() * 5);
                int a = 39 - (int) (Math.random() * 5);

                System.out.println("[Option A] - " + a + "%");
                System.out.println("[Option B] - " + b + "%");
                System.out.println("[Option C] - " + c + "%");
                System.out.println("[Option D] - " + d + "%");

                int sum = a + b + c + d;

                int difference = 100 - sum;

                System.out.println(difference + "% didn't vote.");

                System.out.println("The audience done his job... What is your answer?");
            }

            if (option == 2) {
                System.out.println("How many colors can the human eye distinguish?");
                System.out.println("🄰. 5.3 millions to 9.5 millions\t\t\t\t\t\uD83C\uDD31. 2.3 millions to 7.5 millions of colors");
                System.out.println("\uD83C\uDD32. \t\t\t\t\t\uD83C\uDD33. ");
                System.out.println("the computer eliminated C and D. What is your answer?");
            }

            if (option == 3) {
                System.out.println("Lets call to your friend...");
                System.out.println(".");
                System.out.println(".");
                System.out.println(".");

                System.out.println("Hello Carlos, can you tell me what is the right answer?\nThe question is...\n" +
                        "How many colors can the human eye distinguish? " +
                        "a - 5.3 millions to 9.5 millions, b -  2.3 millions to 7.5 millions of colors, c - 3000 to 5000 colors, d - 75 colors");
                System.out.println("Carlos:  \"Hello my friend, i think B is the right answer\"");
                System.out.println("Thanks Carlos...");
                System.out.println("So , \n" +
                        "what will your answer be?");
            }
        } else {
            System.out.println("Well,i hope you know the answer.");
        }
        System.out.print("answer: ");
        String choice3 = scanner.next();
        if (choice3.equalsIgnoreCase("b")) {
            System.out.println("🄰. 5.3 millions to 9.5 millions " + Colors.ANSI_GREEN_BACKGROUND + "\t\t\t\t\t\uD83C\uDD31. 2.3 millions to 7.5 millions of colors" + Colors.ANSI_RESET);
            System.out.println("\uD83C\uDD32. 3000 to 5000 colors\t\t\t\t\t\uD83C\uDD33. 75 colors");
            rightAnswer();
        }
        if (choice3.equalsIgnoreCase("c")) {
            System.out.println("🄰. 5.3 millions to 9.5 millions " + Colors.ANSI_GREEN_BACKGROUND + "\t\t\t\t\t\uD83C\uDD31. 2.3 millions to 7.5 millions of colors" + Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_RED_BACKGROUND + "\uD83C\uDD32. 3000 to 5000 colors\t\t\t\t\t" + Colors.ANSI_RESET + "\uD83C\uDD33. 75 colors");
            wrongAnswer();
        }
        if (choice3.equalsIgnoreCase("d")) {
            System.out.println("🄰. 5.3 millions to 9.5 millions " + Colors.ANSI_GREEN_BACKGROUND + "\t\t\t\t\t\uD83C\uDD31. 2.3 millions to 7.5 millions of colors" + Colors.ANSI_RESET);
            System.out.println("\uD83C\uDD32. 3000 to 5000 colors\t\t\t\t\t" + Colors.ANSI_RED_BACKGROUND + "\uD83C\uDD33. 75 colors" + Colors.ANSI_RESET);
            wrongAnswer();
        }
        if (choice3.equalsIgnoreCase("a")) {
            System.out.println(Colors.ANSI_RED_BACKGROUND + "🄰. 5.3 millions to 9.5 millions " + Colors.ANSI_RESET + Colors.ANSI_GREEN_BACKGROUND + "\t\t\t\t\t \uD83C\uDD31. 2.3 millions to 7.5 millions of colors" + Colors.ANSI_RESET);
            System.out.println("\uD83C\uDD32. 3000 to 5000 colors\t\t\t\t\t\uD83C\uDD33. 75 colors");
            wrongAnswer();
        }
    }

    //for theme 2, question 1

    public void choice2Case1() {
        System.out.println("Whose famous phrase is \"I think, therefore I exist\"?");
        System.out.println("🄰. Descartes\t\t\t\t\t\uD83C\uDD31. Galileu Galilei");
        System.out.println("\uD83C\uDD32. Platão\t\t\t\t\t\uD83C\uDD33. Sócrates");
        System.out.println("What is the right answer? ...A, B, C, or D?");
        System.out.println("Do you want to use Help? Press 'H' if the answer is yes or any other key if answer is no:");
        String choice5 = scanner.next();
        if (choice5.equalsIgnoreCase("h")) {
            System.out.println("What is the help you want to use?\n\t1- The opinion of the audience (\uD83D\uDC68)\n\t2- The half and half (\uD835\uDFE7\uD835\uDFE2/\uD835\uDFE7\uD835\uDFE2)\n\t3- The call to a friend (\uD83D\uDCDE)");
            System.out.print("Help: ");
            int option = scanner.nextInt();
            if (option == 1) {
                int c = 9 - (int) (Math.random() * 5);
                int b = 12 - (int) (Math.random() * 5);
                int d = 35 - (int) (Math.random() * 5);
                int a = 54 - (int) (Math.random() * 5);

                System.out.println("[Option A] - " + a + "%");
                System.out.println("[Option B] - " + b + "%");
                System.out.println("[Option C] - " + c + "%");
                System.out.println("[Option D] - " + d + "%");

                int sum = a + b + c + d;

                int difference = 100 - sum;

                System.out.println(difference + "% didn't vote.");

                System.out.println("The audience done his job... What is your answer?");
            }

            if (option == 2) {
                System.out.println("Whose famous phrase is \"I think, therefore I exist\"?");
                System.out.println("🄰. Descartes\t\t\t\t\t\uD83C\uDD31. ");
                System.out.println("\uD83C\uDD32. \t\t\t\t\t\uD83C\uDD33. Sócrates");
                System.out.println("the computer eliminated B and C. What is your answer?");
            }

            if (option == 3) {
                System.out.println("Lets call to your friend...");
                System.out.println(".");
                System.out.println(".");
                System.out.println(".");

                System.out.println("Hello Papito, can you tell me what is the right answer?\nThe question is...\n" +
                        "Whose famous phrase is \"I think, therefore I exist\"?" +
                        "a - Descartes, b - Galileu Galilei, c - Platão, d - Sócrates");
                System.out.println("Papito:  \"Hello my friend, i think D is the right answer\"");
                System.out.println("Thanks Papito...");
                System.out.println("So , \n" +
                        "what will your answer be?");
            }
        } else {
            System.out.println("Well,i hope you know the answer.");
        }
        System.out.print("answer: ");
        String choice1 = scanner.next();
        if (choice1.equalsIgnoreCase("a")) {
            System.out.println(Colors.ANSI_GREEN_BACKGROUND + "🄰. Descartes\t\t\t\t\t" + Colors.ANSI_RESET + "\uD83C\uDD31. Galileu Galilei");
            System.out.println("\uD83C\uDD32. Platão\t\t\t\t\t\uD83C\uDD33. Sócrates");
            rightAnswer();
        }
        if (choice1.equalsIgnoreCase("b")) {
            System.out.println(Colors.ANSI_GREEN_BACKGROUND + "🄰. Descartes " + Colors.ANSI_RESET + Colors.ANSI_RED_BACKGROUND + "\t\t\t\t\t\uD83C\uDD31. Galileu Galilei" + Colors.ANSI_RESET);
            System.out.println("\uD83C\uDD32. Platão\t\t\t\t\t\uD83C\uDD33. Sócrates");
            wrongAnswer();
        }
        if (choice1.equalsIgnoreCase("c")) {
            System.out.println(Colors.ANSI_GREEN_BACKGROUND + "🄰. Descartes " + Colors.ANSI_RESET + "\t\t\t\t\t\uD83C\uDD31. Galileu Galilei");
            System.out.println(Colors.ANSI_RED_BACKGROUND + "\uD83C\uDD32. Platão" + Colors.ANSI_RESET + "\t\t\t\t\t\uD83C\uDD33. Sócrates");
            wrongAnswer();
        }
        if (choice1.equalsIgnoreCase("d")) {
            System.out.println(Colors.ANSI_GREEN_BACKGROUND + "🄰. Descartes " + Colors.ANSI_RESET + "\t\t\t\t\t\uD83C\uDD31.  Galileu Galilei");
            System.out.println("\uD83C\uDD32.Digestive\t\t\t\t\t" + Colors.ANSI_RED_BACKGROUND + "\uD83C\uDD33. Sócrates" + Colors.ANSI_RESET);
            wrongAnswer();
        }
    }

    //for theme 2, question 2

    public void choice2Case2() {
        System.out.println("Complete the phrase: Pandora's Box is an extraordinary object that is part of...");
        System.out.println("🄰. Egyptian Mythology\t\t\t\t\t\uD83C\uDD31. Greek Mythology");
        System.out.println("\uD83C\uDD32. Astec Mythology\t\t\t\t\t\uD83C\uDD33. Roman Mythology");
        System.out.println("What is the right answer? ...A, B, C, or D?");
        System.out.println();
        System.out.println("Do you want to use Help? Press 'H' if the answer is yes or any other key if answer is no:");
        System.out.println();
        String choice5 = scanner.next();
        if (choice5.equalsIgnoreCase("h")) {
            System.out.println("What is the help you want to use?\n\t1- The opinion of the audience (\uD83D\uDC68)\n\t2- The half and half (\uD835\uDFE7\uD835\uDFE2/\uD835\uDFE7\uD835\uDFE2)\n\t3- The call to a friend (\uD83D\uDCDE)");
            System.out.print("Help: ");
            int option = scanner.nextInt();
            if (option == 1) {
                int c = 10 - (int) (Math.random() * 5);
                int b = 60 - (int) (Math.random() * 5);
                int d = 20 - (int) (Math.random() * 5);
                int a = 10 - (int) (Math.random() * 5);

                System.out.println("[Option A] - " + a + "%");
                System.out.println("[Option B] - " + b + "%");
                System.out.println("[Option C] - " + c + "%");
                System.out.println("[Option D] - " + d + "%");

                int sum = a + b + c + d;

                int difference = 100 - sum;

                System.out.println(difference + "% didn't vote.");

                System.out.println("The audience done his job... What is your answer?");
            }

            if (option == 2) {
                System.out.println("Complete the phrase: Pandora's Box is an extraordinary object that is part of...");
                System.out.println("🄰. \t\t\t\t\t\uD83C\uDD31. Greek Mythology");
                System.out.println("\uD83C\uDD32. Astec Mythology\t\t\t\t\t\uD83C\uDD33. ");
                System.out.println("the computer eliminated A and D. What is your answer?");
            }

            if (option == 3) {
                System.out.println("Lets call to your friend...");
                System.out.println(".");
                System.out.println(".");
                System.out.println(".");

                System.out.println("Hello Tone, can you tell me what is the right answer?\nThe question is...\n" +
                        "Complete the phrase: Pandora's Box is an extraordinary object that is part of..." +
                        "a - Egyptian Mythology, b - Greek Mythology, c - Astec Mythology, d - Roman Mythology");
                System.out.println("Tone:  \"Hello my friend, i think B is the right answer\"");
                System.out.println("Thanks Tone...");
                System.out.println("So , \n" +
                        "what will your answer be?");
            }
        } else {
            System.out.println("Well,i hope you know the answer.");
        }
        System.out.print("answer: ");
        String choice2 = scanner.next();
        if (choice2.equalsIgnoreCase("b")) {
            System.out.println("🄰. Egyptian Mythology\t\t\t\t\t" + Colors.ANSI_GREEN_BACKGROUND + " \uD83C\uDD31. Greek Mythology" + Colors.ANSI_RESET);
            System.out.println("\uD83C\uDD32. Astec Mythology\t\t\t\t\t\uD83C\uDD33. Roman Mythology");
            rightAnswer();

        }
        if (choice2.equalsIgnoreCase("c")) {
            System.out.println("🄰. Egyptian Mythology\t\t\t\t\t" + Colors.ANSI_GREEN_BACKGROUND + " \uD83C\uDD31. Greek Mythology" + Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_RED_BACKGROUND + "\uD83C\uDD32. Astec Mythology" + Colors.ANSI_RESET + "\t\t\t\t\t\uD83C\uDD33. Roman Mythology");
            wrongAnswer();
        }
        if (choice2.equalsIgnoreCase("d")) {
            System.out.println("🄰. Egyptian Mythology\t\t\t\t\t" + Colors.ANSI_GREEN_BACKGROUND + " \uD83C\uDD31. Greek Mythology" + Colors.ANSI_RESET);
            System.out.println("\uD83C\uDD32. Astec Mythology\t\t\t\t\t" + Colors.ANSI_RED_BACKGROUND + "\uD83C\uDD33. Roman Mythology" + Colors.ANSI_RESET);
            wrongAnswer();
        }
        if (choice2.equalsIgnoreCase("a")) {
            System.out.println(Colors.ANSI_RED_BACKGROUND + "🄰. Egyptian Mythology\t\t\t\t\t" + Colors.ANSI_RESET + Colors.ANSI_GREEN_BACKGROUND + " \uD83C\uDD31. Greek Mythology" + Colors.ANSI_RESET);
            System.out.println("\uD83C\uDD32. Astec Mythology\t\t\t\t\t\uD83C\uDD33. Roman Mythology");
            wrongAnswer();
        }
    }

    //for theme 2, question 3

    public void choice2Case3() {
        System.out.println("For Freud, the unconscious is made up of desires and drives, which repressed can generate harmful effects to the subject's psychic health (neuroses)");
        System.out.println("🄰. Feelings and Drives\t\t\t\t\t\uD83C\uDD31. Desires and Feelings");
        System.out.println("\uD83C\uDD32. Emotions and Feelings\t\t\t\t\t\uD83C\uDD33. Desires and Drives");
        System.out.println("What is the right answer? ...A, B, C, or D?");
        System.out.println("Do you want to use Help? Press 'H' if the answer is yes or any other key if answer is no:");
        String choice5 = scanner.next();
        if (choice5.equalsIgnoreCase("h")) {
            System.out.println("What is the help you want to use?\n\t1- The opinion of the audience (\uD83D\uDC68)\n\t2- The half and half (\uD835\uDFE7\uD835\uDFE2/\uD835\uDFE7\uD835\uDFE2)\n\t3- The call to a friend (\uD83D\uDCDE)");
            System.out.print("Help: ");
            int option = scanner.nextInt();
            if (option == 1) {
                int c = 12 - (int) (Math.random() * 5);
                int b = 20 - (int) (Math.random() * 5);
                int d = 38 - (int) (Math.random() * 5);
                int a = 30 - (int) (Math.random() * 5);

                System.out.println("[Option A] - " + a + "%");
                System.out.println("[Option B] - " + b + "%");
                System.out.println("[Option C] - " + c + "%");
                System.out.println("[Option D] - " + d + "%");

                int sum = a + b + c + d;

                int difference = 100 - sum;

                System.out.println(difference + "% didn't vote.");

                System.out.println("The audience done his job... What is your answer?");
            }

            if (option == 2) {
                System.out.println("For Freud, the unconscious is made up of desires and drives, which repressed can generate harmful effects to the subject's psychic health (neuroses)");
                System.out.println("🄰. \t\t\t\t\t \uD83C\uDD31. ");
                System.out.println("\uD83C\uDD32. Emotions and Feelings\t\t\t\t\t\uD83C\uDD33. Desires and Drives");
                System.out.println("the computer eliminated A and B. What is your answer?");
            }

            if (option == 3) {
                System.out.println("Lets call to your friend...");
                System.out.println(".");
                System.out.println(".");
                System.out.println(".");

                System.out.println("Hello Mario, can you tell me what is the right answer?\nThe question is...\n" +
                        "For Freud, the unconscious is made up of desires and drives, which repressed can generate harmful effects to the subject's psychic health (neuroses)" +
                        "a - Feelings and Drives, b - Desires and Feelings, c - Emotions and Feelings, d - Desires and Drives");
                System.out.println("Mario:  \"Hello my friend, i think D is the right answer\"");
                System.out.println("Thanks Mario...");
                System.out.println("So , \n" +
                        "what will your answer be?");
            }
        } else {
            System.out.println("Well,i hope you know the answer.");
        }
        System.out.print("answer: ");
        String choice3 = scanner.next();
        if (choice3.equalsIgnoreCase("b")) {
            System.out.println("🄰. Feelings and Drives\t\t\t\t\t" + Colors.ANSI_RED_BACKGROUND + "\uD83C\uDD31. Desires and Feelings" + Colors.ANSI_RESET);
            System.out.println("\uD83C\uDD32. Emotions and Feelings\t\t\t\t\t" + Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD33. Desires and Drives" + Colors.ANSI_RESET);
            wrongAnswer();
        }
        if (choice3.equalsIgnoreCase("d")) {
            System.out.println("🄰. Feelings and Drives\t\t\t\t\t\uD83C\uDD31. Desires and Feelings");
            System.out.println("\uD83C\uDD32. Emotions and Feelings\t\t\t\t\t" + Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD33. Desires and Drives" + Colors.ANSI_RESET);
            rightAnswer();
        }
        if (choice3.equalsIgnoreCase("c")) {
            System.out.println("🄰. Feelings and Drives\t\t\t\t\t\uD83C\uDD31. Desires and Feelings");
            System.out.println(Colors.ANSI_RED_BACKGROUND + "\uD83C\uDD32. Emotions and Feelings\t\t\t\t\t" + Colors.ANSI_RESET + Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD33. Desires and Drives" + Colors.ANSI_RESET);
            wrongAnswer();
        }

        if (choice3.equalsIgnoreCase("a")) {
            System.out.println(Colors.ANSI_RED_BACKGROUND + "🄰. Feelings and Drives" + Colors.ANSI_RESET + "\t\t\t\t\t\uD83C\uDD31. Desires and Feelings");
            System.out.println("\uD83C\uDD32. Emotions and Feelings\t\t\t\t\t" + Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD33. Desires and Drives" + Colors.ANSI_RESET);
            wrongAnswer();
        }
    }

    //for theme 3, question 1

    public void choice3Case1() {
        System.out.println("what are the names of the 3 wise men?");
        System.out.println("🄰. Beluci,Gaspão and Baltazar\t\t\t\t\t\uD83C\uDD31. Baltazar,Belchior and Gaspar");
        System.out.println("\uD83C\uDD32. Gustavo,Baltazar and Gaspar\t\t\t\t\t\uD83C\uDD33. Gusmão,Baltazar and Belchior");
        System.out.println("What is the right answer? ...A, B, C, or D?");
        System.out.println("Do you want to use Help? Press 'H' if the answer is yes:");
        String choice5 = scanner.next();
        if (choice5.equalsIgnoreCase("h")) {
            System.out.println("What is the help you want to use?\n\t1- The opinion of the audience (\uD83D\uDC68)\n\t2- The half and half (\uD835\uDFE7\uD835\uDFE2/\uD835\uDFE7\uD835\uDFE2)\n\t3- The call to a friend (\uD83D\uDCDE)");
            System.out.print("Help: ");
            int option = scanner.nextInt();
            if (option == 1) {
                int c = 12 - (int) (Math.random() * 5);
                int b = 38 - (int) (Math.random() * 5);
                int d = 20 - (int) (Math.random() * 5);
                int a = 30 - (int) (Math.random() * 5);

                System.out.println("[Option A] - " + a + "%");
                System.out.println("[Option B] - " + b + "%");
                System.out.println("[Option C] - " + c + "%");
                System.out.println("[Option D] - " + d + "%");

                int sum = a + b + c + d;

                int difference = 100 - sum;

                System.out.println(difference + "% didn't vote.");

                System.out.println("The audience done his job... What is your answer?");
            }

            if (option == 2) {
                System.out.println("what are the names of the 3 wise men?");
                System.out.println("🄰. \t\t\t\t\t\uD83C\uDD31. Baltazar,Belchior and Gaspar");
                System.out.println("\uD83C\uDD32. \t\t\t\t\t\uD83C\uDD33. Gusmão,Baltazar and Belchior");
                System.out.println("the computer eliminated A and C. What is your answer?");
            }

            if (option == 3) {
                System.out.println("Lets call to your friend...");
                System.out.println(".");
                System.out.println(".");
                System.out.println(".");

                System.out.println("Hello Jessi, can you tell me what is the right answer?\nThe question is...\n" +
                        "what are the names of the 3 wise men?" +
                        "a - Beluci,Gaspão and Baltazar, b - Baltazar,Belchior and Gaspar, c - Gustavo,Baltazar and Gaspar, d - Gusmão,Baltazar and Belchior");
                System.out.println("Jessi:  \"Hello my friend, i think B is the right answer\"");
                System.out.println("Thanks Jessi...");
                System.out.println("So , \n" +
                        "what will your answer be?");
            }
        } else {
            System.out.println("Well,i hope you know the answer.");
        }
        System.out.print("answer: ");
        String choice1 = scanner.next();
        if (choice1.equalsIgnoreCase("b")) {
            System.out.println("🄰. Beluci,Gaspão and Baltazar\t\t\t\t\t" + Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD31. Baltazar,Belchior and Gaspar" + Colors.ANSI_RESET);
            System.out.println("\uD83C\uDD32. Gustavo,Baltazar and Gaspar\t\t\t\t\t\uD83C\uDD33. Gusmão,Baltazar and Belchior");
            rightAnswer();

        }
        if (choice1.equalsIgnoreCase("c")) {
            System.out.println("🄰. Beluci,Gaspão and Baltazar\t\t\t\t\t" + Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD31. Baltazar,Belchior and Gaspar" + Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_RED_BACKGROUND + "\uD83C\uDD32. Gustavo,Baltazar and Gaspar" + Colors.ANSI_RESET + "\t\t\t\t\t\uD83C\uDD33. Gusmão,Baltzar and Belchior");
            wrongAnswer();

        }
        if (choice1.equalsIgnoreCase("a")) {
            System.out.println(Colors.ANSI_RED_BACKGROUND + "🄰. Beluci,Gaspão and Baltazar\t\t\t\t\t" + Colors.ANSI_RESET + Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD31. Baltazar,Belchior and Gaspar" + Colors.ANSI_RESET);
            System.out.println("\uD83C\uDD32. Gustavo,Baltazar and Gaspar\t\t\t\t\t\uD83C\uDD33. Gusmão,Baltazar and Belchior");
            wrongAnswer();
        }
        if (choice1.equalsIgnoreCase("d")) {
            System.out.println("🄰. Beluci,Gaspão and Baltazar\t\t\t\t\t" + Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD31. Baltazar,Belchior and Gaspar" + Colors.ANSI_RESET);
            System.out.println("\uD83C\uDD32. Gustavo,Baltazar and Gaspar\t\t\t\t\t" + Colors.ANSI_RED_BACKGROUND + "\uD83C\uDD33. Gusmão,Baltazar and Belchior" + Colors.ANSI_RESET);
            wrongAnswer();
        }
    }

    //for theme 3, question 2

    public void choice3Case2() {
        System.out.println("Which king was nicknamed \"The Farmer\"?");
        System.out.println("🄰. D. Afonso VII\t\t\t\t\t\uD83C\uDD31. D.Fernando");
        System.out.println("\uD83C\uDD32. D.Dinis\t\t\t\t\t\uD83C\uDD33. D.Sebastião");
        System.out.println("What is the right answer? ...A, B, C, or D?");
        System.out.println("Do you want to use Help? Press 'H' if the answer is YES or any other key if NO:");
        String choice5 = scanner.next();
        if (choice5.equalsIgnoreCase("h")) {
            System.out.println("What is the help you want to use?\n\t1- The opinion of the audience (\uD83D\uDC68)\n\t2- The half and half (\uD835\uDFE7\uD835\uDFE2/\uD835\uDFE7\uD835\uDFE2)\n\t3- The call to a friend (\uD83D\uDCDE)");
            System.out.print("Help: ");
            int option = scanner.nextInt();
            if (option == 1) {
                int c = 70 - (int) (Math.random() * 5);
                int b = 10 - (int) (Math.random() * 5);
                int d = 10 - (int) (Math.random() * 5);
                int a = 10 - (int) (Math.random() * 5);

                System.out.println("[Option A] - " + a + "%");
                System.out.println("[Option B] - " + b + "%");
                System.out.println("[Option C] - " + c + "%");
                System.out.println("[Option D] - " + d + "%");

                int sum = a + b + c + d;

                int difference = 100 - sum;

                System.out.println(difference + "% didn't vote.");

                System.out.println("The audience done his job... What is your answer?");
            }

            if (option == 2) {
                System.out.println("Which king was nicknamed \"The Farmer\"?");
                System.out.println("🄰. \t\t\t\t\t\uD83C\uDD31. D.Fernando");
                System.out.println("\uD83C\uDD32. D.Dinis\t\t\t\t\t\uD83C\uDD33. ");
                System.out.println("the computer eliminated A and D. What is your answer?");
            }

            if (option == 3) {
                System.out.println("Lets call to your friend...");
                System.out.println(".");
                System.out.println(".");
                System.out.println(".");

                System.out.println("Hello Jessi, can you tell me what is the right answer?\nThe question is...\n" +
                        "Which king was nicknamed \"The Farmer\"?" +
                        "a - D. Afonso VII, b - D.Fernando, c - D.Dinis, d - D.Sebastião");
                System.out.println("Jessi:  \"Hello my friend, i think C is the right answer\"");
                System.out.println("Thanks Jessi...");
                System.out.println("So , \n" +
                        "what will your answer be?");
            }
        } else {
            System.out.println("Well,i hope you know the answer.");
        }
        System.out.print("answer: ");
        String choice2 = scanner.next();
        if (choice2.equalsIgnoreCase("b")) {
            System.out.println("🄰. D. Afonso VII" + Colors.ANSI_RED_BACKGROUND + "\t\t\t\t\t\uD83C\uDD31. D.Fernando" + Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD32. D.Dinis\t\t\t\t\t" + Colors.ANSI_RESET + "\uD83C\uDD33. D.Sebastião");
            wrongAnswer();
        }
        if (choice2.equalsIgnoreCase("c")) {
            System.out.println("🄰. D. Afonso VII\t\t\t\t\t \uD83C\uDD31. D.Fernando");
            System.out.println(Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD32. D.Dinis" + Colors.ANSI_RESET + "\t\t\t\t\t\uD83C\uDD33. D.Sebastião");
            rightAnswer();
        }
        if (choice2.equalsIgnoreCase("a")) {
            System.out.println(Colors.ANSI_RED_BACKGROUND + "🄰. D. Afonso VII" + Colors.ANSI_RESET + "\t\t\t\t\t\uD83C\uDD31. D.Fernando");
            System.out.println(Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD32. D.Dinis" + Colors.ANSI_RESET + "\t\t\t\t\t\uD83C\uDD33. D.Sebastião");
            wrongAnswer();
        }

        if (choice2.equalsIgnoreCase("d")) {
            System.out.println("🄰. D. Afonso VII\t\t\t\t\t\uD83C\uDD31. D.Fernando");
            System.out.println(Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD32. D.Dinis" + Colors.ANSI_RESET + Colors.ANSI_RED_BACKGROUND + "\t\t\t\t\t\uD83C\uDD33. D.Sebastião" + Colors.ANSI_RESET);
            wrongAnswer();
        }
    }

    //for theme 3, question 3

    public void choice3Case3() {
        System.out.println("What monument was built after the Portugueses won the Battle of Aljubarrota?");
        System.out.println("🄰. Castelo de Paiva\t\t\t\t\t\uD83C\uDD31. Mosteiro de Alcubaça");
        System.out.println("\uD83C\uDD32. Mosteiro de Coimbra\t\t\t\t\t\uD83C\uDD33. Mosteiro da Batalha");
        System.out.println("What is the right answer? ...A, B, C, or D?");
        System.out.println("Do you want to use Help? Press 'H' if the answer is yes or any other key if answer is no:");
        String choice5 = scanner.next();
        if (choice5.equalsIgnoreCase("h")) {
            System.out.println("What is the help you want to use?\n\t1- The opinion of the audience (\uD83D\uDC68)\n\t2- The half and half (\uD835\uDFE7\uD835\uDFE2/\uD835\uDFE7\uD835\uDFE2)\n\t3- The call to a friend (\uD83D\uDCDE)");
            System.out.print("Help: ");
            int option = scanner.nextInt();
            if (option == 1) {
                int a = 13 - (int) (Math.random() * 5);
                int b = 17 - (int) (Math.random() * 5);
                int c = 30 - (int) (Math.random() * 5);
                int d = 40 - (int) (Math.random() * 5);

                System.out.println("[Option A] - " + a + "%");
                System.out.println("[Option B] - " + b + "%");
                System.out.println("[Option C] - " + c + "%");
                System.out.println("[Option D] - " + d + "%");

                int sum = a + b + c + d;

                int difference = 100 - sum;

                System.out.println(difference + "% didn't vote.");

                System.out.println("The audience done his job... What is your answer?");
            }

            if (option == 2) {
                System.out.println("What monument was built after the Portuguese won the Battle of Aljubarrota?");
                System.out.println("🄰. \t\t\t\t\t\uD83C\uDD31. Mosteiro de Alcubaça");
                System.out.println("\uD83C\uDD32. \t\t\t\t\t\uD83C\uDD33. Mosteiro da Batalha");
                System.out.println("the computer eliminated A and C. What is your answer?");
            }

            if (option == 3) {
                System.out.println("Lets call to your friend...");
                System.out.println(".");
                System.out.println(".");
                System.out.println(".");

                System.out.println("Hello Fifi, can you tell me what is the right answer?\nThe question is...\n" +
                        "What monument was built after the Portuguese won the Battle of Aljubarrota?" +
                        "a - Castelo de Paiva, b - Mosteiro de Alcubaça, c - Mosteiro de Coimbra, d - Mosteiro da Batalha");
                System.out.println("Fifi:  \"Hello my friend, i think C is the right answer\"");
                System.out.println("Thanks Fifi...");
                System.out.println("So , \n" +
                        "what will your answer be?");
            }
        } else {
            System.out.println("Well,i hope you know the answer.");
        }
        System.out.print("answer: ");
        String choice3 = scanner.next();
        if (choice3.equalsIgnoreCase("b")) {
            System.out.println("🄰. D. Afonso VII" + Colors.ANSI_RED_BACKGROUND + "\t\t\t\t\t\uD83C\uDD31. D.Fernando" + Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD32. D.Dinis\t\t\t\t\t" + Colors.ANSI_RESET + "\uD83C\uDD33. D.Sebastião");
            wrongAnswer();
        }
        if (choice3.equalsIgnoreCase("c")) {
            System.out.println("🄰. Castelo de Paiva\t\t\t\t\t\uD83C\uDD31. Mosteiro de Alcubaça");
            System.out.println(Colors.ANSI_RED_BACKGROUND + "\uD83C\uDD32. Mosteiro de Coimbra" + Colors.ANSI_RESET + "\t\t\t\t\t" + Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD33. Mosteiro da Batalha" + Colors.ANSI_RESET);
            wrongAnswer();
        }
        if (choice3.equalsIgnoreCase("a")) {
            System.out.println(Colors.ANSI_RED_BACKGROUND + "🄰. Castelo de Paiva\t\t\t\t\t" + Colors.ANSI_RESET + "\uD83C\uDD31. Mosteiro de Alcubaça");
            System.out.println("\uD83C\uDD32. Mosteiro de Coimbra\t\t\t\t\t" + Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD33. Mosteiro da Batalha" + Colors.ANSI_RESET);
            wrongAnswer();
        }

        if (choice3.equalsIgnoreCase("d")) {
            System.out.println("🄰. Castelo de Paiva\t\t\t\t\t\uD83C\uDD31. Mosteiro de Alcubaça");
            System.out.println("\uD83C\uDD32. Mosteiro de Coimbra\t\t\t\t\t" + Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD33. Mosteiro da Batalha" + Colors.ANSI_RESET);
            rightAnswer();
        }
    }

    //for theme 4, question 1

    public void choice4Case1() {
        System.out.println("Who is the best football player in the World?");
        System.out.println("🄰. Messi\t\t\t\t\t\uD83C\uDD31. Cristiano Ronaldo");
        System.out.println("\uD83C\uDD32. Ronaldinho\t\t\t\t\t\uD83C\uDD33. Neymar");
        System.out.println("What is the right answer? ...A, B, C, or D?");
        System.out.println("Do you want to use Help? Press 'H' if the answer is yes or any other key if answer is no:");
        String choice5 = scanner.next();
        if (choice5.equalsIgnoreCase("h")) {
            System.out.println("What is the help you want to use?\n\t1- The opinion of the audience (\uD83D\uDC68)\n\t2- The half and half (\uD835\uDFE7\uD835\uDFE2/\uD835\uDFE7\uD835\uDFE2)\n\t3- The call to a friend (\uD83D\uDCDE)");
            System.out.print("Help: ");
            int option = scanner.nextInt();
            if (option == 1) {
                int a = 1 - (int) (Math.random() * 5);
                int b = 97 - (int) (Math.random() * 5);
                int c = 1 - (int) (Math.random() * 5);
                int d = 1 - (int) (Math.random() * 5);

                System.out.println("[Option A] - " + a + "%");
                System.out.println("[Option B] - " + b + "%");
                System.out.println("[Option C] - " + c + "%");
                System.out.println("[Option D] - " + d + "%");

                int sum = a + b + c + d;

                int difference = 100 - sum;

                System.out.println(difference + "% didn't vote.");

                System.out.println("The audience done his job... What is your answer?");
            }

            if (option == 2) {
                System.out.println("Who is the best football player in the World?");
                System.out.println("🄰. \t\t\t\t\t\uD83C\uDD31. Cristiano Ronaldo");
                System.out.println("\uD83C\uDD32. \t\t\t\t\t\uD83C\uDD33. Neymar");
                System.out.println("the computer eliminated A and C. What is your answer?");
            }

            if (option == 3) {
                System.out.println("Lets call to your friend...");
                System.out.println(".");
                System.out.println(".");
                System.out.println(".");

                System.out.println("Hello Manel, can you tell me what is the right answer?\nThe question is...\n" +
                        "Who is the best football player in the World?" +
                        "a - Messi, b - Cristiano Ronaldo, c - Ronaldinho, d - Neymar");
                System.out.println("Manel:  \"Hello my friend, i have 100% sure B is the right answer\"");
                System.out.println("Thanks Manel...");
                System.out.println("So , \n" +
                        "what will your answer be?");
            }
        } else {
            System.out.println("Well,i hope you know the answer.");
        }
        System.out.print("answer: ");
        String choice1 = scanner.next();
        if (choice1.equalsIgnoreCase("b")) {
            System.out.println("🄰. Messi\t\t\t\t\t" + Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD31. Cristiano Ronaldo" + Colors.ANSI_RESET);
            System.out.println("\uD83C\uDD32. Ronaldinho\t\t\t\t\t\uD83C\uDD33. Neymar");
            rightAnswer();

        }
        if (choice1.equalsIgnoreCase("c")) {
            System.out.println("🄰. Messi\t\t\t\t\t" + Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD31. Cristiano Ronaldo" + Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_RED_BACKGROUND + "\uD83C\uDD32. Ronaldinho" + Colors.ANSI_RESET + "\t\t\t\t\t\uD83C\uDD33. Neymar");
            wrongAnswer();

        }
        if (choice1.equalsIgnoreCase("a")) {
            System.out.println(Colors.ANSI_RED_BACKGROUND + "🄰. Messi\t\t\t\t\t" + Colors.ANSI_RESET + Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD31. Cristiano Ronaldo" + Colors.ANSI_RESET);
            System.out.println("\uD83C\uDD32. Ronaldinho\t\t\t\t\t\uD83C\uDD33. Neymar");
            wrongAnswer();
        }
        if (choice1.equalsIgnoreCase("d")) {
            System.out.println("🄰. Messi\t\t\t\t\t" + Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD31. Cristiano Ronaldo" + Colors.ANSI_RESET);
            System.out.println("\uD83C\uDD32. Ronaldinho\t\t\t\t\t" + Colors.ANSI_RED_BACKGROUND + "\uD83C\uDD33. Neymar" + Colors.ANSI_RESET);
            wrongAnswer();
        }
    }

    //for theme 4, question 2

    public void choice4Case2() {
        System.out.println("What is the best Portuguese Team of the present time?");
        System.out.println("🄰. SL Benfica\t\t\t\t\t\uD83C\uDD31. Sporting");
        System.out.println("\uD83C\uDD32. Beira-Mar\t\t\t\t\t\uD83C\uDD33. Braga");
        System.out.println("What is the right answer? ...A, B, C, or D?");
        System.out.println("Do you want to use Help? Press 'H' if the answer is yes or any other key if answer is no:");
        String choice5 = scanner.next();
        if (choice5.equalsIgnoreCase("h")) {
            System.out.println("What is the help you want to use?\n\t1- The opinion of the audience (\uD83D\uDC68)\n\t2- The half and half (\uD835\uDFE7\uD835\uDFE2/\uD835\uDFE7\uD835\uDFE2)\n\t3- The call to a friend (\uD83D\uDCDE)");
            System.out.print("Help: ");
            int option = scanner.nextInt();
            if (option == 1) {
                int a = 73 - (int) (Math.random() * 5);
                int b = 7 - (int) (Math.random() * 5);
                int c = 10 - (int) (Math.random() * 5);
                int d = 10 - (int) (Math.random() * 5);

                System.out.println("[Option A] - " + a + "%");
                System.out.println("[Option B] - " + b + "%");
                System.out.println("[Option C] - " + c + "%");
                System.out.println("[Option D] - " + d + "%");

                int sum = a + b + c + d;

                int difference = 100 - sum;

                System.out.println(difference + "% didn't vote.");

                System.out.println("The audience done his job... What is your answer?");
            }

            if (option == 2) {
                System.out.println("What is the best Portuguese Team of the present time?");
                System.out.println("🄰. SL Benfica\t\t\t\t\t\uD83C\uDD31. ");
                System.out.println("\uD83C\uDD32. Beira-Mar\t\t\t\t\t\uD83C\uDD33. ");
                System.out.println("the computer eliminated B and D. What is your answer?");
            }

            if (option == 3) {
                System.out.println("Lets call to your friend...");
                System.out.println(".");
                System.out.println(".");
                System.out.println(".");

                System.out.println("Hello Julio, can you tell me what is the right answer?\nThe question is...\n" +
                        "What is the best Portuguese Team of the present time?" +
                        "a - SL Benfica, b - Sporting, c - Beira-Mar, d - Braga");
                System.out.println("Julio:  \"Hello my friend, i know A is the right answer\"");
                System.out.println("Thanks Julio...");
                System.out.println("So , \n" +
                        "what will your answer be?");
            }
        } else {
            System.out.println("Well,i hope you know the answer.");
        }
        System.out.print("answer: ");
        String choice2 = scanner.next();
        if (choice2.equalsIgnoreCase("a")) {
            System.out.println(Colors.ANSI_GREEN_BACKGROUND + "🄰. SL Benfica " + Colors.ANSI_RESET + "\t\t\t\t\t\uD83C\uDD31. Sporting");
            System.out.println("\uD83C\uDD32. Beira-Mar\t\t\t\t\t\uD83C\uDD33. Braga");
            rightAnswer();
        }
        if (choice2.equalsIgnoreCase("c")) {
            System.out.println(Colors.ANSI_GREEN_BACKGROUND + "🄰. Sl Benfica\t\t\t\t\t" + Colors.ANSI_RESET + "\uD83C\uDD31. Sporting");
            System.out.println(Colors.ANSI_RED_BACKGROUND + "\uD83C\uDD32. Beira-Mar" + Colors.ANSI_RESET + "\t\t\t\t\t\uD83C\uDD33. Braga");
            wrongAnswer();
        }
        if (choice2.equalsIgnoreCase("b")) {
            System.out.println(Colors.ANSI_GREEN_BACKGROUND + "🄰. Sl Benfica\t\t\t\t\t" + Colors.ANSI_RESET + Colors.ANSI_RED_BACKGROUND + "\uD83C\uDD31. Sporting" + Colors.ANSI_RESET);
            System.out.println("\uD83C\uDD32. Beira-Mar\t\t\t\t\t\uD83C\uDD33. Braga");
            wrongAnswer();
        }

        if (choice2.equalsIgnoreCase("d")) {
            System.out.println(Colors.ANSI_GREEN_BACKGROUND + "🄰. SL Benfica\t\t\t\t\t" + Colors.ANSI_RESET + "\uD83C\uDD31. Sporting");
            System.out.println("\uD83C\uDD32. Beira-Mar\t\t\t\t\t" + Colors.ANSI_RED_BACKGROUND + "\uD83C\uDD33. Braga" + Colors.ANSI_RESET);
            wrongAnswer();
        }
    }

    //for theme 4, question 3

    public void choice4Case3() {
        System.out.println("How many cups will Benfica win this season?");
        System.out.println("🄰. 2\t\t\t\t\t\uD83C\uDD31. None");
        System.out.println("\uD83C\uDD32. At least 3\t\t\t\t\t\uD83C\uDD33. 1");
        System.out.println("What is the right answer? ...A, B, C, or D?");
        System.out.println("Do you want to use Help? Press 'H' if the answer is yes or any other key if answer is no:");
        String choice5 = scanner.next();
        if (choice5.equalsIgnoreCase("h")) {
            System.out.println("What is the help you want to use?\n\t1- The opinion of the audience (\uD83D\uDC68)\n\t2- The half and half (\uD835\uDFE7\uD835\uDFE2/\uD835\uDFE7\uD835\uDFE2)\n\t3- The call to a friend (\uD83D\uDCDE)");
            System.out.print("Help: ");
            int option = scanner.nextInt();
            if (option == 1) {
                int a = 10 - (int) (Math.random() * 5);
                int b = 20 - (int) (Math.random() * 5);
                int c = 50 - (int) (Math.random() * 5);
                int d = 20 - (int) (Math.random() * 5);

                System.out.println("[Option A] - " + a + "%");
                System.out.println("[Option B] - " + b + "%");
                System.out.println("[Option C] - " + c + "%");
                System.out.println("[Option D] - " + d + "%");

                int sum = a + b + c + d;

                int difference = 100 - sum;

                System.out.println(difference + "% didn't vote.");

                System.out.println("The audience done his job... What is your answer?");
            }

            if (option == 2) {
                System.out.println("How many cups will Benfica win this season?");
                System.out.println("🄰. \t\t\t\t\t\uD83C\uDD31. None");
                System.out.println("\uD83C\uDD32. At least 3\t\t\t\t\t\uD83C\uDD33. ");
                System.out.println("the computer eliminated A and D. What is your answer?");
            }

            if (option == 3) {
                System.out.println("Lets call to your friend...");
                System.out.println(".");
                System.out.println(".");
                System.out.println(".");

                System.out.println("Hello Pablo, can you tell me what is the right answer?\nThe question is...\n" +
                        "How many cups will Benfica win this season?" +
                        "a - 2, b - None, c - At least 3, d - 1");
                System.out.println("Pablo:  \"Hello my friend, i think C is the right answer\"");
                System.out.println("Thanks Pablo...");
                System.out.println("So , \n" +
                        "what will your answer be?");
            }
        } else {
            System.out.println("Well,i hope you know the answer.");
        }
        System.out.print("answer: ");
        String choice3 = scanner.next();
        if (choice3.equalsIgnoreCase("b")) {
            System.out.println("🄰. 2\t\t\t\t\t" + Colors.ANSI_RED_BACKGROUND + "\uD83C\uDD31. None" + Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD32. At least 3" + Colors.ANSI_RESET + "\t\t\t\t\t\uD83C\uDD33. 1");
            wrongAnswer();
        }
        if (choice3.equalsIgnoreCase("c")) {
            System.out.println("🄰. 2\t\t\t\t\t\uD83C\uDD31. None");
            System.out.println(Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD32. At least 3" + Colors.ANSI_RESET + "\t\t\t\t\t\uD83C\uDD33. 1");
            rightAnswer();
        }
        if (choice3.equalsIgnoreCase("a")) {
            System.out.println(Colors.ANSI_RED_BACKGROUND + "🄰. 2\t\t\t\t\t" + Colors.ANSI_RESET + "\uD83C\uDD31. None");
            System.out.println(Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD32. At least 3" + Colors.ANSI_RESET + "\t\t\t\t\t\uD83C\uDD33. 1");
            wrongAnswer();
        }

        if (choice3.equalsIgnoreCase("d")) {
            System.out.println("🄰. 2\t\t\t\t\t\uD83C\uDD31. None");
            System.out.println(Colors.ANSI_GREEN_BACKGROUND + "\uD83C\uDD32. At least 3" + Colors.ANSI_RESET + Colors.ANSI_RED_BACKGROUND + "\t\t\t\t\t\uD83C\uDD33. 1" + Colors.ANSI_RESET);
            wrongAnswer();
        }
    }

    // print the available themes
    public void printThemes() {
        System.out.println("Choose a theme for your question:");
        System.out.println("\t1 - " + QuizThemes.ANATOMY + "\n\t2 - " +
                QuizThemes.PHILOSOPHY + "\n\t3 - " + QuizThemes.HISTORY +
                "\n\t4 - " + QuizThemes.SPORT);
    }

    public void choice1() {
        int randNum = 1 + (int) (Math.random() * 3);
        switch (randNum) {
            case 1:
                choice1Case1();
                break;
            case 2:
                choice1Case2();
                break;
            case 3:
                choice1Case3();
                break;
            default:
                System.out.println();
        }
    }

    public void choice2() {
        int randNum2 = 1 + (int) (Math.random() * 3);
        switch (randNum2) {
            case 1:
                choice2Case1();
                break;
            case 2:
                choice2Case2();
                break;
            case 3:
                choice2Case3();
                break;
            default:
                System.out.println();
        }
    }

    public void choice3() {
        int randNum3 = 1 + (int) (Math.random() * 3);
        switch (randNum3) {
            case 1:
                choice3Case1();
                break;
            case 2:
                choice3Case2();
                break;
            case 3:
                choice3Case3();
                break;
            default:
                System.out.println();
        }
    }

    public void choice4() {
        int randNum4 = 1 + (int) (Math.random() * 3);
        switch (randNum4) {
            case 1:
                choice4Case1();
                break;
            case 2:
                choice4Case2();
                break;
            case 3:
                choice4Case3();
                break;
            default:
                System.out.println();
        }
    }

}