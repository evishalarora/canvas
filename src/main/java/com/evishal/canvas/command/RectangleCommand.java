package com.evishal.canvas.command;

import com.evishal.canvas.constants.Messages;
import com.evishal.canvas.drawable.Canvas;
import com.evishal.canvas.drawable.Rectangle;
import com.evishal.canvas.exception.CanvasException;
import com.evishal.canvas.model.Point;

public class RectangleCommand extends Command {

    public RectangleCommand() {
        super(4);
    }

    @Override
    protected boolean isArgumentValid(String... arguments) {
        return isNumber(arguments[0]) && isNumber(arguments[1]) && isNumber(arguments[2]) && isNumber(arguments[3]);
    }

    @Override
    public Canvas execute(Canvas canvas, String... args) throws CanvasException {
        CanvasException.throwIf(canvas == null, Messages.CANVAS_NOT_INITIALIZED);
        validateParameters(args);

        Rectangle rectangle = new Rectangle(
                new Point(toInt(args[0]), toInt(args[1])),
                new Point(toInt(args[2]), toInt(args[3])),
                canvas);
        canvas.addElement(rectangle);
        return canvas;
    }
}
