import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
@Implements("AbstractWorldMapIcon")
public abstract class AbstractWorldMapIcon {
	@ObfuscatedName("sq")
	@ObfuscatedGetter(
		intValue = -1106675929
	)
	@Export("foundItemIndex")
	static int foundItemIndex;
	@ObfuscatedName("dx")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	@Export("archive6")
	static Archive archive6;
	@ObfuscatedName("dy")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	@Export("archive7")
	static Archive archive7;
	@ObfuscatedName("fp")
	@ObfuscatedSignature(
		signature = "Lfr;"
	)
	@Export("socketTask")
	static Task socketTask;
	@ObfuscatedName("la")
	@ObfuscatedSignature(
		signature = "Lci;"
	)
	@Export("tempMenuAction")
	static MenuAction tempMenuAction;
	@ObfuscatedName("my")
	@ObfuscatedGetter(
		intValue = 468589673
	)
	@Export("selectedSpellFlags")
	static int selectedSpellFlags;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("coord2")
	public final Coord coord2;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("coord1")
	public final Coord coord1;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1506769643
	)
	@Export("screenX")
	int screenX;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -896182235
	)
	@Export("screenY")
	int screenY;

	@ObfuscatedSignature(
		signature = "(Lhj;Lhj;)V"
	)
	AbstractWorldMapIcon(Coord var1, Coord var2) {
		this.coord1 = var1;
		this.coord2 = var2;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "16"
	)
	@Export("getElement")
	public abstract int getElement();

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)Lau;",
		garbageValue = "2077771117"
	)
	@Export("getLabel")
	abstract WorldMapLabel getLabel();

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "650401890"
	)
	@Export("getSubWidth")
	abstract int getSubWidth();

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1828864081"
	)
	@Export("getSubHeight")
	abstract int getSubHeight();

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-57056512"
	)
	@Export("fitsScreen")
	boolean fitsScreen(int var1, int var2) {
		if (this.elementFitsScreen(var1, var2)) {
			return true;
		} else {
			return this.labelFitsScreen(var1, var2);
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(S)Z",
		garbageValue = "-32437"
	)
	@Export("hasValidElement")
	boolean hasValidElement() {
		return this.getElement() >= 0;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "1127928990"
	)
	@Export("elementFitsScreen")
	boolean elementFitsScreen(int var1, int var2) {
		if (!this.hasValidElement()) {
			return false;
		} else {
			WorldMapElement var3 = class25.WorldMapElement_get(this.getElement());
			int var4 = this.getSubWidth();
			int var5 = this.getSubHeight();
			switch(var3.horizontalAlignment.value) {
			case 0:
				if (var1 < this.screenX - var4 / 2 || var1 > var4 / 2 + this.screenX) {
					return false;
				}
				break;
			case 1:
				if (var1 >= this.screenX && var1 < var4 + this.screenX) {
					break;
				}

				return false;
			case 2:
				if (var1 <= this.screenX - var4 || var1 > this.screenX) {
					return false;
				}
			}

			switch(var3.verticalAlignment.value) {
			case 0:
				if (var2 <= this.screenY - var5 || var2 > this.screenY) {
					return false;
				}
				break;
			case 1:
				if (var2 < this.screenY - var5 / 2 || var2 > var5 / 2 + this.screenY) {
					return false;
				}
				break;
			case 2:
				if (var2 < this.screenY || var2 >= var5 + this.screenY) {
					return false;
				}
			}

			return true;
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-411865092"
	)
	@Export("labelFitsScreen")
	boolean labelFitsScreen(int var1, int var2) {
		WorldMapLabel var3 = this.getLabel();
		if (var3 == null) {
			return false;
		} else if (var1 >= this.screenX - var3.width / 2 && var1 <= var3.width / 2 + this.screenX) {
			return var2 >= this.screenY && var2 <= this.screenY + var3.height;
		} else {
			return false;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(CB)Z",
		garbageValue = "0"
	)
	@Export("isAlphaNumeric")
	public static boolean isAlphaNumeric(char var0) {
		return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
	}
}
