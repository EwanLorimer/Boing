package com.example.boing;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rect extends ClosedShape {
    private int width, height;
    /**
     * Creates a rectangle.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the rectangle (in pixels).
     * @param height The height of the rectangle (in pixels).
     * @param colour The line colour or fill colour.
     * @param isFilled True if the rectangle is filled with colour, false if opaque.
     */
    public Rect (int insertionTime, int x, int y, int vx, int vy, int width, int height,
                 Color colour, boolean isFilled) {
        super (insertionTime, x, y, vx, vy, colour, isFilled);
        this.width = width;
        this.height = height;
    }
    /**
     * Output information about shape
     * @return result String which contains shape info
     */
    public String toString () {
        String result = "This is a rectangle\n";
        result += super.toString ();
        result += "Its width is " + this.width + " and its height is " + this.height + "\n";
        return result;
    }

    /**
     * Draw shape
     * @param g The graphics object associated with the drawing component.
     */
    public void draw(GraphicsContext g) {
        g.setFill (colour);
        g.setStroke( colour );
        if (isFilled) {
            g.fillRect( x, y, width, height );
        }
        else {
            g.strokeRect( x, y, width, height );
        }
    }

    /**
     *
     * @param width Value that width will be set to
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     *
     * @param height Value that height will be set to
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     *
     * @return height of the rectangle
     */
    public int getHeight() {
        return this.height;
    }

    /**
     *
     * @return width of the rectangle
     */
    public int getWidth() {
        return this.width;
    }

}
