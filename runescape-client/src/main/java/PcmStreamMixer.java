import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("PcmStreamMixer")
public class PcmStreamMixer extends PcmStream {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Ljw;"
	)
	@Export("subStreams")
	NodeDeque subStreams;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Ljw;"
	)
	NodeDeque field1327;
	@ObfuscatedName("o")
	int field1329;
	@ObfuscatedName("e")
	int field1328;

	public PcmStreamMixer() {
		this.subStreams = new NodeDeque();
		this.field1327 = new NodeDeque();
		this.field1329 = 0;
		this.field1328 = -1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ldn;)V"
	)
	@Export("addSubStream")
	public final synchronized void addSubStream(PcmStream var1) {
		this.subStreams.addLast(var1);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ldn;)V"
	)
	@Export("removeSubStream")
	public final synchronized void removeSubStream(PcmStream var1) {
		var1.remove();
	}

	@ObfuscatedName("o")
	void method2352() {
		if (this.field1329 > 0) {
			for (PcmStreamMixerListener var1 = (PcmStreamMixerListener)this.field1327.last(); var1 != null; var1 = (PcmStreamMixerListener)this.field1327.previous()) {
				var1.field1435 -= this.field1329;
			}

			this.field1328 -= this.field1329;
			this.field1329 = 0;
		}

	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lft;Ldi;)V"
	)
	void method2353(Node var1, PcmStreamMixerListener var2) {
		while (this.field1327.sentinel != var1 && ((PcmStreamMixerListener)var1).field1435 <= var2.field1435) {
			var1 = var1.previous;
		}

		NodeDeque.NodeDeque_addBefore(var2, var1);
		this.field1328 = ((PcmStreamMixerListener)this.field1327.sentinel.previous).field1435;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Ldi;)V"
	)
	void method2354(PcmStreamMixerListener var1) {
		var1.remove();
		var1.remove2();
		Node var2 = this.field1327.sentinel.previous;
		if (var2 == this.field1327.sentinel) {
			this.field1328 = -1;
		} else {
			this.field1328 = ((PcmStreamMixerListener)var2).field1435;
		}

	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "()Ldn;"
	)
	@Export("firstSubStream")
	protected PcmStream firstSubStream() {
		return (PcmStream)this.subStreams.last();
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "()Ldn;"
	)
	@Export("nextSubStream")
	protected PcmStream nextSubStream() {
		return (PcmStream)this.subStreams.previous();
	}

	@ObfuscatedName("l")
	protected int vmethod3965() {
		return 0;
	}

	@ObfuscatedName("j")
	@Export("fill")
	public final synchronized void fill(int[] var1, int var2, int var3) {
		do {
			if (this.field1328 < 0) {
				this.updateSubStreams(var1, var2, var3);
				return;
			}

			if (var3 + this.field1329 < this.field1328) {
				this.field1329 += var3;
				this.updateSubStreams(var1, var2, var3);
				return;
			}

			int var4 = this.field1328 - this.field1329;
			this.updateSubStreams(var1, var2, var4);
			var2 += var4;
			var3 -= var4;
			this.field1329 += var4;
			this.method2352();
			PcmStreamMixerListener var5 = (PcmStreamMixerListener)this.field1327.last();
			synchronized(var5) {
				int var7 = var5.update();
				if (var7 < 0) {
					var5.field1435 = 0;
					this.method2354(var5);
				} else {
					var5.field1435 = var7;
					this.method2353(var5.previous, var5);
				}
			}
		} while(var3 != 0);

	}

	@ObfuscatedName("m")
	@Export("updateSubStreams")
	void updateSubStreams(int[] var1, int var2, int var3) {
		for (PcmStream var4 = (PcmStream)this.subStreams.last(); var4 != null; var4 = (PcmStream)this.subStreams.previous()) {
			var4.update(var1, var2, var3);
		}

	}

	@ObfuscatedName("p")
	@Export("skip")
	public final synchronized void skip(int var1) {
		do {
			if (this.field1328 < 0) {
				this.skipSubStreams(var1);
				return;
			}

			if (this.field1329 + var1 < this.field1328) {
				this.field1329 += var1;
				this.skipSubStreams(var1);
				return;
			}

			int var2 = this.field1328 - this.field1329;
			this.skipSubStreams(var2);
			var1 -= var2;
			this.field1329 += var2;
			this.method2352();
			PcmStreamMixerListener var3 = (PcmStreamMixerListener)this.field1327.last();
			synchronized(var3) {
				int var5 = var3.update();
				if (var5 < 0) {
					var3.field1435 = 0;
					this.method2354(var3);
				} else {
					var3.field1435 = var5;
					this.method2353(var3.previous, var3);
				}
			}
		} while(var1 != 0);

	}

	@ObfuscatedName("h")
	@Export("skipSubStreams")
	void skipSubStreams(int var1) {
		for (PcmStream var2 = (PcmStream)this.subStreams.last(); var2 != null; var2 = (PcmStream)this.subStreams.previous()) {
			var2.skip(var1);
		}

	}
}
