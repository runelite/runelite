import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
@Implements("WorldMapIcon_0")
public class WorldMapIcon_0 extends AbstractWorldMapIcon {
	@ObfuscatedName("sm")
	@Export("foundItemIds")
	static short[] foundItemIds;
	@ObfuscatedName("be")
	@ObfuscatedSignature(
		signature = "Llp;"
	)
	@Export("worldSelectLeftSprite")
	static IndexedSprite worldSelectLeftSprite;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -189436837
	)
	@Export("element")
	final int element;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Law;"
	)
	@Export("label")
	final WorldMapLabel label;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 704139389
	)
	@Export("subWidth")
	final int subWidth;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 155630147
	)
	@Export("subHeight")
	final int subHeight;

	@ObfuscatedSignature(
		signature = "(Lhb;Lhb;ILaw;)V"
	)
	WorldMapIcon_0(Coord var1, Coord var2, int var3, WorldMapLabel var4) {
		super(var1, var2);
		this.element = var3;
		this.label = var4;
		WorldMapElement var5 = Decimator.WorldMapElement_get(this.getElement());
		Sprite var6 = var5.getSpriteBool(false);
		if (var6 != null) {
			this.subWidth = var6.subWidth;
			this.subHeight = var6.subHeight;
		} else {
			this.subWidth = 0;
			this.subHeight = 0;
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "16"
	)
	@Export("getElement")
	public int getElement() {
		return this.element;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)Law;",
		garbageValue = "13348956"
	)
	@Export("getLabel")
	WorldMapLabel getLabel() {
		return this.label;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-175699296"
	)
	@Export("getSubWidth")
	int getSubWidth() {
		return this.subWidth;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "806304417"
	)
	@Export("getSubHeight")
	int getSubHeight() {
		return this.subHeight;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(Lhp;Ljava/lang/String;Ljava/lang/String;I)[Llp;",
		garbageValue = "-29773382"
	)
	public static IndexedSprite[] method222(AbstractArchive var0, String var1, String var2) {
		int var3 = var0.getGroupId(var1);
		int var4 = var0.getFileId(var3, var2);
		return class297.method5389(var0, var3, var4);
	}

	@ObfuscatedName("jd")
	@ObfuscatedSignature(
		signature = "(Lho;I)V",
		garbageValue = "-1181739841"
	)
	static final void method221(Widget var0) {
		int var1 = var0.contentType;
		if (var1 == 324) {
			if (Client.field900 == -1) {
				Client.field900 = var0.spriteId2;
				Client.field901 = var0.spriteId;
			}

			if (Client.playerAppearance.isFemale) {
				var0.spriteId2 = Client.field900;
			} else {
				var0.spriteId2 = Client.field901;
			}

		} else if (var1 == 325) {
			if (Client.field900 == -1) {
				Client.field900 = var0.spriteId2;
				Client.field901 = var0.spriteId;
			}

			if (Client.playerAppearance.isFemale) {
				var0.spriteId2 = Client.field901;
			} else {
				var0.spriteId2 = Client.field900;
			}

		} else if (var1 == 327) {
			var0.modelAngleX = 150;
			var0.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
			var0.modelType = 5;
			var0.modelId = 0;
		} else if (var1 == 328) {
			var0.modelAngleX = 150;
			var0.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
			var0.modelType = 5;
			var0.modelId = 1;
		}
	}
}
