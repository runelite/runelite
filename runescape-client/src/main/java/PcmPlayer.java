import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
@Implements("PcmPlayer")
public class PcmPlayer {
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -2109466943
	)
	@Export("PcmPlayer_sampleRate")
	public static int PcmPlayer_sampleRate;
	@ObfuscatedName("n")
	@Export("PcmPlayer_stereo")
	protected static boolean PcmPlayer_stereo;
	@ObfuscatedName("y")
	@Export("samples")
	protected int[] samples;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Ldz;"
	)
	@Export("stream")
	PcmStream stream;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 2121528369
	)
	int field1384;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		longValue = 7651317449639431647L
	)
	@Export("timeMs")
	long timeMs;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1742403687
	)
	@Export("capacity")
	int capacity;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -2082148367
	)
	int field1399;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1595984821
	)
	int field1388;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		longValue = -7364227675697791643L
	)
	long field1389;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -772636771
	)
	int field1379;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1968577703
	)
	int field1391;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -289661183
	)
	int field1393;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		longValue = 1958141991499651821L
	)
	long field1386;
	@ObfuscatedName("o")
	boolean field1394;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = 168489489
	)
	int field1395;
	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "[Ldz;"
	)
	PcmStream[] field1396;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "[Ldz;"
	)
	PcmStream[] field1397;

	protected PcmPlayer() {
		this.field1384 = 32;
		this.timeMs = SequenceDefinition.method4686();
		this.field1389 = 0L;
		this.field1379 = 0;
		this.field1391 = 0;
		this.field1393 = 0;
		this.field1386 = 0L;
		this.field1394 = true;
		this.field1395 = 0;
		this.field1396 = new PcmStream[8];
		this.field1397 = new PcmStream[8];
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "1"
	)
	@Export("init")
	protected void init() throws Exception {
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1939802329"
	)
	@Export("open")
	protected void open(int var1) throws Exception {
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "428413683"
	)
	@Export("position")
	protected int position() throws Exception {
		return this.capacity;
	}

	@ObfuscatedName("k")
	@Export("write")
	protected void write() throws Exception {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "37766209"
	)
	@Export("close")
	protected void close() {
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "645078569"
	)
	@Export("discard")
	protected void discard() throws Exception {
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Ldz;I)V",
		garbageValue = "-414582995"
	)
	@Export("setStream")
	public final synchronized void setStream(PcmStream var1) {
		this.stream = var1;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-862737237"
	)
	@Export("run")
	public final synchronized void run() {
		if (this.samples != null) {
			long var1 = SequenceDefinition.method4686();

			try {
				if (this.field1389 != 0L) {
					if (var1 < this.field1389) {
						return;
					}

					this.open(this.capacity);
					this.field1389 = 0L;
					this.field1394 = true;
				}

				int var3 = this.position();
				if (this.field1393 - var3 > this.field1379) {
					this.field1379 = this.field1393 - var3;
				}

				int var4 = this.field1388 + this.field1399;
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
					this.field1394 = true;
					if (var4 + 256 > this.capacity) {
						var4 = this.capacity - 256;
						this.field1388 = var4 - this.field1399;
					}
				}

				while (var3 < var4) {
					this.fill(this.samples, 256);
					this.write();
					var3 += 256;
				}

				if (var1 > this.field1386) {
					if (!this.field1394) {
						if (this.field1379 == 0 && this.field1391 == 0) {
							this.close();
							this.field1389 = 2000L + var1;
							return;
						}

						this.field1388 = Math.min(this.field1391, this.field1379);
						this.field1391 = this.field1379;
					} else {
						this.field1394 = false;
					}

					this.field1379 = 0;
					this.field1386 = var1 + 2000L;
				}

				this.field1393 = var3;
			} catch (Exception var7) {
				this.close();
				this.field1389 = var1 + 2000L;
			}

			try {
				if (var1 > this.timeMs + 500000L) {
					var1 = this.timeMs;
				}

				while (var1 > this.timeMs + 5000L) {
					this.skip(256);
					this.timeMs += (long)(256000 / PcmPlayer_sampleRate);
				}
			} catch (Exception var6) {
				this.timeMs = var1;
			}

		}
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1124222572"
	)
	public final void method2397() {
		this.field1394 = true;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-38"
	)
	@Export("tryDiscard")
	public final synchronized void tryDiscard() {
		this.field1394 = true;

		try {
			this.discard();
		} catch (Exception var2) {
			this.close();
			this.field1389 = SequenceDefinition.method4686() + 2000L;
		}

	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "58159891"
	)
	@Export("shutdown")
	public final synchronized void shutdown() {
		if (PacketBufferNode.soundSystem != null) {
			boolean var1 = true;

			for (int var2 = 0; var2 < 2; ++var2) {
				if (this == PacketBufferNode.soundSystem.players[var2]) {
					PacketBufferNode.soundSystem.players[var2] = null;
				}

				if (PacketBufferNode.soundSystem.players[var2] != null) {
					var1 = false;
				}
			}

			if (var1) {
				GrandExchangeOfferWorldComparator.soundSystemExecutor.shutdownNow();
				GrandExchangeOfferWorldComparator.soundSystemExecutor = null;
				PacketBufferNode.soundSystem = null;
			}
		}

		this.close();
		this.samples = null;
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1085561099"
	)
	@Export("skip")
	final void skip(int var1) {
		this.field1395 -= var1;
		if (this.field1395 < 0) {
			this.field1395 = 0;
		}

		if (this.stream != null) {
			this.stream.skip(var1);
		}

	}

	@ObfuscatedName("az")
	@Export("fill")
	final void fill(int[] var1, int var2) {
		int var3 = var2;
		if (PcmPlayer_stereo) {
			var3 = var2 << 1;
		}

		class300.clearIntArray(var1, 0, var3);
		this.field1395 -= var2;
		if (this.stream != null && this.field1395 <= 0) {
			this.field1395 += PcmPlayer_sampleRate >> 4;
			WorldMapArea.PcmStream_disable(this.stream);
			this.method2347(this.stream, this.stream.vmethod2644());
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
						PcmStream var11 = this.field1396[var7];

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
									int var13 = var11.vmethod3834();
									var4 += var13;
									if (var12 != null) {
										var12.position += var13;
									}

									if (var4 >= this.field1384) {
										break label104;
									}

									PcmStream var14 = var11.firstSubStream();
									if (var14 != null) {
										for (int var15 = var11.field1478; var14 != null; var14 = var11.nextSubStream()) {
											this.method2347(var14, var15 * var14.vmethod2644() >> 8);
										}
									}

									PcmStream var18 = var11.after;
									var11.after = null;
									if (var10 == null) {
										this.field1396[var7] = var18;
									} else {
										var10.after = var18;
									}

									if (var18 == null) {
										this.field1397[var7] = var10;
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
				PcmStream var16 = this.field1396[var6];
				PcmStream[] var17 = this.field1396;
				this.field1397[var6] = null;

				for (var17[var6] = null; var16 != null; var16 = var10) {
					var10 = var16.after;
					var16.after = null;
				}
			}
		}

		if (this.field1395 < 0) {
			this.field1395 = 0;
		}

		if (this.stream != null) {
			this.stream.fill(var1, 0, var2);
		}

		this.timeMs = SequenceDefinition.method4686();
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(Ldz;II)V",
		garbageValue = "-2059733660"
	)
	final void method2347(PcmStream var1, int var2) {
		int var3 = var2 >> 5;
		PcmStream var4 = this.field1397[var3];
		if (var4 == null) {
			this.field1396[var3] = var1;
		} else {
			var4.after = var1;
		}

		this.field1397[var3] = var1;
		var1.field1478 = var2;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "0"
	)
	public static boolean method2396(int var0) {
		return (var0 >> 21 & 1) != 0;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lhz;Lhz;Ljava/lang/String;Ljava/lang/String;B)Lkb;",
		garbageValue = "0"
	)
	@Export("SpriteBuffer_getFontByName")
	public static Font SpriteBuffer_getFontByName(AbstractArchive var0, AbstractArchive var1, String var2, String var3) {
		int var4 = var0.getGroupId(var2);
		int var5 = var0.getFileId(var4, var3);
		return FileSystem.SpriteBuffer_getFont(var0, var1, var4, var5);
	}
}
