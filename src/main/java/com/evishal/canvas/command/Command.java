package com.evishal.canvas.command;

import com.evishal.canvas.drawable.Canvas;
import com.evishal.canvas.constants.Messages;
import com.evishal.canvas.exception.CanvasException;

public abstract class Command {
    private int argumentLength;

    protected Command(int argumentLength) {
        this.argumentLength = argumentLength;
    }

    public void validateParameters(String[] arguments) throws CanvasException {
        if(arguments == null) arguments = new String[]{};
        CanvasException.throwIf(arguments.length != argumentLength, Messages.INVALID_NUMBER_OF_PARAMETERS);
        CanvasException.throwIf(!isArgumentValid(arguments), Messages.INVALID_PARAMETERS);
    }

    public boolean isNumber(String num) {
        return num != null && num.chars().allMatch(Character::isDigit);
    }

    public boolean isChar(String ch) {
        return ch != null && ch.length() == 1;
    }

    protected Integer toInt(String num) {
        return Integer.parseInt(num);
    }

    protected char toChar(String ch) {
        return ch.charAt(0);
    }

    /**
     * override this if Command should not invoke draw on canvas
     * @return
     */
    public boolean shouldDraw() {
        return true;
    }

    public abstract Canvas execute(Canvas canvas, String... arguments) throws CanvasException;
    protected abstract boolean isArgumentValid(String... arguments);
}
