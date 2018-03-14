package com.evishal.canvas.model;

public class Point {
    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isBefore(Point b) {
        return this.x <= b.x && this.y <= b.y && !equals(b);
    }

    public boolean isAfter(Point b) {
        return b.isBefore(this) && !equals(b);
    }

    public boolean equals(Point b) {
        return this.x == b.x && this.y == b.y;
    }

    public String toString() {
        return new StringBuilder().append("(").append(x).append(",").append(y).append(")").toString();
    }
}
