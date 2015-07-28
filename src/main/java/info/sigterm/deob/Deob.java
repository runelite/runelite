package info.sigterm.deob;

import info.sigterm.deob.deobfuscators.IllegalStateExceptions;
import info.sigterm.deob.deobfuscators.Jumps;
import info.sigterm.deob.deobfuscators.ModularArithmeticDeobfuscation;
import info.sigterm.deob.deobfuscators.RenameUnique;
import info.sigterm.deob.deobfuscators.RuntimeExceptions;
import info.sigterm.deob.deobfuscators.UnusedBlocks;
import info.sigterm.deob.deobfuscators.UnusedFields;
import info.sigterm.deob.deobfuscators.UnusedMethods;
import info.sigterm.deob.deobfuscators.UnusedParameters;
import info.sigterm.deob.execution.Execution;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.pool.NameAndType;
import info.sigterm.deob.signature.Signature;
import info.sigterm.deob.attributes.Code;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instructions.Goto;
import info.sigterm.deob.attributes.code.instructions.GotoW;
import info.sigterm.deob.attributes.code.instructions.Return;
import info.sigterm.deob.block.Block;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
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
		
		new RenameUnique().run(group);

		// remove except RuntimeException
		new RuntimeExceptions().run(group);
		// the blocks of runtime exceptions may contain interesting things like other obfuscations we identify later, but now that
		// it can't be reached by the execution phase, those things become confused. so remove blocks here.
		new UnusedBlocks().run(group);
		
		// remove unused methods
		new UnusedMethods().run(group);
		
		// remove illegal state exceptions, frees up some parameters
		new IllegalStateExceptions().run(group);
		
		// remove unhit blocks
		new UnusedBlocks().run(group);
		
		// remove unused parameters
		new UnusedParameters().run(group);
		
		// remove jump obfuscation
		//new Jumps().run(group);
		
		// remove unused fields
		new UnusedFields().run(group);
		
		//new ModularArithmeticDeobfuscation().run(group);

		saveJar(group, args[1]);
		
		long end = System.currentTimeMillis();
		System.out.println("Done in " + ((end - start) / 1000L) + "s");
	}
	
	public static boolean isObfuscated(String name)
	{
		return name.startsWith("method") || name.startsWith("vmethod") || name.startsWith("field") || name.startsWith("class");
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