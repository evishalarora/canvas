package com.evishal.canvas;

import com.evishal.canvas.constants.Messages;
import com.evishal.canvas.constants.Symbol;
import com.evishal.canvas.drawable.Canvas;
import com.evishal.canvas.exception.QuitException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.*;
import java.util.Arrays;

@RunWith(JUnit4.class)
public class AppTest {
    private App testSubject = new App();
    ByteArrayOutputStream baos;

    @Before
    public void before() {
        baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
    }

    @Test
    public void showHelp() {

        testSubject.showHelp();

        String helpContent = baos.toString();
        Assert.assertTrue("Doesn't contain welcome message", helpContent.contains("Welcome to ASCII Draw"));
    }

    @Test
    public void executeCommand_WhenCreateCanvas() {

        Canvas canvas = testSubject.executeCommand("C 5 5", null);

        Assert.assertNotNull("Canvas is not created", canvas);
    }

    @Test
    public void executeCommand_WhenDraw() {

        Canvas canvas = testSubject.executeCommand("C 5 5", null);
        canvas = testSubject.executeCommand("L 1 2 1 4", canvas);

        Assert.assertTrue("Doesn't contain line", baos.toString().contains(String.valueOf(Symbol.LINE)));
    }

    @Test
    public void executeCommand_WhenException() {

        testSubject.executeCommand("L 1 2 1 3", null);

        Assert.assertTrue("Canvas initialization error not printed",
                baos.toString().contains(Messages.CANVAS_NOT_INITIALIZED));
    }

    @Test(expected = QuitException.class)
    public void executeCommand_WhenQuitException() {
        testSubject.executeCommand("Q", null);
    }

    @Test
    public void main_WhenTypical() throws IOException {
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        final PipedInputStream in = new PipedInputStream(pipedOutputStream);
        System.setIn(in);
        startThreadWithCommands(pipedOutputStream,"C 6 6", "L 1 2 1 4", "Q");

        App.main(null);

        String output = baos.toString();
        Assert.assertTrue(output.contains(String.valueOf(Symbol.LINE)));
        Assert.assertTrue("Doesn't contain goodbye text", output.contains("Thanks for evaluating ASCII Console Drawing."));
    }

    private void startThreadWithCommands(PipedOutputStream pos, String ... commands) {
        Runnable runnable = () -> {
            try {
                String ls = System.getProperty("line.separator");
                Thread.sleep(100);
                Arrays.asList(commands).forEach(cmd -> {
                    try {
                        pos.write((cmd + ls).getBytes());
                        Thread.sleep(100);
                    } catch(Exception e) {}
                });
            }catch(Exception e) {}
        };
        new Thread(runnable).start();
    }
}
