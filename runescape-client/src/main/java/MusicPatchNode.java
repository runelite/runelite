import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
@Implements("MusicPatchNode")
public class MusicPatchNode extends Node {
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1668563715
	)
	int field2444;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lgp;"
	)
	@Export("patch")
	MusicPatch patch;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lcc;"
	)
	@Export("rawSound")
	RawSound rawSound;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lgt;"
	)
	MusicPatchNode2 field2430;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1764102469
	)
	int field2436;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1904799079
	)
	int field2432;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -520754743
	)
	int field2433;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 2093202959
	)
	int field2442;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -583711797
	)
	int field2435;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1078533747
	)
	int field2434;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1604483671
	)
	int field2437;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 850603648
	)
	int field2446;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -2031818959
	)
	int field2439;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -2089703245
	)
	int field2440;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1525536893
	)
	int field2441;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 2143994261
	)
	int field2438;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1974206537
	)
	int field2443;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1464754039
	)
	int field2427;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Ldg;"
	)
	@Export("stream")
	RawPcmStream stream;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -322620881
	)
	int field2431;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -966369817
	)
	int field2447;

	MusicPatchNode() {
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "300"
	)
	void method3809() {
		this.patch = null;
		this.rawSound = null;
		this.field2430 = null;
		this.stream = null;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(II)Lid;",
		garbageValue = "1715328596"
	)
	public static HitSplatDefinition method3815(int var0) {
		HitSplatDefinition var1 = (HitSplatDefinition)HitSplatDefinition.HitSplatDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = HitSplatDefinition.HitSplatDefinition_archive.takeFile(32, var0);
			var1 = new HitSplatDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			HitSplatDefinition.HitSplatDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "512753699"
	)
	public static int method3814() {
		return KeyHandler.KeyHandler_idleCycles;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Ldw;IIIS)Z",
		garbageValue = "-6878"
	)
	static final boolean method3813(Model var0, int var1, int var2, int var3) {
		boolean var4 = ViewportMouse.ViewportMouse_isInViewport;
		if (!var4) {
			return false;
		} else {
			WorldMapEvent.method764();
			int var5 = var0.xMid + var1;
			int var6 = var2 + var0.yMid;
			int var7 = var3 + var0.zMid;
			int var8 = var0.xMidOffset;
			int var9 = var0.yMidOffset;
			int var10 = var0.zMidOffset;
			int var11 = ViewportMouse.field1717 - var5;
			int var12 = class30.field245 - var6;
			int var13 = ViewportMouse.field1718 - var7;
			if (Math.abs(var11) > var8 + ViewportMouse.field1720) {
				return false;
			} else if (Math.abs(var12) > var9 + class247.field3261) {
				return false;
			} else if (Math.abs(var13) > var10 + MusicPatch.field2472) {
				return false;
			} else if (Math.abs(var13 * WorldMapCacheName.field293 - var12 * class40.field336) > var9 * MusicPatch.field2472 + var10 * class247.field3261) {
				return false;
			} else if (Math.abs(var11 * class40.field336 - var13 * ViewportMouse.field1719) > var8 * MusicPatch.field2472 + var10 * ViewportMouse.field1720) {
				return false;
			} else {
				return Math.abs(var12 * ViewportMouse.field1719 - var11 * WorldMapCacheName.field293) <= var8 * class247.field3261 + var9 * ViewportMouse.field1720;
			}
		}
	}
}
