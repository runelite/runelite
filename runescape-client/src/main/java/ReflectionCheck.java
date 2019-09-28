import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("cq")
@Implements("ReflectionCheck")
public class ReflectionCheck extends Node {
	@ObfuscatedName("sf")
	@ObfuscatedGetter(
		intValue = 1327402685
	)
	@Export("foundItemIndex")
	static int foundItemIndex;
	@ObfuscatedName("gp")
	@ObfuscatedSignature(
		signature = "[Llf;"
	)
	@Export("headIconHintSprites")
	static Sprite[] headIconHintSprites;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 85422493
	)
	@Export("id")
	int id;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 198207431
	)
	@Export("size")
	int size;
	@ObfuscatedName("v")
	@Export("operations")
	int[] operations;
	@ObfuscatedName("u")
	@Export("creationErrors")
	int[] creationErrors;
	@ObfuscatedName("r")
	@Export("fields")
	Field[] fields;
	@ObfuscatedName("p")
	@Export("intReplaceValues")
	int[] intReplaceValues;
	@ObfuscatedName("q")
	@Export("methods")
	Method[] methods;
	@ObfuscatedName("m")
	@Export("arguments")
	byte[][][] arguments;

	ReflectionCheck() {
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "-884073904"
	)
	static int method2271(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.SOUND_SYNTH) {
			Interpreter.Interpreter_intStackSize -= 3;
			Message.queueSoundEffect(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2]);
			return 1;
		} else if (var0 == ScriptOpcodes.SOUND_SONG) {
			MusicPatchNode2.playSong(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
			return 1;
		} else if (var0 == ScriptOpcodes.SOUND_JINGLE) {
			Interpreter.Interpreter_intStackSize -= 2;
			ClientPacket.playSoundJingle(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
			return 1;
		} else {
			return 2;
		}
	}
}
