import java.util.Scanner;
import java.util.Random;

public class Hangman {
    private static final String[] WORDS = {
        "programming", "java", "developer", "computer", "keyboard", "screen", "network", "hangman"
    };
    private static final int MAX_TRIES = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        
        String wordToGuess = WORDS[random.nextInt(WORDS.length)];
        char[] wordArray = new char[wordToGuess.length()];
        for (int i = 0; i < wordArray.length; i++) {
            wordArray[i] = '_';
        }
        
        int tries = 0;
        boolean guessed = false;
        StringBuilder wrongGuesses = new StringBuilder();
        
        System.out.println("Witamy w grze Wisielec!");
        
       
        while (tries < MAX_TRIES && !guessed) {
            System.out.println("\nZgadnij słowo: ");
            printWordArray(wordArray);
            System.out.println("\nNieprawidłowe litery: " + wrongGuesses);
            System.out.println("Pozostałe próby: " + (MAX_TRIES - tries));
            System.out.print("Podaj literę: ");
            char guess = scanner.next().toLowerCase().charAt(0);
            
            
            if (wordToGuess.indexOf(guess) >= 0) {
                
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guess) {
                        wordArray[i] = guess;
                    }
                }
            } else {
                
                if (wrongGuesses.toString().indexOf(guess) == -1) {
                    wrongGuesses.append(guess).append(' ');
                    tries++;
                } else {
                    System.out.println("Już próbowałeś tej litery!");
                }
            }
            
            
            guessed = isWordGuessed(wordArray);
        }
        
        
        if (guessed) {
            System.out.println("\nGratulacje! Zgadłeś słowo: " + wordToGuess);
        } else {
            System.out.println("\nNiestety, przegrałeś. Szukane słowo to: " + wordToGuess);
        }
        
        scanner.close();
    }

   
    private static void printWordArray(char[] wordArray) {
        for (char c : wordArray) {
            System.out.print(c + " ");
        }
    }

    
    private static boolean isWordGuessed(char[] wordArray) {
        for (char c : wordArray) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }
}