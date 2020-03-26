import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
@Implements("ReflectionCheck")
public class ReflectionCheck extends Node {
	@ObfuscatedName("gi")
	@ObfuscatedSignature(
		signature = "[Lla;"
	)
	@Export("headIconPrayerSprites")
	static Sprite[] headIconPrayerSprites;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1911756689
	)
	@Export("id")
	int id;
	@ObfuscatedName("m")
	@Export("arguments")
	byte[][][] arguments;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -28201163
	)
	@Export("size")
	int size;
	@ObfuscatedName("d")
	@Export("operations")
	int[] operations;
	@ObfuscatedName("w")
	@Export("creationErrors")
	int[] creationErrors;
	@ObfuscatedName("v")
	@Export("fields")
	Field[] fields;
	@ObfuscatedName("q")
	@Export("intReplaceValues")
	int[] intReplaceValues;
	@ObfuscatedName("z")
	@Export("methods")
	Method[] methods;

	ReflectionCheck() {
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "100"
	)
	static void method2396() {
		Login.loginIndex = 24;
		HealthBarUpdate.setLoginResponseString("", "You were disconnected from the server.", "");
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(Ldg;S)V",
		garbageValue = "-25430"
	)
	public static final void method2397(class108 var0) {
		PcmPlayer.pcmPlayerProvider = var0;
	}
}
