import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("AttackOption")
public enum AttackOption implements Enumerated {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lco;"
	)
	@Export("AttackOption_dependsOnCombatLevels")
	AttackOption_dependsOnCombatLevels(0),
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lco;"
	)
	@Export("AttackOption_alwaysRightClick")
	AttackOption_alwaysRightClick(1),
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lco;"
	)
	@Export("AttackOption_leftClickWhereAvailable")
	AttackOption_leftClickWhereAvailable(2),
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lco;"
	)
	@Export("AttackOption_hidden")
	AttackOption_hidden(3);

	@ObfuscatedName("ox")
	@ObfuscatedSignature(
		signature = "Lcj;"
	)
	@Export("varcs")
	static Varcs varcs;
	@ObfuscatedName("fr")
	@ObfuscatedSignature(
		signature = "Lky;"
	)
	@Export("fontPlain11")
	static Font fontPlain11;
	@ObfuscatedName("gt")
	@ObfuscatedSignature(
		signature = "[Lln;"
	)
	@Export("mapMarkerSprites")
	static Sprite[] mapMarkerSprites;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 2079114159
	)
	@Export("id")
	final int id;

	AttackOption(int var3) {
		this.id = var3;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "7"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-573010380"
	)
	static int method2098(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return -1;
		} else {
			return var1 >= 0 && var1 < var2.ids.length ? var2.ids[var1] : -1;
		}
	}

	@ObfuscatedName("fq")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-940191492"
	)
	@Export("playSong")
	static void playSong(int var0) {
		if (var0 == -1 && !Client.field742) {
			TileItemPile.method2811();
		} else if (var0 != -1 && var0 != Client.currentTrackGroupId && Client.musicVolume != 0 && !Client.field742) {
			World.method1819(2, AbstractWorldMapData.archive6, var0, 0, Client.musicVolume, false);
		}

		Client.currentTrackGroupId = var0;
	}
}
