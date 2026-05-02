import javax.swing.JOptionPane;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {

        Random random = new Random();
        int score = 0;
        String playAgain = "" ;
    

         int input = JOptionPane.showOptionDialog(
        null,                        
            "Guess Number Between 1-100",    //Message
            "Number Guessing Game",         //Title
            JOptionPane.YES_NO_OPTION,     
            JOptionPane.QUESTION_MESSAGE,  
            null,                          
            new Object[]{"Start Game", "Exit"}, //Buttons  
            "Start Game" //Default Button                  
            );  

    if(input == 0){        //checks for Empty Input

    do {

        int numberToGuess = random.nextInt(100) + 1 ;
        int attempts = 0;
        boolean  hasWon = false;

        while(!hasWon){
               String userInput = JOptionPane.showInputDialog("Enter your Guess:");
               if(userInput.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please Enter a Number!");
               }else{
               int userGuess = Integer.parseInt(userInput);
               attempts++;

               if (userGuess == numberToGuess) {
                    hasWon = true;
                    if(attempts <= 3) {
                        score += 10;}
                            else if (attempts <=6){
                                score += 5;
                                } else {
                                    score +=1;
                                    }

                JOptionPane.showMessageDialog(null, "Correct! You guessed in "+ attempts +" attempts");
 
                  } else if (userGuess < numberToGuess) {  //Checks Guessed Number is Small or not  
                        JOptionPane.showMessageDialog(null, "Too Low! Try Higher");
                         } else {    
                            JOptionPane.showMessageDialog(null, "Too High! Try Lower");
                    }



        }}

        playAgain = JOptionPane.showInputDialog("Play Again ?? (Yes/No)");  

    }   while (playAgain.equalsIgnoreCase("Yes"));

        JOptionPane.showMessageDialog(null, "Game Over! Your Final Score: " + score);

    }}   

}
