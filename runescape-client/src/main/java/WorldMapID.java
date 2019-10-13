import java.applet.Applet;
import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("ar")
@Implements("WorldMapID")
public class WorldMapID {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lar;"
	)
	static final WorldMapID field256;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lar;"
	)
	static final WorldMapID field257;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Llf;"
	)
	@Export("leftTitleSprite")
	static Sprite leftTitleSprite;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -81572617
	)
	@Export("clientTickTimeIdx")
	static int clientTickTimeIdx;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1325901065
	)
	@Export("value")
	final int value;

	static {
		field256 = new WorldMapID(0);
		field257 = new WorldMapID(1);
	}

	WorldMapID(int var1) {
		this.value = var1;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZLjava/lang/String;ZI)V",
		garbageValue = "-1035717036"
	)
	static void method568(String var0, boolean var1, String var2, boolean var3) {
		if (var1) {
			if (!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
				try {
					Desktop.getDesktop().browse(new URI(var0));
					return;
				} catch (Exception var5) {
				}
			}

			if (class51.field406.startsWith("win") && !var3) {
				Interpreter.method2025(var0, 0);
				return;
			}

			if (class51.field406.startsWith("mac")) {
				method567(var0, 1, var2);
				return;
			}

			Interpreter.method2025(var0, 2);
		} else {
			Interpreter.method2025(var0, 3);
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
		garbageValue = "-1037909601"
	)
	static boolean method567(String var0, int var1, String var2) {
		if (var1 == 0) {
			try {
				if (!class51.field406.startsWith("win")) {
					throw new Exception();
				} else if (!var0.startsWith("http://") && !var0.startsWith("https://")) {
					throw new Exception();
				} else {
					String var13 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

					for (int var4 = 0; var4 < var0.length(); ++var4) {
						if (var13.indexOf(var0.charAt(var4)) == -1) {
							throw new Exception();
						}
					}

					Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
					return true;
				}
			} catch (Throwable var8) {
				return false;
			}
		} else if (var1 == 1) {
			try {
				Applet var7 = class51.applet;
				Object[] var5 = new Object[]{(new URL(class51.applet.getCodeBase(), var0)).toString()};
				Object var3 = JSObject.getWindow(var7).call(var2, var5);
				return var3 != null;
			} catch (Throwable var9) {
				return false;
			}
		} else if (var1 == 2) {
			try {
				class51.applet.getAppletContext().showDocument(new URL(class51.applet.getCodeBase(), var0), "_blank");
				return true;
			} catch (Exception var10) {
				return false;
			}
		} else if (var1 == 3) {
			try {
				class47.method881(class51.applet, "loggedout");
			} catch (Throwable var12) {
			}

			try {
				class51.applet.getAppletContext().showDocument(new URL(class51.applet.getCodeBase(), var0), "_top");
				return true;
			} catch (Exception var11) {
				return false;
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-2144797919"
	)
	static final void method569(int var0, int var1, int var2) {
		int var3;
		for (var3 = 0; var3 < 8; ++var3) {
			for (int var4 = 0; var4 < 8; ++var4) {
				Tiles.Tiles_heights[var0][var3 + var1][var4 + var2] = 0;
			}
		}

		if (var1 > 0) {
			for (var3 = 1; var3 < 8; ++var3) {
				Tiles.Tiles_heights[var0][var1][var3 + var2] = Tiles.Tiles_heights[var0][var1 - 1][var3 + var2];
			}
		}

		if (var2 > 0) {
			for (var3 = 1; var3 < 8; ++var3) {
				Tiles.Tiles_heights[var0][var3 + var1][var2] = Tiles.Tiles_heights[var0][var3 + var1][var2 - 1];
			}
		}

		if (var1 > 0 && Tiles.Tiles_heights[var0][var1 - 1][var2] != 0) {
			Tiles.Tiles_heights[var0][var1][var2] = Tiles.Tiles_heights[var0][var1 - 1][var2];
		} else if (var2 > 0 && Tiles.Tiles_heights[var0][var1][var2 - 1] != 0) {
			Tiles.Tiles_heights[var0][var1][var2] = Tiles.Tiles_heights[var0][var1][var2 - 1];
		} else if (var1 > 0 && var2 > 0 && Tiles.Tiles_heights[var0][var1 - 1][var2 - 1] != 0) {
			Tiles.Tiles_heights[var0][var1][var2] = Tiles.Tiles_heights[var0][var1 - 1][var2 - 1];
		}

	}

	@ObfuscatedName("fy")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "95"
	)
	@Export("playPcmPlayers")
	static final void playPcmPlayers() {
		if (GrandExchangeOfferWorldComparator.pcmPlayer1 != null) {
			GrandExchangeOfferWorldComparator.pcmPlayer1.run();
		}

		if (class219.pcmPlayer0 != null) {
			class219.pcmPlayer0.run();
		}

	}
}
