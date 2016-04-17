package net.runelite.rs.api;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Import;

public interface ClassInfo
{
	@Import("methods")
	Method[] getMethods();

	@Import("fields")
	Field[] getFields();

	@Import("args")
	byte[][][] getArgs();
}
