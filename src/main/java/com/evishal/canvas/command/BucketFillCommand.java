package com.evishal.canvas.command;

import com.evishal.canvas.drawable.Canvas;
import com.evishal.canvas.model.Point;
import com.evishal.canvas.constants.Messages;
import com.evishal.canvas.drawable.BucketFill;
import com.evishal.canvas.exception.CanvasException;

public class BucketFillCommand extends Command {
    public BucketFillCommand() {
        super(3);
    }

    @Override
    protected boolean isArgumentValid(String... arguments) {
        return isNumber(arguments[0]) && isNumber(arguments[1]) && isChar(arguments[2]);
    }

    @Override
    public Canvas execute(Canvas canvas, String... arguments) throws CanvasException {
        CanvasException.throwIf(canvas == null, Messages.CANVAS_NOT_INITIALIZED);
        validateParameters(arguments);

        BucketFill bucketFill = new BucketFill(
                new Point(toInt(arguments[0]), toInt(arguments[1])),
                toChar(arguments[2]),
                canvas);
        canvas.addElement(bucketFill);
        return canvas;
    }
}
