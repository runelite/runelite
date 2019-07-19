package net.runelite.deob.deobfuscators.mapping.mappingdumper;

import com.google.gson.annotations.SerializedName;

public class MappedField
{
	@SerializedName("field")
	public String exportedName;
	public String owner;
	@SerializedName("name")
	public String obfuscatedName;
	public int access;
	public String descriptor;
	public Long decoder;
}
