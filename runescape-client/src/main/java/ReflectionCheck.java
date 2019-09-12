import java.applet.Applet;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("cf")
@Implements("ReflectionCheck")
public class ReflectionCheck extends Node {
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lgy;"
	)
	@Export("musicTrack")
	public static MusicTrack musicTrack;
	@ObfuscatedName("fx")
	@ObfuscatedGetter(
		intValue = 1741628195
	)
	static int field1303;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -698721725
	)
	@Export("id")
	int id;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -414565063
	)
	@Export("size")
	int size;
	@ObfuscatedName("t")
	@Export("operations")
	int[] operations;
	@ObfuscatedName("g")
	@Export("creationErrors")
	int[] creationErrors;
	@ObfuscatedName("l")
	@Export("fields")
	Field[] fields;
	@ObfuscatedName("u")
	@Export("intReplaceValues")
	int[] intReplaceValues;
	@ObfuscatedName("j")
	@Export("methods")
	Method[] methods;
	@ObfuscatedName("v")
	@Export("arguments")
	byte[][][] arguments;

	ReflectionCheck() {
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ILjava/lang/String;B)Z",
		garbageValue = "122"
	)
	static boolean method2261(String var0, int var1, String var2) {
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
				class47.method812(class51.applet, "loggedout");
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

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lbb;I)V",
		garbageValue = "1777731201"
	)
	@Export("changeWorld")
	static void changeWorld(World var0) {
		if (var0.isMembersOnly() != Client.isMembersWorld) {
			Client.isMembersWorld = var0.isMembersOnly();
			VertexNormal.method2960(var0.isMembersOnly());
		}

		ArchiveLoader.worldHost = var0.host;
		Client.worldId = var0.id;
		Client.worldProperties = var0.properties;
		WorldMapSection1.port1 = Client.gameBuild == 0 ? 43594 : var0.id + 40000;
		IsaacCipher.port2 = Client.gameBuild == 0 ? 443 : var0.id + 50000;
		LoginPacket.port3 = WorldMapSection1.port1;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lhy;IB)V",
		garbageValue = "0"
	)
	@Export("Widget_setKeyIgnoreHeld")
	static final void Widget_setKeyIgnoreHeld(Widget var0, int var1) {
		if (var0.field2671 == null) {
			throw new RuntimeException();
		} else {
			if (var0.field2656 == null) {
				var0.field2656 = new int[var0.field2671.length];
			}

			var0.field2656[var1] = Integer.MAX_VALUE;
		}
	}
}
