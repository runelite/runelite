import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
@Implements("UrlRequester")
public class UrlRequester implements Runnable {
	@ObfuscatedName("gn")
	@Export("regionLandArchives")
	static byte[][] regionLandArchives;
	@ObfuscatedName("hb")
	@ObfuscatedGetter(
		intValue = -65542583
	)
	@Export("cameraX")
	static int cameraX;
	@ObfuscatedName("a")
	@Export("thread")
	final Thread thread;
	@ObfuscatedName("t")
	@Export("isClosed")
	volatile boolean isClosed;
	@ObfuscatedName("n")
	@Export("requests")
	Queue requests;

	public UrlRequester() {
		this.requests = new LinkedList();
		this.thread = new Thread(this);
		this.thread.setPriority(1);
		this.thread.start();
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Ljava/net/URL;I)Ler;",
		garbageValue = "575867579"
	)
	@Export("request")
	public UrlRequest request(URL var1) {
		UrlRequest var2 = new UrlRequest(var1);
		synchronized(this) {
			this.requests.add(var2);
			this.notify();
			return var2;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1752528799"
	)
	@Export("close")
	public void close() {
		this.isClosed = true;

		try {
			synchronized(this) {
				this.notify();
			}

			this.thread.join();
		} catch (InterruptedException var4) {
		}

	}

	public void run() {
		while (!this.isClosed) {
			try {
				UrlRequest var1;
				synchronized(this) {
					var1 = (UrlRequest)this.requests.poll();
					if (var1 == null) {
						try {
							this.wait();
						} catch (InterruptedException var13) {
						}
						continue;
					}
				}

				DataInputStream var2 = null;
				URLConnection var3 = null;

				try {
					var3 = var1.url.openConnection();
					var3.setConnectTimeout(5000);
					var3.setReadTimeout(5000);
					var3.setUseCaches(false);
					var3.setRequestProperty("Connection", "close");
					int var7 = var3.getContentLength();
					if (var7 >= 0) {
						byte[] var5 = new byte[var7];
						var2 = new DataInputStream(var3.getInputStream());
						var2.readFully(var5);
						var1.response0 = var5;
					}

					var1.isDone0 = true;
				} catch (IOException var14) {
					var1.isDone0 = true;
				} finally {
					if (var2 != null) {
						var2.close();
					}

					if (var3 != null && var3 instanceof HttpURLConnection) {
						((HttpURLConnection)var3).disconnect();
					}

				}
			} catch (Exception var17) {
				User.RunException_sendStackTrace((String)null, var17);
			}
		}

	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "70"
	)
	public static void method3428(boolean var0) {
		if (NetCache.NetCache_socket != null) {
			try {
				Buffer var1 = new Buffer(4);
				var1.writeByte(var0 ? 2 : 3);
				var1.writeMedium(0);
				NetCache.NetCache_socket.write(var1.array, 0, 4);
			} catch (IOException var4) {
				try {
					NetCache.NetCache_socket.close();
				} catch (Exception var3) {
				}

				++NetCache.NetCache_ioExceptions;
				NetCache.NetCache_socket = null;
			}

		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "693068962"
	)
	@Export("changeWorldSelectSorting")
	static void changeWorldSelectSorting(int var0, int var1) {
		int[] var2 = new int[4];
		int[] var3 = new int[4];
		var2[0] = var0;
		var3[0] = var1;
		int var4 = 1;

		for (int var5 = 0; var5 < 4; ++var5) {
			if (World.World_sortOption1[var5] != var0) {
				var2[var4] = World.World_sortOption1[var5];
				var3[var4] = World.World_sortOption2[var5];
				++var4;
			}
		}

		World.World_sortOption1 = var2;
		World.World_sortOption2 = var3;
		class2.sortWorlds(Username.World_worlds, 0, Username.World_worlds.length - 1, World.World_sortOption1, World.World_sortOption2);
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(Lks;Lks;I)V",
		garbageValue = "149989197"
	)
	static void method3430(Font var0, Font var1) {
		int var4;
		int var5;
		if (GrandExchangeEvent.worldSelectBackSprites == null) {
			Archive var3 = GrandExchangeOfferUnitPriceComparator.archive8;
			var4 = var3.getGroupId("sl_back");
			var5 = var3.getFileId(var4, "");
			Sprite[] var2 = class83.SpriteBuffer_getSpriteArray(var3, var4, var5);
			GrandExchangeEvent.worldSelectBackSprites = var2;
		}

		if (JagexCache.worldSelectFlagSprites == null) {
			JagexCache.worldSelectFlagSprites = PlayerAppearance.method4160(GrandExchangeOfferUnitPriceComparator.archive8, "sl_flags", "");
		}

		if (StudioGame.worldSelectArrows == null) {
			StudioGame.worldSelectArrows = PlayerAppearance.method4160(GrandExchangeOfferUnitPriceComparator.archive8, "sl_arrows", "");
		}

		if (Interpreter.worldSelectStars == null) {
			Interpreter.worldSelectStars = PlayerAppearance.method4160(GrandExchangeOfferUnitPriceComparator.archive8, "sl_stars", "");
		}

		if (class288.worldSelectLeftSprite == null) {
			class288.worldSelectLeftSprite = ClientPacket.SpriteBuffer_getIndexedSpriteByName(GrandExchangeOfferUnitPriceComparator.archive8, "leftarrow", "");
		}

		if (WorldMapSection2.worldSelectRightSprite == null) {
			WorldMapSection2.worldSelectRightSprite = ClientPacket.SpriteBuffer_getIndexedSpriteByName(GrandExchangeOfferUnitPriceComparator.archive8, "rightarrow", "");
		}

		Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding, 23, 765, 480, 0);
		Rasterizer2D.Rasterizer2D_fillRectangleGradient(Login.xPadding, 0, 125, 23, 12425273, 9135624);
		Rasterizer2D.Rasterizer2D_fillRectangleGradient(Login.xPadding + 125, 0, 640, 23, 5197647, 2697513);
		var0.drawCentered("Select a world", Login.xPadding + 62, 15, 0, -1);
		if (Interpreter.worldSelectStars != null) {
			Interpreter.worldSelectStars[1].drawAt(Login.xPadding + 140, 1);
			var1.draw("Members only world", Login.xPadding + 152, 10, 16777215, -1);
			Interpreter.worldSelectStars[0].drawAt(Login.xPadding + 140, 12);
			var1.draw("Free world", Login.xPadding + 152, 21, 16777215, -1);
		}

		if (StudioGame.worldSelectArrows != null) {
			int var22 = Login.xPadding + 280;
			if (World.World_sortOption1[0] == 0 && World.World_sortOption2[0] == 0) {
				StudioGame.worldSelectArrows[2].drawAt(var22, 4);
			} else {
				StudioGame.worldSelectArrows[0].drawAt(var22, 4);
			}

			if (World.World_sortOption1[0] == 0 && World.World_sortOption2[0] == 1) {
				StudioGame.worldSelectArrows[3].drawAt(var22 + 15, 4);
			} else {
				StudioGame.worldSelectArrows[1].drawAt(var22 + 15, 4);
			}

			var0.draw("World", var22 + 32, 17, 16777215, -1);
			int var23 = Login.xPadding + 390;
			if (World.World_sortOption1[0] == 1 && World.World_sortOption2[0] == 0) {
				StudioGame.worldSelectArrows[2].drawAt(var23, 4);
			} else {
				StudioGame.worldSelectArrows[0].drawAt(var23, 4);
			}

			if (World.World_sortOption1[0] == 1 && World.World_sortOption2[0] == 1) {
				StudioGame.worldSelectArrows[3].drawAt(var23 + 15, 4);
			} else {
				StudioGame.worldSelectArrows[1].drawAt(var23 + 15, 4);
			}

			var0.draw("Players", var23 + 32, 17, 16777215, -1);
			var4 = Login.xPadding + 500;
			if (World.World_sortOption1[0] == 2 && World.World_sortOption2[0] == 0) {
				StudioGame.worldSelectArrows[2].drawAt(var4, 4);
			} else {
				StudioGame.worldSelectArrows[0].drawAt(var4, 4);
			}

			if (World.World_sortOption1[0] == 2 && World.World_sortOption2[0] == 1) {
				StudioGame.worldSelectArrows[3].drawAt(var4 + 15, 4);
			} else {
				StudioGame.worldSelectArrows[1].drawAt(var4 + 15, 4);
			}

			var0.draw("Location", var4 + 32, 17, 16777215, -1);
			var5 = Login.xPadding + 610;
			if (World.World_sortOption1[0] == 3 && World.World_sortOption2[0] == 0) {
				StudioGame.worldSelectArrows[2].drawAt(var5, 4);
			} else {
				StudioGame.worldSelectArrows[0].drawAt(var5, 4);
			}

			if (World.World_sortOption1[0] == 3 && World.World_sortOption2[0] == 1) {
				StudioGame.worldSelectArrows[3].drawAt(var5 + 15, 4);
			} else {
				StudioGame.worldSelectArrows[1].drawAt(var5 + 15, 4);
			}

			var0.draw("Type", var5 + 32, 17, 16777215, -1);
		}

		Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding + 708, 4, 50, 16, 0);
		var1.drawCentered("Cancel", Login.xPadding + 708 + 25, 16, 16777215, -1);
		Login.hoveredWorldIndex = -1;
		if (GrandExchangeEvent.worldSelectBackSprites != null) {
			byte var26 = 88;
			byte var27 = 19;
			var4 = 765 / (var26 + 1) - 1;
			var5 = 480 / (var27 + 1);

			int var6;
			int var7;
			do {
				var6 = var5;
				var7 = var4;
				if (var5 * (var4 - 1) >= World.World_count) {
					--var4;
				}

				if (var4 * (var5 - 1) >= World.World_count) {
					--var5;
				}

				if (var4 * (var5 - 1) >= World.World_count) {
					--var5;
				}
			} while(var5 != var6 || var4 != var7);

			var6 = (765 - var26 * var4) / (var4 + 1);
			if (var6 > 5) {
				var6 = 5;
			}

			var7 = (480 - var5 * var27) / (var5 + 1);
			if (var7 > 5) {
				var7 = 5;
			}

			int var8 = (765 - var26 * var4 - var6 * (var4 - 1)) / 2;
			int var9 = (480 - var5 * var27 - var7 * (var5 - 1)) / 2;
			int var10 = (var5 + World.World_count - 1) / var5;
			Login.worldSelectPagesCount = var10 - var4;
			if (class288.worldSelectLeftSprite != null && Login.worldSelectPage > 0) {
				class288.worldSelectLeftSprite.drawAt(8, FloorUnderlayDefinition.canvasHeight / 2 - class288.worldSelectLeftSprite.subHeight / 2);
			}

			if (WorldMapSection2.worldSelectRightSprite != null && Login.worldSelectPage < Login.worldSelectPagesCount) {
				WorldMapSection2.worldSelectRightSprite.drawAt(class286.canvasWidth - WorldMapSection2.worldSelectRightSprite.subWidth - 8, FloorUnderlayDefinition.canvasHeight / 2 - WorldMapSection2.worldSelectRightSprite.subHeight / 2);
			}

			int var11 = var9 + 23;
			int var12 = var8 + Login.xPadding;
			int var13 = 0;
			boolean var14 = false;
			int var15 = Login.worldSelectPage;

			int var16;
			for (var16 = var5 * var15; var16 < World.World_count && var15 - Login.worldSelectPage < var4; ++var16) {
				World var24 = Username.World_worlds[var16];
				boolean var18 = true;
				String var19 = Integer.toString(var24.population);
				if (var24.population == -1) {
					var19 = "OFF";
					var18 = false;
				} else if (var24.population > 1980) {
					var19 = "FULL";
					var18 = false;
				}

				int var21 = 0;
				byte var20;
				if (var24.isBeta()) {
					if (var24.isMembersOnly()) {
						var20 = 7;
					} else {
						var20 = 6;
					}
				} else if (var24.isDeadman()) {
					var21 = 16711680;
					if (var24.isMembersOnly()) {
						var20 = 5;
					} else {
						var20 = 4;
					}
				} else if (var24.method1887()) {
					var20 = 8;
				} else if (var24.isPvp()) {
					if (var24.isMembersOnly()) {
						var20 = 3;
					} else {
						var20 = 2;
					}
				} else if (var24.isMembersOnly()) {
					var20 = 1;
				} else {
					var20 = 0;
				}

				if (MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var11 && MouseHandler.MouseHandler_x < var12 + var26 && MouseHandler.MouseHandler_y < var27 + var11 && var18) {
					Login.hoveredWorldIndex = var16;
					GrandExchangeEvent.worldSelectBackSprites[var20].drawTransOverlayAt(var12, var11, 128, 16777215);
					var14 = true;
				} else {
					GrandExchangeEvent.worldSelectBackSprites[var20].drawAt(var12, var11);
				}

				if (JagexCache.worldSelectFlagSprites != null) {
					JagexCache.worldSelectFlagSprites[(var24.isMembersOnly() ? 8 : 0) + var24.location].drawAt(var12 + 29, var11);
				}

				var0.drawCentered(Integer.toString(var24.id), var12 + 15, var27 / 2 + var11 + 5, var21, -1);
				var1.drawCentered(var19, var12 + 60, var27 / 2 + var11 + 5, 268435455, -1);
				var11 = var11 + var7 + var27;
				++var13;
				if (var13 >= var5) {
					var11 = var9 + 23;
					var12 = var12 + var6 + var26;
					var13 = 0;
					++var15;
				}
			}

			if (var14) {
				var16 = var1.stringWidth(Username.World_worlds[Login.hoveredWorldIndex].activity) + 6;
				int var17 = var1.ascent + 8;
				int var25 = MouseHandler.MouseHandler_y + 25;
				if (var25 + var17 > 480) {
					var25 = MouseHandler.MouseHandler_y - 25 - var17;
				}

				Rasterizer2D.Rasterizer2D_fillRectangle(MouseHandler.MouseHandler_x - var16 / 2, var25, var16, var17, 16777120);
				Rasterizer2D.Rasterizer2D_drawRectangle(MouseHandler.MouseHandler_x - var16 / 2, var25, var16, var17, 0);
				var1.drawCentered(Username.World_worlds[Login.hoveredWorldIndex].activity, MouseHandler.MouseHandler_x, var25 + var1.ascent + 4, 0, -1);
			}
		}

		AbstractWorldMapData.rasterProvider.drawFull(0, 0);
	}

	@ObfuscatedName("jd")
	@ObfuscatedSignature(
		signature = "(IIIIIII)V",
		garbageValue = "710444841"
	)
	static final void method3431(int var0, int var1, int var2, int var3, int var4, int var5) {
		int var6 = var2 - var0;
		int var7 = var3 - var1;
		int var8 = var6 >= 0 ? var6 : -var6;
		int var9 = var7 >= 0 ? var7 : -var7;
		int var10 = var8;
		if (var8 < var9) {
			var10 = var9;
		}

		if (var10 != 0) {
			int var11 = (var6 << 16) / var10;
			int var12 = (var7 << 16) / var10;
			if (var12 <= var11) {
				var11 = -var11;
			} else {
				var12 = -var12;
			}

			int var13 = var5 * var12 >> 17;
			int var14 = var5 * var12 + 1 >> 17;
			int var15 = var5 * var11 >> 17;
			int var16 = var5 * var11 + 1 >> 17;
			var0 -= Rasterizer2D.Rasterizer2D_xClipStart;
			var1 -= Rasterizer2D.Rasterizer2D_yClipStart;
			int var17 = var0 + var13;
			int var18 = var0 - var14;
			int var19 = var0 + var6 - var14;
			int var20 = var0 + var6 + var13;
			int var21 = var15 + var1;
			int var22 = var1 - var16;
			int var23 = var7 + var1 - var16;
			int var24 = var15 + var7 + var1;
			Rasterizer3D.method3125(var17, var18, var19);
			Rasterizer3D.method3134(var21, var22, var23, var17, var18, var19, var4);
			Rasterizer3D.method3125(var17, var19, var20);
			Rasterizer3D.method3134(var21, var23, var24, var17, var19, var20, var4);
		}
	}
}
