import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("AbstractWorldMapIcon")
public abstract class AbstractWorldMapIcon {
	@ObfuscatedName("qa")
	@ObfuscatedSignature(
		signature = "Ldo;"
	)
	@Export("decimator")
	static Decimator decimator;
	@ObfuscatedName("dz")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive2")
	static Archive archive2;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("coord2")
	public final Coord coord2;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("coord1")
	public final Coord coord1;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 2101295301
	)
	@Export("screenX")
	int screenX;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1809390745
	)
	@Export("screenY")
	int screenY;

	@ObfuscatedSignature(
		signature = "(Lhf;Lhf;)V"
	)
	AbstractWorldMapIcon(Coord var1, Coord var2) {
		this.coord1 = var1;
		this.coord2 = var2;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1878632225"
	)
	@Export("getElement")
	public abstract int getElement();

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Lar;",
		garbageValue = "-77909992"
	)
	@Export("getLabel")
	abstract WorldMapLabel getLabel();

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "60677286"
	)
	@Export("getSubWidth")
	abstract int getSubWidth();

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-92"
	)
	@Export("getSubHeight")
	abstract int getSubHeight();

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "1408503186"
	)
	@Export("fitsScreen")
	boolean fitsScreen(int var1, int var2) {
		if (this.elementFitsScreen(var1, var2)) {
			return true;
		} else {
			return this.labelFitsScreen(var1, var2);
		}
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1618081006"
	)
	@Export("hasValidElement")
	boolean hasValidElement() {
		return this.getElement() >= 0;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "471623513"
	)
	@Export("elementFitsScreen")
	boolean elementFitsScreen(int var1, int var2) {
		if (!this.hasValidElement()) {
			return false;
		} else {
			WorldMapElement var3 = class65.WorldMapElement_get(this.getElement());
			int var4 = this.getSubWidth();
			int var5 = this.getSubHeight();
			switch(var3.horizontalAlignment.value) {
			case 0:
				if (var1 <= this.screenX - var4 || var1 > this.screenX) {
					return false;
				}
				break;
			case 1:
				if (var1 >= this.screenX - var4 / 2 && var1 <= var4 / 2 + this.screenX) {
					break;
				}

				return false;
			case 2:
				if (var1 < this.screenX || var1 >= var4 + this.screenX) {
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

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "1082527847"
	)
	@Export("labelFitsScreen")
	boolean labelFitsScreen(int var1, int var2) {
		WorldMapLabel var3 = this.getLabel();
		if (var3 == null) {
			return false;
		} else if (var1 >= this.screenX - var3.width / 2 && var1 <= var3.width / 2 + this.screenX) {
			return var2 >= this.screenY && var2 <= var3.height + this.screenY;
		} else {
			return false;
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "93178768"
	)
	static boolean method679(char var0) {
		return "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".indexOf(var0) != -1;
	}

	@ObfuscatedName("fa")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "30161399"
	)
	static final void method652() {
		if (Client.logoutTimer > 0) {
			class1.logOut();
		} else {
			Client.timer.method5123();
			Tile.updateGameState(40);
			Tiles.field499 = Client.packetWriter.getSocket();
			Client.packetWriter.removeSocket();
		}
	}

	@ObfuscatedName("fo")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "542479713"
	)
	@Export("playSong")
	static void playSong(int var0) {
		if (var0 == -1 && !Client.field855) {
			class197.midiPcmStream.clear();
			class197.field2377 = 1;
			class247.musicTrackArchive = null;
		} else if (var0 != -1 && var0 != Client.currentTrackGroupId && Client.musicVolume != 0 && !Client.field855) {
			WorldMapIcon_0.method253(2, class216.archive6, var0, 0, Client.musicVolume, false);
		}

		Client.currentTrackGroupId = var0;
	}
}
