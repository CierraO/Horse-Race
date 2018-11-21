import java.util.Scanner;

public class Driver
{
    // Creates an object to take in user input
    static Scanner input = new Scanner(System.in);
    // Creates a new track with 6 horses that is 80 hyphens long
    static Track horseTrack = new Track(6, 80);

    public static void main(String[] args)
    {
        
        // Asks the player to guess what horse will win
        horseTrack.takeGuess();

        // Prints the track to the console and waits for the player to press enter before continuing
        horseTrack.printTrack();
        continueRace();
        
        // As long as no one has won, each horse keeps getting a new position and the track keeps printing
        while(horseTrack.raceOngoing())
        {
            for(int j = 0; j < horseTrack.getNumOfHorses(); j++)
            {
                horseTrack.horses[j].setPosition();
            }

            horseTrack.printTrack();
            continueRace();
        }

        // Now that one or more horse has won, checks to see if the player's guess was correct
        horseTrack.checkWin();

    }


    // Asks the player to press the enter key in order to continue
    public static void continueRace()
    {
        System.out.println("Press enter to continue.");
        String enter = input.nextLine();
    }

}