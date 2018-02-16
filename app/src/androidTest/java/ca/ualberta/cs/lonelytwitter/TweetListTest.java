package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jdorn on 2/15/18.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }
    
    public void testAddTweet() {
        TweetList tweets = new TweetList();
        
        Tweet tweet = new NormalTweet("adding a normal Tweet");
        
        tweets.add(tweet);
        
        assertTrue(tweets.hasTweet(tweet));
        
        boolean didThrow = false;
        try {
            tweets.add(tweet);
        }
        catch (IllegalArgumentException e) {
            didThrow = true;
        }
        
        assertTrue(didThrow);
    }
    
    public void testHasTweet() {
        TweetList tweets = new TweetList();
        
        Tweet tweet = new NormalTweet("adding a normal Tweet");
        
        assertFalse(tweets.hasTweet(tweet));
        
        tweets.add(tweet);
        
        assertTrue(tweets.hasTweet(tweet));
    }
    
    public void testGetTweet() {
        TweetList tweets = new TweetList();
        
        Tweet tweet = new NormalTweet("adding a normal Tweet");
        
        tweets.add(tweet);
        Tweet returnedTweet = tweets.getTweet(0);
        assertEquals(returnedTweet.getDate(), tweet.getDate());
        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
    }
    
    public void testGetTweets() {
        TweetList tweets = new TweetList();
        
        Tweet tweet1 = new NormalTweet("FIRST", new Date(100, 1, 1));
        Tweet tweet2 = new NormalTweet("THIRD", new Date(101, 1, 1));
        Tweet tweet3 = new NormalTweet("SECOND", new Date(100, 2, 2));
        
        tweets.add(tweet3);
        tweets.add(tweet2);
        tweets.add(tweet1);
        
        ArrayList<Tweet> correctList = new ArrayList<Tweet>();
        correctList.add(tweet1);
        correctList.add(tweet3);
        correctList.add(tweet2);
        
        assertEquals(correctList, tweets.getTweets());
    }
    
    public void testDeleteTweet() {
        TweetList tweets = new TweetList();
        
        NormalTweet tweet = new NormalTweet("adding a normal Tweet");
        
        tweets.add(tweet);
        
        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }
    
    public void testCountTweets() {
        TweetList tweets = new TweetList();
        
        assertEquals(0, tweets.countTweets());
        
        Tweet tweet1 = new NormalTweet("add 1");
        tweets.add(tweet1);
        assertEquals(1, tweets.countTweets());
        
        Tweet tweet2 = new NormalTweet("add 2");
        tweets.add(tweet2);
        assertEquals(2, tweets.countTweets());
        
        tweets.delete(tweet2);
        assertEquals(1, tweets.countTweets());
        
        tweets.add(tweet2);
        assertEquals(2, tweets.countTweets());
        
        tweets.delete(tweet1);
        assertEquals(1, tweets.countTweets());
        
        tweets.delete(tweet2);
        assertEquals(0, tweets.countTweets());
    }
}
