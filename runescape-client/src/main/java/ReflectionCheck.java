import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("ReflectionCheck")
public class ReflectionCheck extends Node {
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lhi;"
	)
	static Widget field1310;
	@ObfuscatedName("dc")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive19")
	static Archive archive19;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1464057187
	)
	@Export("id")
	int id;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -828282983
	)
	@Export("size")
	int size;
	@ObfuscatedName("n")
	@Export("operations")
	int[] operations;
	@ObfuscatedName("q")
	@Export("creationErrors")
	int[] creationErrors;
	@ObfuscatedName("v")
	@Export("fields")
	Field[] fields;
	@ObfuscatedName("l")
	@Export("intReplaceValues")
	int[] intReplaceValues;
	@ObfuscatedName("c")
	@Export("methods")
	Method[] methods;
	@ObfuscatedName("o")
	@Export("arguments")
	byte[][][] arguments;

	ReflectionCheck() {
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-2"
	)
	public static void method2438() {
		class197.midiPcmStream.clear();
		class197.field2377 = 1;
		class247.musicTrackArchive = null;
	}

	@ObfuscatedName("jv")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-1720039753"
	)
	@Export("setTapToDrop")
	static void setTapToDrop(boolean var0) {
		Client.tapToDrop = var0;
	}
}
