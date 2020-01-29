import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jp")
@Implements("Ignored")
public class Ignored extends User {
	@ObfuscatedName("gg")
	@ObfuscatedSignature(
		signature = "[Llt;"
	)
	@Export("headIconPkSprites")
	static Sprite[] headIconPkSprites;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1391988611
	)
	@Export("id")
	int id;

	Ignored() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljp;I)I",
		garbageValue = "-2090061914"
	)
	@Export("compareTo_ignored")
	int compareTo_ignored(Ignored var1) {
		return this.id - var1.id;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(Ljk;I)I",
		garbageValue = "-746331144"
	)
	@Export("compareTo_user")
	public int compareTo_user(User var1) {
		return this.compareTo_ignored((Ignored)var1);
	}

	public int compareTo(Object var1) {
		return this.compareTo_ignored((Ignored)var1);
	}

	@ObfuscatedName("ho")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "5"
	)
	static final void method5213(int var0, int var1) {
		if (Client.menuOptionsCount >= 2 || Client.isItemSelected != 0 || Client.isSpellSelected) {
			if (Client.showMouseOverText) {
				int var2 = Client.menuOptionsCount - 1;
				String var4;
				if (Client.isItemSelected == 1 && Client.menuOptionsCount < 2) {
					var4 = "Use" + " " + Client.selectedItemName + " " + "->";
				} else if (Client.isSpellSelected && Client.menuOptionsCount < 2) {
					var4 = Client.selectedSpellActionName + " " + Client.selectedSpellName + " " + "->";
				} else {
					var4 = VerticalAlignment.method4426(var2);
				}

				if (Client.menuOptionsCount > 2) {
					var4 = var4 + PacketWriter.colorStartTag(16777215) + " " + '/' + " " + (Client.menuOptionsCount - 2) + " more options";
				}

				class1.fontBold12.drawRandomAlphaAndSpacing(var4, var0 + 4, var1 + 15, 16777215, 0, Client.cycle / 1000);
			}
		}
	}
}
