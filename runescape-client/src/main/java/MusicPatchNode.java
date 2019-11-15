import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
@Implements("MusicPatchNode")
public class MusicPatchNode extends Node {
	@ObfuscatedName("kl")
	@ObfuscatedGetter(
		intValue = -1634536661
	)
	@Export("menuX")
	static int menuX;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 830928495
	)
	int field2425;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lgz;"
	)
	@Export("patch")
	MusicPatch patch;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lca;"
	)
	@Export("rawSound")
	RawSound rawSound;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lgp;"
	)
	MusicPatchNode2 field2417;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1191451859
	)
	int field2422;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 157095745
	)
	int field2419;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1068242143
	)
	int field2430;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 747760665
	)
	int field2421;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 2032697643
	)
	int field2416;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 910822609
	)
	int field2423;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -233419885
	)
	int field2424;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1986379776
	)
	int field2420;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1890707239
	)
	int field2431;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1386699845
	)
	int field2427;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1121905843
	)
	int field2428;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 40924709
	)
	int field2429;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -141158297
	)
	int field2426;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -964518569
	)
	int field2414;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lds;"
	)
	@Export("stream")
	RawPcmStream stream;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -312260617
	)
	int field2433;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -2047299569
	)
	int field2434;

	MusicPatchNode() {
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1779627042"
	)
	void method3974() {
		this.patch = null;
		this.rawSound = null;
		this.field2417 = null;
		this.stream = null;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "428887942"
	)
	public static void method3973() {
		WorldMapElement.WorldMapElement_cachedSprites.clear();
	}
}
