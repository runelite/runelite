import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
@Implements("ObjectSound")
public final class ObjectSound extends Node {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Ljw;"
	)
	@Export("objectSounds")
	static NodeDeque objectSounds;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1573103385
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1434930617
	)
	@Export("x")
	int x;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1295537280
	)
	@Export("y")
	int y;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 393514941
	)
	int field1069;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -840891776
	)
	int field1080;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 210061871
	)
	int field1070;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 2754531
	)
	@Export("soundEffectId")
	int soundEffectId;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lde;"
	)
	@Export("stream1")
	RawPcmStream stream1;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1469470179
	)
	int field1074;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1106113547
	)
	int field1075;
	@ObfuscatedName("h")
	@Export("soundEffectIds")
	int[] soundEffectIds;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -52141537
	)
	int field1077;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lde;"
	)
	@Export("stream2")
	RawPcmStream stream2;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lir;"
	)
	@Export("obj")
	ObjectDefinition obj;

	static {
		objectSounds = new NodeDeque();
	}

	ObjectSound() {
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-280548434"
	)
	@Export("set")
	void set() {
		int var1 = this.soundEffectId;
		ObjectDefinition var2 = this.obj.transform();
		if (var2 != null) {
			this.soundEffectId = var2.ambientSoundId;
			this.field1070 = var2.int4 * 128;
			this.field1074 = var2.int5;
			this.field1075 = var2.int6;
			this.soundEffectIds = var2.soundEffectIds;
		} else {
			this.soundEffectId = -1;
			this.field1070 = 0;
			this.field1074 = 0;
			this.field1075 = 0;
			this.soundEffectIds = null;
		}

		if (var1 != this.soundEffectId && this.stream1 != null) {
			class2.pcmStreamMixer.removeSubStream(this.stream1);
			this.stream1 = null;
		}

	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIILir;II)V",
		garbageValue = "1319023386"
	)
	static void method1931(int var0, int var1, int var2, ObjectDefinition var3, int var4) {
		ObjectSound var5 = new ObjectSound();
		var5.plane = var0;
		var5.x = var1 * 128;
		var5.y = var2 * 16384;
		int var6 = var3.sizeX;
		int var7 = var3.sizeY;
		if (var4 == 1 || var4 == 3) {
			var6 = var3.sizeY;
			var7 = var3.sizeX;
		}

		var5.field1069 = (var6 + var1) * 128;
		var5.field1080 = (var7 + var2) * 16384;
		var5.soundEffectId = var3.ambientSoundId;
		var5.field1070 = var3.int4 * 128;
		var5.field1074 = var3.int5;
		var5.field1075 = var3.int6;
		var5.soundEffectIds = var3.soundEffectIds;
		if (var3.transforms != null) {
			var5.obj = var3;
			var5.set();
		}

		objectSounds.addFirst(var5);
		if (var5.soundEffectIds != null) {
			var5.field1077 = var5.field1074 + (int)(Math.random() * (double)(var5.field1075 - var5.field1074));
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "1"
	)
	public static void method1933(int var0) {
		if (var0 != -1) {
			if (class197.Widget_loadedInterfaces[var0]) {
				class197.Widget_archive.clearFilesGroup(var0);
				if (WorldMapLabel.Widget_interfaceComponents[var0] != null) {
					boolean var1 = true;

					for (int var2 = 0; var2 < WorldMapLabel.Widget_interfaceComponents[var0].length; ++var2) {
						if (WorldMapLabel.Widget_interfaceComponents[var0][var2] != null) {
							if (WorldMapLabel.Widget_interfaceComponents[var0][var2].type != 2) {
								WorldMapLabel.Widget_interfaceComponents[var0][var2] = null;
							} else {
								var1 = false;
							}
						}
					}

					if (var1) {
						WorldMapLabel.Widget_interfaceComponents[var0] = null;
					}

					class197.Widget_loadedInterfaces[var0] = false;
				}
			}
		}
	}

	@ObfuscatedName("jv")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-1074092886"
	)
	@Export("setTapToDrop")
	static void setTapToDrop(boolean var0) {
		Client.tapToDrop = var0;
	}

	@ObfuscatedName("lh")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "1"
	)
	static void method1934() {
		if (class218.field2716 != null) {
			Client.field888 = Client.cycle;
			class218.field2716.method4395();

			for (int var0 = 0; var0 < Client.players.length; ++var0) {
				if (Client.players[var0] != null) {
					class218.field2716.method4408(Messages.baseX * 64 + (Client.players[var0].x >> 7), Language.baseY * 64 + (Client.players[var0].y >> 7));
				}
			}
		}

	}
}
