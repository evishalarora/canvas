package com.evishal.canvas.command;

import com.evishal.canvas.drawable.Canvas;
import com.evishal.canvas.exception.CanvasException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

@RunWith(JUnit4.class)
public class HelpCommandTest {
    private Command testSubject = new HelpCommand();

    @Test
    public void execute_WhenNoCommandArguments() {
        testSubject.execute(null);
    }

    @Test(expected = CanvasException.class)
    public void execute_WhenAdditionaArgumentsPassed() {
        testSubject.execute(null, "A");
    }

    @Test
    public void execute_WhenCanvasExists() {
        Canvas oldCanvas = new Canvas(20, 4);

        Canvas result = testSubject.execute(oldCanvas);

        assertSame(oldCanvas, result);
    }

    @Test
    public void shouldDraw() {
        assertFalse(testSubject.shouldDraw());
    }
}
