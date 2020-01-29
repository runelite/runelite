import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
@Implements("Canvas")
public final class Canvas extends java.awt.Canvas {
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("SequenceDefinition_animationsArchive")
	static AbstractArchive SequenceDefinition_animationsArchive;
	@ObfuscatedName("c")
	@Export("component")
	Component component;

	Canvas(Component var1) {
		this.component = var1;
	}

	public final void paint(Graphics var1) {
		this.component.paint(var1);
	}

	public final void update(Graphics var1) {
		this.component.update(var1);
	}

	@ObfuscatedName("fq")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-97"
	)
	static final void method861() {
		if (FileSystem.ClanChat_inClanChat) {
			if (InterfaceParent.clanChat != null) {
				InterfaceParent.clanChat.sort();
			}

			DefaultsGroup.method5953();
			FileSystem.ClanChat_inClanChat = false;
		}

	}

	@ObfuscatedName("hf")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "-77"
	)
	static int method864(int var0, int var1) {
		int var2 = var1 - 334;
		if (var2 < 0) {
			var2 = 0;
		} else if (var2 > 100) {
			var2 = 100;
		}

		int var3 = (Client.zoomWidth - Client.zoomHeight) * var2 / 100 + Client.zoomHeight;
		return var0 * var3 / 256;
	}
}
