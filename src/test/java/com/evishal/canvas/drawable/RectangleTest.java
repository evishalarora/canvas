package com.evishal.canvas.drawable;

import com.evishal.canvas.constants.Symbol;
import com.evishal.canvas.exception.CanvasException;
import com.evishal.canvas.model.Point;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class RectangleTest {
    private Canvas canvas;

    @Before
    public void before() {
        canvas = new Canvas(6,6);
    }

    @Test
    public void new_ValidArguments() {
        new Rectangle(new Point(1, 1), new Point(4, 4), canvas);
    }

    @Test(expected = CanvasException.class)
    public void new_NegativePoints() {
        new Rectangle(new Point(-1, -2), new Point(1, 4), canvas);
    }

    @Test(expected = CanvasException.class)
    public void new_StartAfterEnd() {
        new Rectangle(new Point(3, 4), new Point(3, 2), canvas);
    }

    @Test(expected = CanvasException.class)
    public void new_FirstPointOutOfCanvas() {
        new Rectangle(new Point(3, 0), new Point(3, 2), canvas);
    }

    @Test(expected = CanvasException.class)
    public void new_SecondPointOutOfCanvas() {
        new Rectangle(new Point(3, 4), new Point(21, 4), canvas);
    }


    @Test(expected = CanvasException.class)
    public void new_WhenCanvasIsNull() {
        new Rectangle(new Point(1, 3), new Point(10, 4), null);
    }

    @Test
    public void draw_WhenTypical() {
        Point topLeft = new Point(1, 1);
        Point bottomRight = new Point(4, 4);
        Rectangle rectangle = new Rectangle(topLeft, bottomRight, canvas);

        rectangle.draw();

        assertTrue(IntStream.rangeClosed(1, 4).allMatch(x ->
            IntStream.rangeClosed(1, 6).allMatch(y -> {
                Point p = new Point(x, y);
                char ch = canvas.getAt(p);
                return isOn(p, topLeft, bottomRight) ? ch == Symbol.LINE : ch == Symbol.SPACE;
            })));
    }

    /**
     * Checks if a point is on boundary of a rectangle having topLeft and bottmRight
     * @param p
     * @param topLeft
     * @param bottomRight
     * @return
     */
    private boolean isOn(Point p, Point topLeft, Point bottomRight) {
        return (p.x == topLeft.x && p.y >= topLeft.y && p.y <= bottomRight.y) ||
                (p.x == bottomRight.x && p.y >= topLeft.y && p.y <= bottomRight.y) ||
                (p.y == topLeft.y && p.x >= topLeft.x && p.x <= bottomRight.x) ||
                (p.y == bottomRight.y && p.x >= topLeft.x && p.x <= bottomRight.x);
    }
}
