package com.evishal.canvas.command;

import com.evishal.canvas.drawable.Canvas;
import com.evishal.canvas.exception.CanvasException;

public class HelpCommand extends Command {
    public HelpCommand() {
        super(0);
    }

    @Override
    protected boolean isArgumentValid(String... arguments) {
        return true;
    }

    @Override
    public boolean shouldDraw() {
        return false;
    }

    @Override
    public Canvas execute(Canvas canvas, String... arguments) throws CanvasException {
        validateParameters(arguments);

        System.out.println("******************************************************************");
        System.out.println("*                  Welcome to ASCII Draw                         *");
        System.out.println("******************************************************************");
        System.out.println("| Code           | Description                                   |");
        System.out.println("******************************************************************");
        System.out.println("| C w h          | Create a new Canvas of width 20 and height 4  |");
        System.out.println("|                |                                               |");
        System.out.println("| L x1 y1 x2 y2  | Draw a new line from (x1, y1) to (x2, y2),    |");
        System.out.println("|                | Currently only horizontal or vertical lines   |");
        System.out.println("|                | are supported, lines will be drawn with 'x'   |");
        System.out.println("|                |                                               |");
        System.out.println("| R x1 y1 x2 y2  | Draw a rectangle whose upper left corner will |");
        System.out.println("|                | be (x1, y1) and bottom right corner will be   |");
        System.out.println("|                | (x2, y2). It will also be drawn with 'x'      |");
        System.out.println("|                |                                               |");
        System.out.println("| B x y c        | Fill entire area connected with (x,y) with    |");
        System.out.println("|                | color c. It works as bucket fill works in MS  |");
        System.out.println("|                | Paint.                                        |");
        System.out.println("|                |                                               |");
        System.out.println("| H              | Display this help message                     |");
        System.out.println("|                |                                               |");
        System.out.println("| Q              | Quit the program                              |");
        System.out.println("******************************************************************");
        return canvas;
    }
}
