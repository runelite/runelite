import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
	@ObfuscatedName("fh")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	@Export("urlRequester")
	static UrlRequester urlRequester;
	@ObfuscatedName("hv")
	@ObfuscatedGetter(
		intValue = 966526807
	)
	static int field559;
	@ObfuscatedName("s")
	@Export("args")
	Object[] args;
	@ObfuscatedName("j")
	@Export("isMouseInputEvent")
	boolean isMouseInputEvent;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("widget")
	Widget widget;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1722758415
	)
	@Export("mouseX")
	int mouseX;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1522847743
	)
	@Export("mouseY")
	int mouseY;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 494348445
	)
	@Export("opIndex")
	int opIndex;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("dragTarget")
	Widget dragTarget;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 329318747
	)
	@Export("keyTyped")
	int keyTyped;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1953283421
	)
	@Export("keyPressed")
	int keyPressed;
	@ObfuscatedName("d")
	@Export("targetName")
	String targetName;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1233738225
	)
	int field555;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -998343503
	)
	@Export("type")
	int type;

	public ScriptEvent() {
		this.type = 76;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "([Ljava/lang/Object;I)V",
		garbageValue = "136665190"
	)
	@Export("setArgs")
	public void setArgs(Object[] var1) {
		this.args = var1;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "0"
	)
	@Export("setType")
	public void setType(int var1) {
		this.type = var1;
	}
}
