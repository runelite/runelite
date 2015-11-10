package net.runelite.deob;

import net.runelite.deob.deobfuscators.FieldInliner;

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
import net.runelite.deob.deobfuscators.ConstantParameter;
import net.runelite.deob.deobfuscators.IllegalStateExceptions;
import net.runelite.deob.deobfuscators.MethodInliner;
import net.runelite.deob.deobfuscators.rename.Rename;
import net.runelite.deob.deobfuscators.RenameUnique;
import net.runelite.deob.deobfuscators.RuntimeExceptions;
import net.runelite.deob.deobfuscators.UnreachedCode;
import net.runelite.deob.deobfuscators.UnusedClass;
import net.runelite.deob.deobfuscators.UnusedFields;
import net.runelite.deob.deobfuscators.UnusedMethods;
import net.runelite.deob.deobfuscators.UnusedParameters;
import net.runelite.deob.deobfuscators.arithmetic.ModArith;
import net.runelite.deob.deobfuscators.arithmetic.MultiplicationDeobfuscator;
import net.runelite.deob.deobfuscators.arithmetic.MultiplyOneDeobfuscator;
import net.runelite.deob.deobfuscators.arithmetic.MultiplyZeroDeobfuscator;
import net.runelite.deob.execution.Execution;

// XXX something to detect final fields and evaluate them
// XXX ORDER IN WHICH FIELDS ARE ACCESSED

public class Deob
{
	public static void main(String[] args) throws IOException
	{
		//merge(); if(true) return;
		
		long start = System.currentTimeMillis();
		
		ClassGroup group = loadJar(args[0]);
		
//		run(group, new RenameUnique());
//
//		// remove except RuntimeException
//		run(group, new RuntimeExceptions());
//		
//		// remove unused methods
//		run(group, new UnusedMethods());
//		
//		run(group, new UnreachedCode());
//		
//		// remove illegal state exceptions, frees up some parameters
//		run(group, new IllegalStateExceptions());
//		
//		// remove constant logically dead parameters
//		run(group, new ConstantParameter());
//		
//		// remove unhit blocks
//		run(group, new UnreachedCode());
//		run(group, new UnusedMethods());
//
//		// remove unused parameters
//		run(group, new UnusedParameters());
//		
//		// remove jump obfuscation
//		//new Jumps().run(group);
//		
//		// remove unused fields
//		run(group, new UnusedFields());
//		
//		// remove unused methods, again?
//		run(group, new UnusedMethods());

		run(group, new MethodInliner());
		run(group, new UnusedMethods()); // inliner might leave unused methods

//		// broken because rename was removed
//		//run(group, new MethodMover());
//		
//		run(group, new FieldInliner());
//		
//		// XXX this is broken because when moving clinit around, some fields can depend on other fields
//		// (like multianewarray)
//		//new FieldMover().run(group);
//		
//		run(group, new UnusedClass());
//	
//		ModArith mod = new ModArith();
//		mod.run(group);
//		
//		int last = -1, cur;
//		while ((cur = mod.runOnce()) > 0)
//		{	
//			new MultiplicationDeobfuscator().run(group);
//
//			new MultiplyOneDeobfuscator().run(group);
//
//			new MultiplyZeroDeobfuscator().run(group);
//			
//			if (last == cur)
//			{
//				System.out.println("break");
//				break;
//			}
//			
//			last = cur;
//			//break;
//		}
		
		// eval constant fields (only set once to a constant in ctor) maybe just inline them
		
		// make fields private

		saveJar(group, args[1]);
		
		long end = System.currentTimeMillis();
		System.out.println("Done in " + ((end - start) / 1000L) + "s");
	}
	
	private static void merge() throws IOException
	{
		ClassGroup group1 = loadJar("d:/rs/07/adamin1.jar"),
			group2 = loadJar("d:/rs/07/adamin2.jar");
		
		Rename rename = new Rename();
		rename.run(group1, group2);
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
	
	private static void run(ClassGroup group, Deobfuscator deob)
	{
		long bstart, bdur;
		
		bstart = System.currentTimeMillis();
		deob.run(group);
		bdur = System.currentTimeMillis() - bstart;
		
		System.out.println(deob.getClass().getName() + " took " + (bdur / 1000L) + " seconds");
		
		// check code is still correct
		Execution execution = new Execution(group);
		execution.populateInitialMethods();
		execution.run();
	}
}