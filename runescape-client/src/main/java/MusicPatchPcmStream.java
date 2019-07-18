import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
@Implements("MusicPatchPcmStream")
public class MusicPatchPcmStream extends PcmStream {
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "Llt;"
	)
	@Export("rasterProvider")
	public static AbstractRasterProvider rasterProvider;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lga;"
	)
	@Export("superStream")
	MidiPcmStream superStream;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	@Export("queue")
	NodeDeque queue;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lcz;"
	)
	@Export("mixer")
	PcmStreamMixer mixer;

	@ObfuscatedSignature(
		signature = "(Lga;)V"
	)
	MusicPatchPcmStream(MidiPcmStream var1) {
		this.queue = new NodeDeque();
		this.mixer = new PcmStreamMixer();
		this.superStream = var1;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lgi;[IIIII)V",
		garbageValue = "1316254184"
	)
	void method3895(MusicPatchNode var1, int[] var2, int var3, int var4, int var5) {
		if ((this.superStream.field2421[var1.field2440] & 4) != 0 && var1.field2436 < 0) {
			int var6 = this.superStream.field2408[var1.field2440] / CollisionMap.PcmPlayer_sampleRate;

			while (true) {
				int var7 = (var6 + 1048575 - var1.field2444) / var6;
				if (var7 > var4) {
					var1.field2444 += var4 * var6;
					break;
				}

				var1.stream.fill(var2, var3, var7);
				var3 += var7;
				var4 -= var7;
				var1.field2444 += var6 * var7 - 1048576;
				int var8 = CollisionMap.PcmPlayer_sampleRate / 100;
				int var9 = 262144 / var6;
				if (var9 < var8) {
					var8 = var9;
				}

				RawPcmStream var10 = var1.stream;
				if (this.superStream.field2410[var1.field2440] == 0) {
					var1.stream = RawPcmStream.method2524(var1.rawSound, var10.method2539(), var10.method2531(), var10.method2541());
				} else {
					var1.stream = RawPcmStream.method2524(var1.rawSound, var10.method2539(), 0, var10.method2541());
					this.superStream.method3767(var1, var1.patch.field2482[var1.field2450] < 0);
					var1.stream.method2535(var8, var10.method2531());
				}

				if (var1.patch.field2482[var1.field2450] < 0) {
					var1.stream.setNumLoops(-1);
				}

				var10.method2540(var8);
				var10.fill(var2, var3, var5 - var3);
				if (var10.method2585()) {
					this.mixer.addSubStream(var10);
				}
			}
		}

		var1.stream.fill(var2, var3, var4);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lgi;II)V",
		garbageValue = "1166888342"
	)
	void method3896(MusicPatchNode var1, int var2) {
		if ((this.superStream.field2421[var1.field2440] & 4) != 0 && var1.field2436 < 0) {
			int var3 = this.superStream.field2408[var1.field2440] / CollisionMap.PcmPlayer_sampleRate;
			int var4 = (var3 + 1048575 - var1.field2444) / var3;
			var1.field2444 = var3 * var2 + var1.field2444 & 1048575;
			if (var4 <= var2) {
				if (this.superStream.field2410[var1.field2440] == 0) {
					var1.stream = RawPcmStream.method2524(var1.rawSound, var1.stream.method2539(), var1.stream.method2531(), var1.stream.method2541());
				} else {
					var1.stream = RawPcmStream.method2524(var1.rawSound, var1.stream.method2539(), 0, var1.stream.method2541());
					this.superStream.method3767(var1, var1.patch.field2482[var1.field2450] < 0);
				}

				if (var1.patch.field2482[var1.field2450] < 0) {
					var1.stream.setNumLoops(-1);
				}

				var2 = var1.field2444 / var3;
			}
		}

		var1.stream.skip(var2);
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "()Ldx;"
	)
	@Export("firstSubStream")
	protected PcmStream firstSubStream() {
		MusicPatchNode var1 = (MusicPatchNode)this.queue.last();
		if (var1 == null) {
			return null;
		} else {
			return (PcmStream)(var1.stream != null ? var1.stream : this.nextSubStream());
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "()Ldx;"
	)
	@Export("nextSubStream")
	protected PcmStream nextSubStream() {
		MusicPatchNode var1;
		do {
			var1 = (MusicPatchNode)this.queue.previous();
			if (var1 == null) {
				return null;
			}
		} while(var1.stream == null);

		return var1.stream;
	}

	@ObfuscatedName("i")
	protected int vmethod3892() {
		return 0;
	}

	@ObfuscatedName("c")
	@Export("fill")
	protected void fill(int[] var1, int var2, int var3) {
		this.mixer.fill(var1, var2, var3);

		for (MusicPatchNode var6 = (MusicPatchNode)this.queue.last(); var6 != null; var6 = (MusicPatchNode)this.queue.previous()) {
			if (!this.superStream.method3739(var6)) {
				int var4 = var2;
				int var5 = var3;

				do {
					if (var5 <= var6.field2455) {
						this.method3895(var6, var1, var4, var5, var4 + var5);
						var6.field2455 -= var5;
						break;
					}

					this.method3895(var6, var1, var4, var6.field2455, var5 + var4);
					var4 += var6.field2455;
					var5 -= var6.field2455;
				} while(!this.superStream.method3740(var6, var1, var4, var5));
			}
		}

	}

	@ObfuscatedName("x")
	@Export("skip")
	protected void skip(int var1) {
		this.mixer.skip(var1);

		for (MusicPatchNode var3 = (MusicPatchNode)this.queue.last(); var3 != null; var3 = (MusicPatchNode)this.queue.previous()) {
			if (!this.superStream.method3739(var3)) {
				int var2 = var1;

				do {
					if (var2 <= var3.field2455) {
						this.method3896(var3, var2);
						var3.field2455 -= var2;
						break;
					}

					this.method3896(var3, var3.field2455);
					var2 -= var3.field2455;
				} while(!this.superStream.method3740(var3, (int[])null, 0, var2));
			}
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lbw;B)V",
		garbageValue = "35"
	)
	@Export("changeWorld")
	static void changeWorld(World var0) {
		if (var0.isMembersOnly() != Client.isMembersWorld) {
			Client.isMembersWorld = var0.isMembersOnly();
			boolean var1 = var0.isMembersOnly();
			if (var1 != ModelData0.inMembersWorld) {
				ItemDefinition.ItemDefinition_cached.clear();
				ItemDefinition.ItemDefinition_cachedModels.clear();
				ItemDefinition.ItemDefinition_cachedSprites.clear();
				ModelData0.inMembersWorld = var1;
			}
		}

		ClientPreferences.worldHost = var0.host;
		Client.worldId = var0.id;
		Client.worldProperties = var0.properties;
		class190.port1 = Client.gameBuild == 0 ? 43594 : var0.id + 40000;
		Skeleton.port2 = Client.gameBuild == 0 ? 443 : var0.id + 50000;
		Varcs.port3 = class190.port1;
	}

	@ObfuscatedName("ih")
	@ObfuscatedSignature(
		signature = "(IIIIIII)V",
		garbageValue = "2095922546"
	)
	static final void method3912(int var0, int var1, int var2, int var3, int var4, int var5) {
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
			int var24 = var7 + var15 + var1;
			Rasterizer3D.method2981(var17, var18, var19);
			Rasterizer3D.method3007(var21, var22, var23, var17, var18, var19, var4);
			Rasterizer3D.method2981(var17, var19, var20);
			Rasterizer3D.method3007(var21, var23, var24, var17, var19, var20, var4);
		}
	}
}
