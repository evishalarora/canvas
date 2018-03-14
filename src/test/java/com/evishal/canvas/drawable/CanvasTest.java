package com.evishal.canvas.drawable;

import com.evishal.canvas.model.Point;
import com.evishal.canvas.constants.Symbol;
import com.evishal.canvas.exception.CanvasException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class CanvasTest {

    @Test
    public void new_WhenTypical() {
        int width = 20;
        int height = 4;

        Canvas canvas = new Canvas(width, height);

        assertEquals(height + 2, canvas.getCanvasPrint().length); //+2 for boundary
        assertEquals(width, canvas.getCanvasPrint()[0].length);
    }

    @Test(expected = CanvasException.class)
    public void new_WidthOrHeighIsNegative() {
        int width = -20;
        int height = 4;

        new Canvas(width, height);
    }

    @Test
    public void draw() {
        int width = 20;
        int height = 4;
        Canvas canvas = new Canvas(width, height);

        canvas.draw();

        //top horizontal line
        assertTrue(
            IntStream.rangeClosed(0, 19).allMatch(x ->
                canvas.getAt(new Point(x, 0)) == Symbol.CANVAS_HORIZONTAL));

        // bottom horizontal line
        assertTrue(
            IntStream.rangeClosed(0, 19).allMatch(x ->
                canvas.getAt(new Point(x, 5)) == Symbol.CANVAS_HORIZONTAL));

        // left vertical line
        assertTrue(
            IntStream.rangeClosed(1, 4).allMatch(y ->
                canvas.getAt(new Point(0, y)) == Symbol.CANVAS_VERTICAL));

        // right vertical line
        assertTrue(
            IntStream.rangeClosed(1, 4).allMatch(y ->
                canvas.getAt(new Point(19, y)) == Symbol.CANVAS_VERTICAL));
    }
}
