import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        while (true) {
            int userChoice = 0;
            System.out.println("||| Welcome to quiz! |||");
            System.out.println("This quiz has 3 questions.");
            System.out.println("----------------------------------");
            System.out.println("Please choose from the following: ");
            System.out.println("1) Math");
            System.out.println("2) Geography");
            System.out.println("0) Quit");
            Scanner scanner = new Scanner(System.in);
            try {
                userChoice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input.");
                continue;
            }

            if (userChoice == 1) {
                Quiz.mathQuiz(scanner);
            }
            if (userChoice == 2) {
                Quiz.geographyQuiz(scanner);
            }
            if (userChoice == 0) {
                break;
            }
        }
    }

}

class Quiz {
    public static void geographyQuiz(Scanner scanner) {
        System.out.println("----------------------------------");
        System.out.println("You have chosen: Geography.");
        System.out.println("Welcome to Geography quiz!");
        System.out.println("==================================");
        char a, b, c;
        int score = 0;
        if (Question.askQuestion(scanner, "What is the capital of France? \n a) Madrid\n b) Paris\n c) Rome (Question with a single answer)", "b")) {
            score++;
        }
        if (Question.askQuestion(scanner, "Which continent is Brazil located on? \n a) Asia\n b) South America\n c) Africa (Question with a single answer)", "b")) {
            score++;
        }
        if (Question.askQuestion(scanner, "Which ocean is the largest? \n a) Atlantic Ocean\n b) Indian Ocean\n c) Pacific (Question with a single answer)", "c")) {
            score++;
        }

        Results.showResults(score);
    }
    public static void mathQuiz(Scanner scanner){
        System.out.println("----------------------------------");
        System.out.println("You have chosen: Math.");
        System.out.println("Welcome to Math quiz!");
        System.out.println("==================================");
        char a, b, c;
        int score = 0;
        if (Question.askQuestion(scanner, "What is 2 + 2\n a) 5\n b) 4\n c) 6 (Question with a single answer)", "b")) {
            score++;
        }
        if (Question.askQuestion(scanner, "What is 2 + 5 \n a)7\n b) 12\n c) 8 (Question with a single answer)", "a")) {
            score++;
        }
        if (Question.askQuestion(scanner, "4 = ?\n a) 2^2\n b) -2^2\n c) 1+3 (Question with multiple answers)", "ac")) {
            score++;
        }
        Results.showResults(score);


    }
}

class Question {
    public static boolean askQuestion(Scanner scanner, String question, String correctAnswer) {
        System.out.println(question);

        String userInput = "";

        while (true) {
            System.out.print("Enter your answer: ");
            try {
                userInput = scanner.next().toLowerCase();

                if (!userInput.matches("[abc]+")) {
                    System.out.println("Invalid choice. Please use letters a, b, or c only.");
                    continue;
                }

                break;

            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
                scanner.nextLine();
            }
        }

        Set<Character> correctSet = new HashSet<>();
        for (char c : correctAnswer.toCharArray()) {
            correctSet.add(c);
        }

        Set<Character> userSet = new HashSet<>();
        for (char c : userInput.toCharArray()) {
            userSet.add(c);
        }

        if (userSet.equals(correctSet)) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("Incorrect.");
            return false;
        }
    }

}
class Results {
    public static void showResults(int score) {
        System.out.println("----------------------------------");
        System.out.println("Your score: " + score + "/3");
        System.out.println("==================================");
    }
}