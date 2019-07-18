import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
@Implements("WorldMapLabelSize")
public class WorldMapLabelSize {
	@ObfuscatedName("sy")
	@ObfuscatedSignature(
		signature = "Lbk;"
	)
	@Export("clientPreferences")
	static ClientPreferences clientPreferences;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "La;"
	)
	@Export("WorldMapLabelSize_small")
	public static final WorldMapLabelSize WorldMapLabelSize_small;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "La;"
	)
	@Export("WorldMapLabelSize_medium")
	public static final WorldMapLabelSize WorldMapLabelSize_medium;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "La;"
	)
	@Export("WorldMapLabelSize_large")
	public static final WorldMapLabelSize WorldMapLabelSize_large;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Ldf;"
	)
	@Export("soundCache")
	public static SoundCache soundCache;
	@ObfuscatedName("dk")
	@ObfuscatedSignature(
		signature = "Liu;"
	)
	@Export("archive10")
	static Archive archive10;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1999419383
	)
	final int field112;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1876270567
	)
	final int field114;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 798925557
	)
	final int field115;

	static {
		WorldMapLabelSize_small = new WorldMapLabelSize(0, 0, 4);
		WorldMapLabelSize_medium = new WorldMapLabelSize(2, 1, 2);
		WorldMapLabelSize_large = new WorldMapLabelSize(1, 2, 0);
	}

	WorldMapLabelSize(int var1, int var2, int var3) {
		this.field112 = var1;
		this.field114 = var2;
		this.field115 = var3;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(FI)Z",
		garbageValue = "-927816948"
	)
	boolean method184(float var1) {
		return var1 >= (float)this.field115;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)[La;",
		garbageValue = "31"
	)
	static WorldMapLabelSize[] method178() {
		return new WorldMapLabelSize[]{WorldMapLabelSize_small, WorldMapLabelSize_medium, WorldMapLabelSize_large};
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(II)La;",
		garbageValue = "1320537825"
	)
	static WorldMapLabelSize method177(int var0) {
		WorldMapLabelSize[] var1 = method178();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			WorldMapLabelSize var3 = var1[var2];
			if (var0 == var3.field114) {
				return var3;
			}
		}

		return null;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IZIZI)V",
		garbageValue = "-176379221"
	)
	@Export("sortWorldList")
	static void sortWorldList(int var0, boolean var1, int var2, boolean var3) {
		if (World.worlds != null) {
			GrandExchangeOffer.doWorldSorting(0, World.worlds.length - 1, var0, var1, var2, var3);
		}

	}

	@ObfuscatedName("fe")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "131988648"
	)
	static void method188(int var0, int var1) {
		if (Client.field911 != 0 && var0 != -1) {
			class169.method3503(class32.archive11, var0, 0, Client.field911, false);
			Client.field699 = true;
		}

	}

	@ObfuscatedName("is")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1199742641"
	)
	static final void method175(int var0, int var1) {
		if (class162.loadInterface(var0)) {
			WorldMapID.method539(Widget.Widget_interfaceComponents[var0], var1);
		}
	}
}
