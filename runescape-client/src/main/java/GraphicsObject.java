import java.io.IOException;
import java.util.LinkedHashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("GraphicsObject")
public final class GraphicsObject extends Entity {
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = 2069035029
	)
	static int field1141;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1892453991
	)
	@Export("y")
	int y;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -760249917
	)
	@Export("id")
	int id;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1800328217
	)
	@Export("cycleStart")
	int cycleStart;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1899634503
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1416163877
	)
	@Export("x")
	int x;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1568421589
	)
	@Export("height")
	int height;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Ljc;"
	)
	@Export("sequenceDefinition")
	SequenceDefinition sequenceDefinition;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 137908093
	)
	@Export("frame")
	int frame;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1659950887
	)
	@Export("frameCycle")
	int frameCycle;
	@ObfuscatedName("e")
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
		int var8 = MouseHandler.SpotAnimationDefinition_get(this.id).sequence;
		if (var8 != -1) {
			this.isFinished = false;
			this.sequenceDefinition = SpotAnimationDefinition.SequenceDefinition_get(var8);
		} else {
			this.isFinished = true;
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-937691597"
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

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Lel;",
		garbageValue = "480835067"
	)
	@Export("getModel")
	protected final Model getModel() {
		SpotAnimationDefinition var1 = MouseHandler.SpotAnimationDefinition_get(this.id);
		Model var2;
		if (!this.isFinished) {
			var2 = var1.getModel(this.frame);
		} else {
			var2 = var1.getModel(-1);
		}

		return var2 == null ? null : var2;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-22"
	)
	public static void method2121() {
		if (MouseHandler.MouseHandler_instance != null) {
			synchronized(MouseHandler.MouseHandler_instance) {
				MouseHandler.MouseHandler_instance = null;
			}
		}

	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)[B",
		garbageValue = "1774574647"
	)
	public static byte[] method2120() {
		byte[] var0 = new byte[24];

		try {
			JagexCache.JagexCache_randomDat.seek(0L);
			JagexCache.JagexCache_randomDat.readFully(var0);

			int var1;
			for (var1 = 0; var1 < 24 && var0[var1] == 0; ++var1) {
			}

			if (var1 >= 24) {
				throw new IOException();
			}
		} catch (Exception var4) {
			for (int var2 = 0; var2 < 24; ++var2) {
				var0[var2] = -1;
			}
		}

		return var0;
	}

	@ObfuscatedName("ft")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "1004007010"
	)
	static final void method2122(boolean var0) {
		if (var0) {
			Client.field715 = Login.field1214 ? class169.field2007 : class169.field2006;
		} else {
			LinkedHashMap var1 = GrandExchangeOfferOwnWorldComparator.clientPreferences.parameters;
			String var3 = Login.Login_username;
			int var4 = var3.length();
			int var5 = 0;

			for (int var6 = 0; var6 < var4; ++var6) {
				var5 = (var5 << 5) - var5 + var3.charAt(var6);
			}

			Client.field715 = var1.containsKey(var5) ? class169.field2012 : class169.field2008;
		}

	}
}
