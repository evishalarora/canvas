package com.evishal.canvas.command;

import com.evishal.canvas.drawable.Canvas;
import com.evishal.canvas.exception.CanvasException;

public class CanvasCommand extends Command {

    public CanvasCommand() {
        super(2);
    }

    protected boolean isArgumentValid(String... arguments) {
        return isNumber(arguments[0]) && isNumber(arguments[1]);
    }

    @Override
    public Canvas execute(Canvas canvas, String... arguments) throws CanvasException {
        validateParameters(arguments);

        return new Canvas(toInt(arguments[0]), toInt(arguments[1]));
    }

}
