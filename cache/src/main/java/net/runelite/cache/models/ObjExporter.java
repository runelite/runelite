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
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import net.runelite.cache.definitions.ModelDefinition;

public class ObjExporter
{
	private final ModelDefinition model;

	public ObjExporter(ModelDefinition model)
	{
		this.model = model;
	}

	public void export(PrintWriter objWriter, PrintWriter mtlWriter)
	{
		model.computeNormals();

		objWriter.println("mtllib " + model.id + ".mtl");

		objWriter.println("o runescapemodel");

		for (int i = 0; i < model.vertexCount; ++i)
		{
			objWriter.println("     v " + model.vertexPositionsX[i] + " " + model.vertexPositionsY[i] + " " + model.vertexPositionsZ[i]);
		}

		for (VertexNormal normal : model.vertexNormals)
		{
			objWriter.println("     vn " + normal.x + " " + normal.y + " " + normal.z);
		}

		Set<Integer> usedMaterials = new HashSet<>();

		for (int i = 0; i < model.faceCount; ++i)
		{
			Color color = rs2hsbToColor(model.faceColors[i]);

			int alpha = 0;

			if (model.faceAlphas != null)
			{
				alpha = model.faceAlphas[i] & 0xFF;
			}

			int rgba = color.getRGB() << 8 | alpha;
			
			objWriter.println("     usemtl color" + rgba);
			objWriter.println("             f " + (model.faceVertexIndices1[i] + 1) + "//" + (model.faceVertexIndices1[i] + 1) +
				" " + (model.faceVertexIndices2[i] + 1) + "//" + (model.faceVertexIndices2[i] + 1) +
				" " + (model.faceVertexIndices3[i] + 1) + "//" + (model.faceVertexIndices3[i] + 1));
			objWriter.println("");

			// Write material
			
			if (usedMaterials.contains(rgba))
				continue;
			usedMaterials.add(rgba);

			mtlWriter.println("newmtl color" + rgba);

			double r = color.getRed() / 255.0;
			double g = color.getGreen() / 255.0;
			double b = color.getBlue() / 255.0;

			mtlWriter.println("     Kd " + r + " " + g + " " + b);

			if (alpha != 0)
			{
				mtlWriter.println("     d " + (alpha / 255.0));
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
