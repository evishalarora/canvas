package com.evishal.canvas.command;

import com.evishal.canvas.drawable.Canvas;
import com.evishal.canvas.drawable.Drawable;
import com.evishal.canvas.drawable.BucketFill;
import com.evishal.canvas.exception.CanvasException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class BucketFillCommandTest {
    private BucketFillCommand testSubject = new BucketFillCommand();
    Canvas canvas;

    @Before
    public void init() {
        canvas = new Canvas(20, 4);
    }

    @Test
    public void execute_WhenArgumentAreValid()  {
        testSubject.execute(canvas, "1", "2", "c");
        assertEquals(1, canvas.getElements().size());
        Drawable drawable = canvas.getElements().peek();
        assertTrue(drawable.getClass().isAssignableFrom(BucketFill.class));
    }

    @Test(expected = CanvasException.class)
    public void execute_WhenArgumentLengthIsLessThan3() {
        testSubject.execute(canvas, "1", "2");
    }

    @Test(expected = CanvasException.class)
    public void execute_WhenArgumentLengthIsGreaterThan3() {
        testSubject.execute(canvas, "1", "2", "c", "e");
    }

    @Test(expected = CanvasException.class)
    public void execute_WhenFirstArgumentIsNotANumber() {
        testSubject.execute(canvas, "A", "2", "c");
    }

    @Test(expected = CanvasException.class)
    public void execute_WhenSecondArgumentIsNotANumber() {
        testSubject.execute(canvas, "1", "A", "c");
    }

    @Test(expected = CanvasException.class)
    public void execute_WhenThirdArgumentIsNotMultipleChars() {
        testSubject.execute(canvas, "1", "2", "CC");
    }

    @Test(expected = CanvasException.class)
    public void execute_WhenCanvasIsNull() {
        testSubject.execute(null, "1", "2", "CC");
    }

    @Test
    public void execute_WhenThirdArgumentIsADigit() {
        testSubject.execute(canvas, "1", "2", "1");
        assertEquals(1, canvas.getElements().size());
        Drawable drawable = canvas.getElements().peek();
        assertTrue(drawable.getClass().isAssignableFrom(BucketFill.class));
    }

    @Test
    public void shouldDraw() {
        assertTrue(testSubject.shouldDraw());
    }
}
