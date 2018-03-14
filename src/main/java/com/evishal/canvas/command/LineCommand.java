package com.evishal.canvas.command;

import com.evishal.canvas.constants.Messages;
import com.evishal.canvas.drawable.Canvas;
import com.evishal.canvas.drawable.Line;
import com.evishal.canvas.exception.CanvasException;
import com.evishal.canvas.model.Point;

public class LineCommand extends Command {

    public LineCommand() {
        super(4);
    }

    @Override
    protected boolean isArgumentValid(String... arguments) {
        return isNumber(arguments[0]) && isNumber(arguments[1]) && isNumber(arguments[2]) && isNumber(arguments[3]);
    }

    @Override
    public Canvas execute(Canvas canvas, String... arguments) throws CanvasException {
        CanvasException.throwIf(canvas == null, Messages.CANVAS_NOT_INITIALIZED);
        validateParameters(arguments);

        Line line = new Line(
                new Point(toInt(arguments[0]), toInt(arguments[1])),
                new Point(toInt(arguments[2]), toInt(arguments[3])),
                canvas);
        canvas.addElement(line);
        return canvas;
    }
}
