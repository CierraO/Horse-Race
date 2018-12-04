import java.util.Random;

public class Horse
{

    // Creates an object that allows random numbers to be generated
    Random random = new Random();
    private int position;
    private int farthestPosition;

    /**
     * Constructor, used to create a new Horse
     */
    public Horse(int farthestPosition)
    {

        this.position = 0;
        this.farthestPosition = farthestPosition;

    }


    /**
     * Randomizes how far the horse has moved from 0 to 2 steps
     */
    public void setPosition()
    {

        // Finds a random number from 0 to 2 and adds that to the current position
        int change = random.nextInt(3);
        this.position = this.position + change;

        // If the horse has gone farther than the end of the track, the horse's position is set back to the end of the track
        if(this.position > this.farthestPosition)
        {
            this.position = this.farthestPosition;
        }

    }

    
    public int getPosition()
    {

        return this.position;

    }

}