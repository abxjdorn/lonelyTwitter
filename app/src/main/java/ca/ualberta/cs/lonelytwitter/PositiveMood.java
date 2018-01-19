package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class PositiveMood extends Mood {

    public PositiveMood() {
        super();
    }

    public PositiveMood(Date date) {
        super(date);
    }

    @Override
    public String format() {
        return "Positive mood";
    }
}
