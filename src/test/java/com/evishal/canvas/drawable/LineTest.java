package com.evishal.canvas.drawable;

import com.evishal.canvas.model.Point;
import com.evishal.canvas.constants.Symbol;
import com.evishal.canvas.exception.CanvasException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class LineTest {
    private Canvas canvas;

    @Before
    public void before() {
        canvas = new Canvas(20, 4);
    }

    @Test
    public void new_ValidArguments() {
        new Line(new Point(1, 2), new Point(1, 4), canvas);
    }

    @Test(expected = CanvasException.class)
    public void new_NegativePoints() {
        new Line(new Point(-1, -2), new Point(1, 4), canvas);
    }

    @Test(expected = CanvasException.class)
    public void new_StartAfterEnd() {
        new Line(new Point(3, 4), new Point(3, 2), canvas);
    }

    @Test(expected = CanvasException.class)
    public void new_FirstPointOutOfCanvas() {
        new Line(new Point(3, 0), new Point(3, 2), canvas);
    }

    @Test(expected = CanvasException.class)
    public void new_SecondPointOutOfCanvas() {
        new Line(new Point(3, 4), new Point(21, 4), canvas);
    }

    @Test(expected = CanvasException.class)
    public void new_WhenNotHorizontalOrVertical() {
        new Line(new Point(1, 3), new Point(10, 4), canvas);
    }

    @Test(expected = CanvasException.class)
    public void new_WhenCanvasIsNull() {
        new Line(new Point(1, 3), new Point(10, 4), null);
    }

    @Test
    public void draw_WhenHorizontal() {
        Line line = new Line(new Point(3, 4), new Point(5, 4), canvas);

        line.draw();

        assertEquals(Symbol.LINE, canvas.getAt(new Point(3, 4)));
        assertEquals(Symbol.LINE, canvas.getAt(new Point(4, 4)));
        assertEquals(Symbol.LINE, canvas.getAt(new Point(5, 4)));
    }

    @Test
    public void draw_WhenVertical() {
        Line line = new Line(new Point(3, 2), new Point(3, 4), canvas);

        line.draw();

        assertEquals(Symbol.LINE, canvas.getAt(new Point(3, 2)));
        assertEquals(Symbol.LINE, canvas.getAt(new Point(3, 3)));
        assertEquals(Symbol.LINE, canvas.getAt(new Point(3, 4)));
    }
}
