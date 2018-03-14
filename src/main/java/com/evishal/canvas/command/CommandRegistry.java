package com.evishal.canvas.command;

import com.evishal.canvas.constants.Messages;
import com.evishal.canvas.exception.CanvasException;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {
    private static Map<String, Command> commandMap = new HashMap<>();
    static {
        addCommand("C", new CanvasCommand());
        addCommand("L", new LineCommand());
        addCommand("R", new RectangleCommand());
        addCommand("B", new BucketFillCommand());
        addCommand("H", new HelpCommand());
        addCommand("Q", new QuitCommand());
    }

    private static void addCommand(String alias, Command command) {
        commandMap.put(alias, command);
    }

    public static Command getCommand(String alias) throws CanvasException {
        Command command = commandMap.get(alias.toUpperCase());
        CanvasException.throwIf(command == null, Messages.CMD_NOT_FOUND, alias);
        return command;
    }
}
