package info.sigterm.deob;

import info.sigterm.deob.deobfuscators.IllegalStateExceptions;
import info.sigterm.deob.deobfuscators.RenameUnique;
import info.sigterm.deob.deobfuscators.RuntimeExceptions;
import info.sigterm.deob.deobfuscators.UnusedBlocks;
import info.sigterm.deob.deobfuscators.UnusedFields;
import info.sigterm.deob.deobfuscators.UnusedMethods;
import info.sigterm.deob.deobfuscators.UnusedParameters;
import info.sigterm.deob.deobfuscators.ConstantParameter;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

public class Deob
{
	public static void main(String[] args) throws IOException
	{
		long start = System.currentTimeMillis();
		
		ClassGroup group = loadJar(args[0]);
		long bstart, bdur;
		
//		bstart = System.currentTimeMillis();
//		new RenameUnique().run(group);
//		bdur = System.currentTimeMillis() - bstart;
//		System.out.println("rename unique took " + bdur/1000L + " seconds");

		// remove except RuntimeException
		bstart = System.currentTimeMillis();
		new RuntimeExceptions().run(group);
		// the blocks of runtime exceptions may contain interesting things like other obfuscations we identify later, but now that
		// it can't be reached by the execution phase, those things become confused. so remove blocks here.
		new UnusedBlocks().run(group);
		bdur = System.currentTimeMillis() - bstart;
		System.out.println("runtime exception took " + bdur/1000L + " seconds");
		
		// remove unused methods
		bstart = System.currentTimeMillis();
		new UnusedMethods().run(group);
		bdur = System.currentTimeMillis() - bstart;
		System.out.println("unused methods took " + bdur/1000L + " seconds");
		
		// remove illegal state exceptions, frees up some parameters
		bstart = System.currentTimeMillis();
		new IllegalStateExceptions().run(group);
		bdur = System.currentTimeMillis() - bstart;
		System.out.println("illegal state exception took " + bdur/1000L + " seconds");
		
		// remove constant logically dead parameters
		bstart = System.currentTimeMillis();
		new ConstantParameter().run(group);
		bdur = System.currentTimeMillis() - bstart;
		System.out.println("constant param took " + bdur/1000L + " seconds");
		
		// remove unhit blocks
//		bstart = System.currentTimeMillis();
//		new UnusedBlocks().run(group);
//		bdur = System.currentTimeMillis() - bstart;
//		System.out.println("unused blocks took " + bdur/1000L + " seconds");

		// remove unused parameters
		bstart = System.currentTimeMillis();
		new UnusedParameters().run(group);
		bdur = System.currentTimeMillis() - bstart;
		System.out.println("unused params took " + bdur/1000L + " seconds");
		
		// remove jump obfuscation
		//new Jumps().run(group);
		
		// remove unused fields
//		bstart = System.currentTimeMillis();
//		new UnusedFields().run(group);
//		bdur = System.currentTimeMillis() - bstart;
//		System.out.println("unused fields took " + bdur/1000L + " seconds");
		
		//new ModularArithmeticDeobfuscation().run(group);

		saveJar(group, args[1]);
		
		long end = System.currentTimeMillis();
		System.out.println("Done in " + ((end - start) / 1000L) + "s");
	}
	
	public static boolean isObfuscated(String name)
	{
		return name.length() <= 2 || name.startsWith("method") || name.startsWith("vmethod") || name.startsWith("field") || name.startsWith("class");
	}
	
	private static ClassGroup loadJar(String jarfile) throws IOException
	{
		ClassGroup group = new ClassGroup();

		JarFile jar = new JarFile(jarfile);
		for (Enumeration<JarEntry> it = jar.entries(); it.hasMoreElements();)
		{
			JarEntry entry = it.nextElement();

			if (!entry.getName().endsWith(".class"))
				continue;

			InputStream is = jar.getInputStream(entry);
			group.addClass(entry.getName(), new DataInputStream(is));
		}
		jar.close();
		
		return group;
	}
	
	private static void saveJar(ClassGroup group, String jarfile) throws IOException
	{
		JarOutputStream jout = new JarOutputStream(new FileOutputStream(jarfile), new Manifest());
		
		for (ClassFile cf : group.getClasses())
		{
			JarEntry entry = new JarEntry(cf.getName() + ".class");
			jout.putNextEntry(entry);
			
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			cf.write(new DataOutputStream(bout));
			jout.write(bout.toByteArray());
			
			jout.closeEntry();
		}
		
		jout.close();
	}
}