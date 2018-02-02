/* Tweet
 *
 * Version 1.0
 *
 * Feb 01, 2018
 *
 * Copyright ...
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by dezfuli on 1/16/18.
 */

/**
 * Represents a tweet
 *
 * @author dezfuli
 * @version 1.0
 */
public abstract class Tweet implements Tweetable {
    /** Message of the tweet */
    private String message;
    
    /** Date of the tweet */
    private Date date;
    
    /**
     * Constructs a tweet instance using the given message
     *
     * @param message the message of the tweet
     */
    Tweet(String message){

        this.message = message;
        date = new Date();
//        message = message;
    }
    
    /**
     * Creates a tweet with given message and date.
     *
     * @param message message of the tweet
     * @param date date of the tweet
     */
    Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }
    
    /**
     * Gets the message of the tweet.
     *
     * @return message of the tweet
     */
    public String getMessage(){
        return message;
    }
    
    /**
     * Sets the message of the tweet
     *
     * @param message the new message of the tweet
     * @throws TweetTooLongException is thrown when the message is over 140 characters
     *
     * @see ImportantTweet
     * @see NormalTweet
     */
    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() < 140){
            this.message = message;
        }
        else{
            throw new TweetTooLongException();
        }
    }
    
    /**
     * Gets the date of the tweet.
     *
     * @return date of the tweet
     */
    public Date getDate(){
        return date;
    }
    
    /**
     * Sets the date of the tweet.
     *
     * @param date date to set
     */
    public void setDate(Date date){
        this.date = date;
    }
    
    /**
     * Returns whether this tweet is important.
     *
     * @return true if the tweet is important, false if it is not
     */
    public abstract Boolean isImportant();
    
    /**
     * Returns the printable string representation of the tweet.
     *
     * @return String representing the tweet
     */
    @Override
    public String toString() {
        return this.date.toString() + " | " + this.message;
    }
}
