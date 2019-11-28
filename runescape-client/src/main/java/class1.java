import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
final class class1 implements class0 {
	@ObfuscatedName("ix")
	@ObfuscatedGetter(
		intValue = -609036975
	)
	@Export("selectedItemWidget")
	static int selectedItemWidget;

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lkg;I)V",
		garbageValue = "-1331780546"
	)
	public void vmethod57(Object var1, Buffer var2) {
		this.method7((Integer)var1, var2);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lkg;I)Ljava/lang/Object;",
		garbageValue = "1713449680"
	)
	public Object vmethod65(Buffer var1) {
		return var1.readInt();
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Integer;Lkg;I)V",
		garbageValue = "-1969898467"
	)
	void method7(Integer var1, Buffer var2) {
		var2.writeInt(var1);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)Lbp;",
		garbageValue = "1259947083"
	)
	@Export("getNextWorldListWorld")
	static World getNextWorldListWorld() {
		return World.World_listCount < World.World_count ? Skills.World_worlds[++World.World_listCount - 1] : null;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(Ldt;B)V",
		garbageValue = "104"
	)
	@Export("PcmStream_disable")
	static final void PcmStream_disable(PcmStream var0) {
		var0.active = false;
		if (var0.sound != null) {
			var0.sound.position = 0;
		}

		for (PcmStream var1 = var0.firstSubStream(); var1 != null; var1 = var0.nextSubStream()) {
			PcmStream_disable(var1);
		}

	}

	@ObfuscatedName("ev")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1824721053"
	)
	static final void method15() {
		Scene.Scene_isLowDetail = false;
		Client.isLowDetail = false;
	}

	@ObfuscatedName("gz")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "1"
	)
	static boolean method16() {
		return (Client.drawPlayerNames & 1) != 0;
	}
}
