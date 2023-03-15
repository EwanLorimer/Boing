package com.example.boing;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends ClosedShape {
    private int side;
    /**
     * Creates a square.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param side The length of each side of the square (in pixels).
     * @param colour The line colour or fill colour.
     * @param isFilled True if the rectangle is filled with colour, false if opaque.
     */
    public Square (int insertionTime, int x, int y, int vx, int vy, int side, Color colour, boolean isFilled) {
        super (insertionTime, x, y, vx, vy, colour, isFilled);
        this.side = side;
    }

    /**
     * Output information about shape
     * @return result String which contains shape info
     */
    public String toString () {
        String result = "This is a square\n";
        result += super.toString ();
        result += "Its side is " + this.side + "\n";
        return result;
    }

    /**
     * Draw the shape on screen
     * @param g The graphics object associated with the drawing component.
     */
    public void draw(GraphicsContext g) {
        g.setFill (colour);
        g.setStroke( colour );
        if (isFilled) {
            g.fillRect( x, y, side, side);
        }
        else {
            g.strokeRect( x, y, side, side);
        }
    }

    /**
     *
     * @param side Value that the side will be set to
     */
    public void setSide(int side) {
        this.side = side;
    }


    /**
     *
     * @return side length
     */
    public int getHeight() {
        return this.side;
    }

    /**
     *
     * @return side length
     */
    public int getWidth() {
        return this.side;
    }

}