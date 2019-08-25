package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface RSModelData extends RSEntity
{
	@Import("faceCount")
	int getTriangleFaceCount();

	@Import("indices1")
	int[] getTrianglePointsX();

	@Import("indices2")
	int[] getTrianglePointsY();

	@Import("indices3")
	int[] getTrianglePointsZ();

	@Import("verticesX")
	int[] getVertexX();

	@Import("verticesY")
	int[] getVertexY();

	@Import("verticesZ")
	int[] getVertexZ();

	@Import("texTriangleX")
	short[] getTexTriangleX();

	@Import("texTriangleY")
	short[] getTexTriangleY();

	@Import("texTriangleZ")
	short[] getTexTriangleZ();

	@Import("faceTextures")
	short[] getFaceTextures();

	@Import("textureCoords")
	byte[] getTextureCoords();

	@Import("textureRenderTypes")
	byte[] getTextureRenderTypes();
}
