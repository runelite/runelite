import java.applet.Applet;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("x")
@Implements("GrandExchangeEvent")
public class GrandExchangeEvent {
	@ObfuscatedName("ss")
	@ObfuscatedSignature(
		signature = "Lld;"
	)
	@Export("worldMap")
	static WorldMap worldMap;
	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	@Export("worldSelectLeftSprite")
	static IndexedSprite worldSelectLeftSprite;
	@ObfuscatedName("kx")
	@ObfuscatedGetter(
		intValue = -830703967
	)
	@Export("menuX")
	static int menuX;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -492844339
	)
	@Export("world")
	public final int world;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		longValue = 6772397130790099757L
	)
	@Export("age")
	public final long age;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Ld;"
	)
	@Export("grandExchangeOffer")
	public final GrandExchangeOffer grandExchangeOffer;
	@ObfuscatedName("w")
	@Export("offerName")
	String offerName;
	@ObfuscatedName("p")
	@Export("previousOfferName")
	String previousOfferName;

	@ObfuscatedSignature(
		signature = "(Lkq;BI)V"
	)
	GrandExchangeEvent(Buffer var1, byte var2, int var3) {
		this.offerName = var1.readStringCp1252NullTerminated();
		this.previousOfferName = var1.readStringCp1252NullTerminated();
		this.world = var1.readUnsignedShort();
		this.age = var1.readLong();
		int var4 = var1.readInt();
		int var5 = var1.readInt();
		this.grandExchangeOffer = new GrandExchangeOffer();
		this.grandExchangeOffer.method99(2);
		this.grandExchangeOffer.method100(var2);
		this.grandExchangeOffer.unitPrice = var4;
		this.grandExchangeOffer.totalQuantity = var5;
		this.grandExchangeOffer.currentQuantity = 0;
		this.grandExchangeOffer.currentPrice = 0;
		this.grandExchangeOffer.id = var3;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "-859042126"
	)
	@Export("getOfferName")
	public String getOfferName() {
		return this.offerName;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "342302982"
	)
	@Export("getPreviousOfferName")
	public String getPreviousOfferName() {
		return this.previousOfferName;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ILjava/lang/String;B)Z",
		garbageValue = "-128"
	)
	static boolean method79(String var0, int var1, String var2) {
		if (var1 == 0) {
			try {
				if (!class50.field410.startsWith("win")) {
					throw new Exception();
				} else if (!var0.startsWith("http://") && !var0.startsWith("https://")) {
					throw new Exception();
				} else {
					String var14 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

					for (int var4 = 0; var4 < var0.length(); ++var4) {
						if (var14.indexOf(var0.charAt(var4)) == -1) {
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
				Applet var7 = class50.applet;
				Object[] var5 = new Object[]{(new URL(class50.applet.getCodeBase(), var0)).toString()};
				Object var13 = JSObject.getWindow(var7).call(var2, var5);
				return var13 != null;
			} catch (Throwable var9) {
				return false;
			}
		} else if (var1 == 2) {
			try {
				class50.applet.getAppletContext().showDocument(new URL(class50.applet.getCodeBase(), var0), "_blank");
				return true;
			} catch (Exception var10) {
				return false;
			}
		} else if (var1 == 3) {
			try {
				Applet var3 = class50.applet;
				JSObject.getWindow(var3).call("loggedout", (Object[])null);
			} catch (Throwable var12) {
			}

			try {
				class50.applet.getAppletContext().showDocument(new URL(class50.applet.getCodeBase(), var0), "_top");
				return true;
			} catch (Exception var11) {
				return false;
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(ILht;ZI)V",
		garbageValue = "1641094625"
	)
	static void method80(int var0, Coord var1, boolean var2) {
		WorldMapArea var3 = Canvas.getWorldMap().getMapArea(var0);
		int var4 = Message.localPlayer.plane;
		int var5 = MusicPatchPcmStream.baseX * 64 + (Message.localPlayer.x >> 7);
		int var6 = ScriptEvent.baseY * 64 + (Message.localPlayer.y >> 7);
		Coord var7 = new Coord(var4, var5, var6);
		Canvas.getWorldMap().method6373(var3, var7, var1, var2);
	}
}
