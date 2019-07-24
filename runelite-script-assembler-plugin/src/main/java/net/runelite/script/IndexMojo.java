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
package net.runelite.script;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(
	name = "build-index",
	defaultPhase = LifecyclePhase.GENERATE_RESOURCES
)
public class IndexMojo extends AbstractMojo
{
	@Parameter(required = true)
	private File archiveOverlayDirectory;

	@Parameter(required = true)
	private File indexFile;

	private IndexMojo(File archiveOverlayDirectory, File indexFile)
	{
		this.archiveOverlayDirectory = archiveOverlayDirectory;
		this.indexFile = indexFile;
	}

	public static void main(String[] args) throws Exception
	{
		if (args.length < 2)
		{
			throw new IllegalArgumentException("Usage: overlaydir indexfile");
		}

		File archiveOverlayDirectory = new File(args[0]);
		File indexFile = new File(args[1]);

		new IndexMojo(archiveOverlayDirectory, indexFile).execute();
	}

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException
	{
		try (DataOutputStream fout = new DataOutputStream(new FileOutputStream(indexFile)))
		{
			for (File indexFolder : archiveOverlayDirectory.listFiles())
			{
				if (indexFolder.isDirectory())
				{
					int indexId = parseInt(indexFolder.getName());
					for (File archiveFile : indexFolder.listFiles())
					{
						int archiveId;
						try
						{
							archiveId = parseInt(archiveFile.getName());
						}
						catch (NumberFormatException ex)
						{
							continue;
						}

						fout.writeInt(indexId << 16 | archiveId);
					}
				}
			}

			fout.writeInt(-1);
		}
		catch (IOException ex)
		{
			throw new MojoExecutionException("error building index file", ex);
		}
	}

}
