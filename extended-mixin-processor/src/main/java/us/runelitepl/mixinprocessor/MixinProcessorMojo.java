/*
 *  Copyright (c) 2019, ThatGamerBlue <thatgamerblue@gmail.com>
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package us.runelitepl.mixinprocessor;


import com.google.common.collect.ImmutableSet;
import com.google.common.io.ByteStreams;
import com.google.common.reflect.ClassPath;
import io.sigpipe.jbsdiff.Patch;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.LoaderClassPath;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import us.runelitepl.mixinprocessor.generators.AnnotationProcessor;
import us.runelitepl.mixinprocessor.generators.PatchGenerator;
import us.runelitepl.mixinprocessor.generators.StaticGenerator;
import us.runelitepl.mixinprocessor.generators.StaticStageTwoGenerator;
import us.runelitepl.mixinprocessor.parsers.GamepackDownloader;
import us.runelitepl.mixinprocessor.parsers.HooksParser;
import us.runelitepl.mixinprocessor.transformers.AsmMethodGarbageTransformer;
import us.runelitepl.mixinprocessor.transformers.AsmMethodSignatureTransformer;
import us.runelitepl.mixinprocessor.util.JavassistUtils;
import us.runelitepl.mixinprocessor.util.RefUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Goal which touches a timestamp file.
 */
@Mojo(name = "process-mixins", defaultPhase = LifecyclePhase.PROCESS_CLASSES, requiresDependencyResolution =
		ResolutionScope.COMPILE)
public class MixinProcessorMojo
		extends AbstractMojo implements Opcodes
{
	private static final String PATCHES_PACKAGE = "us.runelitepl.mixins";
	/**
	 * Location of the file.
	 */
	@Parameter(defaultValue = "${project.build.directory}", property = "outputDir", required = true)
	private File outputDirectory;
	
	@Parameter(defaultValue = "${project}", required = true, readonly = true)
	private MavenProject project;
	
	@Parameter(property = "process-mixins.hooks", defaultValue = "hooks.json", required = true)
	private String hooks;
	
	@Parameter(property = "process-mixins.ops", defaultValue = "gamepack.deob.jar.op.json", required = true)
	private String ops;
	
	private static MixinProcessorMojo INST;
	
	public static ClassPool classPool;
	
	public static HashMap<String, Long> fieldDecoders = new HashMap<>();
	
	public static HashMap<String, String> classNames = new HashMap<>();
	public static HashMap<String, String> methodNames = new HashMap<>();
	public static HashMap<String, String> fieldNames = new HashMap<>();
	
	public static HashMap<String, Boolean> isFieldTagged = new HashMap<>();
	public static HashMap<String, Boolean> isMethodTagged = new HashMap<>();
	
	public static HashMap<String, MethodGarbageValue> methodGarbageValues = new HashMap<>();
	
	public static HashMap<String, byte[]> gamepack = new HashMap<>();
	
	public static final int BUFFER_SIZE = 1024 * 1024 * 4;
	
	public void execute()
	throws MojoExecutionException
	{
		INST = this;
		try
		{
			List runtimeClasspathElements = project.getRuntimeClasspathElements();
			URL[] runtimeUrls = new URL[runtimeClasspathElements.size()];
			for (int i = 0; i < runtimeClasspathElements.size(); i++)
			{
				String element = (String) runtimeClasspathElements.get(i);
				runtimeUrls[i] = new File(element).toURI().toURL();
			}
			URLClassLoader classLoader = new URLClassLoader(runtimeUrls,
					Thread.currentThread().getContextClassLoader());
			
			File outputFolder = new File(project.getBuild().getOutputDirectory());
			File projectDir = new File(System.getProperty("user.dir"));
			
			File hooksFile = new File(projectDir, hooks);
			File opsFile = new File(projectDir, ops);
			
			outputFolder.mkdirs();
			
			GamepackDownloader.downloadGamepack(gamepack);
			
			ByteArrayOutputStream patchOutputStream = new ByteArrayOutputStream(BUFFER_SIZE); // 4mb
			
			HooksParser.run(hooksFile, opsFile);
			
			classPool = new ClassPool();
			
			classPool.appendClassPath((new LoaderClassPath(classLoader)));
			
			for (Map.Entry<String, byte[]> entry : gamepack.entrySet())
			{
				byte[] b1_;
				try (InputStream is = getClass().getResourceAsStream("/patch/" + entry.getKey() + ".class.bs"))
				{
					if (is == null)
					{
						stderr("IS null for %s", entry.getKey());
						continue;
					}
					
					b1_ = ByteStreams.toByteArray(is);
				}
				patchOutputStream.reset();
				Patch.patch(entry.getValue(), b1_, patchOutputStream);
				entry.setValue(patchOutputStream.toByteArray());
				
				classPool.makeClass(new ByteArrayInputStream(entry.getValue()));
			}
			
			
			HashMap<String, byte[]> finalClasses = new HashMap<>();
			
			ImmutableSet<ClassPath.ClassInfo> classes =
					ClassPath.from(classLoader).getTopLevelClassesRecursive(PATCHES_PACKAGE);
			
			for (ClassPath.ClassInfo clazz : classes)
			{
				
				stderr("");
				stderr("Annotations: %s", clazz.getSimpleName());
				
				CtClass ctClass = classPool.get(clazz.getName());
				
				String className = ctClass.getSimpleName();
				className = RefUtils.getObbedClassName(className);
				
				byte[] finalCode = JavassistUtils.getClassBytecode(ctClass);
				
				finalCode = new AnnotationProcessor(className, finalCode).run();
				
				finalClasses.put(className, finalCode);
			}
			
			for (Map.Entry<String, byte[]> entry : finalClasses.entrySet())
			{
				String className = entry.getKey();
				byte[] finalCode = entry.getValue();
				
				stderr("");
				stderr("Pass 1: %s", className);
				finalCode = new AsmMethodSignatureTransformer(className, finalCode).transform();
				finalCode = new AsmMethodGarbageTransformer(className, finalCode, finalClasses).transform();
				finalClasses.put(className, finalCode);
			}
			
			stderr("");
			stderr("Pass Statics");
			
			new StaticGenerator().run(finalClasses.get(RefUtils.STATICS_STRING));
			
			new StaticStageTwoGenerator(finalClasses).run();
			
			for (Map.Entry<String, byte[]> entry : finalClasses.entrySet())
			{
				String className = entry.getKey();
				if (className == null)
				{
					stderr("Class name null? %s", entry.getValue().length);
					continue;
				}
				if (className.endsWith(RefUtils.STATICS_STRING))
				{
					continue;
				}
				stderr("");
				stderr("Pass 2: %s", className);
				
				byte[] finalCode = entry.getValue();
				finalCode = new PatchGenerator(className, finalCode).run();
				
				
				entry.setValue(finalCode);
			}
			
			deleteDir(new File(outputFolder, "us/runelitepl/mixins"));
			
			outputFolder = new File(outputFolder, "extended-mixins");
			outputFolder.mkdirs();
			
			for (Map.Entry<String, byte[]> entry : finalClasses.entrySet())
			{
				if (entry.getKey().contains(RefUtils.STATICS_STRING))
				{
					continue;
				}
				Files.write(new File(outputFolder, entry.getKey() + ".class").toPath(),
						entry.getValue());
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			throw new MojoExecutionException(ex.getMessage());
		}
		
	}
	
	public void stderr(String s, Object... format)
	{
		getLog().info(String.format(s, format));
	}
	
	public static void log(String s, Object... format)
	{
		INST.stderr(s, format);
	}
	
	static void deleteDir(File file) throws IOException
	{
		if (!file.exists())
		{
			return;
		}
		Files.walk(file.toPath())
				.sorted(Comparator.reverseOrder())
				.map(Path::toFile)
				.forEach(File::delete);
	}
}
