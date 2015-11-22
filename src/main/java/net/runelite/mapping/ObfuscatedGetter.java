package net.runelite.mapping;

public @interface ObfuscatedGetter
{
	int intValue() default 0;
	
	long longValue() default 0L;
}
