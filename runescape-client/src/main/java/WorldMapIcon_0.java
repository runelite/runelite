import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
@Implements("WorldMapIcon_0")
public class WorldMapIcon_0 extends AbstractWorldMapIcon {
	@ObfuscatedName("t")
	public static String field131;
	@ObfuscatedName("eh")
	@ObfuscatedGetter(
		intValue = 720171421
	)
	@Export("port3")
	static int port3;
	@ObfuscatedName("gx")
	@Export("xteaKeys")
	static int[][] xteaKeys;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1743201389
	)
	@Export("element")
	final int element;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lam;"
	)
	@Export("label")
	final WorldMapLabel label;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1823460023
	)
	@Export("subWidth")
	final int subWidth;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1703496191
	)
	@Export("subHeight")
	final int subHeight;

	@ObfuscatedSignature(
		signature = "(Lhx;Lhx;ILam;)V"
	)
	WorldMapIcon_0(Coord var1, Coord var2, int var3, WorldMapLabel var4) {
		super(var1, var2);
		this.element = var3;
		this.label = var4;
		WorldMapElement var5 = Varcs.WorldMapElement_get(this.getElement());
		Sprite var6 = var5.getSpriteBool(false);
		if (var6 != null) {
			this.subWidth = var6.subWidth;
			this.subHeight = var6.subHeight;
		} else {
			this.subWidth = 0;
			this.subHeight = 0;
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-871583687"
	)
	@Export("getElement")
	public int getElement() {
		return this.element;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)Lam;",
		garbageValue = "969160497"
	)
	@Export("getLabel")
	WorldMapLabel getLabel() {
		return this.label;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-55298135"
	)
	@Export("getSubWidth")
	int getSubWidth() {
		return this.subWidth;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-51"
	)
	@Export("getSubHeight")
	int getSubHeight() {
		return this.subHeight;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lij;II)V",
		garbageValue = "1850991099"
	)
	static void method224(Archive var0, int var1) {
		if (class83.NetCache_reference != null) {
			class83.NetCache_reference.offset = var1 * 8 + 5;
			int var2 = class83.NetCache_reference.readInt();
			int var3 = class83.NetCache_reference.readInt();
			var0.loadIndex(var2, var3);
		} else {
			ClientPreferences.requestNetFile((Archive)null, 255, 255, 0, (byte)0, true);
			NetCache.NetCache_archives[var1] = var0;
		}
	}

	@ObfuscatedName("jr")
	@ObfuscatedSignature(
		signature = "([Lhl;IB)V",
		garbageValue = "0"
	)
	@Export("runComponentCloseListeners")
	static final void runComponentCloseListeners(Widget[] var0, int var1) {
		for (int var2 = 0; var2 < var0.length; ++var2) {
			Widget var3 = var0[var2];
			if (var3 != null) {
				if (var3.type == 0) {
					if (var3.children != null) {
						runComponentCloseListeners(var3.children, var1);
					}

					InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var3.id);
					if (var4 != null) {
						GrandExchangeEvents.runIntfCloseListeners(var4.group, var1);
					}
				}

				ScriptEvent var5;
				if (var1 == 0 && var3.onDialogAbort != null) {
					var5 = new ScriptEvent();
					var5.widget = var3;
					var5.args = var3.onDialogAbort;
					WorldMapLabel.runScriptEvent(var5);
				}

				if (var1 == 1 && var3.onSubChange != null) {
					if (var3.childIndex >= 0) {
						Widget var6 = Language.getWidget(var3.id);
						if (var6 == null || var6.children == null || var3.childIndex >= var6.children.length || var3 != var6.children[var3.childIndex]) {
							continue;
						}
					}

					var5 = new ScriptEvent();
					var5.widget = var3;
					var5.args = var3.onSubChange;
					WorldMapLabel.runScriptEvent(var5);
				}
			}
		}

	}

	@ObfuscatedName("kw")
	@ObfuscatedSignature(
		signature = "(IIIILln;Lhn;B)V",
		garbageValue = "-95"
	)
	@Export("worldToMinimap")
	static final void worldToMinimap(int var0, int var1, int var2, int var3, Sprite var4, SpriteMask var5) {
		int var6 = var3 * var3 + var2 * var2;
		if (var6 > 4225 && var6 < 90000) {
			int var7 = Client.camAngleY & 2047;
			int var8 = Rasterizer3D.Rasterizer3D_sine[var7];
			int var9 = Rasterizer3D.Rasterizer3D_cosine[var7];
			int var10 = var9 * var2 + var3 * var8 >> 16;
			int var11 = var3 * var9 - var8 * var2 >> 16;
			double var12 = Math.atan2((double)var10, (double)var11);
			int var14 = var5.width / 2 - 25;
			int var15 = (int)(Math.sin(var12) * (double)var14);
			int var16 = (int)(Math.cos(var12) * (double)var14);
			byte var17 = 20;
			class225.redHintArrowSprite.method6200(var15 + (var0 + var5.width / 2 - var17 / 2), var5.height / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
		} else {
			class185.drawSpriteOnMinimap(var0, var1, var2, var3, var4, var5);
		}

	}
}
