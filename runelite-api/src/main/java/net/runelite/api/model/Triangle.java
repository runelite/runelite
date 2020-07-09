package net.runelite.api.model;

import lombok.Value;

/**
 * Represents 3 vertices as a three-dimensional Triangle.
 */
@Value
public class Triangle
{
    private final Vertex a;
    private final Vertex b;
    private final Vertex c;

    /**
     * Rotates the triangle by the given orientation.
     *
     * @param orientation passed orientation
     * @return new instance
     */
    public Triangle rotate(int orientation)
    {
        return new Triangle(
                a.rotate(orientation),
                b.rotate(orientation),
                c.rotate(orientation)
        );
    }

}