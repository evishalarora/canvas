package com.evishal.canvas.constants;

public interface Messages {
    String INVALID_NUMBER_OF_PARAMETERS = "Invalid number of parameters, please use help by sending H.";
    String INVALID_PARAMETERS = "Invalid parameter format, please use help by sending H.";
    String CMD_NOT_FOUND = "Command \"%s\" not found, please use help by sending H.";
    String CANVAS_NOT_INITIALIZED = "Canvas is not created yet, please create canvas first.";
    String STAR_AFTER_END = "%s is after %s. Consider reversing the positions.";
    String STAR_EQ_END = "Star and end points are same.";
    String LINE_NOT_IN_CANVAS = "Line from %s to %s will not fit in canvas";
    String LINE_ONLY_ST_LINES = "Only horizontal and vertical lines are supported as of now";
    String REC_NOT_IN_CANVAS = "Rectangle from %s to %s will not fit in canvas";
    String PT_NOT_IN_CANVAS = "Point %s is not in canvas";
}
