package net.runelite.deob.deobfuscators.mapping.mappingdumper;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class MappedMethod
{
	@SerializedName("method")
	public String exportedName;
	public String owner;
	@SerializedName("name")
	public String obfuscatedName;
	public int access;
	public List<String> parameters;
	public String descriptor;
	public Long garbageValue;
}
