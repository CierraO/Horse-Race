import java.util.Random;

public class Horse
{

    // Creates an object that alows random numbers to be generated
    Random random = new Random();
    private int position;

    // Constructor; all horses are in the 0th position at first
    public Horse()
    {

        this.position = 0;

    }


    // Randomizes how far the horse has moved from 0 to 2 steps
    public void setPosition()
    {

        // Finds a random number from 0 to 2 and adds that to the current position
        int change = random.nextInt(3);
        this.position = this.position + change;

        // If the horse has gone farther than the end of the track, the horse's position is set back to the end of the track
        if(this.position > Driver.horseTrack.getLengthOfTrack() - 1)
        {
            this.position = Driver.horseTrack.getLengthOfTrack() - 1;
        }

    }

    
    public int getPosition()
    {

        return this.position;

    }

}