import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
@Implements("WorldMapEvent")
public class WorldMapEvent {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lhc;"
	)
	@Export("NetCache_currentResponse")
	static NetFileRequest NetCache_currentResponse;
	@ObfuscatedName("ek")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	@Export("archive20")
	static Archive archive20;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -133473401
	)
	@Export("mapElement")
	public int mapElement;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	@Export("coord1")
	public Coord coord1;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	@Export("coord2")
	public Coord coord2;

	@ObfuscatedSignature(
		signature = "(ILhb;Lhb;)V"
	)
	public WorldMapEvent(int var1, Coord var2, Coord var3) {
		this.mapElement = var1;
		this.coord1 = var2;
		this.coord2 = var3;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "1393398598"
	)
	static int method801(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return 0;
		} else if (var1 == -1) {
			return 0;
		} else {
			int var3 = 0;

			for (int var4 = 0; var4 < var2.quantities.length; ++var4) {
				if (var2.ids[var4] == var1) {
					var3 += var2.quantities[var4];
				}
			}

			return var3;
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(BI)C",
		garbageValue = "1512501229"
	)
	public static char method802(byte var0) {
		int var1 = var0 & 255;
		if (var1 == 0) {
			throw new IllegalArgumentException("" + Integer.toString(var1, 16));
		} else {
			if (var1 >= 128 && var1 < 160) {
				char var2 = class287.cp1252AsciiExtension[var1 - 128];
				if (var2 == 0) {
					var2 = '?';
				}

				var1 = var2;
			}

			return (char)var1;
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "782060885"
	)
	static final int method800(int var0, int var1) {
		if (var0 == -2) {
			return 12345678;
		} else if (var0 == -1) {
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return var1;
		} else {
			var1 = (var0 & 127) * var1 / 128;
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return (var0 & 65408) + var1;
		}
	}
}
