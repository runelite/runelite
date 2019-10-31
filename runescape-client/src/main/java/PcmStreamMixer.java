import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("PcmStreamMixer")
public class PcmStreamMixer extends PcmStream {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Ljb;"
	)
	@Export("subStreams")
	NodeDeque subStreams;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Ljb;"
	)
	NodeDeque field1316;
	@ObfuscatedName("n")
	int field1317;
	@ObfuscatedName("q")
	int field1315;

	public PcmStreamMixer() {
		this.subStreams = new NodeDeque();
		this.field1316 = new NodeDeque();
		this.field1317 = 0;
		this.field1315 = -1;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Ldj;)V"
	)
	@Export("addSubStream")
	public final synchronized void addSubStream(PcmStream var1) {
		this.subStreams.addLast(var1);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ldj;)V"
	)
	@Export("removeSubStream")
	public final synchronized void removeSubStream(PcmStream var1) {
		var1.remove();
	}

	@ObfuscatedName("n")
	void method2439() {
		if (this.field1317 > 0) {
			for (PcmStreamMixerListener var1 = (PcmStreamMixerListener)this.field1316.last(); var1 != null; var1 = (PcmStreamMixerListener)this.field1316.previous()) {
				var1.field1420 -= this.field1317;
			}

			this.field1315 -= this.field1317;
			this.field1317 = 0;
		}

	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lfd;Ldn;)V"
	)
	void method2443(Node var1, PcmStreamMixerListener var2) {
		while (this.field1316.sentinel != var1 && ((PcmStreamMixerListener)var1).field1420 <= var2.field1420) {
			var1 = var1.previous;
		}

		NodeDeque.NodeDeque_addBefore(var2, var1);
		this.field1315 = ((PcmStreamMixerListener)this.field1316.sentinel.previous).field1420;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Ldn;)V"
	)
	void method2478(PcmStreamMixerListener var1) {
		var1.remove();
		var1.remove2();
		Node var2 = this.field1316.sentinel.previous;
		if (var2 == this.field1316.sentinel) {
			this.field1315 = -1;
		} else {
			this.field1315 = ((PcmStreamMixerListener)var2).field1420;
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "()Ldj;"
	)
	@Export("firstSubStream")
	protected PcmStream firstSubStream() {
		return (PcmStream)this.subStreams.last();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "()Ldj;"
	)
	@Export("nextSubStream")
	protected PcmStream nextSubStream() {
		return (PcmStream)this.subStreams.previous();
	}

	@ObfuscatedName("o")
	protected int vmethod4063() {
		return 0;
	}

	@ObfuscatedName("i")
	@Export("fill")
	public final synchronized void fill(int[] var1, int var2, int var3) {
		do {
			if (this.field1315 < 0) {
				this.updateSubStreams(var1, var2, var3);
				return;
			}

			if (var3 + this.field1317 < this.field1315) {
				this.field1317 += var3;
				this.updateSubStreams(var1, var2, var3);
				return;
			}

			int var4 = this.field1315 - this.field1317;
			this.updateSubStreams(var1, var2, var4);
			var2 += var4;
			var3 -= var4;
			this.field1317 += var4;
			this.method2439();
			PcmStreamMixerListener var5 = (PcmStreamMixerListener)this.field1316.last();
			synchronized(var5) {
				int var7 = var5.update();
				if (var7 < 0) {
					var5.field1420 = 0;
					this.method2478(var5);
				} else {
					var5.field1420 = var7;
					this.method2443(var5.previous, var5);
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

	@ObfuscatedName("m")
	@Export("skip")
	public final synchronized void skip(int var1) {
		do {
			if (this.field1315 < 0) {
				this.skipSubStreams(var1);
				return;
			}

			if (this.field1317 + var1 < this.field1315) {
				this.field1317 += var1;
				this.skipSubStreams(var1);
				return;
			}

			int var2 = this.field1315 - this.field1317;
			this.skipSubStreams(var2);
			var1 -= var2;
			this.field1317 += var2;
			this.method2439();
			PcmStreamMixerListener var3 = (PcmStreamMixerListener)this.field1316.last();
			synchronized(var3) {
				int var5 = var3.update();
				if (var5 < 0) {
					var3.field1420 = 0;
					this.method2478(var3);
				} else {
					var3.field1420 = var5;
					this.method2443(var3.previous, var3);
				}
			}
		} while(var1 != 0);

	}

	@ObfuscatedName("p")
	@Export("skipSubStreams")
	void skipSubStreams(int var1) {
		for (PcmStream var2 = (PcmStream)this.subStreams.last(); var2 != null; var2 = (PcmStream)this.subStreams.previous()) {
			var2.skip(var1);
		}

	}
}
