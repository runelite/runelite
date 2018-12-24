/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.mixins;

import net.runelite.api.Model;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSModel;
import net.runelite.rs.api.RSModelData;

@Mixin(RSModelData.class)
public abstract class RSModelDataMixin implements RSModelData
{
	@Shadow("clientInstance")
	private static RSClient client;

	@Inject
	private float[][] faceTextureUCoordinates;

	@Inject
	private float[][] faceTextureVCoordinates;

	@Copy("light")
	public abstract Model rs$light(int ambient, int contrast, int var3, int var4, int var5);

	@Replace("light")
	public Model rl$light(int ambient, int contrast, int var3, int var4, int var5)
	{
		client.getLogger().debug("Lighting model {}", this);

		Model model = rs$light(ambient, contrast, var3, var4, var5);
		if (model == null)
		{
			return null;
		}

		if (faceTextureUCoordinates == null)
		{
			computeTextureUVCoordinates();
		}

		RSModel rsModel = (RSModel) model;
		rsModel.setFaceTextureUCoordinates(faceTextureUCoordinates);
		rsModel.setFaceTextureVCoordinates(faceTextureVCoordinates);
		return model;
	}

	@Inject
	public void computeTextureUVCoordinates()
	{
		final short[] faceTextures = getFaceTextures();
		if (faceTextures == null)
		{
			return;
		}

		final int[] vertexPositionsX = getVertexX();
		final int[] vertexPositionsY = getVertexY();
		final int[] vertexPositionsZ = getVertexZ();

		final int[] trianglePointsX = getTrianglePointsX();
		final int[] trianglePointsY = getTrianglePointsY();
		final int[] trianglePointsZ = getTrianglePointsZ();

		final short[] texTriangleX = getTexTriangleX();
		final short[] texTriangleY = getTexTriangleY();
		final short[] texTriangleZ = getTexTriangleZ();

		final byte[] textureCoords = getTextureCoords();
		final byte[] textureRenderTypes = getTextureRenderTypes();

		int faceCount = getTriangleFaceCount();
		this.faceTextureUCoordinates = new float[faceCount][];
		this.faceTextureVCoordinates = new float[faceCount][];

		for (int i = 0; i < faceCount; i++)
		{
			int textureCoordinate;
			if (textureCoords == null)
			{
				textureCoordinate = -1;
			}
			else
			{
				textureCoordinate = textureCoords[i];
			}

			short textureIdx;
			textureIdx = faceTextures[i];

			if (textureIdx != -1)
			{
				float[] u = new float[3];
				float[] v = new float[3];

				if (textureCoordinate == -1)
				{
					u[0] = 0.0F;
					v[0] = 1.0F;

					u[1] = 1.0F;
					v[1] = 1.0F;

					u[2] = 0.0F;
					v[2] = 0.0F;
				}
				else
				{
					textureCoordinate &= 0xFF;

					byte textureRenderType = 0;
					if (textureRenderTypes != null)
					{
						textureRenderType = textureRenderTypes[textureCoordinate];
					}

					if (textureRenderType == 0)
					{
						int faceVertexIdx1 = trianglePointsX[i];
						int faceVertexIdx2 = trianglePointsY[i];
						int faceVertexIdx3 = trianglePointsZ[i];

						int triangleVertexIdx1 = texTriangleX[textureCoordinate];
						int triangleVertexIdx2 = texTriangleY[textureCoordinate];
						int triangleVertexIdx3 = texTriangleZ[textureCoordinate];

						float triangleX = (float) vertexPositionsX[triangleVertexIdx1];
						float triangleY = (float) vertexPositionsY[triangleVertexIdx1];
						float triangleZ = (float) vertexPositionsZ[triangleVertexIdx1];

						float f_882_ = (float) vertexPositionsX[triangleVertexIdx2] - triangleX;
						float f_883_ = (float) vertexPositionsY[triangleVertexIdx2] - triangleY;
						float f_884_ = (float) vertexPositionsZ[triangleVertexIdx2] - triangleZ;
						float f_885_ = (float) vertexPositionsX[triangleVertexIdx3] - triangleX;
						float f_886_ = (float) vertexPositionsY[triangleVertexIdx3] - triangleY;
						float f_887_ = (float) vertexPositionsZ[triangleVertexIdx3] - triangleZ;
						float f_888_ = (float) vertexPositionsX[faceVertexIdx1] - triangleX;
						float f_889_ = (float) vertexPositionsY[faceVertexIdx1] - triangleY;
						float f_890_ = (float) vertexPositionsZ[faceVertexIdx1] - triangleZ;
						float f_891_ = (float) vertexPositionsX[faceVertexIdx2] - triangleX;
						float f_892_ = (float) vertexPositionsY[faceVertexIdx2] - triangleY;
						float f_893_ = (float) vertexPositionsZ[faceVertexIdx2] - triangleZ;
						float f_894_ = (float) vertexPositionsX[faceVertexIdx3] - triangleX;
						float f_895_ = (float) vertexPositionsY[faceVertexIdx3] - triangleY;
						float f_896_ = (float) vertexPositionsZ[faceVertexIdx3] - triangleZ;

						float f_897_ = f_883_ * f_887_ - f_884_ * f_886_;
						float f_898_ = f_884_ * f_885_ - f_882_ * f_887_;
						float f_899_ = f_882_ * f_886_ - f_883_ * f_885_;
						float f_900_ = f_886_ * f_899_ - f_887_ * f_898_;
						float f_901_ = f_887_ * f_897_ - f_885_ * f_899_;
						float f_902_ = f_885_ * f_898_ - f_886_ * f_897_;
						float f_903_ = 1.0F / (f_900_ * f_882_ + f_901_ * f_883_ + f_902_ * f_884_);

						u[0] = (f_900_ * f_888_ + f_901_ * f_889_ + f_902_ * f_890_) * f_903_;
						u[1] = (f_900_ * f_891_ + f_901_ * f_892_ + f_902_ * f_893_) * f_903_;
						u[2] = (f_900_ * f_894_ + f_901_ * f_895_ + f_902_ * f_896_) * f_903_;

						f_900_ = f_883_ * f_899_ - f_884_ * f_898_;
						f_901_ = f_884_ * f_897_ - f_882_ * f_899_;
						f_902_ = f_882_ * f_898_ - f_883_ * f_897_;
						f_903_ = 1.0F / (f_900_ * f_885_ + f_901_ * f_886_ + f_902_ * f_887_);

						v[0] = (f_900_ * f_888_ + f_901_ * f_889_ + f_902_ * f_890_) * f_903_;
						v[1] = (f_900_ * f_891_ + f_901_ * f_892_ + f_902_ * f_893_) * f_903_;
						v[2] = (f_900_ * f_894_ + f_901_ * f_895_ + f_902_ * f_896_) * f_903_;
					}
				}

				this.faceTextureUCoordinates[i] = u;
				this.faceTextureVCoordinates[i] = v;
			}
		}
	}

}
