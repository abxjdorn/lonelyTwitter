package ca.ualberta.cs.lonelytwitter;

/**
 * Created by dezfuli on 1/16/18.
 */
import java.util.Date;

/**
 * Represents a concrete tweet with no special properties.
 *
 * @author dezfuli
 * @version 1.0
 */
public class NormalTweet extends Tweet {
    /**
     * Creates a tweet with explicit message and automatically sets the date.
     * @param message message of the new tweet.
     *
     * @see Tweet
     */
    NormalTweet(String message){
        super(message);
    }
    
    /**
     * Creates a tweet with explicit message and date.
     * @param message
     * @param date
     *
     * @see Tweet
     */
    NormalTweet(String message, Date date){
        super(message, date);
    }
    
    /**
     * Returns whether this tweet is important
     *
     * @return whether the tweet is important (it isn't, so returns false)
     *
     * @see ImportantTweet
     */
    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
