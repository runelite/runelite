package net.runelite.deob.updater.mappingdumper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.pool.Class;
import net.runelite.asm.pool.Field;
import net.runelite.asm.pool.Method;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.updater.MappingDumper;
import static org.objectweb.asm.Opcodes.ACC_STATIC;

public class MappingDump
{
	public int revision;

	public int totalClasses = 0;
	public int totalNamedClasses = 0;

	public int totalFields = 0;
	public int totalNamedFields = 0;

	public int totalNonStaticFields = 0;
	public int totalNamedNonStaticFields = 0;

	public int totalStaticFields = 0;
	public int totalNamedStaticFields = 0;

	public int totalMethods = 0;
	public int totalNamedMethods = 0;

	public int totalNonStaticMethods = 0;
	public int totalNamedNonStaticMethods = 0;

	public int totalStaticMethods = 0;
	public int totalNamedStaticMethods = 0;

	public List<MappedClass> classes;

	private ClassGroup group;

	public MappingDump visitGroup(ClassGroup group)
	{
		this.group = group;
		classes = new ArrayList<>();

		for (ClassFile c : group.getClasses())
		{
			if (c.getName().contains("runelite"))
			{
				continue;
			}

			final MappedClass mc = new MappedClass();
			classes.add(mc.visitClass(c, this));
		}

		totalClasses = classes.size();

		for (MappedClass c : classes)
		{
			if (c.implementingName != null)
			{
				totalNamedClasses++;
			}

			for (MappedMethod mm : c.methods)
			{
				for (Map.Entry<Field, Integer> entry : mm.fieldGets.entrySet())
				{
					MappedField mf = MappingDumper.getMap(entry.getKey());
					if (mf == null)
					{
						continue;
					}
					mf.gets.put(
						new Method(
							new Class(mm.owner),
							mm.obfuscatedName,
							new Signature(mm.descriptor)),
						entry.getValue());
				}
				for (Map.Entry<Field, Integer> entry : mm.fieldPuts.entrySet())
				{
					MappedField mf = MappingDumper.getMap(entry.getKey());
					if (mf == null)
					{
						continue;
					}
					mf.puts.put(
						new Method(
							new Class(mm.owner),
							mm.obfuscatedName,
							new Signature(mm.descriptor)),
						entry.getValue());
				}
			}

			grabAmountInfo(c);
		}
		totalNonStaticFields = totalFields - totalStaticFields;
		totalNamedNonStaticFields = totalNamedFields - totalNamedStaticFields;
		totalNonStaticMethods = totalMethods - totalStaticMethods;
		totalNamedNonStaticMethods = totalNamedMethods - totalNamedStaticMethods;

		return this;
	}

	private void grabAmountInfo(MappedClass c)
	{
		totalFields += c.fields.size();
		totalNamedFields += c.fields
			.stream()
			.filter(f -> f.exportedName != null)
			.count();
		totalStaticFields += c.fields
			.stream()
			.filter(f -> (f.access & ACC_STATIC) != 0)
			.count();
		totalNamedStaticFields += c.fields
			.stream()
			.filter(f -> f.exportedName != null
				&& (f.access & ACC_STATIC) != 0)
			.count();

		totalMethods += c.methods.size();
		totalNamedMethods += c.methods
			.stream()
			.filter(f -> f.exportedName != null)
			.count();
		totalStaticMethods += c.methods
			.stream()
			.filter(f -> (f.access & ACC_STATIC) != 0)
			.count();
		totalNamedStaticMethods += c.methods
			.stream()
			.filter(f -> f.exportedName != null
				&& (f.access & ACC_STATIC) != 0)
			.count();
	}

	ClassGroup getGroup()
	{
		return group;
	}
}
