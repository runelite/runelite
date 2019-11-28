import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
	@ObfuscatedName("u")
	@Export("args")
	Object[] args;
	@ObfuscatedName("f")
	@Export("isMouseInputEvent")
	boolean isMouseInputEvent;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lhl;"
	)
	@Export("widget")
	Widget widget;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1134113153
	)
	@Export("mouseX")
	int mouseX;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1207275519
	)
	@Export("mouseY")
	int mouseY;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1547508789
	)
	@Export("opIndex")
	int opIndex;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lhl;"
	)
	@Export("dragTarget")
	Widget dragTarget;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 74638955
	)
	@Export("keyTyped")
	int keyTyped;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1612924995
	)
	@Export("keyPressed")
	int keyPressed;
	@ObfuscatedName("i")
	@Export("targetName")
	String targetName;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -618805579
	)
	int field577;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 684866193
	)
	@Export("type")
	int type;

	public ScriptEvent() {
		this.type = 76;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "([Ljava/lang/Object;I)V",
		garbageValue = "1989616138"
	)
	@Export("setArgs")
	public void setArgs(Object[] var1) {
		this.args = var1;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1172076159"
	)
	@Export("setType")
	public void setType(int var1) {
		this.type = var1;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1502841158"
	)
	public static void method1198() {
		try {
			if (class197.field2411 == 1) {
				int var0 = FaceNormal.midiPcmStream.method3769();
				if (var0 > 0 && FaceNormal.midiPcmStream.isReady()) {
					var0 -= class335.field4014;
					if (var0 < 0) {
						var0 = 0;
					}

					FaceNormal.midiPcmStream.setPcmStreamVolume(var0);
					return;
				}

				FaceNormal.midiPcmStream.clear();
				FaceNormal.midiPcmStream.removeAll();
				if (class197.musicTrackArchive != null) {
					class197.field2411 = 2;
				} else {
					class197.field2411 = 0;
				}

				WorldMapSprite.musicTrack = null;
				NPC.soundCache = null;
			}
		} catch (Exception var2) {
			var2.printStackTrace();
			FaceNormal.midiPcmStream.clear();
			class197.field2411 = 0;
			WorldMapSprite.musicTrack = null;
			NPC.soundCache = null;
			class197.musicTrackArchive = null;
		}

	}

	@ObfuscatedName("ji")
	@ObfuscatedSignature(
		signature = "(Lhl;B)V",
		garbageValue = "-95"
	)
	@Export("invalidateWidget")
	static void invalidateWidget(Widget var0) {
		if (var0.cycle == Client.field690) {
			Client.field847[var0.rootIndex] = true;
		}

	}
}
