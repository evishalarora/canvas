package com.evishal.canvas.drawable;

import com.evishal.canvas.constants.Messages;
import com.evishal.canvas.constants.Symbol;
import com.evishal.canvas.exception.CanvasException;
import com.evishal.canvas.model.Point;

import java.util.stream.IntStream;

public class Line implements Drawable {
    private Point start;
    private Point end;
    private Canvas canvas;

    public Line(Point start, Point end, Canvas canvas) throws CanvasException {
        this.start = start;
        this.end = end;
        this.canvas = canvas;

        ensureValid();
    }

    private void ensureValid() throws CanvasException {
        CanvasException.throwIf(canvas == null, Messages.CANVAS_NOT_INITIALIZED);
        CanvasException.throwIf(start.isAfter(end), Messages.STAR_AFTER_END, start, end);
        CanvasException.throwIf(start.equals(end), Messages.STAR_EQ_END);
        CanvasException.throwIf(!canvas.contains(start) || !canvas.contains(end), Messages.LINE_NOT_IN_CANVAS, start, end);
        CanvasException.throwIf(start.x != end.x && start.y != end.y, Messages.LINE_ONLY_ST_LINES);
    }

    public void draw() {
        IntStream.rangeClosed(start.x, end.x).forEach(col ->
            IntStream.rangeClosed(start.y, end.y).forEach(row ->
                canvas.getCanvasPrint()[row][col] = Symbol.LINE));
    }
}
