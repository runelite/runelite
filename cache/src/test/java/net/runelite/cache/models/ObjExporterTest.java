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

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import net.runelite.cache.StoreLocation;
import net.runelite.cache.TextureManager;
import net.runelite.cache.definitions.ModelDefinition;
import net.runelite.cache.definitions.loaders.ModelLoader;
import net.runelite.cache.fs.Store;
import org.junit.Ignore;
import org.junit.Test;

public class ObjExporterTest
{
	@Test
	@Ignore
	public void testExport() throws Exception
	{
		try (Store store = new Store(StoreLocation.LOCATION))
		{
			store.load();

			TextureManager tm = new TextureManager(store);
			tm.load();

			ModelLoader loader = new ModelLoader();
			ModelDefinition model = loader.load(9638, Files.readAllBytes(new File("D:\\rs\\07\\cache\\models\\9638.model").toPath()));

			ObjExporter exporter = new ObjExporter(tm, model);
			try (PrintWriter objWriter = new PrintWriter(new FileWriter(new File("D:\\rs\\07\\temp\\9638.obj")));
				PrintWriter mtlWriter = new PrintWriter(new FileWriter(new File("D:\\rs\\07\\temp\\9638.mtl"))))
			{
				exporter.export(objWriter, mtlWriter);
			}
		}
	}
}
