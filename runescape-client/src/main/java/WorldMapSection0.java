import java.applet.Applet;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("a")
@Implements("WorldMapSection0")
public class WorldMapSection0 implements WorldMapSection {
	@ObfuscatedName("qc")
	@ObfuscatedGetter(
		intValue = 2121568877
	)
	static int field129;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1843368435
	)
	@Export("oldZ")
	int oldZ;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1967867601
	)
	@Export("newZ")
	int newZ;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 59619681
	)
	@Export("oldX")
	int oldX;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1129571555
	)
	@Export("oldY")
	int oldY;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1545521373
	)
	@Export("newX")
	int newX;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1178438045
	)
	@Export("newY")
	int newY;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1044467109
	)
	@Export("oldChunkXLow")
	int oldChunkXLow;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 2073431393
	)
	@Export("oldChunkYLow")
	int oldChunkYLow;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1873956173
	)
	@Export("oldChunkXHigh")
	int oldChunkXHigh;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -263670183
	)
	@Export("oldChunkYHigh")
	int oldChunkYHigh;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -631680795
	)
	@Export("newChunkXLow")
	int newChunkXLow;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1516769831
	)
	@Export("newChunkYLow")
	int newChunkYLow;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1418040295
	)
	@Export("newChunkXHigh")
	int newChunkXHigh;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -779321503
	)
	@Export("newChunkYHigh")
	int newChunkYHigh;

	WorldMapSection0() {
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lav;I)V",
		garbageValue = "-1068467910"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.newX) {
			var1.regionLowX = this.newX;
		}

		if (var1.regionHighX < this.newX) {
			var1.regionHighX = this.newX;
		}

		if (var1.regionLowY > this.newY) {
			var1.regionLowY = this.newY;
		}

		if (var1.regionHighY < this.newY) {
			var1.regionHighY = this.newY;
		}

	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "1014871771"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.oldZ && var1 < this.newZ + this.oldZ) {
			return var2 >= (this.oldX << 6) + (this.oldChunkXLow << 3) && var2 <= (this.oldX << 6) + (this.oldChunkXHigh << 3) + 7 && var3 >= (this.oldY << 6) + (this.oldChunkYLow << 3) && var3 <= (this.oldY << 6) + (this.oldChunkYHigh << 3) + 7;
		} else {
			return false;
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "694688168"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >= (this.newX << 6) + (this.newChunkXLow << 3) && var1 <= (this.newX << 6) + (this.newChunkXHigh << 3) + 7 && var2 >= (this.newY << 6) + (this.newChunkYLow << 3) && var2 <= (this.newY << 6) + (this.newChunkYHigh << 3) + 7;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "-45443461"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{this.newX * 64 - this.oldX * 64 + var2 + (this.newChunkXLow * 8 - this.oldChunkXLow * 8), var3 + (this.newY * 64 - this.oldY * 64) + (this.newChunkYLow * 8 - this.oldChunkYLow * 8)};
			return var4;
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(III)Lhd;",
		garbageValue = "1267204541"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.oldX * 64 - this.newX * 64 + (this.oldChunkXLow * 8 - this.newChunkXLow * 8) + var1;
			int var4 = this.oldY * 64 - this.newY * 64 + var2 + (this.oldChunkYLow * 8 - this.newChunkYLow * 8);
			return new Coord(this.oldZ, var3, var4);
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lky;I)V",
		garbageValue = "1072299144"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.oldZ = var1.readUnsignedByte();
		this.newZ = var1.readUnsignedByte();
		this.oldX = var1.readUnsignedShort();
		this.oldChunkXLow = var1.readUnsignedByte();
		this.oldChunkXHigh = var1.readUnsignedByte();
		this.oldY = var1.readUnsignedShort();
		this.oldChunkYLow = var1.readUnsignedByte();
		this.oldChunkYHigh = var1.readUnsignedByte();
		this.newX = var1.readUnsignedShort();
		this.newChunkXLow = var1.readUnsignedByte();
		this.newChunkXHigh = var1.readUnsignedByte();
		this.newY = var1.readUnsignedShort();
		this.newChunkYLow = var1.readUnsignedByte();
		this.newChunkYHigh = var1.readUnsignedByte();
		this.postRead();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "105"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "([BIII)Ljava/lang/String;",
		garbageValue = "44636829"
	)
	static String method211(byte[] var0, int var1, int var2) {
		StringBuilder var3 = new StringBuilder();

		for (int var4 = var1; var4 < var2 + var1; var4 += 3) {
			int var5 = var0[var4] & 255;
			var3.append(class289.field3631[var5 >>> 2]);
			if (var4 < var2 - 1) {
				int var6 = var0[var4 + 1] & 255;
				var3.append(class289.field3631[(var5 & 3) << 4 | var6 >>> 4]);
				if (var4 < var2 - 2) {
					int var7 = var0[var4 + 2] & 255;
					var3.append(class289.field3631[(var6 & 15) << 2 | var7 >>> 6]).append(class289.field3631[var7 & 63]);
				} else {
					var3.append(class289.field3631[(var6 & 15) << 2]).append("=");
				}
			} else {
				var3.append(class289.field3631[(var5 & 3) << 4]).append("==");
			}
		}

		return var3.toString();
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "956806000"
	)
	public static int method215(int var0, int var1) {
		int var2;
		for (var2 = 0; var1 > 0; --var1) {
			var2 = var2 << 1 | var0 & 1;
			var0 >>>= 1;
		}

		return var2;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ILjava/lang/String;B)Z",
		garbageValue = "44"
	)
	static boolean method232(String var0, int var1, String var2) {
		if (var1 == 0) {
			try {
				if (!class51.field404.startsWith("win")) {
					throw new Exception();
				} else if (!var0.startsWith("http://") && !var0.startsWith("https://")) {
					throw new Exception();
				} else {
					String var11 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

					for (int var4 = 0; var4 < var0.length(); ++var4) {
						if (var11.indexOf(var0.charAt(var4)) == -1) {
							throw new Exception();
						}
					}

					Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
					return true;
				}
			} catch (Throwable var5) {
				return false;
			}
		} else if (var1 == 1) {
			try {
				Object var10 = class47.method795(class51.applet, var2, new Object[]{(new URL(class51.applet.getCodeBase(), var0)).toString()});
				return var10 != null;
			} catch (Throwable var6) {
				return false;
			}
		} else if (var1 == 2) {
			try {
				class51.applet.getAppletContext().showDocument(new URL(class51.applet.getCodeBase(), var0), "_blank");
				return true;
			} catch (Exception var7) {
				return false;
			}
		} else if (var1 == 3) {
			try {
				Applet var3 = class51.applet;
				JSObject.getWindow(var3).call("loggedout", (Object[])null);
			} catch (Throwable var9) {
			}

			try {
				class51.applet.getAppletContext().showDocument(new URL(class51.applet.getCodeBase(), var0), "_top");
				return true;
			} catch (Exception var8) {
				return false;
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("lz")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "905677752"
	)
	static void method221() {
		Client.packetWriter.addNode(MenuAction.getPacketBufferNode(ClientPacket.field2222, Client.packetWriter.isaacCipher));
		Client.oculusOrbState = 0;
	}

	@ObfuscatedName("lo")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "1"
	)
	static void method230() {
		if (GameObject.field1921 != null) {
			Client.field892 = Client.cycle;
			GameObject.field1921.method4241();

			for (int var0 = 0; var0 < Client.players.length; ++var0) {
				if (Client.players[var0] != null) {
					GameObject.field1921.method4237(PacketWriter.baseX * 64 + (Client.players[var0].x >> 7), RouteStrategy.baseY * 64 + (Client.players[var0].y >> 7));
				}
			}
		}

	}
}
