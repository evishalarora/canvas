package com.evishal.canvas;

import com.evishal.canvas.command.Command;
import com.evishal.canvas.drawable.Canvas;
import com.evishal.canvas.exception.QuitException;
import com.evishal.canvas.command.CommandRegistry;
import com.evishal.canvas.exception.CanvasException;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    private static final String ARGUMENT_SPLITTER = " ";

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    void showHelp() {
        Command helpCommand = CommandRegistry.getCommand("H");
        helpCommand.execute(null, null);
    }

    Canvas executeCommand(String commandStr, Canvas canvas) throws QuitException {
        try {
            String[] arguments = commandStr.split(ARGUMENT_SPLITTER);
            Command command = CommandRegistry.getCommand(arguments[0]);
            canvas = command.execute(canvas, Arrays.copyOfRange(arguments, 1, arguments.length)); //Exclude first one
            if(command.shouldDraw() && canvas != null) {
                canvas.draw();
            }
        } catch(CanvasException e) {
            System.out.println(e.getMessage());
        }
        return canvas;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Canvas canvas = null;
        showHelp();
        while(true) {
            try {
                System.out.print("enter command: ");
                String line = scanner.nextLine().trim();
                canvas = executeCommand(line, canvas);
            } catch(QuitException eq) {
                System.out.println("Thanks for evaluating ASCII Console Drawing.");
                break;
            }
        }
    }
}
