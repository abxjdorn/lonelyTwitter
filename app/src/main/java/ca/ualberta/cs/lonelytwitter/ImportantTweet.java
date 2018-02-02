package ca.ualberta.cs.lonelytwitter;

/**
 * Created by dezfuli on 1/16/18.
 */
import java.util.Date;

/**
 * Represents a tweet that is important.
 *
 * @author dezfuli
 * @version 1.0
 */
public class ImportantTweet extends Tweet {
    /**
     * Creates an important tweet from message, filling in the
     * date automatically.
     * @param message message of the new tweet
     *
     * @see Tweet
     */
    ImportantTweet(String message){
        super(message);
    }
    
    /**
     * Creates an important tweet with explicit message and date.
     * @param message message of the new tweet
     * @param date date of the new tweet
     *
     * @see Tweet
     */
    ImportantTweet(String message, Date date){
        super(message, date);
    }
    
    /**
     * Returns whether the tweet is important
     *
     * @return whether the tweet is important (it is, so returns true)
     */
    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}
