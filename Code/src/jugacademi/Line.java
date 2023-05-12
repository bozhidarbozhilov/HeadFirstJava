package jugacademi;

public class Line {
    private Point start;
    private Point end;

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "[(" + start.getX() + "," + start.getY() + "),(" + end.getX() + "," + end.getY() + ")]";
    }
}
