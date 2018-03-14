package com.evishal.canvas.command;

import com.evishal.canvas.drawable.Canvas;
import com.evishal.canvas.exception.CanvasException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class CanvasCommandTest {
    private CanvasCommand testSubject = new CanvasCommand();

    @Test
    public void execute_WhenArgumentAreValid()  {
        Canvas canvas = testSubject.execute(null, "20", "4");
        assertNotNull(canvas);
        assertEquals(6, canvas.getCanvasPrint().length); //Boundary bits added
        assertEquals(20, canvas.getCanvasPrint()[0].length);
    }

    @Test(expected = CanvasException.class)
    public void execute_WhenArgumentLengthIsLessThan2() {
        testSubject.execute(null, "20");
    }

    @Test(expected = CanvasException.class)
    public void execute_WhenArgumentLengthIsGreaterThan2() {
        testSubject.execute(null, "20", "4", "9");
    }

    @Test(expected = CanvasException.class)
    public void execute_WhenFirstArgumentIsNotANumber() {
        testSubject.execute(null, "A", "2");
    }

    @Test(expected = CanvasException.class)
    public void execute_WhenSecondArgumentIsNotANumber() {
        testSubject.execute(null, "20", "A");
    }

    @Test(expected = CanvasException.class)
    public void execute_WhenWidthIsNegative() {
        testSubject.execute(null, "-20", "4");
    }

    @Test(expected = CanvasException.class)
    public void execute_WhenHeightIsNegative() {
        testSubject.execute(null, "20", "-4");
    }

    @Test
    public void execute_WhenExistingCanvasIsPassed() {
        Canvas oldCanvas = new Canvas(20, 3);
        Canvas result = testSubject.execute(oldCanvas, "20", "4");

        assertNotSame(oldCanvas, result);
    }

    @Test
    public void shouldDraw() {
        assertTrue(testSubject.shouldDraw());
    }
}
