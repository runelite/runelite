/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.cache.models;

import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;
import net.runelite.cache.definitions.ModelDefinition;

public class ObjExporter
{
	private final ModelDefinition model;

	public ObjExporter(ModelDefinition model)
	{
		this.model = model;
	}

	public void export(PrintWriter objWriter, PrintWriter mtlWriter) throws IOException
	{
		model.computeNormals();

		objWriter.println("mtllib " + model.id + ".mtl");

		objWriter.println("o runescapemodel");

		for (int i = 0; i < model.vertexCount; ++i)
		{
			objWriter.println("     v " + model.vertexX[i] + " " + model.vertexY[i] + " " + model.vertexZ[i]);
		}

		for (VertexNormal normal : model.normals)
		{
			objWriter.println("     vn " + normal.x + " " + normal.y + " " + normal.z);
		}

		for (int i = 0; i < model.triangleFaceCount; ++i)
		{
			objWriter.println("     usemtl color" + model.faceColor[i]);
			objWriter.println("             f " + (model.trianglePointsX[i] + 1) + " " + (model.trianglePointsY[i] + 1) + " " + (model.trianglePointsZ[i] + 1));
			objWriter.println("");
		}

		for (int i = 0; i < model.faceColor.length; ++i)
		{
			mtlWriter.println("newmtl color" + model.faceColor[i]);

			Color color = rs2hsbToColor(model.faceColor[i]);

			double r = color.getRed() / 255.0;
			double g = color.getGreen() / 255.0;
			double b = color.getBlue() / 255.0;

			mtlWriter.println("     Kd " + r + " " + g + " " + b);

			if (model.faceAlphas != null)
			{
				mtlWriter.println("     d " + (model.faceAlphas[i] & 0xFF) / 255.0);
			}
		}
	}

	private static Color rs2hsbToColor(int hsb)
	{
		int decode_hue = (hsb >> 10) & 0x3f;
		int decode_saturation = (hsb >> 7) & 0x07;
		int decode_brightness = (hsb & 0x7f);
		return Color.getHSBColor((float) decode_hue / 63, (float) decode_saturation / 7, (float) decode_brightness / 127);
	}
}
