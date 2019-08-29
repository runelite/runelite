import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("PcmStreamMixer")
public class PcmStreamMixer extends PcmStream {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Ljc;"
	)
	@Export("subStreams")
	NodeDeque subStreams;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Ljc;"
	)
	NodeDeque field1317;
	@ObfuscatedName("i")
	int field1315;
	@ObfuscatedName("k")
	int field1314;

	public PcmStreamMixer() {
		this.subStreams = new NodeDeque();
		this.field1317 = new NodeDeque();
		this.field1315 = 0;
		this.field1314 = -1;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Ldz;)V"
	)
	@Export("addSubStream")
	public final synchronized void addSubStream(PcmStream var1) {
		this.subStreams.addLast(var1);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Ldz;)V"
	)
	@Export("removeSubStream")
	public final synchronized void removeSubStream(PcmStream var1) {
		var1.remove();
	}

	@ObfuscatedName("i")
	void method2218() {
		if (this.field1315 > 0) {
			for (PcmStreamMixerListener var1 = (PcmStreamMixerListener)this.field1317.last(); var1 != null; var1 = (PcmStreamMixerListener)this.field1317.previous()) {
				var1.field1429 -= this.field1315;
			}

			this.field1314 -= this.field1315;
			this.field1315 = 0;
		}

	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lfb;Ldj;)V"
	)
	void method2226(Node var1, PcmStreamMixerListener var2) {
		while (this.field1317.sentinel != var1 && ((PcmStreamMixerListener)var1).field1429 <= var2.field1429) {
			var1 = var1.previous;
		}

		NodeDeque.NodeDeque_addBefore(var2, var1);
		this.field1314 = ((PcmStreamMixerListener)this.field1317.sentinel.previous).field1429;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ldj;)V"
	)
	void method2230(PcmStreamMixerListener var1) {
		var1.remove();
		var1.remove2();
		Node var2 = this.field1317.sentinel.previous;
		if (var2 == this.field1317.sentinel) {
			this.field1314 = -1;
		} else {
			this.field1314 = ((PcmStreamMixerListener)var2).field1429;
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "()Ldz;"
	)
	@Export("firstSubStream")
	protected PcmStream firstSubStream() {
		return (PcmStream)this.subStreams.last();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "()Ldz;"
	)
	@Export("nextSubStream")
	protected PcmStream nextSubStream() {
		return (PcmStream)this.subStreams.previous();
	}

	@ObfuscatedName("q")
	protected int vmethod3834() {
		return 0;
	}

	@ObfuscatedName("x")
	@Export("fill")
	public final synchronized void fill(int[] var1, int var2, int var3) {
		do {
			if (this.field1314 < 0) {
				this.updateSubStreams(var1, var2, var3);
				return;
			}

			if (var3 + this.field1315 < this.field1314) {
				this.field1315 += var3;
				this.updateSubStreams(var1, var2, var3);
				return;
			}

			int var4 = this.field1314 - this.field1315;
			this.updateSubStreams(var1, var2, var4);
			var2 += var4;
			var3 -= var4;
			this.field1315 += var4;
			this.method2218();
			PcmStreamMixerListener var5 = (PcmStreamMixerListener)this.field1317.last();
			synchronized(var5) {
				int var7 = var5.update();
				if (var7 < 0) {
					var5.field1429 = 0;
					this.method2230(var5);
				} else {
					var5.field1429 = var7;
					this.method2226(var5.previous, var5);
				}
			}
		} while(var3 != 0);

	}

	@ObfuscatedName("d")
	@Export("updateSubStreams")
	void updateSubStreams(int[] var1, int var2, int var3) {
		for (PcmStream var4 = (PcmStream)this.subStreams.last(); var4 != null; var4 = (PcmStream)this.subStreams.previous()) {
			var4.update(var1, var2, var3);
		}

	}

	@ObfuscatedName("f")
	@Export("skip")
	public final synchronized void skip(int var1) {
		do {
			if (this.field1314 < 0) {
				this.skipSubStreams(var1);
				return;
			}

			if (this.field1315 + var1 < this.field1314) {
				this.field1315 += var1;
				this.skipSubStreams(var1);
				return;
			}

			int var2 = this.field1314 - this.field1315;
			this.skipSubStreams(var2);
			var1 -= var2;
			this.field1315 += var2;
			this.method2218();
			PcmStreamMixerListener var3 = (PcmStreamMixerListener)this.field1317.last();
			synchronized(var3) {
				int var5 = var3.update();
				if (var5 < 0) {
					var3.field1429 = 0;
					this.method2230(var3);
				} else {
					var3.field1429 = var5;
					this.method2226(var3.previous, var3);
				}
			}
		} while(var1 != 0);

	}

	@ObfuscatedName("c")
	@Export("skipSubStreams")
	void skipSubStreams(int var1) {
		for (PcmStream var2 = (PcmStream)this.subStreams.last(); var2 != null; var2 = (PcmStream)this.subStreams.previous()) {
			var2.skip(var1);
		}

	}
}
