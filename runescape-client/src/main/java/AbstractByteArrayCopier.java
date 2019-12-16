import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("gu")
@Implements("AbstractByteArrayCopier")
public abstract class AbstractByteArrayCopier {
	AbstractByteArrayCopier() {
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)[B",
		garbageValue = "-112018699"
	)
	@Export("get")
	public abstract byte[] get();

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "([BB)V",
		garbageValue = "33"
	)
	@Export("set")
	public abstract void set(byte[] var1);

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(ILcu;ZB)I",
		garbageValue = "-27"
	)
	static int method3937(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.SOUND_SYNTH) {
			class188.Interpreter_intStackSize -= 3;
			class268.queueSoundEffect(Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1], Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 2]);
			return 1;
		} else if (var0 == ScriptOpcodes.SOUND_SONG) {
			WorldMapSprite.playSong(Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize]);
			return 1;
		} else if (var0 == ScriptOpcodes.SOUND_JINGLE) {
			class188.Interpreter_intStackSize -= 2;
			ScriptFrame.playSoundJingle(Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1]);
			return 1;
		} else {
			return 2;
		}
	}
}
