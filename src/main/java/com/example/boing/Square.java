//package com.example.boing;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends ClosedShape {
    private int side;
    /**
     * Creates a rectangle.
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

    public String toString () {
        String result = "This is a rectangle\n";
        result += super.toString ();
        result += "Its side is " + this.side + "\n";
        return result;
    }

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

    public void setSide(int side) {
        this.side = side;
    }
    public void setHeight(int height) {
        this.side = side;
    }
    public int getHeight() {
        return this.side;
    }

    public int getWidth() {
        return this.side;
    }

}