import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
public class class238 {
	@ObfuscatedName("c")
	@Export("spriteMap")
	final HashMap spriteMap;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	@Export("bounds")
	Bounds bounds;
	@ObfuscatedName("o")
	int[] field3189;
	@ObfuscatedName("e")
	int[] field3187;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -63300003
	)
	int field3190;

	public class238() {
		this.spriteMap = new HashMap();
		this.bounds = new Bounds(0, 0);
		this.field3189 = new int[2048];
		this.field3187 = new int[2048];
		this.field3190 = 0;
		class218.field2718 = new int[2000];
		int var1 = 0;
		int var2 = 240;

		int var4;
		for (byte var3 = 12; var1 < 16; var2 -= var3) {
			var4 = Decimator.method2600((double)((float)var2 / 360.0F), 0.9998999834060669D, (double)(0.075F + (float)var1 * 0.425F / 16.0F));
			class218.field2718[var1] = var4;
			++var1;
		}

		var2 = 48;

		for (int var6 = var2 / 6; var1 < class218.field2718.length; var2 -= var6) {
			var4 = var1 * 2;

			for (int var5 = Decimator.method2600((double)((float)var2 / 360.0F), 0.9998999834060669D, 0.5D); var1 < var4 && var1 < class218.field2718.length; ++var1) {
				class218.field2718[var1] = var5;
			}
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1042631612"
	)
	void method4393(int var1) {
		int var2 = var1 * 2 + 1;
		double[] var3 = BufferedSink.method5902(0.0D, (double)((float)var1 / 3.0F), var1);
		double var4 = var3[var1] * var3[var1];
		int[] var6 = new int[var2 * var2];
		boolean var7 = false;

		for (int var8 = 0; var8 < var2; ++var8) {
			for (int var9 = 0; var9 < var2; ++var9) {
				int var10 = var6[var9 + var8 * var2] = (int)(var3[var8] * var3[var9] / var4 * 256.0D);
				if (!var7 && var10 > 0) {
					var7 = true;
				}
			}
		}

		Sprite var11 = new Sprite(var6, var2, var2);
		this.spriteMap.put(var1, var11);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IB)Llt;",
		garbageValue = "-100"
	)
	Sprite method4396(int var1) {
		if (!this.spriteMap.containsKey(var1)) {
			this.method4393(var1);
		}

		return (Sprite)this.spriteMap.get(var1);
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "45"
	)
	public final void method4408(int var1, int var2) {
		if (this.field3190 < this.field3189.length) {
			this.field3189[this.field3190] = var1;
			this.field3187[this.field3190] = var2;
			++this.field3190;
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "0"
	)
	public final void method4395() {
		this.field3190 = 0;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IILlt;FB)V",
		garbageValue = "111"
	)
	public final void method4404(int var1, int var2, Sprite var3, float var4) {
		int var5 = (int)(18.0F * var4);
		Sprite var6 = this.method4396(var5);
		int var7 = var5 * 2 + 1;
		Bounds var8 = new Bounds(0, 0, var3.subWidth, var3.subHeight);
		Bounds var9 = new Bounds(0, 0);
		this.bounds.setHigh(var7, var7);
		System.nanoTime();

		int var10;
		int var11;
		int var12;
		for (var10 = 0; var10 < this.field3190; ++var10) {
			var11 = this.field3189[var10];
			var12 = this.field3187[var10];
			int var13 = (int)(var4 * (float)(var11 - var1)) - var5;
			int var14 = (int)((float)var3.subHeight - var4 * (float)(var12 - var2)) - var5;
			this.bounds.setLow(var13, var14);
			this.bounds.method6031(var8, var9);
			this.method4397(var6, var3, var9);
		}

		System.nanoTime();
		System.nanoTime();

		for (var10 = 0; var10 < var3.pixels.length; ++var10) {
			if (var3.pixels[var10] == 0) {
				var3.pixels[var10] = -16777216;
			} else {
				var11 = (var3.pixels[var10] + 64 - 1) / 256;
				if (var11 <= 0) {
					var3.pixels[var10] = -16777216;
				} else {
					if (var11 > class218.field2718.length) {
						var11 = class218.field2718.length;
					}

					var12 = class218.field2718[var11 - 1];
					var3.pixels[var10] = -16777216 | var12;
				}
			}
		}

		System.nanoTime();
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Llt;Llt;Lll;I)V",
		garbageValue = "-1243462627"
	)
	void method4397(Sprite var1, Sprite var2, Bounds var3) {
		if (var3.highX != 0 && var3.highY != 0) {
			int var4 = 0;
			int var5 = 0;
			if (var3.lowX == 0) {
				var4 = var1.subWidth - var3.highX;
			}

			if (var3.lowY == 0) {
				var5 = var1.subHeight - var3.highY;
			}

			int var6 = var4 + var5 * var1.subWidth;
			int var7 = var2.subWidth * var3.lowY + var3.lowX;

			for (int var8 = 0; var8 < var3.highY; ++var8) {
				for (int var9 = 0; var9 < var3.highX; ++var9) {
					int[] var10000 = var2.pixels;
					int var10001 = var7++;
					var10000[var10001] += var1.pixels[var6++];
				}

				var6 += var1.subWidth - var3.highX;
				var7 += var2.subWidth - var3.highX;
			}

		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "-1969161403"
	)
	static boolean method4414(char var0) {
		return "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".indexOf(var0) != -1;
	}

	@ObfuscatedName("gl")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "-28085"
	)
	static void method4415() {
		PacketBufferNode var0 = TilePaint.getPacketBufferNode(ClientPacket.field2289, Client.packetWriter.isaacCipher);
		var0.packetBuffer.writeByte(Friend.getWindowedMode());
		var0.packetBuffer.writeShort(Username.canvasWidth);
		var0.packetBuffer.writeShort(WorldMapData_1.canvasHeight);
		Client.packetWriter.addNode(var0);
	}
}
