package jugacademi.api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interval {
    private boolean isStartOpened;
    private boolean isEndOpened;
    private Integer start;
    private Integer end;

    public static void main(String[] args) {
        Interval interval = new Interval();
        interval.init("(1,2)");

        System.out.println(interval.isStartOpened());
        System.out.println(interval.getStart());
        System.out.println(interval.getEnd());
        System.out.println(interval.isEndOpened());
    }

    public void init(String interval) {
        java.util.regex.Pattern intervalPattern =
                java.util.regex.Pattern.compile("^([\\[\\(])(\\d*),(\\d*)([\\)\\]])$");


        java.util.regex.Matcher intervalMatcher = intervalPattern.matcher(interval);

        if (intervalMatcher.matches()) {
            isStartOpened = intervalMatcher.group(1).equals("(");
            isEndOpened = intervalMatcher.group(4).equals(")");
            if (!intervalMatcher.group(2).isBlank()) {
                start = Integer.parseInt(intervalMatcher.group(2));
            }
            if (!intervalMatcher.group(3).isBlank()) {
                end = Integer.parseInt(intervalMatcher.group(3));
            }

        }

    }

    public boolean isStartOpened() {
        return isStartOpened;
    }

    public void setStartOpened(boolean startOpened) {
        isStartOpened = startOpened;
    }

    public boolean isEndOpened() {
        return isEndOpened;
    }

    public void setEndOpened(boolean endOpened) {
        isEndOpened = endOpened;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
