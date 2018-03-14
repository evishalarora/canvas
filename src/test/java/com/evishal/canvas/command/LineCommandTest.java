package com.evishal.canvas.command;

import com.evishal.canvas.drawable.Line;
import com.evishal.canvas.drawable.Canvas;
import com.evishal.canvas.exception.CanvasException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class LineCommandTest {
    private Command testSubject = new LineCommand();
    private Canvas canvas;

    @Before
    public void before() {
        canvas = new Canvas(20, 4);
    }

    @Test
    public void shouldDraw() {
        assertTrue(testSubject.shouldDraw());
    }

    @Test
    public void execute_WhenArgumentsAreValid() {
        testSubject.execute(canvas, "1", "2", "1", "4");

        assertEquals(1, canvas.getElements().size());
        assertTrue(canvas.getElements().peek().getClass().isAssignableFrom(Line.class));
    }

    @Test(expected = CanvasException.class)
    public void execute_WhenAnyArgumentLengthIsLessThan4() {
        testSubject.execute(canvas, "1", "2", "1");
    }

    @Test(expected = CanvasException.class)
    public void execute_WhenAnyArgumentLengthIsGreaterThan4() {
        testSubject.execute(canvas, "1", "2", "1", "4", "5");
    }

    @Test(expected = CanvasException.class)
    public void execute_WhenAnyArgumentIsNotDigit() {
        testSubject.execute(canvas, "1", "C", "1", "4");
    }
}
