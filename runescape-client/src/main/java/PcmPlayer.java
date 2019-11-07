import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
@Implements("PcmPlayer")
public class PcmPlayer {
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -326357542
	)
	@Export("PcmPlayer_sampleRate")
	public static int PcmPlayer_sampleRate;
	@ObfuscatedName("k")
	@Export("samples")
	protected int[] samples;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Ldj;"
	)
	@Export("stream")
	PcmStream stream;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1561038713
	)
	int field1394;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		longValue = -4392841547696202379L
	)
	@Export("timeMs")
	long timeMs;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1043621473
	)
	@Export("capacity")
	int capacity;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 87415669
	)
	int field1388;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 692811819
	)
	int field1389;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		longValue = -5109190258343752079L
	)
	long field1390;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -728002027
	)
	int field1384;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1330759581
	)
	int field1380;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1355026859
	)
	int field1393;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		longValue = 8313708391947362675L
	)
	long field1396;
	@ObfuscatedName("y")
	boolean field1395;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = 232307999
	)
	int field1392;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "[Ldj;"
	)
	PcmStream[] field1397;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "[Ldj;"
	)
	PcmStream[] field1398;

	protected PcmPlayer() {
		this.field1394 = 32;
		this.timeMs = PlayerAppearance.currentTimeMillis();
		this.field1390 = 0L;
		this.field1384 = 0;
		this.field1380 = 0;
		this.field1393 = 0;
		this.field1396 = 0L;
		this.field1395 = true;
		this.field1392 = 0;
		this.field1397 = new PcmStream[8];
		this.field1398 = new PcmStream[8];
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-122"
	)
	@Export("init")
	protected void init() throws Exception {
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1329305761"
	)
	@Export("open")
	protected void open(int var1) throws Exception {
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-2053382901"
	)
	@Export("position")
	protected int position() throws Exception {
		return this.capacity;
	}

	@ObfuscatedName("q")
	@Export("write")
	protected void write() throws Exception {
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-359946727"
	)
	@Export("close")
	protected void close() {
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "47548316"
	)
	@Export("discard")
	protected void discard() throws Exception {
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(Ldj;S)V",
		garbageValue = "2001"
	)
	@Export("setStream")
	public final synchronized void setStream(PcmStream var1) {
		this.stream = var1;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-162724995"
	)
	@Export("run")
	public final synchronized void run() {
		if (this.samples != null) {
			long var1 = PlayerAppearance.currentTimeMillis();

			try {
				if (0L != this.field1390) {
					if (var1 < this.field1390) {
						return;
					}

					this.open(this.capacity);
					this.field1390 = 0L;
					this.field1395 = true;
				}

				int var3 = this.position();
				if (this.field1393 - var3 > this.field1384) {
					this.field1384 = this.field1393 - var3;
				}

				int var4 = this.field1389 + this.field1388;
				if (var4 + 256 > 16384) {
					var4 = 16128;
				}

				if (var4 + 256 > this.capacity) {
					this.capacity += 1024;
					if (this.capacity > 16384) {
						this.capacity = 16384;
					}

					this.close();
					this.open(this.capacity);
					var3 = 0;
					this.field1395 = true;
					if (var4 + 256 > this.capacity) {
						var4 = this.capacity - 256;
						this.field1389 = var4 - this.field1388;
					}
				}

				while (var3 < var4) {
					this.fill(this.samples, 256);
					this.write();
					var3 += 256;
				}

				if (var1 > this.field1396) {
					if (!this.field1395) {
						if (this.field1384 == 0 && this.field1380 == 0) {
							this.close();
							this.field1390 = var1 + 2000L;
							return;
						}

						this.field1389 = Math.min(this.field1380, this.field1384);
						this.field1380 = this.field1384;
					} else {
						this.field1395 = false;
					}

					this.field1384 = 0;
					this.field1396 = 2000L + var1;
				}

				this.field1393 = var3;
			} catch (Exception var7) {
				this.close();
				this.field1390 = var1 + 2000L;
			}

			try {
				if (var1 > this.timeMs + 500000L) {
					var1 = this.timeMs;
				}

				while (var1 > 5000L + this.timeMs) {
					this.skip(256);
					this.timeMs += (long)(256000 / (PcmPlayer_sampleRate * 22050));
				}
			} catch (Exception var6) {
				this.timeMs = var1;
			}

		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2122185925"
	)
	public final void method2581() {
		this.field1395 = true;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-855034369"
	)
	@Export("tryDiscard")
	public final synchronized void tryDiscard() {
		this.field1395 = true;

		try {
			this.discard();
		} catch (Exception var2) {
			this.close();
			this.field1390 = PlayerAppearance.currentTimeMillis() + 2000L;
		}

	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1045839525"
	)
	@Export("shutdown")
	public final synchronized void shutdown() {
		if (VerticalAlignment.soundSystem != null) {
			boolean var1 = true;

			for (int var2 = 0; var2 < 2; ++var2) {
				if (this == VerticalAlignment.soundSystem.players[var2]) {
					VerticalAlignment.soundSystem.players[var2] = null;
				}

				if (VerticalAlignment.soundSystem.players[var2] != null) {
					var1 = false;
				}
			}

			if (var1) {
				SecureRandomCallable.soundSystemExecutor.shutdownNow();
				SecureRandomCallable.soundSystemExecutor = null;
				VerticalAlignment.soundSystem = null;
			}
		}

		this.close();
		this.samples = null;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1485075672"
	)
	@Export("skip")
	final void skip(int var1) {
		this.field1392 -= var1;
		if (this.field1392 < 0) {
			this.field1392 = 0;
		}

		if (this.stream != null) {
			this.stream.skip(var1);
		}

	}

	@ObfuscatedName("aj")
	@Export("fill")
	final void fill(int[] var1, int var2) {
		int var3 = var2;
		if (InterfaceParent.PcmPlayer_stereo) {
			var3 = var2 << 1;
		}

		class300.clearIntArray(var1, 0, var3);
		this.field1392 -= var2;
		if (this.stream != null && this.field1392 <= 0) {
			this.field1392 += PcmPlayer_sampleRate * 22050 >> 4;
			PlayerAppearance.PcmStream_disable(this.stream);
			this.method2586(this.stream, this.stream.vmethod2868());
			int var4 = 0;
			int var5 = 255;

			int var6;
			PcmStream var10;
			label104:
			for (var6 = 7; var5 != 0; --var6) {
				int var7;
				int var8;
				if (var6 < 0) {
					var7 = var6 & 3;
					var8 = -(var6 >> 2);
				} else {
					var7 = var6;
					var8 = 0;
				}

				for (int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
					if ((var9 & 1) != 0) {
						var5 &= ~(1 << var7);
						var10 = null;
						PcmStream var11 = this.field1397[var7];

						label98:
						while (true) {
							while (true) {
								if (var11 == null) {
									break label98;
								}

								AbstractSound var12 = var11.sound;
								if (var12 != null && var12.position > var8) {
									var5 |= 1 << var7;
									var10 = var11;
									var11 = var11.after;
								} else {
									var11.active = true;
									int var13 = var11.vmethod4063();
									var4 += var13;
									if (var12 != null) {
										var12.position += var13;
									}

									if (var4 >= this.field1394) {
										break label104;
									}

									PcmStream var14 = var11.firstSubStream();
									if (var14 != null) {
										for (int var15 = var11.field1467; var14 != null; var14 = var11.nextSubStream()) {
											this.method2586(var14, var15 * var14.vmethod2868() >> 8);
										}
									}

									PcmStream var18 = var11.after;
									var11.after = null;
									if (var10 == null) {
										this.field1397[var7] = var18;
									} else {
										var10.after = var18;
									}

									if (var18 == null) {
										this.field1398[var7] = var10;
									}

									var11 = var18;
								}
							}
						}
					}

					var7 += 4;
					++var8;
				}
			}

			for (var6 = 0; var6 < 8; ++var6) {
				PcmStream var16 = this.field1397[var6];
				PcmStream[] var17 = this.field1397;
				this.field1398[var6] = null;

				for (var17[var6] = null; var16 != null; var16 = var10) {
					var10 = var16.after;
					var16.after = null;
				}
			}
		}

		if (this.field1392 < 0) {
			this.field1392 = 0;
		}

		if (this.stream != null) {
			this.stream.fill(var1, 0, var2);
		}

		this.timeMs = PlayerAppearance.currentTimeMillis();
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(Ldj;IB)V",
		garbageValue = "113"
	)
	final void method2586(PcmStream var1, int var2) {
		int var3 = var2 >> 5;
		PcmStream var4 = this.field1398[var3];
		if (var4 == null) {
			this.field1397[var3] = var1;
		} else {
			var4.after = var1;
		}

		this.field1398[var3] = var1;
		var1.field1467 = var2;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "1251726708"
	)
	public static boolean method2639(char var0) {
		if (var0 > ' ' && var0 < 127 || var0 > 127 && var0 < 160 || var0 > 160 && var0 <= 255) {
			return true;
		} else {
			if (var0 != 0) {
				char[] var1 = class287.cp1252AsciiExtension;

				for (int var2 = 0; var2 < var1.length; ++var2) {
					char var3 = var1[var2];
					if (var0 == var3) {
						return true;
					}
				}
			}

			return false;
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "1581886582"
	)
	static int method2638(int var0, int var1) {
		long var2 = (long)((var0 << 16) + var1);
		return UserComparator6.NetCache_currentResponse != null && var2 == UserComparator6.NetCache_currentResponse.key ? Frames.NetCache_responseArchiveBuffer.offset * 99 / (Frames.NetCache_responseArchiveBuffer.array.length - UserComparator6.NetCache_currentResponse.padding) + 1 : 0;
	}

	@ObfuscatedName("hk")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "-14"
	)
	static int method2637(int var0, int var1) {
		int var2 = var1 - 334;
		if (var2 < 0) {
			var2 = 0;
		} else if (var2 > 100) {
			var2 = 100;
		}

		int var3 = (Client.zoomWidth - Client.zoomHeight) * var2 / 100 + Client.zoomHeight;
		return var0 * var3 / 256;
	}
}
