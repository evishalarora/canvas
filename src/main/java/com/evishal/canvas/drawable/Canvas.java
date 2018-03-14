package com.evishal.canvas.drawable;

import com.evishal.canvas.model.Point;
import com.evishal.canvas.constants.Messages;
import com.evishal.canvas.constants.Symbol;
import com.evishal.canvas.exception.CanvasException;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Canvas implements Drawable{
    private Queue<Drawable> elements = new LinkedList<>();
    private char[][] canvasPrint;
    private int width;
    private int height;
    private boolean excludeBoundry = Boolean.parseBoolean(System.getProperty("excludeBoundry", "false"));

    /**
     * Initialize the canvas,
     *
     * add 2 to both height and width for boundary
     * However, In the problem statement We have excluded the boundary for height, but not width
     * i.e. 18 is the max x (R 14 1 18 3 is making a rectangle which is at the end of the canvas)
     * where as height can go till 4 even though canvas size is 20 x 4
     *
     * To cater to above, I making default behavior as in the examples, but can return to true behaviour by adding
     * system property excludeBoundry which will make sure that a canvas of 20x4 can have a rectangle from 1,1 to 20,4
     * @param w
     * @param h
     */
    public Canvas(int w, int h) throws CanvasException {
        ensureValid(w, h);
        this.width = excludeBoundry ? w + 2 : w;
        this.height = h + 2;
        canvasPrint = new char[height][width];
        IntStream.range(0, this.width).forEach(col ->
                IntStream.range(0, this.height).forEach(row ->
                        canvasPrint[row][col] = Symbol.SPACE));
    }

    private void ensureValid(int w, int h) throws CanvasException {
        CanvasException.throwIf(w < 0 || h < 0, Messages.INVALID_PARAMETERS);
    }

    public void addElement(Drawable element) {
        elements.add(element);
    }

    public void draw() {
        IntStream.range(0, height)
                .forEach(row -> canvasPrint[row][0] = canvasPrint[row][width - 1] = Symbol.CANVAS_VERTICAL);
        IntStream.range(0, width)
                .forEach(col -> canvasPrint[0][col] = canvasPrint[height - 1][col] = Symbol.CANVAS_HORIZONTAL);

        elements.forEach(element -> element.draw());

        Arrays.asList(canvasPrint).forEach(line -> System.out.println(line));
    }

    public char[][] getCanvasPrint() {
        return canvasPrint;
    }

    public boolean contains(Point p) {
        return p.x > 0 && p.x <= this.width - 2 && p.y > 0 && p.y <= this.height - 2;
    }

    public char getAt(Point p) {
        return canvasPrint[p.y][p.x];
    }

    public Queue<Drawable> getElements() {
        return elements;
    }
}
