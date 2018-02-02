package ca.ualberta.cs.lonelytwitter;

/**
 * Created by dezfuli on 1/16/18.
 */
import java.util.Date;

/**
 * Represents something that can be tweeted.
 *
 * @author dezfuli
 * @version 1.0
 */
public interface Tweetable {
    /**
     * Gets the message of the tweetable object
     * @return message of the tweetable object
     */
    public String getMessage();
    
    /**
     * Gets the date of the tweetable object
     * @return date of the tweetable object
     */
    public Date getDate();
}
