package com.evishal.canvas.drawable;

import com.evishal.canvas.exception.CanvasException;
import com.evishal.canvas.model.Point;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class BucketFillTest {
    private Canvas canvas;

    @Before
    public void before() {
        canvas = new Canvas(6,6);
    }

    @Test(expected = CanvasException.class)
    public void new_NegativePoint() {
        new BucketFill(new Point(-1, -2), 'c', canvas);
    }

    @Test(expected = CanvasException.class)
    public void new_WhenCanvasIsNull() {
        new BucketFill(new Point(2, 2), 'c', null);
    }

    @Test(expected = CanvasException.class)
    public void new_WhenPointIsOutsideCanvas() {
        new BucketFill(new Point(7, 5), 'c', canvas);
    }

    @Test
    public void draw_WhenCanvasEmpty() {
        BucketFill fill = new BucketFill(new Point(1,1), 'c', canvas);
        fill.draw();

        // As in problem statement we are excluding boundary for height but not width
        assertTrue(IntStream.rangeClosed(1, 4).allMatch(x ->
            IntStream.rangeClosed(1, 6).allMatch(y ->
                canvas.getAt(new Point(x,y)) == 'c')));
    }

    @Test
    public void draw_FillInsideRectangle() {
        Point topLeft = new Point(1,1);
        Point bottomRight = new Point(4, 4);
        Rectangle rectangle = new Rectangle(topLeft, bottomRight, canvas);
        BucketFill fill = new BucketFill(new Point(2, 2), 'c', canvas);
        rectangle.draw();
        fill.draw();
        /**
         * If point is inside traingle then should be filled else not.
         */
        assertTrue(IntStream.rangeClosed(1, 4).allMatch(x ->
            IntStream.rangeClosed(1, 6).allMatch(y -> {
                Point p = new Point(x, y);
                char ch = canvas.getAt(p);
                return isInside(p, topLeft, bottomRight) ? ch == 'c' : ch != 'c';
            })));
    }

    @Test
    public void draw_FillOnRectangle() {
        Point topLeft = new Point(1,1);
        Point bottomRight = new Point(4, 4);
        Rectangle rectangle = new Rectangle(topLeft, bottomRight, canvas);
        BucketFill fill = new BucketFill(new Point(1, 1), 'c', canvas);
        rectangle.draw();
        fill.draw();
        /**
         * If point is inside traingle then should be filled else not.
         */
        assertTrue(IntStream.rangeClosed(1, 4).allMatch(x ->
            IntStream.rangeClosed(1, 6).allMatch(y -> {
                Point p = new Point(x, y);
                char ch = canvas.getAt(p);
                return isOn(p, topLeft, bottomRight) ? ch == 'c' : ch != 'c';
            })));
    }

    /**
     * Checks if a point is inside a rectangle having topLeft and bottmRight
     * this will be exluding the boundary
     * @param p
     * @param topLeft
     * @param bottomRight
     * @return
     */
    private boolean isInside(Point p, Point topLeft, Point bottomRight) {
        return p.x > topLeft.x && p.y > topLeft.y && p.x < bottomRight.x && p.y < bottomRight.y;
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
