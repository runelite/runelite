import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("GraphicsObject")
public final class GraphicsObject extends Entity {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1800757053
	)
	@Export("id")
	int id;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 815583153
	)
	@Export("cycleStart")
	int cycleStart;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 497499711
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1418605465
	)
	@Export("x")
	int x;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -744262401
	)
	@Export("y")
	int y;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1599899605
	)
	@Export("height")
	int height;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lip;"
	)
	@Export("sequenceDefinition")
	SequenceDefinition sequenceDefinition;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 715957131
	)
	@Export("frame")
	int frame;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1558881033
	)
	@Export("frameCycle")
	int frameCycle;
	@ObfuscatedName("m")
	@Export("isFinished")
	boolean isFinished;

	GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		this.frame = 0;
		this.frameCycle = 0;
		this.isFinished = false;
		this.id = var1;
		this.plane = var2;
		this.x = var3;
		this.y = var4;
		this.height = var5;
		this.cycleStart = var7 + var6;
		int var8 = class65.SpotAnimationDefinition_get(this.id).sequence;
		if (var8 != -1) {
			this.isFinished = false;
			this.sequenceDefinition = GraphicsDefaults.SequenceDefinition_get(var8);
		} else {
			this.isFinished = true;
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "65536"
	)
	@Export("advance")
	final void advance(int var1) {
		if (!this.isFinished) {
			this.frameCycle += var1;

			while (this.frameCycle > this.sequenceDefinition.frameLengths[this.frame]) {
				this.frameCycle -= this.sequenceDefinition.frameLengths[this.frame];
				++this.frame;
				if (this.frame >= this.sequenceDefinition.frameIds.length) {
					this.isFinished = true;
					break;
				}
			}

		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)Ldx;",
		garbageValue = "-2133076860"
	)
	@Export("getModel")
	protected final Model getModel() {
		SpotAnimationDefinition var1 = class65.SpotAnimationDefinition_get(this.id);
		Model var2;
		if (!this.isFinished) {
			var2 = var1.getModel(this.frame);
		} else {
			var2 = var1.getModel(-1);
		}

		return var2 == null ? null : var2;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)[Lih;",
		garbageValue = "-51"
	)
	static HorizontalAlignment[] method2064() {
		return new HorizontalAlignment[]{HorizontalAlignment.field3454, HorizontalAlignment.HorizontalAlignment_centered, HorizontalAlignment.field3451};
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lii;B)V",
		garbageValue = "66"
	)
	public static void method2063(AbstractArchive var0) {
		StructDefinition.StructDefinition_archive = var0;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(JLjava/lang/String;I)I",
		garbageValue = "-2060202992"
	)
	static final int method2060(long var0, String var2) {
		Random var3 = new Random();
		Buffer var4 = new Buffer(128);
		Buffer var5 = new Buffer(128);
		int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
		var4.writeByte(10);

		int var7;
		for (var7 = 0; var7 < 4; ++var7) {
			var4.writeInt(var3.nextInt());
		}

		var4.writeInt(var6[0]);
		var4.writeInt(var6[1]);
		var4.writeLong(var0);
		var4.writeLong(0L);

		for (var7 = 0; var7 < 4; ++var7) {
			var4.writeInt(var3.nextInt());
		}

		var4.encryptRsa(class80.field1123, class80.field1120);
		var5.writeByte(10);

		for (var7 = 0; var7 < 3; ++var7) {
			var5.writeInt(var3.nextInt());
		}

		var5.writeLong(var3.nextLong());
		var5.writeLongMedium(var3.nextLong());
		if (Client.randomDatData != null) {
			var5.writeBytes(Client.randomDatData, 0, Client.randomDatData.length);
		} else {
			byte[] var8 = new byte[24];

			try {
				JagexCache.JagexCache_randomDat.seek(0L);
				JagexCache.JagexCache_randomDat.readFully(var8);

				int var9;
				for (var9 = 0; var9 < 24 && var8[var9] == 0; ++var9) {
				}

				if (var9 >= 24) {
					throw new IOException();
				}
			} catch (Exception var24) {
				for (int var10 = 0; var10 < 24; ++var10) {
					var8[var10] = -1;
				}
			}

			var5.writeBytes(var8, 0, var8.length);
		}

		var5.writeLong(var3.nextLong());
		var5.encryptRsa(class80.field1123, class80.field1120);
		var7 = Buddy.stringCp1252NullTerminatedByteSize(var2);
		if (var7 % 8 != 0) {
			var7 += 8 - var7 % 8;
		}

		Buffer var25 = new Buffer(var7);
		var25.writeStringCp1252NullTerminated(var2);
		var25.offset = var7;
		var25.xteaEncryptAll(var6);
		Buffer var18 = new Buffer(var25.offset + var4.offset + var5.offset + 5);
		var18.writeByte(2);
		var18.writeByte(var4.offset);
		var18.writeBytes(var4.array, 0, var4.offset);
		var18.writeByte(var5.offset);
		var18.writeBytes(var5.array, 0, var5.offset);
		var18.writeShort(var25.offset);
		var18.writeBytes(var25.array, 0, var25.offset);
		String var20 = Frames.method3340(var18.array);

		try {
			URL var11 = new URL(class42.method809("services", false) + "m=accountappeal/login.ws");
			URLConnection var12 = var11.openConnection();
			var12.setDoInput(true);
			var12.setDoOutput(true);
			var12.setConnectTimeout(5000);
			OutputStreamWriter var13 = new OutputStreamWriter(var12.getOutputStream());
			var13.write("data2=" + ArchiveDiskAction.method4216(var20) + "&dest=" + ArchiveDiskAction.method4216("passwordchoice.ws"));
			var13.flush();
			InputStream var14 = var12.getInputStream();
			var18 = new Buffer(new byte[1000]);

			do {
				int var15 = var14.read(var18.array, var18.offset, 1000 - var18.offset);
				if (var15 == -1) {
					var13.close();
					var14.close();
					String var21 = new String(var18.array);
					if (var21.startsWith("OFFLINE")) {
						return 4;
					} else if (var21.startsWith("WRONG")) {
						return 7;
					} else if (var21.startsWith("RELOAD")) {
						return 3;
					} else if (var21.startsWith("Not permitted for social network accounts.")) {
						return 6;
					} else {
						var18.xteaDecryptAll(var6);

						while (var18.offset > 0 && var18.array[var18.offset - 1] == 0) {
							--var18.offset;
						}

						var21 = new String(var18.array, 0, var18.offset);
						boolean var16;
						if (var21 == null) {
							var16 = false;
						} else {
							label107: {
								try {
									new URL(var21);
								} catch (MalformedURLException var22) {
									var16 = false;
									break label107;
								}

								var16 = true;
							}
						}

						if (var16) {
							class215.openURL(var21, true, false);
							return 2;
						} else {
							return 5;
						}
					}
				}

				var18.offset += var15;
			} while(var18.offset < 1000);

			return 5;
		} catch (Throwable var23) {
			var23.printStackTrace();
			return 5;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IB)Lix;",
		garbageValue = "52"
	)
	public static FloorUnderlayDefinition method2055(int var0) {
		FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.FloorUnderlayDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = FloorUnderlayDefinition.FloorUnderlayDefinition_archive.takeFile(1, var0);
			var1 = new FloorUnderlayDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2), var0);
			}

			var1.postDecode();
			FloorUnderlayDefinition.FloorUnderlayDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("ic")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;IIIIS)V",
		garbageValue = "3604"
	)
	@Export("insertMenuItemNoShift")
	public static final void insertMenuItemNoShift(String var0, String var1, int var2, int var3, int var4, int var5) {
		class160.insertMenuItem(var0, var1, var2, var3, var4, var5, false);
	}
}
