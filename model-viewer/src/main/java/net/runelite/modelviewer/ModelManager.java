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
package net.runelite.modelviewer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import net.runelite.cache.definitions.ModelDefinition;
import net.runelite.cache.definitions.ObjectDefinition;
import net.runelite.cache.definitions.loaders.ModelLoader;
import net.runelite.cache.region.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelManager
{
	private static final Logger logger = LoggerFactory.getLogger(ModelManager.class);

	private static Map<LocationKey, ModelDefinition> models = new HashMap<>();

	public static ModelDefinition getModel(int id, ObjectDefinition object, Location location)
	{
		LocationKey key;

		int rot = location.getOrientation();

		if (location != null)
		{
			key = new LocationKey(id, location.getType(), rot);
		}
		else
		{
			key = new LocationKey(id, -1, -1);
		}

		ModelDefinition md = models.get(key);
		if (md != null)
		{
			return md;
		}

		try
		{
			byte[] b = Files.readAllBytes(new File("models/" + id + ".model").toPath());

			ModelLoader loader = new ModelLoader();
			md = loader.load(id, b);

			if (object != null && location != null)
			{
				rotate(md, object, location, rot);
				md.computeNormals();
			}

			models.put(key, md);
			return md;
		}
		catch (IOException ex)
		{
			logger.warn(null, ex);
			return null;
		}
	}

	// this logic is from method3697 in 140
	private static void rotate(ModelDefinition md, ObjectDefinition object, Location location, int rot)
	{
		if (object.getObjectTypes() == null)
		{
			boolean isRotate = object.isRotated();

			if (location.getType() == 2 && rot > 3)
			{
				isRotate = !isRotate;
			}

			if (isRotate)
			{
				md.method1493();
			}
		}
		else
		{
			boolean isRotate = object.isRotated() ^ rot > 3;

			if (isRotate)
			{
				md.method1493();
			}
		}

		switch (rot & 3)
		{
			case 1:
				md.rotate1();
				break;
			case 2:
				md.rotate2();
				break;
			case 3:
				md.rotate3();
				break;
		}
	}
}
