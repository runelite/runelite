import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
@Implements("MusicPatchPcmStream")
public class MusicPatchPcmStream extends PcmStream {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lgz;"
	)
	@Export("superStream")
	MidiPcmStream superStream;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Ljd;"
	)
	@Export("queue")
	NodeDeque queue;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lca;"
	)
	@Export("mixer")
	PcmStreamMixer mixer;

	@ObfuscatedSignature(
		signature = "(Lgz;)V"
	)
	MusicPatchPcmStream(MidiPcmStream var1) {
		this.queue = new NodeDeque();
		this.mixer = new PcmStreamMixer();
		this.superStream = var1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lge;[IIIII)V",
		garbageValue = "71906833"
	)
	void method3962(MusicPatchNode var1, int[] var2, int var3, int var4, int var5) {
		if ((this.superStream.field2428[var1.field2449] & 4) != 0 && var1.field2459 < 0) {
			int var6 = this.superStream.field2433[var1.field2449] / Messages.PcmPlayer_sampleRate;

			while (true) {
				int var7 = (var6 + 1048575 - var1.field2463) / var6;
				if (var7 > var4) {
					var1.field2463 += var6 * var4;
					break;
				}

				var1.stream.fill(var2, var3, var7);
				var3 += var7;
				var4 -= var7;
				var1.field2463 += var7 * var6 - 1048576;
				int var8 = Messages.PcmPlayer_sampleRate / 100;
				int var9 = 262144 / var6;
				if (var9 < var8) {
					var8 = var9;
				}

				RawPcmStream var10 = var1.stream;
				if (this.superStream.field2441[var1.field2449] == 0) {
					var1.stream = RawPcmStream.method2568(var1.rawSound, var10.method2701(), var10.method2575(), var10.method2576());
				} else {
					var1.stream = RawPcmStream.method2568(var1.rawSound, var10.method2701(), 0, var10.method2576());
					this.superStream.method3779(var1, var1.patch.field2485[var1.field2450] < 0);
					var1.stream.method2580(var8, var10.method2575());
				}

				if (var1.patch.field2485[var1.field2450] < 0) {
					var1.stream.setNumLoops(-1);
				}

				var10.method2582(var8);
				var10.fill(var2, var3, var5 - var3);
				if (var10.method2686()) {
					this.mixer.addSubStream(var10);
				}
			}
		}

		var1.stream.fill(var2, var3, var4);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lge;II)V",
		garbageValue = "-1756065596"
	)
	void method3959(MusicPatchNode var1, int var2) {
		if ((this.superStream.field2428[var1.field2449] & 4) != 0 && var1.field2459 < 0) {
			int var3 = this.superStream.field2433[var1.field2449] / Messages.PcmPlayer_sampleRate;
			int var4 = (var3 + 1048575 - var1.field2463) / var3;
			var1.field2463 = var3 * var2 + var1.field2463 & 1048575;
			if (var4 <= var2) {
				if (this.superStream.field2441[var1.field2449] == 0) {
					var1.stream = RawPcmStream.method2568(var1.rawSound, var1.stream.method2701(), var1.stream.method2575(), var1.stream.method2576());
				} else {
					var1.stream = RawPcmStream.method2568(var1.rawSound, var1.stream.method2701(), 0, var1.stream.method2576());
					this.superStream.method3779(var1, var1.patch.field2485[var1.field2450] < 0);
				}

				if (var1.patch.field2485[var1.field2450] < 0) {
					var1.stream.setNumLoops(-1);
				}

				var2 = var1.field2463 / var3;
			}
		}

		var1.stream.skip(var2);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "()Ldt;"
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

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "()Ldt;"
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

	@ObfuscatedName("y")
	protected int vmethod3963() {
		return 0;
	}

	@ObfuscatedName("w")
	@Export("fill")
	protected void fill(int[] var1, int var2, int var3) {
		this.mixer.fill(var1, var2, var3);

		for (MusicPatchNode var6 = (MusicPatchNode)this.queue.last(); var6 != null; var6 = (MusicPatchNode)this.queue.previous()) {
			if (!this.superStream.method3801(var6)) {
				int var4 = var2;
				int var5 = var3;

				do {
					if (var5 <= var6.field2464) {
						this.method3962(var6, var1, var4, var5, var4 + var5);
						var6.field2464 -= var5;
						break;
					}

					this.method3962(var6, var1, var4, var6.field2464, var5 + var4);
					var4 += var6.field2464;
					var5 -= var6.field2464;
				} while(!this.superStream.method3802(var6, var1, var4, var5));
			}
		}

	}

	@ObfuscatedName("k")
	@Export("skip")
	protected void skip(int var1) {
		this.mixer.skip(var1);

		for (MusicPatchNode var3 = (MusicPatchNode)this.queue.last(); var3 != null; var3 = (MusicPatchNode)this.queue.previous()) {
			if (!this.superStream.method3801(var3)) {
				int var2 = var1;

				do {
					if (var2 <= var3.field2464) {
						this.method3959(var3, var2);
						var3.field2464 -= var2;
						break;
					}

					this.method3959(var3, var3.field2464);
					var2 -= var3.field2464;
				} while(!this.superStream.method3802(var3, (int[])null, 0, var2));
			}
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2088292857"
	)
	public static void method3970() {
		PlayerAppearance.PlayerAppearance_cachedModels.clear();
	}

	@ObfuscatedName("jh")
	@ObfuscatedSignature(
		signature = "([Lhl;II)V",
		garbageValue = "1264481635"
	)
	@Export("drawModelComponents")
	static final void drawModelComponents(Widget[] var0, int var1) {
		for (int var2 = 0; var2 < var0.length; ++var2) {
			Widget var3 = var0[var2];
			if (var3 != null && var3.parentId == var1 && (!var3.isIf3 || !AbstractByteArrayCopier.isComponentHidden(var3))) {
				if (var3.type == 0) {
					if (!var3.isIf3 && AbstractByteArrayCopier.isComponentHidden(var3) && var3 != class185.mousedOverWidgetIf1) {
						continue;
					}

					drawModelComponents(var0, var3.id);
					if (var3.children != null) {
						drawModelComponents(var3.children, var3.id);
					}

					InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var3.id);
					if (var4 != null) {
						class160.method3494(var4.group);
					}
				}

				if (var3.type == 6) {
					int var5;
					if (var3.sequenceId != -1 || var3.sequenceId2 != -1) {
						boolean var7 = WorldMapArea.runCs1(var3);
						if (var7) {
							var5 = var3.sequenceId2;
						} else {
							var5 = var3.sequenceId;
						}

						if (var5 != -1) {
							SequenceDefinition var6 = GrandExchangeOfferAgeComparator.SequenceDefinition_get(var5);

							for (var3.modelFrameCycle += Client.field704; var3.modelFrameCycle > var6.frameLengths[var3.modelFrame]; ScriptEvent.invalidateWidget(var3)) {
								var3.modelFrameCycle -= var6.frameLengths[var3.modelFrame];
								++var3.modelFrame;
								if (var3.modelFrame >= var6.frameIds.length) {
									var3.modelFrame -= var6.frameCount;
									if (var3.modelFrame < 0 || var3.modelFrame >= var6.frameIds.length) {
										var3.modelFrame = 0;
									}
								}
							}
						}
					}

					if (var3.field2633 != 0 && !var3.isIf3) {
						int var8 = var3.field2633 >> 16;
						var5 = var3.field2633 << 16 >> 16;
						var8 *= Client.field704;
						var5 *= Client.field704;
						var3.modelAngleX = var8 + var3.modelAngleX & 2047;
						var3.modelAngleY = var5 + var3.modelAngleY & 2047;
						ScriptEvent.invalidateWidget(var3);
					}
				}
			}
		}

	}
}
