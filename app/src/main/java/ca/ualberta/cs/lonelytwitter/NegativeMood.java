package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class NegativeMood extends Mood {

    public NegativeMood() {
        super();
    }

    public NegativeMood(Date date) {
        super(date);
    }

    @Override
    public String format() {
        return "Negative mood";
    }
}
