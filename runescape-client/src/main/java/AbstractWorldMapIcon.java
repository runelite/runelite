import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
@Implements("AbstractWorldMapIcon")
public abstract class AbstractWorldMapIcon {
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	@Export("coord2")
	public final Coord coord2;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	@Export("coord1")
	public final Coord coord1;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1277861537
	)
	@Export("screenX")
	int screenX;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -946812135
	)
	@Export("screenY")
	int screenY;

	@ObfuscatedSignature(
		signature = "(Lhv;Lhv;)V"
	)
	AbstractWorldMapIcon(Coord var1, Coord var2) {
		this.coord1 = var1;
		this.coord2 = var2;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-229566020"
	)
	@Export("getElement")
	public abstract int getElement();

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)Las;",
		garbageValue = "1426074195"
	)
	@Export("getLabel")
	abstract WorldMapLabel getLabel();

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "14"
	)
	@Export("getSubWidth")
	abstract int getSubWidth();

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "1"
	)
	@Export("getSubHeight")
	abstract int getSubHeight();

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IIB)Z",
		garbageValue = "-101"
	)
	@Export("fitsScreen")
	boolean fitsScreen(int var1, int var2) {
		if (this.elementFitsScreen(var1, var2)) {
			return true;
		} else {
			return this.labelFitsScreen(var1, var2);
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1274004046"
	)
	@Export("hasValidElement")
	boolean hasValidElement() {
		return this.getElement() >= 0;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "406020312"
	)
	@Export("elementFitsScreen")
	boolean elementFitsScreen(int var1, int var2) {
		if (!this.hasValidElement()) {
			return false;
		} else {
			WorldMapElement var3 = class222.getWorldMapElement(this.getElement());
			int var4 = this.getSubWidth();
			int var5 = this.getSubHeight();
			switch(var3.horizontalAlignment.value) {
			case 0:
				if (var1 <= this.screenX - var4 || var1 > this.screenX) {
					return false;
				}
				break;
			case 1:
				if (var1 >= this.screenX && var1 < var4 + this.screenX) {
					break;
				}

				return false;
			case 2:
				if (var1 < this.screenX - var4 / 2 || var1 > var4 / 2 + this.screenX) {
					return false;
				}
			}

			switch(var3.verticalAlignment.value) {
			case 0:
				if (var2 < this.screenY - var5 / 2 || var2 > var5 / 2 + this.screenY) {
					return false;
				}
				break;
			case 1:
				if (var2 <= this.screenY - var5 || var2 > this.screenY) {
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

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-1252480817"
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

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1908697951"
	)
	@Export("NpcDefinition_clearCached")
	public static void NpcDefinition_clearCached() {
		NPCDefinition.NpcDefinition_cached.clear();
		NPCDefinition.NpcDefinition_cachedModels.clear();
	}

	@ObfuscatedName("fb")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-108"
	)
	@Export("getWindowedMode")
	static int getWindowedMode() {
		return Client.isResizable ? 2 : 1;
	}
}
