package net.runelite.deob.deobfuscators.mapping.mappingdumper;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class MappedClass
{
	@SerializedName("class")
	public String implementingName;
	@SerializedName("name")
	public String obfuscatedName;
	@SerializedName("super")
	public String superClass;
	public int access;
	public List<String> interfaces;
	public List<MappedField> fields;
	public List<MappedMethod> methods;
	public List<MappedMethod> constructors;
	// Static fields/methods belonging to this class (ClassName_name)
	public List<MappedField> staticFields;
	public List<MappedMethod> staticMethods;
}
