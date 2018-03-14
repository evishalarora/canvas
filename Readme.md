# ASCII Draw

__Description__

The requirement is to implement a simple console drawing program in Java.

Its functionality is currently quite limited but this *might* change in the future.

In a nutshell, the program should work as follows:
 1. Create a new canvas
 2. Draw on the canvas by issuing various commands
 3. Quit

        ******************************************************************
        | Code           | Description                                   |
        ******************************************************************
        | C w h          | Create a new Canvas of width 20 and height 4  |
        |                |                                               |
        | L x1 y1 x2 y2  | Draw a new line from (x1, y1) to (x2, y2),    |
        |                | Currently only horizontal or vertical lines   |
        |                | are supported, lines will be drawn with 'x'   |
        |                |                                               |
        | R x1 y1 x2 y2  | Draw a rectangle whose upper left corner will |
        |                | be (x1, y1) and bottom right corner will be   |
        |                | (x2, y2). It will also be drawn with 'x'      |
        |                |                                               |
        | B x y c        | Fill entire area connected with (x,y) with    |
        |                | color c. It works as bucket fill works in MS  |
        |                | Paint.                                        |
        |                |                                               |
        | H              | Display this help message                     |
        |                |                                               |
        | Q              | Quit the program                              |
        ******************************************************************
        
Note: Currently in the program, the boundary's are included in the width, where as it is not included in height 
from the sample program below. In Default case a canvas of 20 x 4 actually has a working area of 18 x 4.
The above behaviour can be changed by passing the system property excludeBoundary with value as true, doing this, 
the command C 20 4 i.e. a canvas of 20x4 will have an actual working area of 20x4.
 
__Sample Run__

Below is a sample run of the program. User input is prefixed with `enter command: `
````text
enter command: C 20 4
--------------------
|                  |
|                  |
|                  |
|                  |
--------------------

enter command: L 1 2 6 2
--------------------
|                  |
|xxxxxx            |
|                  |
|                  |
--------------------

enter command: L 6 3 6 4
--------------------
|                  |
|xxxxxx            |
|     x            |
|     x            |
--------------------

enter command: R 14 1 18 3
--------------------
|             xxxxx|
|xxxxxx       x   x|
|     x       xxxxx|
|     x            |
--------------------

enter command: B 10 3 o
--------------------
|oooooooooooooxxxxx|
|xxxxxxooooooox   x|
|     xoooooooxxxxx|
|     xoooooooooooo|
--------------------

enter command: L 6 4 13 4
--------------------
|oooooooooooooxxxxx|
|xxxxxxooooooox   x|
|     xoooooooxxxxx|
|     xxxxxxxxooooo|
--------------------

enter command: B 1 2 .
--------------------
|oooooooooooooxxxxx|
|......ooooooox   x|
|     .oooooooxxxxx|
|     ........ooooo|
--------------------

enter command: Q
````
