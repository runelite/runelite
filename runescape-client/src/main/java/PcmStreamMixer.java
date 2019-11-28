import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
@Implements("PcmStreamMixer")
public class PcmStreamMixer extends PcmStream {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Ljd;"
	)
	@Export("subStreams")
	NodeDeque subStreams;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Ljd;"
	)
	NodeDeque field1326;
	@ObfuscatedName("b")
	int field1328;
	@ObfuscatedName("g")
	int field1329;

	public PcmStreamMixer() {
		this.subStreams = new NodeDeque();
		this.field1326 = new NodeDeque();
		this.field1328 = 0;
		this.field1329 = -1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ldt;)V"
	)
	@Export("addSubStream")
	public final synchronized void addSubStream(PcmStream var1) {
		this.subStreams.addLast(var1);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Ldt;)V"
	)
	@Export("removeSubStream")
	public final synchronized void removeSubStream(PcmStream var1) {
		var1.remove();
	}

	@ObfuscatedName("b")
	void method2332() {
		if (this.field1328 > 0) {
			for (PcmStreamMixerListener var1 = (PcmStreamMixerListener)this.field1326.last(); var1 != null; var1 = (PcmStreamMixerListener)this.field1326.previous()) {
				var1.field1440 -= this.field1328;
			}

			this.field1329 -= this.field1328;
			this.field1328 = 0;
		}

	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lfb;Ldp;)V"
	)
	void method2330(Node var1, PcmStreamMixerListener var2) {
		while (this.field1326.sentinel != var1 && ((PcmStreamMixerListener)var1).field1440 <= var2.field1440) {
			var1 = var1.previous;
		}

		NodeDeque.NodeDeque_addBefore(var2, var1);
		this.field1329 = ((PcmStreamMixerListener)this.field1326.sentinel.previous).field1440;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ldp;)V"
	)
	void method2322(PcmStreamMixerListener var1) {
		var1.remove();
		var1.remove2();
		Node var2 = this.field1326.sentinel.previous;
		if (var2 == this.field1326.sentinel) {
			this.field1329 = -1;
		} else {
			this.field1329 = ((PcmStreamMixerListener)var2).field1440;
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "()Ldt;"
	)
	@Export("firstSubStream")
	protected PcmStream firstSubStream() {
		return (PcmStream)this.subStreams.last();
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "()Ldt;"
	)
	@Export("nextSubStream")
	protected PcmStream nextSubStream() {
		return (PcmStream)this.subStreams.previous();
	}

	@ObfuscatedName("y")
	protected int vmethod3963() {
		return 0;
	}

	@ObfuscatedName("w")
	@Export("fill")
	public final synchronized void fill(int[] var1, int var2, int var3) {
		do {
			if (this.field1329 < 0) {
				this.updateSubStreams(var1, var2, var3);
				return;
			}

			if (var3 + this.field1328 < this.field1329) {
				this.field1328 += var3;
				this.updateSubStreams(var1, var2, var3);
				return;
			}

			int var4 = this.field1329 - this.field1328;
			this.updateSubStreams(var1, var2, var4);
			var2 += var4;
			var3 -= var4;
			this.field1328 += var4;
			this.method2332();
			PcmStreamMixerListener var5 = (PcmStreamMixerListener)this.field1326.last();
			synchronized(var5) {
				int var7 = var5.update();
				if (var7 < 0) {
					var5.field1440 = 0;
					this.method2322(var5);
				} else {
					var5.field1440 = var7;
					this.method2330(var5.previous, var5);
				}
			}
		} while(var3 != 0);

	}

	@ObfuscatedName("i")
	@Export("updateSubStreams")
	void updateSubStreams(int[] var1, int var2, int var3) {
		for (PcmStream var4 = (PcmStream)this.subStreams.last(); var4 != null; var4 = (PcmStream)this.subStreams.previous()) {
			var4.update(var1, var2, var3);
		}

	}

	@ObfuscatedName("k")
	@Export("skip")
	public final synchronized void skip(int var1) {
		do {
			if (this.field1329 < 0) {
				this.skipSubStreams(var1);
				return;
			}

			if (this.field1328 + var1 < this.field1329) {
				this.field1328 += var1;
				this.skipSubStreams(var1);
				return;
			}

			int var2 = this.field1329 - this.field1328;
			this.skipSubStreams(var2);
			var1 -= var2;
			this.field1328 += var2;
			this.method2332();
			PcmStreamMixerListener var3 = (PcmStreamMixerListener)this.field1326.last();
			synchronized(var3) {
				int var5 = var3.update();
				if (var5 < 0) {
					var3.field1440 = 0;
					this.method2322(var3);
				} else {
					var3.field1440 = var5;
					this.method2330(var3.previous, var3);
				}
			}
		} while(var1 != 0);

	}

	@ObfuscatedName("x")
	@Export("skipSubStreams")
	void skipSubStreams(int var1) {
		for (PcmStream var2 = (PcmStream)this.subStreams.last(); var2 != null; var2 = (PcmStream)this.subStreams.previous()) {
			var2.skip(var1);
		}

	}
}
