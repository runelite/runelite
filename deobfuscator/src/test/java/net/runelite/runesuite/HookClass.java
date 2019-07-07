package net.runelite.runesuite;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class HookClass
{
	@SerializedName("class")
	String clazz;
	String name;
	List<HookField> fields;
	List<HookMethod> methods;
}
