package com.evishal.canvas.drawable;

import com.evishal.canvas.constants.Messages;
import com.evishal.canvas.exception.CanvasException;
import com.evishal.canvas.model.Point;

public class Rectangle implements Drawable {
    Point topLeft;
    Point bottomRight;
    Canvas canvas;

    public Rectangle(Point topLeft, Point bottomRight, Canvas canvas) throws CanvasException {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        this.canvas = canvas;
        ensureValid();
    }

    private void ensureValid() throws CanvasException {
        CanvasException.throwIf(canvas == null, Messages.CANVAS_NOT_INITIALIZED);
        CanvasException.throwIf(topLeft.isAfter(bottomRight), Messages.STAR_AFTER_END, topLeft, bottomRight);
        CanvasException.throwIf(topLeft.equals(bottomRight), Messages.STAR_EQ_END);
        CanvasException.throwIf(!canvas.contains(topLeft) || !canvas.contains(bottomRight),
                Messages.REC_NOT_IN_CANVAS, topLeft, bottomRight);
    }

    /**
     * Just create four lines to make a rectangle
     * 2 keeping x constant
     * x1, y1 -> x1, y2
     * x2, y1 -> x2, y2
     * 2 keeping y constant
     * x1, y1 -> x2, y1
     * x1, y2 -> x2, y2
     */
    public void draw() {
        try {
            new Line(topLeft, new Point(topLeft.x, bottomRight.y), canvas).draw();
            new Line(topLeft, new Point(bottomRight.x, topLeft.y), canvas).draw();

            new Line(new Point(bottomRight.x, topLeft.y), bottomRight, canvas).draw();
            new Line(new Point(topLeft.x, bottomRight.y), bottomRight, canvas).draw();
        } catch (CanvasException e) {
            //nothing to do here as this will already be captured in constructor by a call to ensureValid
        }
    }
}
