import java.util.Scanner;

public class Track
{

    private int numOfHorses;
    private int lengthOfTrack;
    static int guess = 0;
    static boolean isInt;
    static Scanner input = new Scanner(System.in);   // Creates an object to take in user input
    Horse[] horses;   // Creates an array of horses

    // The constructor; sets the variables and gives values to the array
    public Track(int numOfHorses, int lengthOfTrack)
    {

        this.numOfHorses = numOfHorses;
        this.lengthOfTrack = lengthOfTrack;
        this.horses = new Horse[numOfHorses];

        // For every horse, a horse is added to the array
        for(int i = 0; i < this.numOfHorses; i++)
        {
            this.horses[i] = new Horse();
        }

    }


    public int getNumOfHorses()
    {
        return this.numOfHorses;
    }


    public int getLengthOfTrack()
    {
        return this.lengthOfTrack;
    }


    // Takes the user's guess of what horse will win and stores it
    public void takeGuess()
    {
        System.out.println("There are six horses racing today! Pick which horse you think will win by entering a number from 1 to 6.");

        // As long as guess has not been assigned a new value, this will repeat
        while(guess == 0)
        {
            // userInput will be set to whatever the user inputs to the console
            String userInput = input.nextLine();

            // Determines whether what the user inputted is an int
            // The first part checks if converting the int to a String causes an error
            try
            {
                Integer.parseInt(userInput);
                isInt = true;   // If the line above does not cause an error, the input is an int, so isInt is set to true
            }
            catch(NumberFormatException e)
            {
                isInt = false;   // If it did cause an error, it means the input is not an int, so isInt is set to false
            }

            // If what the user has inputted is a whole number between 1 and 6, the value will be given to guess
            // and the loop will stop repeating
            if(isInt && Integer.parseInt(userInput) >= 1 && Integer.parseInt(userInput) <= 6)   //Integer.parseInt converts the integer to a String
            {
                guess = Integer.parseInt(userInput);
            }
            else
            {
                // If what the user inputted is not a whole number between 1 and 6, guess will not be given the value
                // and the loop will repeat
                System.out.println("This is not a number from 1 to 6. Please try again. Make sure you are entering the number in its numeric form.");
            } 
        }

    }


    // Prints out the tracks to the console
    public void printTrack()
    {

        // One lane will be printed per horse
        for(int i = 0; i < this.numOfHorses; i++)
        {
            // The amount of hyphens printed is equal to the length of the track
            for(int j = 0; j < this.lengthOfTrack; j++)
            {
                // If this is where the horse is positioned, print the number of the horse rather than a hyphen
                if(j == horses[i].getPosition())
                {
                    System.out.print(i + 1);
                }
                else
                {
                    System.out.print("-");
                }
            }

            System.out.println();
        }

    }


    // Determines if the race is still ongoing or if a horse has won
    public boolean raceOngoing()
    {

        int numOfWinners = 0;
        // Every horse will be checked to see if it is in the last position / if it has won
        // If it is, one is added to the number of winners
        for(int i = 0; i < this.numOfHorses; i++)
        {
            if(this.horses[i].getPosition() == this.lengthOfTrack - 1)
            {
                numOfWinners++;
            }
        }

        // If there is at least one winner, the race is no longer ongoing
        if(numOfWinners > 0)
        {
            return false;
        }
        else
        {
            return true;
        }

    }


    // Checks if the player has won
    public void checkWin()
    {

        boolean win = false;

        // If a horse is in the last position, it checks to see if this is the horse the player guessed
        // If so, the player wins
        for(int i = 0; i < this.numOfHorses; i++)
        {
            if(this.horses[i].getPosition() == this.lengthOfTrack - 1)
            {
                if(i + 1 == guess)
                {
                    win = true;
                }
            }
        }

        if(win)
        {
            System.out.println("You win!");
        }
        else
        {
            System.out.println("You lose!");
        }

    }

}