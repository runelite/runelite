import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
@Implements("WorldMapIcon_0")
public class WorldMapIcon_0 extends AbstractWorldMapIcon {
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -348487323
	)
	@Export("element")
	final int element;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Law;"
	)
	@Export("label")
	final WorldMapLabel label;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -453490289
	)
	@Export("subWidth")
	final int subWidth;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 350288691
	)
	@Export("subHeight")
	final int subHeight;

	@ObfuscatedSignature(
		signature = "(Lht;Lht;ILaw;)V"
	)
	WorldMapIcon_0(Coord var1, Coord var2, int var3, WorldMapLabel var4) {
		super(var1, var2);
		this.element = var3;
		this.label = var4;
		WorldMapElement var5 = GrandExchangeOfferUnitPriceComparator.WorldMapElement_get(this.getElement());
		Sprite var6 = var5.getSpriteBool(false);
		if (var6 != null) {
			this.subWidth = var6.subWidth;
			this.subHeight = var6.subHeight;
		} else {
			this.subWidth = 0;
			this.subHeight = 0;
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "63"
	)
	@Export("getElement")
	public int getElement() {
		return this.element;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Law;",
		garbageValue = "-1801186977"
	)
	@Export("getLabel")
	WorldMapLabel getLabel() {
		return this.label;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-2033351231"
	)
	@Export("getSubWidth")
	int getSubWidth() {
		return this.subWidth;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1873129621"
	)
	@Export("getSubHeight")
	int getSubHeight() {
		return this.subHeight;
	}

	@ObfuscatedName("i")
	public static String method201(long var0) {
		if (var0 > 0L && var0 < 6582952005840035281L) {
			if (0L == var0 % 37L) {
				return null;
			} else {
				int var2 = 0;

				for (long var3 = var0; 0L != var3; var3 /= 37L) {
					++var2;
				}

				StringBuilder var5 = new StringBuilder(var2);

				while (var0 != 0L) {
					long var6 = var0;
					var0 /= 37L;
					var5.append(class288.base37Table[(int)(var6 - 37L * var0)]);
				}

				return var5.reverse().toString();
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("gg")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1371690211"
	)
	static final int method202() {
		if (Interpreter.clientPreferences.roofsHidden) {
			return UrlRequest.Client_plane;
		} else {
			int var0 = ScriptEvent.getTileHeight(MusicPatchNode2.cameraX, UserComparator9.cameraZ, UrlRequest.Client_plane);
			return var0 - class60.cameraY < 800 && (Tiles.Tiles_renderFlags[UrlRequest.Client_plane][MusicPatchNode2.cameraX >> 7][UserComparator9.cameraZ >> 7] & 4) != 0 ? UrlRequest.Client_plane : 3;
		}
	}
}
