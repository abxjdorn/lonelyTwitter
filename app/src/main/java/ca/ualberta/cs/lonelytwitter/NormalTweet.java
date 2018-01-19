package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class NormalTweet extends Tweet {

    public NormalTweet(String message) {
        super(message);
    }

    public NormalTweet(String message, Date date) {
        super(message, date);
    }

    @Override
    public boolean isImportant() {
        return Boolean.FALSE;
    }
}
