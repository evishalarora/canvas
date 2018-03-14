package com.evishal.canvas.command;

import com.evishal.canvas.exception.QuitException;
import com.evishal.canvas.exception.CanvasException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;

@RunWith(JUnit4.class)
public class QuitCommandTest {
    private Command testSubject = new QuitCommand();

    @Test(expected = QuitException.class)
    public void execute_WhenNoCommandArguments() {
        testSubject.execute(null);
    }

    @Test(expected = CanvasException.class)
    public void execute_WhenAdditionaArgumentsPassed() {
        testSubject.execute(null, "A");
    }

    @Test
    public void shouldDraw() {
        assertFalse(testSubject.shouldDraw());
    }
}
