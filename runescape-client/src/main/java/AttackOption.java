import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("AttackOption")
public enum AttackOption implements Enumerated {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lcr;"
	)
	@Export("AttackOption_dependsOnCombatLevels")
	AttackOption_dependsOnCombatLevels(0),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lcr;"
	)
	@Export("AttackOption_alwaysRightClick")
	AttackOption_alwaysRightClick(1),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lcr;"
	)
	@Export("AttackOption_leftClickWhereAvailable")
	AttackOption_leftClickWhereAvailable(2),
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lcr;"
	)
	@Export("AttackOption_hidden")
	AttackOption_hidden(3);

	@ObfuscatedName("c")
	@Export("SpriteBuffer_spriteHeights")
	public static int[] SpriteBuffer_spriteHeights;
	@ObfuscatedName("h")
	public static boolean field1151;
	@ObfuscatedName("fp")
	@ObfuscatedSignature(
		signature = "Lfw;"
	)
	@Export("socketTask")
	static Task socketTask;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -871271379
	)
	@Export("id")
	final int id;

	AttackOption(int var3) {
		this.id = var3;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1993081102"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lhq;B)V",
		garbageValue = "17"
	)
	public static void method2221(AbstractArchive var0) {
		VarbitDefinition.VarbitDefinition_archive = var0;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lhq;Lhq;ZIS)V",
		garbageValue = "-32666"
	)
	static void method2218(AbstractArchive var0, AbstractArchive var1, boolean var2, int var3) {
		if (Login.field1188) {
			if (var3 == 4) {
				Login.loginIndex = 4;
			}

		} else {
			Login.loginIndex = var3;
			Rasterizer2D.Rasterizer2D_clear();
			byte[] var4 = var0.takeFileByNames("title.jpg", "");
			Login.leftTitleSprite = WorldMapSection1.convertJpgToSprite(var4);
			FontName.rightTitleSprite = Login.leftTitleSprite.mirrorHorizontally();
			if ((Client.worldProperties & 536870912) != 0) {
				Tiles.logoSprite = ClientPacket.SpriteBuffer_getIndexedSpriteByName(var1, "logo_deadman_mode", "");
			} else if ((Client.worldProperties & 1073741824) != 0) {
				Tiles.logoSprite = ClientPacket.SpriteBuffer_getIndexedSpriteByName(var1, "logo_seasonal_mode", "");
			} else {
				Tiles.logoSprite = ClientPacket.SpriteBuffer_getIndexedSpriteByName(var1, "logo", "");
			}

			NPC.titleboxSprite = ClientPacket.SpriteBuffer_getIndexedSpriteByName(var1, "titlebox", "");
			UserComparator9.titlebuttonSprite = ClientPacket.SpriteBuffer_getIndexedSpriteByName(var1, "titlebutton", "");
			class208.runesSprite = PlayerAppearance.method4160(var1, "runes", "");
			Decimator.title_muteSprite = PlayerAppearance.method4160(var1, "title_mute", "");
			UserComparator8.options_buttons_0Sprite = ClientPacket.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,0", "");
			class51.field412 = ClientPacket.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,4", "");
			Login.options_buttons_2Sprite = ClientPacket.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,2", "");
			class4.field23 = ClientPacket.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,6", "");
			Login.field1174 = UserComparator8.options_buttons_0Sprite.subWidth;
			Language.field2328 = UserComparator8.options_buttons_0Sprite.subHeight;
			Login.loginScreenRunesAnimation = new LoginScreenAnimation(class208.runesSprite);
			if (var2) {
				Login.Login_username = "";
				Login.Login_password = "";
			}

			Huffman.field2491 = 0;
			class268.otp = "";
			Login.field1177 = true;
			Login.worldSelectOpen = false;
			if (!ScriptEvent.clientPreferences.titleMusicDisabled) {
				Archive var5 = class216.archive6;
				int var6 = var5.getGroupId("scape main");
				int var7 = var5.getFileId(var6, "");
				WorldMapIcon_0.method253(2, var5, var6, var7, 255, false);
			} else {
				class80.method2194(2);
			}

			UrlRequester.method3428(false);
			Login.field1188 = true;
			Login.xPadding = (class286.canvasWidth - 765) / 2;
			Login.loginBoxX = Login.xPadding + 202;
			class192.loginBoxCenter = Login.loginBoxX + 180;
			Login.leftTitleSprite.drawAt(Login.xPadding, 0);
			FontName.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
			Tiles.logoSprite.drawAt(Login.xPadding + 382 - Tiles.logoSprite.subWidth / 2, 18);
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "2026213000"
	)
	@Export("Messages_getHistorySize")
	static int Messages_getHistorySize(int var0) {
		ChatChannel var1 = (ChatChannel)Messages.Messages_channels.get(var0);
		return var1 == null ? 0 : var1.size();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1182575987"
	)
	static void method2215() {
		if (class43.loadWorlds()) {
			Login.worldSelectOpen = true;
			Login.worldSelectPage = 0;
			Login.worldSelectPagesCount = 0;
		}

	}

	@ObfuscatedName("jj")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "2104552058"
	)
	@Export("runIntfCloseListeners")
	static final void runIntfCloseListeners(int var0, int var1) {
		if (TextureProvider.loadInterface(var0)) {
			DirectByteArrayCopier.runComponentCloseListeners(Widget.Widget_interfaceComponents[var0], var1);
		}
	}
}
