import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
	@ObfuscatedName("km")
	@ObfuscatedGetter(
		intValue = -2032356267
	)
	@Export("Client_plane")
	static int Client_plane;
	@ObfuscatedName("x")
	@Export("args")
	Object[] args;
	@ObfuscatedName("m")
	@Export("isMouseInputEvent")
	boolean isMouseInputEvent;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lhe;"
	)
	@Export("widget")
	Widget widget;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 662449011
	)
	@Export("mouseX")
	int mouseX;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1491668133
	)
	@Export("mouseY")
	int mouseY;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -44479267
	)
	@Export("opIndex")
	int opIndex;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lhe;"
	)
	@Export("dragTarget")
	Widget dragTarget;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 128989033
	)
	@Export("keyTyped")
	int keyTyped;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1018201725
	)
	@Export("keyPressed")
	int keyPressed;
	@ObfuscatedName("e")
	@Export("targetName")
	String targetName;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 171881153
	)
	int field604;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -893996953
	)
	@Export("type")
	int type;

	public ScriptEvent() {
		this.type = 76;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "([Ljava/lang/Object;I)V",
		garbageValue = "-1877597946"
	)
	@Export("setArgs")
	public void setArgs(Object[] var1) {
		this.args = var1;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "77"
	)
	@Export("setType")
	public void setType(int var1) {
		this.type = var1;
	}

	@ObfuscatedName("kv")
	@ObfuscatedSignature(
		signature = "(IIIILla;Lhg;B)V",
		garbageValue = "-20"
	)
	@Export("drawSpriteOnMinimap")
	static final void drawSpriteOnMinimap(int var0, int var1, int var2, int var3, Sprite var4, SpriteMask var5) {
		if (var4 != null) {
			int var6 = Client.camAngleY & 2047;
			int var7 = var3 * var3 + var2 * var2;
			if (var7 <= 6400) {
				int var8 = Rasterizer3D.Rasterizer3D_sine[var6];
				int var9 = Rasterizer3D.Rasterizer3D_cosine[var6];
				int var10 = var9 * var2 + var3 * var8 >> 16;
				int var11 = var3 * var9 - var8 * var2 >> 16;
				if (var7 > 2500) {
					var4.method6240(var10 + var5.width / 2 - var4.width / 2, var5.height / 2 - var11 - var4.height / 2, var0, var1, var5.width, var5.height, var5.xStarts, var5.xWidths);
				} else {
					var4.drawTransBgAt(var0 + var10 + var5.width / 2 - var4.width / 2, var5.height / 2 + var1 - var11 - var4.height / 2);
				}

			}
		}
	}

	@ObfuscatedName("kc")
	@ObfuscatedSignature(
		signature = "(Lhe;I)I",
		garbageValue = "-1130493417"
	)
	@Export("getWidgetClickMask")
	static int getWidgetClickMask(Widget var0) {
		IntegerNode var1 = (IntegerNode)Client.widgetClickMasks.get((long)var0.childIndex + ((long)var0.id << 32));
		return var1 != null ? var1.integer : var0.clickMask;
	}
}
