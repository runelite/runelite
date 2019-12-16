import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
@Implements("ReflectionCheck")
public class ReflectionCheck extends Node {
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lko;"
	)
	@Export("ItemDefinition_fontPlain11")
	static Font ItemDefinition_fontPlain11;
	@ObfuscatedName("m")
	@Export("userHomeDirectory")
	static String userHomeDirectory;
	@ObfuscatedName("mp")
	@ObfuscatedGetter(
		intValue = -942024519
	)
	@Export("selectedSpellFlags")
	static int selectedSpellFlags;
	@ObfuscatedName("f")
	@Export("intReplaceValues")
	int[] intReplaceValues;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1153531937
	)
	@Export("id")
	int id;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1226139147
	)
	@Export("size")
	int size;
	@ObfuscatedName("w")
	@Export("operations")
	int[] operations;
	@ObfuscatedName("p")
	@Export("creationErrors")
	int[] creationErrors;
	@ObfuscatedName("b")
	@Export("fields")
	Field[] fields;
	@ObfuscatedName("e")
	@Export("methods")
	Method[] methods;
	@ObfuscatedName("x")
	@Export("arguments")
	byte[][][] arguments;

	ReflectionCheck() {
	}
}
