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

package net.runelite.deob.deobfuscators.rename;

import java.io.File;
import java.io.IOException;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.deob.deobfuscators.mapping.AnnotationIntegrityChecker;
import net.runelite.deob.deobfuscators.mapping.AnnotationMapper;
import net.runelite.deob.deobfuscators.mapping.Mapper;
import net.runelite.deob.deobfuscators.mapping.MappingExecutorUtil;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;
import static net.runelite.deob.deobfuscators.rename.MapperTest.print;
import static net.runelite.deob.deobfuscators.rename.MapperTest.summary;
import net.runelite.deob.util.JarUtil;
import org.junit.Ignore;
import org.junit.Test;

public class AnnotationMapperTest
{
	private static final String JAR1 = "C:\\Users\\Adam\\.m2\\repository\\net\\runelite\\rs\\rs-client\\1.0-SNAPSHOT\\rs-client-1.0-SNAPSHOT.jar",
		JAR2 = "d:/rs/07/gamepack_113_deobfuscated.jar",
		OUT = "d:/rs/07/adamout.jar";
	
	@Test
	@Ignore
	public void testRun() throws IOException
	{
		ClassGroup group1 = JarUtil.loadJar(new File(JAR1));
		ClassGroup group2 = JarUtil.loadJar(new File(JAR2));

		Mapper mapper = new Mapper(group1, group2);
		mapper.run();
		ParallelExecutorMapping mapping = mapper.getMapping();

		summary(mapping, group1);

		String sg1 = print(group1),
			sg2 = print(group2);

		System.out.println("GROUP 1 " + sg1);
		System.out.println("GROUP 2 " + sg2);

		Method m1 = group1.findClass("class199").findMethod("method3902");
		Method m2 = (Method) mapping.get(m1);

		MappingExecutorUtil.map(m1, m2);

		AnnotationMapper amapper = new AnnotationMapper(group1, group2, mapping);
		amapper.run();

		AnnotationIntegrityChecker aic = new AnnotationIntegrityChecker(group1, group2, mapping);
		aic.run();

		JarUtil.saveJar(group2, new File(OUT));
	}

}
