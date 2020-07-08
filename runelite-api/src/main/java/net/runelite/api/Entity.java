package net.runelite.api;

/**
 * Represents an object that can be rendered.
 */
public interface Entity extends Node
{
    /**
     * Gets the model of the object.
     */
    Model getModel();

    /**
     * Gets the height of the model.
     */
    int getModelHeight();

    void setModelHeight(int modelHeight);

    void draw(int orientation, int pitchSin, int pitchCos, int yawSin, int yawCos, int x, int y, int z, long hash);
}