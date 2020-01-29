import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
@Implements("MusicPatchNode")
public class MusicPatchNode extends Node {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 158121519
	)
	int field2447;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lgr;"
	)
	@Export("patch")
	MusicPatch patch;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lcv;"
	)
	@Export("rawSound")
	RawSound rawSound;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lgf;"
	)
	MusicPatchNode2 field2445;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1663286447
	)
	int field2449;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -816079619
	)
	int field2450;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1312167649
	)
	int field2451;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 109203307
	)
	int field2457;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1309254043
	)
	int field2446;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -83070697
	)
	int field2454;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -280788283
	)
	int field2455;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 1453033600
	)
	int field2456;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1758842307
	)
	int field2448;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1607529919
	)
	int field2458;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1043883777
	)
	int field2459;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1085218982
	)
	int field2460;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 559765115
	)
	int field2461;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 586713195
	)
	int field2453;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lde;"
	)
	@Export("stream")
	RawPcmStream stream;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -923217515
	)
	int field2464;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1975530933
	)
	int field2465;

	MusicPatchNode() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1631381229"
	)
	void method3896() {
		this.patch = null;
		this.rawSound = null;
		this.field2445 = null;
		this.stream = null;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)[Lhx;",
		garbageValue = "-72"
	)
	public static StudioGame[] method3898() {
		return new StudioGame[]{StudioGame.game5, StudioGame.stellardawn, StudioGame.game4, StudioGame.runescape, StudioGame.oldscape, StudioGame.game3};
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "55138406"
	)
	static final int method3903() {
		return ViewportMouse.ViewportMouse_x;
	}

	@ObfuscatedName("ii")
	@ObfuscatedSignature(
		signature = "(IIIIB)V",
		garbageValue = "18"
	)
	@Export("selectSpell")
	static void selectSpell(int var0, int var1, int var2, int var3) {
		Widget var4 = SpriteMask.getWidgetChild(var0, var1);
		if (var4 != null && var4.onTargetEnter != null) {
			ScriptEvent var5 = new ScriptEvent();
			var5.widget = var4;
			var5.args = var4.onTargetEnter;
			class4.runScriptEvent(var5);
		}

		Client.field802 = var3;
		Client.isSpellSelected = true;
		FontName.selectedSpellWidget = var0;
		Client.selectedSpellChildIndex = var1;
		NetSocket.selectedSpellFlags = var2;
		NPCDefinition.invalidateWidget(var4);
	}

	@ObfuscatedName("ji")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-1594747914"
	)
	static boolean method3902(int var0) {
		for (int var1 = 0; var1 < Client.field762; ++var1) {
			if (Client.field869[var1] == var0) {
				return true;
			}
		}

		return false;
	}
}
