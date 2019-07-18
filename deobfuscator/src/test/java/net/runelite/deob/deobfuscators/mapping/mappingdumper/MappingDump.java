package net.runelite.deob.deobfuscators.mapping.mappingdumper;

import java.util.List;

public class MappingDump
{
	public int revision;

	public int totalClasses;
	public int totalNamedClasses;

	public int totalFields;
	public int totalNamedFields;

	public int totalNonStaticFields;
	public int totalNamedNonStaticFields;

	public int totalStaticFields;
	public int totalNamedStaticFields;

	public int totalMethods;
	public int totalNamedMethods;

	public int totalNonStaticMethods;
	public int totalNamedNonStaticMethods;

	public int totalStaticMethods;
	public int totalNamedStaticMethods;

	public List<MappedClass> classes;

	// Static things belonging to a certain class will be in both these lists and in the classes
	public List<MappedField> staticFields;
	public List<MappedMethod> staticMethods;
}
