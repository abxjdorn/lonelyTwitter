package ca.ualberta.cs.lonelytwitter;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by jdorn on 2/15/18.
 */

public class TweetList {
    
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    
    public void add(Tweet tweet) {
        if (tweets.contains(tweet)) {
            throw new InvalidParameterException();
        }
        tweets.add(tweet);
    }
    
    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }
    
    public Tweet getTweet(int index) {
        return tweets.get(index);
    }
    
    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }
    
    public int countTweets() {
        return tweets.size();
    }
    
    public ArrayList<Tweet> getTweets() {
        tweets.sort(new Comparator<Tweet>() {
            @Override
            public int compare(Tweet tweet, Tweet t1) {
                return tweet.getDate().compareTo(t1.getDate());
            }
        });
        return tweets;
    }
}
