package net.runelite.rs.api;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public interface ClassInfo
{
	Method getMethods();

	Field getFields();

	byte[][][] getArgs();
}
