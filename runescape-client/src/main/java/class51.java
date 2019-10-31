import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class51 {
	@ObfuscatedName("a")
	@Export("applet")
	static Applet applet;
	@ObfuscatedName("t")
	static String field416;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Llw;"
	)
	static IndexedSprite field412;
	@ObfuscatedName("fv")
	@ObfuscatedSignature(
		signature = "Lks;"
	)
	@Export("fontPlain11")
	static Font fontPlain11;

	static {
		applet = null;
		field416 = "";
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)[Lhy;",
		garbageValue = "1830105975"
	)
	@Export("PlayerType_values")
	public static PlayerType[] PlayerType_values() {
		return new PlayerType[]{PlayerType.PlayerType_hardcoreIronman, PlayerType.PlayerType_ultimateIronman, PlayerType.PlayerType_jagexModerator, PlayerType.PlayerType_playerModerator, PlayerType.PlayerType_ironman, PlayerType.PlayerType_normal};
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)Llw;",
		garbageValue = "2066459689"
	)
	static IndexedSprite method975() {
		IndexedSprite var0 = new IndexedSprite();
		var0.width = class325.SpriteBuffer_spriteWidth;
		var0.height = class325.SpriteBuffer_spriteHeight;
		var0.xOffset = SecureRandomFuture.SpriteBuffer_xOffsets[0];
		var0.yOffset = HealthBar.SpriteBuffer_yOffsets[0];
		var0.subWidth = SecureRandomCallable.SpriteBuffer_spriteWidths[0];
		var0.subHeight = AttackOption.SpriteBuffer_spriteHeights[0];
		var0.palette = class325.SpriteBuffer_spritePalette;
		var0.pixels = class325.SpriteBuffer_pixels[0];
		WorldMapData_1.method787();
		return var0;
	}

	@ObfuscatedName("ic")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "1215512172"
	)
	@Export("selectSpell")
	static void selectSpell(int var0, int var1, int var2, int var3) {
		Widget var4 = ArchiveLoader.getWidgetChild(var0, var1);
		if (var4 != null && var4.onTargetEnter != null) {
			ScriptEvent var5 = new ScriptEvent();
			var5.widget = var4;
			var5.args = var4.onTargetEnter;
			GrandExchangeOfferAgeComparator.runScriptEvent(var5);
		}

		Client.field788 = var3;
		Client.isSpellSelected = true;
		Clock.selectedSpellWidget = var0;
		Client.selectedSpellChildIndex = var1;
		class81.selectedSpellFlags = var2;
		GrandExchangeOfferAgeComparator.invalidateWidget(var4);
	}
}
