package com.evishal.canvas.command;

import com.evishal.canvas.drawable.Canvas;
import com.evishal.canvas.exception.QuitException;
import com.evishal.canvas.exception.CanvasException;

public class QuitCommand extends Command {
    public QuitCommand() {
        super(0);
    }

    @Override
    protected boolean isArgumentValid(String... arguments) {
        return true;
    }

    @Override
    public Canvas execute(Canvas canvas, String... arguments) throws CanvasException, QuitException {
        validateParameters(arguments);

        throw new QuitException();
    }

    @Override
    public boolean shouldDraw() {
        return false;
    }
}
