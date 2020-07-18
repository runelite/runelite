package net.runelite.client.plugins.gauntlet;

import net.runelite.api.Perspective;

public class Vertex
{
    private final int x;
    private final int y;
    private final int z;

    public Vertex(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getZ()
    {
        return z;
    }

    /**
     * Rotates the triangle by the given orientation.
     *
     * @param orientation passed orientation
     * @return new instance
     */
    public Vertex rotate(int orientation)
    {
        // models are orientated north (1024) and there are 2048 angles total
        orientation = (orientation + 1024) % 2048;

        if (orientation == 0)
        {
            return this;
        }

        int sin = Perspective.SINE[orientation];
        int cos = Perspective.COSINE[orientation];

        return new Vertex(
                x * cos + z * sin >> 16,
                y,
                z * cos - x * sin >> 16
        );
    }
}
