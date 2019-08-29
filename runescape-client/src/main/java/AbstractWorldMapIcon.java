import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("AbstractWorldMapIcon")
public abstract class AbstractWorldMapIcon {
	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		signature = "Llq;"
	)
	@Export("worldSelectLeftSprite")
	static IndexedSprite worldSelectLeftSprite;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lhd;"
	)
	@Export("coord2")
	public final Coord coord2;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lhd;"
	)
	@Export("coord1")
	public final Coord coord1;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 318036895
	)
	@Export("screenX")
	int screenX;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1985838427
	)
	@Export("screenY")
	int screenY;

	@ObfuscatedSignature(
		signature = "(Lhd;Lhd;)V"
	)
	AbstractWorldMapIcon(Coord var1, Coord var2) {
		this.coord1 = var1;
		this.coord2 = var2;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "78"
	)
	@Export("getElement")
	public abstract int getElement();

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(B)Lai;",
		garbageValue = "1"
	)
	@Export("getLabel")
	abstract WorldMapLabel getLabel();

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1930584854"
	)
	@Export("getSubWidth")
	abstract int getSubWidth();

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-56"
	)
	@Export("getSubHeight")
	abstract int getSubHeight();

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "505598061"
	)
	@Export("fitsScreen")
	boolean fitsScreen(int var1, int var2) {
		if (this.elementFitsScreen(var1, var2)) {
			return true;
		} else {
			return this.labelFitsScreen(var1, var2);
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(S)Z",
		garbageValue = "256"
	)
	@Export("hasValidElement")
	boolean hasValidElement() {
		return this.getElement() >= 0;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IIS)Z",
		garbageValue = "-26498"
	)
	@Export("elementFitsScreen")
	boolean elementFitsScreen(int var1, int var2) {
		if (!this.hasValidElement()) {
			return false;
		} else {
			WorldMapElement var3 = WorldMapData_0.WorldMapElement_get(this.getElement());
			int var4 = this.getSubWidth();
			int var5 = this.getSubHeight();
			switch(var3.horizontalAlignment.value) {
			case 0:
				if (var1 >= this.screenX && var1 < var4 + this.screenX) {
					break;
				}

				return false;
			case 1:
				if (var1 >= this.screenX - var4 / 2 && var1 <= var4 / 2 + this.screenX) {
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
				if (var2 >= this.screenY - var5 / 2 && var2 <= var5 / 2 + this.screenY) {
					break;
				}

				return false;
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

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIB)Z",
		garbageValue = "66"
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
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "261353448"
	)
	static final void method591(String var0) {
		StringBuilder var10000 = (new StringBuilder()).append(var0);
		Object var10001 = null;
		String var1 = var10000.append(" is already on your ignore list").toString();
		DirectByteArrayCopier.addGameMessage(30, "", var1);
	}
}
