package com.evishal.canvas.command;

import com.evishal.canvas.exception.CanvasException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class CommandRegistryTest {

    @Test
    public void getCommand_Canvas() {
        Command cmd = CommandRegistry.getCommand("C");

        assertTrue(cmd.getClass().isAssignableFrom(CanvasCommand.class));
    }

    @Test
    public void getCommand_Line() {
        Command cmd = CommandRegistry.getCommand("L");

        assertTrue(cmd.getClass().isAssignableFrom(LineCommand.class));
    }

    @Test
    public void getCommand_Rectangle() {
        Command cmd = CommandRegistry.getCommand("R");

        assertTrue(cmd.getClass().isAssignableFrom(RectangleCommand.class));
    }

    @Test
    public void getCommand_BucketFill() {
        Command cmd = CommandRegistry.getCommand("B");

        assertTrue(cmd.getClass().isAssignableFrom(BucketFillCommand.class));
    }

    @Test
    public void getCommand_Help() {
        Command cmd = CommandRegistry.getCommand("H");

        assertTrue(cmd.getClass().isAssignableFrom(HelpCommand.class));
    }

    @Test
    public void getCommand_Quit() {
        Command cmd = CommandRegistry.getCommand("Q");

        assertTrue(cmd.getClass().isAssignableFrom(QuitCommand.class));
    }

    @Test(expected = CanvasException.class)
    public void getCommand_UnknownCommand() {
        Command cmd = CommandRegistry.getCommand("A");
    }
}
