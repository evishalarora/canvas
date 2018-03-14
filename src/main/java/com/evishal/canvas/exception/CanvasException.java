package com.evishal.canvas.exception;

public class CanvasException extends RuntimeException {

    public CanvasException(String message) {
        super(message);
    }

    public static void throwIf(boolean condition, String message, Object ... replacements) throws CanvasException {
        if(condition) throw new CanvasException(String.format(message, replacements));
    }
}
