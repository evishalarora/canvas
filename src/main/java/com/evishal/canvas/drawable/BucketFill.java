package com.evishal.canvas.drawable;

import com.evishal.canvas.constants.Messages;
import com.evishal.canvas.exception.CanvasException;
import com.evishal.canvas.model.Point;

public class BucketFill implements Drawable {
    private Point enclosingPoint;
    private char color;
    private Canvas canvas;

    public BucketFill(Point point, char color, Canvas canvas) throws CanvasException {
        this.enclosingPoint = point;
        this.canvas = canvas;
        this.color = color;
        ensureValid();
    }

    private void ensureValid() throws CanvasException {
        CanvasException.throwIf(canvas == null, Messages.CANVAS_NOT_INITIALIZED);
        CanvasException.throwIf(!canvas.contains(enclosingPoint), Messages.PT_NOT_IN_CANVAS, enclosingPoint);
    }

    public void draw() {
        char toReplace = canvas.getAt(enclosingPoint);
        fill(enclosingPoint, toReplace);
    }

    /**
     * Fill Point if it a empty
     * fill surrounding points if same as original point
     * if point is outside canvas, then leave
     * @param p
     */
    public void fill(Point p, char toReplace) {
        if(!canvas.contains(p) || toReplace == color) return;
        if(canvas.getCanvasPrint()[p.y][p.x] == toReplace) {
            canvas.getCanvasPrint()[p.y][p.x] = color;
            fill(new Point(p.x, p.y - 1), toReplace);
            fill(new Point(p.x, p.y + 1), toReplace);
            fill(new Point(p.x - 1, p.y), toReplace);
            fill(new Point(p.x + 1, p.y), toReplace);
        }
    }
}
