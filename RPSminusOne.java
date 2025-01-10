import java.util.Scanner;

public class RPSminusOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(); // Visual appeals
        System.out.println("Welcome to Rock Paper Scissors, Minus One!");
        System.out.println();

        // Get user's first hand
        System.out.print("Please declare 'r', 'p', or 's' for your first hand: ");
        char userInputOne = scanner.next().charAt(0); // Wait for user to input a letter
        while (!valid(userInputOne)) { // Only let user input r, p, or s
            System.out.print("Please only declare 'r', 'p', or 's': ");
            userInputOne = scanner.next().charAt(0);
        }

        System.out.println();

        // Same thing for second hand
        System.out.print("Please declare 'r', 'p', or 's' for your second hand: ");
        char userInputTwo = scanner.next().charAt(0);
        while (!valid(userInputTwo)) {
            System.out.print("Please only declare 'r', 'p', or 's': ");
            userInputTwo = scanner.next().charAt(0);
        }

        System.out.println(); // Visual appeals

        // Randomly assign computer hands
        char computerInputOne;
        char computerInputTwo;
        int random1 = (int) StdRandom.uniform(0.0, 2.0);
        int random2 = (int) StdRandom.uniform(0.0, 2.0);

        if (random1 == 0) {
            computerInputOne = 'r';
        } else if (random1 == 1) {
            computerInputOne = 'p';
        } else {
            computerInputOne = 's';
        }

        if (random2 == 0) {
            computerInputTwo = 'r';
        } else if (random2 == 1) {
            computerInputTwo = 'p';
        } else {
            computerInputTwo = 's';
        }

        // Play stage 1
        System.out.println("Rock, Paper, Scissors, shoot...");
        System.out.println("Computer picked: " + computerInputOne + " and " + computerInputTwo + ".");

        System.out.println(); // Visuals

        // Start stage 2
        System.out.print("Pick one of your hands to remove: ");
        char removalHand = scanner.next().charAt(0);
        while (!validRemoval(removalHand, userInputOne, userInputTwo)) {
            System.out.print("Please only pick one of your current two hands, '" + userInputOne + "' or '" + userInputTwo + "': ");
            removalHand = scanner.next().charAt(0);
        }
        char userSelectedHand;
        if (removalHand == userInputOne) {
            userSelectedHand = userInputTwo;
        } else {
            userSelectedHand = userInputOne;
        }

        System.out.println(); // Visuals

        // Remove computer hand
        char computerSelectedHand;
        int randomRemoval = (int) StdRandom.uniform (0.0, 1.0); 
        if (randomRemoval ==  0) {
            computerSelectedHand = computerInputTwo;
        } else {
            computerSelectedHand = computerInputOne;
        }

        // Play stage 2
        System.out.println("...Minus one!");
        if (userSelectedHand == computerSelectedHand) {
            System.out.println("Computer picked " + computerSelectedHand + ".");
            System.out.println("You tied! Quit and play again!");
        } else {
            System.out.println(decideWinner(userSelectedHand, computerSelectedHand));
            System.out.println();
        }
        
        scanner.close();

    }

    public static boolean valid(char userInput) {
        return userInput == 'r' || userInput == 'p' || userInput == 's';
    }

    public static boolean validRemoval(char removalHand, char handOne, char handTwo) {
        return removalHand == handOne || removalHand == handTwo;
    }

    public static String decideWinner(char userSelectedHand, char computerSelectedHand) {
        if (userSelectedHand == 'r' && computerSelectedHand == 's') {
            return "You picked r and computer picked s! You Win!";
        } else if (userSelectedHand == 'p' && computerSelectedHand == 'r') {
            return "You picked p and computer picked r! You Win!";
        } else if (userSelectedHand == 's' && computerSelectedHand == 'p') {
            return "You picked s and computer picked p! You Win!";
        } else {
            return ("You picked " + userSelectedHand + " and computer picked " + computerSelectedHand + "! You Lose!");
        }
    }

}