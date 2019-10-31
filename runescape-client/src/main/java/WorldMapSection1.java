import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
@Implements("WorldMapSection1")
public class WorldMapSection1 implements WorldMapSection {
	@ObfuscatedName("br")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	@Export("clientLanguage")
	static Language clientLanguage;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1154068221
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1054158347
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1028854111
	)
	@Export("regionStartX")
	int regionStartX;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1350471723
	)
	@Export("regionStartY")
	int regionStartY;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1028705705
	)
	@Export("regionEndX")
	int regionEndX;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -615162757
	)
	@Export("regionEndY")
	int regionEndY;

	WorldMapSection1() {
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Laa;B)V",
		garbageValue = "-111"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.regionEndX) {
			var1.regionLowX = this.regionEndX;
		}

		if (var1.regionHighX < this.regionEndX) {
			var1.regionHighX = this.regionEndX;
		}

		if (var1.regionLowY > this.regionEndY) {
			var1.regionLowY = this.regionEndY;
		}

		if (var1.regionHighY < this.regionEndY) {
			var1.regionHighY = this.regionEndY;
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "-1417818612"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.minPlane + this.planes) {
			return var2 >> 6 == this.regionStartX && var3 >> 6 == this.regionStartY;
		} else {
			return false;
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-2132898041"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >> 6 == this.regionEndX && var2 >> 6 == this.regionEndY;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "1209167521"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{this.regionEndX * 64 - this.regionStartX * 64 + var2, var3 + (this.regionEndY * 64 - this.regionStartY * 64)};
			return var4;
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IIS)Lhf;",
		garbageValue = "7283"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.regionStartX * 64 - this.regionEndX * 64 + var1;
			int var4 = this.regionStartY * 64 - this.regionEndY * 64 + var2;
			return new Coord(this.minPlane, var3, var4);
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lkc;I)V",
		garbageValue = "-568369534"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.minPlane = var1.readUnsignedByte();
		this.planes = var1.readUnsignedByte();
		this.regionStartX = var1.readUnsignedShort();
		this.regionStartY = var1.readUnsignedShort();
		this.regionEndX = var1.readUnsignedShort();
		this.regionEndY = var1.readUnsignedShort();
		this.postRead();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "0"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("a")
	static double method636(double var0, double var2, double var4) {
		double var8 = (var0 - var2) / var4;
		double var6 = Math.exp(var8 * -var8 / 2.0D) / Math.sqrt(6.283185307179586D);
		return var6 / var4;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "([BS)Llx;",
		garbageValue = "-10858"
	)
	@Export("convertJpgToSprite")
	public static final Sprite convertJpgToSprite(byte[] var0) {
		BufferedImage var1 = null;

		try {
			var1 = ImageIO.read(new ByteArrayInputStream(var0));
			int var2 = var1.getWidth();
			int var3 = var1.getHeight();
			int[] var4 = new int[var2 * var3];
			PixelGrabber var5 = new PixelGrabber(var1, 0, 0, var2, var3, var4, 0, var2);
			var5.grabPixels();
			return new Sprite(var4, var2, var3);
		} catch (IOException var7) {
		} catch (InterruptedException var8) {
		}

		return new Sprite(0, 0);
	}

	@ObfuscatedName("hf")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1373255332"
	)
	static final void method622() {
		Client.field745 = 0;
		int var0 = UserComparator8.baseX * 64 + (class215.localPlayer.x >> 7);
		int var1 = HealthBar.baseY * 64 + (class215.localPlayer.y >> 7);
		if (var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
			Client.field745 = 1;
		}

		if (var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
			Client.field745 = 1;
		}

		if (Client.field745 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
			Client.field745 = 0;
		}

	}

	@ObfuscatedName("lk")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1886233259"
	)
	static void method650() {
		if (Client.oculusOrbState == 1) {
			Client.field645 = true;
		}

	}
}
