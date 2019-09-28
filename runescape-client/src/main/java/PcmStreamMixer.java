import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
@Implements("PcmStreamMixer")
public class PcmStreamMixer extends PcmStream {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	@Export("subStreams")
	NodeDeque subStreams;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	NodeDeque field1318;
	@ObfuscatedName("v")
	int field1319;
	@ObfuscatedName("u")
	int field1317;

	public PcmStreamMixer() {
		this.subStreams = new NodeDeque();
		this.field1318 = new NodeDeque();
		this.field1319 = 0;
		this.field1317 = -1;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ldc;)V"
	)
	@Export("addSubStream")
	public final synchronized void addSubStream(PcmStream var1) {
		this.subStreams.addLast(var1);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Ldc;)V"
	)
	@Export("removeSubStream")
	public final synchronized void removeSubStream(PcmStream var1) {
		var1.remove();
	}

	@ObfuscatedName("v")
	void method2275() {
		if (this.field1319 > 0) {
			for (PcmStreamMixerListener var1 = (PcmStreamMixerListener)this.field1318.last(); var1 != null; var1 = (PcmStreamMixerListener)this.field1318.previous()) {
				var1.field1421 -= this.field1319;
			}

			this.field1317 -= this.field1319;
			this.field1319 = 0;
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lfx;Lde;)V"
	)
	void method2298(Node var1, PcmStreamMixerListener var2) {
		while (this.field1318.sentinel != var1 && ((PcmStreamMixerListener)var1).field1421 <= var2.field1421) {
			var1 = var1.previous;
		}

		NodeDeque.NodeDeque_addBefore(var2, var1);
		this.field1317 = ((PcmStreamMixerListener)this.field1318.sentinel.previous).field1421;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(Lde;)V"
	)
	void method2276(PcmStreamMixerListener var1) {
		var1.remove();
		var1.remove2();
		Node var2 = this.field1318.sentinel.previous;
		if (var2 == this.field1318.sentinel) {
			this.field1317 = -1;
		} else {
			this.field1317 = ((PcmStreamMixerListener)var2).field1421;
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "()Ldc;"
	)
	@Export("firstSubStream")
	protected PcmStream firstSubStream() {
		return (PcmStream)this.subStreams.last();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "()Ldc;"
	)
	@Export("nextSubStream")
	protected PcmStream nextSubStream() {
		return (PcmStream)this.subStreams.previous();
	}

	@ObfuscatedName("m")
	protected int vmethod3882() {
		return 0;
	}

	@ObfuscatedName("y")
	@Export("fill")
	public final synchronized void fill(int[] var1, int var2, int var3) {
		do {
			if (this.field1317 < 0) {
				this.updateSubStreams(var1, var2, var3);
				return;
			}

			if (var3 + this.field1319 < this.field1317) {
				this.field1319 += var3;
				this.updateSubStreams(var1, var2, var3);
				return;
			}

			int var4 = this.field1317 - this.field1319;
			this.updateSubStreams(var1, var2, var4);
			var2 += var4;
			var3 -= var4;
			this.field1319 += var4;
			this.method2275();
			PcmStreamMixerListener var5 = (PcmStreamMixerListener)this.field1318.last();
			synchronized(var5) {
				int var7 = var5.update();
				if (var7 < 0) {
					var5.field1421 = 0;
					this.method2276(var5);
				} else {
					var5.field1421 = var7;
					this.method2298(var5.previous, var5);
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

	@ObfuscatedName("c")
	@Export("skip")
	public final synchronized void skip(int var1) {
		do {
			if (this.field1317 < 0) {
				this.skipSubStreams(var1);
				return;
			}

			if (this.field1319 + var1 < this.field1317) {
				this.field1319 += var1;
				this.skipSubStreams(var1);
				return;
			}

			int var2 = this.field1317 - this.field1319;
			this.skipSubStreams(var2);
			var1 -= var2;
			this.field1319 += var2;
			this.method2275();
			PcmStreamMixerListener var3 = (PcmStreamMixerListener)this.field1318.last();
			synchronized(var3) {
				int var5 = var3.update();
				if (var5 < 0) {
					var3.field1421 = 0;
					this.method2276(var3);
				} else {
					var3.field1421 = var5;
					this.method2298(var3.previous, var3);
				}
			}
		} while(var1 != 0);

	}

	@ObfuscatedName("b")
	@Export("skipSubStreams")
	void skipSubStreams(int var1) {
		for (PcmStream var2 = (PcmStream)this.subStreams.last(); var2 != null; var2 = (PcmStream)this.subStreams.previous()) {
			var2.skip(var1);
		}

	}
}
