/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.modelviewer;

import java.awt.Color;
import java.io.File;
import java.nio.file.Files;
import net.runelite.cache.definitions.ModelDefinition;
import net.runelite.cache.definitions.loaders.ModelLoader;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;

public class ModelViewer
{
	public static void main(String[] args) throws Exception
	{
		if (args.length < 1)
		{
			System.err.println("Usage: modelfile");
			System.exit(1);
		}

		ModelLoader loader = new ModelLoader();
		byte[] b = Files.readAllBytes(new File(args[0]).toPath());
		ModelDefinition md = loader.load(b);

		Display.setDisplayMode(new DisplayMode(800, 600));
		Display.setTitle("Model Viewer");
		Display.setInitialBackground((float) Color.gray.getRed() / 255f, (float) Color.gray.getGreen() / 255f, (float) Color.gray.getBlue() / 255f);
		Display.create();

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		double aspect = 1;
		double near = 1; // near should be chosen as far into the scene as possible
		double far = 1000;
		double fov = 1; // 1 gives you a 90° field of view. It's tan(fov_angle)/2.
		GL11.glFrustum(-aspect * near * fov, aspect * near * fov, -fov, fov, near, far);

		GL11.glCullFace(GL11.GL_BACK);

		long last = 0;

		// rotate and step back to view
		glRotatef(-90, 1, 0, 0);
		glTranslatef(0, 60.0f, 0);

		while (!Display.isCloseRequested())
		{
			// Clear the screen and depth buffer
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

			GL11.glBegin(GL11.GL_TRIANGLES);

			for (int i = 0; i < md.triangleFaceCount; ++i)
			{
				int vertexA = md.trianglePointsX[i];
				int vertexB = md.trianglePointsY[i];
				int vertexC = md.trianglePointsZ[i];

				int vertexAx = md.vertexX[vertexA];
				int vertexAy = md.vertexY[vertexA];
				int vertexAz = md.vertexZ[vertexA];

				int vertexBx = md.vertexX[vertexB];
				int vertexBy = md.vertexY[vertexB];
				int vertexBz = md.vertexZ[vertexB];

				int vertexCx = md.vertexX[vertexC];
				int vertexCy = md.vertexY[vertexC];
				int vertexCz = md.vertexZ[vertexC];

				short hsb = md.faceColor[i];

				int rgb = RS2HSB_to_RGB(hsb);
				Color c = new Color(rgb);

				// convert to range of 0-1
				float rf = (float) c.getRed() / 255f;
				float gf = (float) c.getGreen() / 255f;
				float bf = (float) c.getBlue() / 255f;

				GL11.glColor3f(rf, gf, bf);

				GL11.glVertex3i(vertexAx, vertexAy, vertexAz);
				GL11.glVertex3i(vertexBx, vertexBy, vertexBz);
				GL11.glVertex3i(vertexCx, vertexCy, vertexCz);
			}

			GL11.glEnd();

			Display.update();
			Display.sync(50); // fps

			long delta = System.currentTimeMillis() - last;
			last = System.currentTimeMillis();

			Camera.create();
			Camera.acceptInput(delta);

			Camera.apply();
		}

		Display.destroy();
	}

	// found these two functions here https://www.rune-server.org/runescape-development/rs2-client/tools/589900-rs2-hsb-color-picker.html
	public static int RGB_to_RS2HSB(int red, int green, int blue)
	{
		float[] HSB = Color.RGBtoHSB(red, green, blue, null);
		float hue = (HSB[0]);
		float saturation = (HSB[1]);
		float brightness = (HSB[2]);
		int encode_hue = (int) (hue * 63);			//to 6-bits
		int encode_saturation = (int) (saturation * 7);		//to 3-bits
		int encode_brightness = (int) (brightness * 127); 	//to 7-bits
		return (encode_hue << 10) + (encode_saturation << 7) + (encode_brightness);
	}

	public static int RS2HSB_to_RGB(int RS2HSB)
	{
		int decode_hue = (RS2HSB >> 10) & 0x3f;
		int decode_saturation = (RS2HSB >> 7) & 0x07;
		int decode_brightness = (RS2HSB & 0x7f);
		return Color.HSBtoRGB((float) decode_hue / 63, (float) decode_saturation / 7, (float) decode_brightness / 127);
	}
}
