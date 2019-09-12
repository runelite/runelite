import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
@Implements("MusicPatchNode")
public class MusicPatchNode extends Node {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1620633945
	)
	int field2431;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lgc;"
	)
	@Export("patch")
	MusicPatch patch;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lcg;"
	)
	@Export("rawSound")
	RawSound rawSound;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lgg;"
	)
	MusicPatchNode2 field2415;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 360732481
	)
	int field2426;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1173675801
	)
	int field2413;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -51671167
	)
	int field2417;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1916698407
	)
	int field2418;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1571144209
	)
	int field2419;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1866086819
	)
	int field2420;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -994523657
	)
	int field2433;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 47399593
	)
	int field2414;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 86626141
	)
	int field2423;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 707055873
	)
	int field2424;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -497269847
	)
	int field2425;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1087437009
	)
	int field2416;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 830088765
	)
	int field2427;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 819729093
	)
	int field2428;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lda;"
	)
	@Export("stream")
	RawPcmStream stream;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -2114516523
	)
	int field2430;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -98902085
	)
	int field2422;

	MusicPatchNode() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1763442476"
	)
	void method3810() {
		this.patch = null;
		this.rawSound = null;
		this.field2415 = null;
		this.stream = null;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "1"
	)
	static final int method3811(int var0, int var1) {
		int var2 = SoundCache.method2467(var0 + 45365, 91923 + var1, 4) - 128 + (SoundCache.method2467(10294 + var0, 37821 + var1, 2) - 128 >> 1) + (SoundCache.method2467(var0, var1, 1) - 128 >> 2);
		var2 = (int)((double)var2 * 0.3D) + 35;
		if (var2 < 10) {
			var2 = 10;
		} else if (var2 > 60) {
			var2 = 60;
		}

		return var2;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-640083852"
	)
	static final int method3812(int var0, int var1) {
		if (var0 == -1) {
			return 12345678;
		} else {
			var1 = (var0 & 127) * var1 / 128;
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return (var0 & 65408) + var1;
		}
	}

	@ObfuscatedName("fv")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1280184446"
	)
	@Export("setWindowedMode")
	static void setWindowedMode(int var0) {
		Client.field835 = 0L;
		if (var0 >= 2) {
			Client.isResizable = true;
		} else {
			Client.isResizable = false;
		}

		if (class43.getWindowedMode() == 1) {
			Coord.client.setMaxCanvasSize(765, 503);
		} else {
			Coord.client.setMaxCanvasSize(7680, 2160);
		}

		if (Client.gameState >= 25) {
			MouseRecorder.method1145();
		}

	}
}
