import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
public class class191 {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	static final class191 field2354;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	static final class191 field2350;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	static final class191 field2352;

	static {
		field2354 = new class191();
		field2350 = new class191();
		field2352 = new class191();
	}

	class191() {
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(II)Lix;",
		garbageValue = "-2115403746"
	)
	@Export("KitDefinition_get")
	public static KitDefinition KitDefinition_get(int var0) {
		KitDefinition var1 = (KitDefinition)KitDefinition.KitDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = KitDefinition.KitDefinition_archive.takeFile(3, var0);
			var1 = new KitDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			KitDefinition.KitDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lbj;I)V",
		garbageValue = "-1644977095"
	)
	static void method3638(GameShell var0) {
		while (KeyHandler.isKeyDown()) {
			if (VertexNormal.field1732 == 13) {
				Login.worldSelectOpen = false;
				UrlRequest.leftTitleSprite.drawAt(Login.xPadding, 0);
				ScriptFrame.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
				Login.logoSprite.drawAt(Login.xPadding + 382 - Login.logoSprite.subWidth / 2, 18);
				return;
			}

			if (VertexNormal.field1732 == 96) {
				if (Login.worldSelectPage > 0 && GrandExchangeEvent.worldSelectLeftSprite != null) {
					--Login.worldSelectPage;
				}
			} else if (VertexNormal.field1732 == 97 && Login.worldSelectPage < Login.worldSelectPagesCount && UserList.worldSelectRightSprite != null) {
				++Login.worldSelectPage;
			}
		}

		if (MouseHandler.MouseHandler_lastButton == 1 || !NetFileRequest.mouseCam && MouseHandler.MouseHandler_lastButton == 4) {
			int var1 = Login.xPadding + 280;
			if (MouseHandler.MouseHandler_lastPressedX >= var1 && MouseHandler.MouseHandler_lastPressedX <= var1 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				PcmPlayer.changeWorldSelectSorting(0, 0);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= var1 + 15 && MouseHandler.MouseHandler_lastPressedX <= var1 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				PcmPlayer.changeWorldSelectSorting(0, 1);
				return;
			}

			int var2 = Login.xPadding + 390;
			if (MouseHandler.MouseHandler_lastPressedX >= var2 && MouseHandler.MouseHandler_lastPressedX <= var2 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				PcmPlayer.changeWorldSelectSorting(1, 0);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= var2 + 15 && MouseHandler.MouseHandler_lastPressedX <= var2 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				PcmPlayer.changeWorldSelectSorting(1, 1);
				return;
			}

			int var3 = Login.xPadding + 500;
			if (MouseHandler.MouseHandler_lastPressedX >= var3 && MouseHandler.MouseHandler_lastPressedX <= var3 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				PcmPlayer.changeWorldSelectSorting(2, 0);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= var3 + 15 && MouseHandler.MouseHandler_lastPressedX <= var3 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				PcmPlayer.changeWorldSelectSorting(2, 1);
				return;
			}

			int var4 = Login.xPadding + 610;
			if (MouseHandler.MouseHandler_lastPressedX >= var4 && MouseHandler.MouseHandler_lastPressedX <= var4 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				PcmPlayer.changeWorldSelectSorting(3, 0);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= var4 + 15 && MouseHandler.MouseHandler_lastPressedX <= var4 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				PcmPlayer.changeWorldSelectSorting(3, 1);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 708 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedX <= Login.xPadding + 708 + 50 && MouseHandler.MouseHandler_lastPressedY <= 20) {
				Login.worldSelectOpen = false;
				UrlRequest.leftTitleSprite.drawAt(Login.xPadding, 0);
				ScriptFrame.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
				Login.logoSprite.drawAt(Login.xPadding + 382 - Login.logoSprite.subWidth / 2, 18);
				return;
			}

			if (Login.hoveredWorldIndex != -1) {
				World var5 = class162.World_worlds[Login.hoveredWorldIndex];
				KeyHandler.changeWorld(var5);
				Login.worldSelectOpen = false;
				UrlRequest.leftTitleSprite.drawAt(Login.xPadding, 0);
				ScriptFrame.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
				Login.logoSprite.drawAt(Login.xPadding + 382 - Login.logoSprite.subWidth / 2, 18);
				return;
			}

			if (Login.worldSelectPage > 0 && GrandExchangeEvent.worldSelectLeftSprite != null && MouseHandler.MouseHandler_lastPressedX >= 0 && MouseHandler.MouseHandler_lastPressedX <= GrandExchangeEvent.worldSelectLeftSprite.subWidth && MouseHandler.MouseHandler_lastPressedY >= AttackOption.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= AttackOption.canvasHeight / 2 + 50) {
				--Login.worldSelectPage;
			}

			if (Login.worldSelectPage < Login.worldSelectPagesCount && UserList.worldSelectRightSprite != null && MouseHandler.MouseHandler_lastPressedX >= GrandExchangeOfferTotalQuantityComparator.canvasWidth - UserList.worldSelectRightSprite.subWidth - 5 && MouseHandler.MouseHandler_lastPressedX <= GrandExchangeOfferTotalQuantityComparator.canvasWidth && MouseHandler.MouseHandler_lastPressedY >= AttackOption.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= AttackOption.canvasHeight / 2 + 50) {
				++Login.worldSelectPage;
			}
		}

	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "-1025442048"
	)
	@Export("isAlphaNumeric")
	public static boolean isAlphaNumeric(char var0) {
		return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-13"
	)
	static final void method3640(String var0) {
		Tiles.method1143("Please remove " + var0 + " from your friend list first");
	}
}
