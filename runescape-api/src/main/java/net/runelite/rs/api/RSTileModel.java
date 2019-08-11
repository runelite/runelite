package net.runelite.rs.api;

import net.runelite.api.TileModel;
import net.runelite.mapping.Import;

public interface RSTileModel extends TileModel
{
	@Import("underlayRgb")
	@Override
	int getModelUnderlay();

	@Import("overlayRgb")
	@Override
	int getModelOverlay();

	@Import("shape")
	@Override
	int getShape();

	@Import("rotation")
	@Override
	int getRotation();

	@Import("faceX")
	@Override
	int[] getFaceX();

	@Import("faceY")
	@Override
	int[] getFaceY();

	@Import("faceZ")
	@Override
	int[] getFaceZ();

	@Import("vertexX")
	@Override
	int[] getVertexX();

	@Import("vertexY")
	@Override
	int[] getVertexY();

	@Import("vertexZ")
	@Override
	int[] getVertexZ();

	@Import("triangleColorA")
	@Override
	int[] getTriangleColorA();

	@Import("triangleColorB")
	@Override
	int[] getTriangleColorB();

	@Import("triangleColorC")
	@Override
	int[] getTriangleColorC();

	@Import("triangleTextureId")
	@Override
	int[] getTriangleTextureId();
}
