import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("r")
public class class16 {
	@ObfuscatedName("hi")
	@ObfuscatedGetter(
		intValue = -71438851
	)
	@Export("cameraY")
	static int cameraY;

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(ILcj;ZI)I",
		garbageValue = "2052755977"
	)
	static int method224(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.SOUND_SYNTH) {
			Interpreter.Interpreter_intStackSize -= 3;
			class185.queueSoundEffect(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2]);
			return 1;
		} else if (var0 == ScriptOpcodes.SOUND_SONG) {
			AbstractWorldMapIcon.playSong(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
			return 1;
		} else if (var0 == ScriptOpcodes.SOUND_JINGLE) {
			Interpreter.Interpreter_intStackSize -= 2;
			WorldMapEvent.playSoundJingle(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("iw")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "1"
	)
	@Export("getNewestMenuIdx")
	static final int getNewestMenuIdx() {
		return Client.menuOptionsCount - 1;
	}
}
