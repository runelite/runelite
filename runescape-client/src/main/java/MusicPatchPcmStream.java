import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gy")
@Implements("MusicPatchPcmStream")
public class MusicPatchPcmStream extends PcmStream {
	@ObfuscatedName("fb")
	@ObfuscatedGetter(
		intValue = 310366357
	)
	@Export("baseX")
	static int baseX;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	@Export("superStream")
	MidiPcmStream superStream;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Ljs;"
	)
	@Export("queue")
	NodeDeque queue;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lcy;"
	)
	@Export("mixer")
	PcmStreamMixer mixer;

	@ObfuscatedSignature(
		signature = "(Lgm;)V"
	)
	MusicPatchPcmStream(MidiPcmStream var1) {
		this.queue = new NodeDeque();
		this.mixer = new PcmStreamMixer();
		this.superStream = var1;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lgl;[IIIII)V",
		garbageValue = "2129262150"
	)
	void method3879(MusicPatchNode var1, int[] var2, int var3, int var4, int var5) {
		if ((this.superStream.field2412[var1.field2444] & 4) != 0 && var1.field2441 < 0) {
			int var6 = this.superStream.field2425[var1.field2444] / (DirectByteArrayCopier.field2490 * -168449264);

			while (true) {
				int var7 = (var6 + 1048575 - var1.field2447) / var6;
				if (var7 > var4) {
					var1.field2447 += var4 * var6;
					break;
				}

				var1.stream.fill(var2, var3, var7);
				var3 += var7;
				var4 -= var7;
				var1.field2447 += var6 * var7 - 1048576;
				int var8 = DirectByteArrayCopier.field2490 * -168449264 / 100;
				int var9 = 262144 / var6;
				if (var9 < var8) {
					var8 = var9;
				}

				RawPcmStream var10 = var1.stream;
				if (this.superStream.field2415[var1.field2444] == 0) {
					var1.stream = RawPcmStream.method2582(var1.rawSound, var10.method2561(), var10.method2609(), var10.method2553());
				} else {
					var1.stream = RawPcmStream.method2582(var1.rawSound, var10.method2561(), 0, var10.method2553());
					this.superStream.method3764(var1, var1.patch.field2464[var1.field2432] < 0);
					var1.stream.method2557(var8, var10.method2609());
				}

				if (var1.patch.field2464[var1.field2432] < 0) {
					var1.stream.setNumLoops(-1);
				}

				var10.method2559(var8);
				var10.fill(var2, var3, var5 - var3);
				if (var10.method2563()) {
					this.mixer.addSubStream(var10);
				}
			}
		}

		var1.stream.fill(var2, var3, var4);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lgl;II)V",
		garbageValue = "-1324133665"
	)
	void method3880(MusicPatchNode var1, int var2) {
		if ((this.superStream.field2412[var1.field2444] & 4) != 0 && var1.field2441 < 0) {
			int var3 = this.superStream.field2425[var1.field2444] / (DirectByteArrayCopier.field2490 * -168449264);
			int var4 = (var3 + 1048575 - var1.field2447) / var3;
			var1.field2447 = var3 * var2 + var1.field2447 & 1048575;
			if (var4 <= var2) {
				if (this.superStream.field2415[var1.field2444] == 0) {
					var1.stream = RawPcmStream.method2582(var1.rawSound, var1.stream.method2561(), var1.stream.method2609(), var1.stream.method2553());
				} else {
					var1.stream = RawPcmStream.method2582(var1.rawSound, var1.stream.method2561(), 0, var1.stream.method2553());
					this.superStream.method3764(var1, var1.patch.field2464[var1.field2432] < 0);
				}

				if (var1.patch.field2464[var1.field2432] < 0) {
					var1.stream.setNumLoops(-1);
				}

				var2 = var1.field2447 / var3;
			}
		}

		var1.stream.skip(var2);
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "()Ldl;"
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

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "()Ldl;"
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

	@ObfuscatedName("x")
	protected int vmethod3889() {
		return 0;
	}

	@ObfuscatedName("a")
	@Export("fill")
	protected void fill(int[] var1, int var2, int var3) {
		this.mixer.fill(var1, var2, var3);

		for (MusicPatchNode var6 = (MusicPatchNode)this.queue.last(); var6 != null; var6 = (MusicPatchNode)this.queue.previous()) {
			if (!this.superStream.method3767(var6)) {
				int var4 = var2;
				int var5 = var3;

				do {
					if (var5 <= var6.field2431) {
						this.method3879(var6, var1, var4, var5, var5 + var4);
						var6.field2431 -= var5;
						break;
					}

					this.method3879(var6, var1, var4, var6.field2431, var5 + var4);
					var4 += var6.field2431;
					var5 -= var6.field2431;
				} while(!this.superStream.method3728(var6, var1, var4, var5));
			}
		}

	}

	@ObfuscatedName("c")
	@Export("skip")
	protected void skip(int var1) {
		this.mixer.skip(var1);

		for (MusicPatchNode var3 = (MusicPatchNode)this.queue.last(); var3 != null; var3 = (MusicPatchNode)this.queue.previous()) {
			if (!this.superStream.method3767(var3)) {
				int var2 = var1;

				do {
					if (var2 <= var3.field2431) {
						this.method3880(var3, var2);
						var3.field2431 -= var2;
						break;
					}

					this.method3880(var3, var3.field2431);
					var2 -= var3.field2431;
				} while(!this.superStream.method3728(var3, (int[])null, 0, var2));
			}
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)[Lhp;",
		garbageValue = "1994123729"
	)
	@Export("PlayerType_values")
	public static PlayerType[] PlayerType_values() {
		return new PlayerType[]{PlayerType.PlayerType_ironman, PlayerType.PlayerType_normal, PlayerType.PlayerType_jagexModerator, PlayerType.PlayerType_playerModerator, PlayerType.PlayerType_hardcoreIronman, PlayerType.PlayerType_ultimateIronman};
	}

	@ObfuscatedName("im")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "96"
	)
	static final void method3898(int var0) {
		if (var0 >= 0) {
			int var1 = Client.menuArguments1[var0];
			int var2 = Client.menuArguments2[var0];
			int var3 = Client.menuOpcodes[var0];
			int var4 = Client.menuIdentifiers[var0];
			String var5 = Client.menuActions[var0];
			String var6 = Client.menuTargets[var0];
			AbstractWorldMapData.menuAction(var1, var2, var3, var4, var5, var6, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
		}
	}
}
