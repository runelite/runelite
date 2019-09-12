import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
@Implements("VarpDefinition")
public class VarpDefinition extends DualNode {
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Let;"
	)
	@Export("VarpDefinition_cached")
	static EvictingDualNodeHashTable VarpDefinition_cached;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1682787017
	)
	@Export("type")
	public int type;

	static {
		VarpDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	VarpDefinition() {
		this.type = 0;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkz;B)V",
		garbageValue = "76"
	)
	@Export("decode")
	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkz;IB)V",
		garbageValue = "86"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 5) {
			this.type = var1.readUnsignedShort();
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lhz;Lhz;ZIS)V",
		garbageValue = "-8911"
	)
	static void method4354(AbstractArchive var0, AbstractArchive var1, boolean var2, int var3) {
		if (Login.field1181) {
			if (var3 == 4) {
				Login.loginIndex = 4;
			}

		} else {
			Login.loginIndex = var3;
			Rasterizer2D.Rasterizer2D_clear();
			byte[] var4 = var0.takeFileByNames("title.jpg", "");
			Login.leftTitleSprite = class16.convertJpgToSprite(var4);
			class191.rightTitleSprite = Login.leftTitleSprite.mirrorHorizontally();
			if ((Client.worldProperties & 536870912) != 0) {
				HealthBar.logoSprite = Interpreter.SpriteBuffer_getIndexedSpriteByName(var1, "logo_deadman_mode", "");
			} else {
				HealthBar.logoSprite = Interpreter.SpriteBuffer_getIndexedSpriteByName(var1, "logo", "");
			}

			Login.titleboxSprite = Interpreter.SpriteBuffer_getIndexedSpriteByName(var1, "titlebox", "");
			class191.titlebuttonSprite = Interpreter.SpriteBuffer_getIndexedSpriteByName(var1, "titlebutton", "");
			UserComparator10.runesSprite = GrandExchangeOfferNameComparator.method122(var1, "runes", "");
			FileSystem.title_muteSprite = GrandExchangeOfferNameComparator.method122(var1, "title_mute", "");
			GrandExchangeOfferWorldComparator.options_buttons_0Sprite = Interpreter.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,0", "");
			Login.field1153 = Interpreter.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,4", "");
			Login.options_buttons_2Sprite = Interpreter.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,2", "");
			WorldMapDecoration.field202 = Interpreter.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,6", "");
			class4.field17 = GrandExchangeOfferWorldComparator.options_buttons_0Sprite.subWidth;
			class267.field3524 = GrandExchangeOfferWorldComparator.options_buttons_0Sprite.subHeight;
			UserComparator5.loginScreenRunesAnimation = new LoginScreenAnimation(UserComparator10.runesSprite);
			if (var2) {
				Login.Login_username = "";
				Login.Login_password = "";
			}

			class222.field2729 = 0;
			class81.otp = "";
			Login.field1183 = true;
			Login.worldSelectOpen = false;
			if (!Actor.clientPreferences.titleMusicDisabled) {
				PendingSpawn.method1681(2, WorldMapDecoration.archive6, "scape main", "", 255, false);
			} else {
				WallDecoration.method3256(2);
			}

			class173.method3575(false);
			Login.field1181 = true;
			Login.xPadding = (GraphicsDefaults.canvasWidth - 765) / 2;
			Login.loginBoxX = Login.xPadding + 202;
			VarcInt.loginBoxCenter = Login.loginBoxX + 180;
			Login.leftTitleSprite.drawAt(Login.xPadding, 0);
			class191.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
			HealthBar.logoSprite.drawAt(Login.xPadding + 382 - HealthBar.logoSprite.subWidth / 2, 18);
		}
	}
}
