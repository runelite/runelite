import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bc")
@Implements("GraphicsObject")
public final class GraphicsObject extends Entity {
	@ObfuscatedName("qe")
	@ObfuscatedGetter(
		intValue = -487309312
	)
	static int field1079;
	@ObfuscatedName("gx")
	@Export("regionLandArchives")
	static byte[][] regionLandArchives;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -609520515
	)
	@Export("id")
	int id;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 528073861
	)
	@Export("cycleStart")
	int cycleStart;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1305204903
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1986692437
	)
	@Export("x")
	int x;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 575337647
	)
	@Export("y")
	int y;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -893117639
	)
	@Export("height")
	int height;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("sequenceDefinition")
	SequenceDefinition sequenceDefinition;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1568571077
	)
	@Export("frame")
	int frame;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1439045539
	)
	@Export("frameCycle")
	int frameCycle;
	@ObfuscatedName("d")
	@Export("isFinished")
	boolean isFinished;

	GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		this.frame = 0;
		this.frameCycle = 0;
		this.isFinished = false;
		this.id = var1;
		this.plane = var2;
		this.x = var3;
		this.y = var4;
		this.height = var5;
		this.cycleStart = var7 + var6;
		int var8 = HealthBarUpdate.SpotAnimationDefinition_get(this.id).sequence;
		if (var8 != -1) {
			this.isFinished = false;
			this.sequenceDefinition = Widget.SequenceDefinition_get(var8);
		} else {
			this.isFinished = true;
		}

	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IS)V",
		garbageValue = "-9690"
	)
	@Export("advance")
	final void advance(int var1) {
		if (!this.isFinished) {
			this.frameCycle += var1;

			while (this.frameCycle > this.sequenceDefinition.frameLengths[this.frame]) {
				this.frameCycle -= this.sequenceDefinition.frameLengths[this.frame];
				++this.frame;
				if (this.frame >= this.sequenceDefinition.frameIds.length) {
					this.isFinished = true;
					break;
				}
			}

		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Ldo;",
		garbageValue = "-419920513"
	)
	@Export("getModel")
	protected final Model getModel() {
		SpotAnimationDefinition var1 = HealthBarUpdate.SpotAnimationDefinition_get(this.id);
		Model var2;
		if (!this.isFinished) {
			var2 = var1.getModel(this.frame);
		} else {
			var2 = var1.getModel(-1);
		}

		return var2 == null ? null : var2;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "971415890"
	)
	public static boolean method1946(int var0) {
		return var0 == WorldMapDecorationType.field2722.id;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "85520367"
	)
	@Export("hasReflectionCheck")
	public static boolean hasReflectionCheck() {
		ReflectionCheck var0 = (ReflectionCheck)class96.reflectionChecks.last();
		return var0 != null;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(ILcr;ZI)I",
		garbageValue = "886521701"
	)
	static int method1939(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? class286.field3623 : class297.field3693;
		if (var0 == ScriptOpcodes.CC_GETINVOBJECT) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.itemId;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETINVCOUNT) {
			if (var3.itemId != -1) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.itemQuantity;
			} else {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETID) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.childIndex;
			return 1;
		} else {
			return 2;
		}
	}
}
