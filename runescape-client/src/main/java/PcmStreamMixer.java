import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("PcmStreamMixer")
public class PcmStreamMixer extends PcmStream {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Ljs;"
	)
	@Export("subStreams")
	NodeDeque subStreams;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Ljs;"
	)
	NodeDeque field1303;
	@ObfuscatedName("y")
	int field1305;
	@ObfuscatedName("p")
	int field1306;

	public PcmStreamMixer() {
		this.subStreams = new NodeDeque();
		this.field1303 = new NodeDeque();
		this.field1305 = 0;
		this.field1306 = -1;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Ldl;)V"
	)
	@Export("addSubStream")
	public final synchronized void addSubStream(PcmStream var1) {
		this.subStreams.addLast(var1);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Ldl;)V"
	)
	@Export("removeSubStream")
	public final synchronized void removeSubStream(PcmStream var1) {
		var1.remove();
	}

	@ObfuscatedName("y")
	void method2300() {
		if (this.field1305 > 0) {
			for (PcmStreamMixerListener var1 = (PcmStreamMixerListener)this.field1303.last(); var1 != null; var1 = (PcmStreamMixerListener)this.field1303.previous()) {
				var1.field1410 -= this.field1305;
			}

			this.field1306 -= this.field1305;
			this.field1305 = 0;
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lgk;Ldf;)V"
	)
	void method2309(Node var1, PcmStreamMixerListener var2) {
		while (this.field1303.sentinel != var1 && ((PcmStreamMixerListener)var1).field1410 <= var2.field1410) {
			var1 = var1.previous;
		}

		NodeDeque.NodeDeque_addBefore(var2, var1);
		this.field1306 = ((PcmStreamMixerListener)this.field1303.sentinel.previous).field1410;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Ldf;)V"
	)
	void method2302(PcmStreamMixerListener var1) {
		var1.remove();
		var1.remove2();
		Node var2 = this.field1303.sentinel.previous;
		if (var2 == this.field1303.sentinel) {
			this.field1306 = -1;
		} else {
			this.field1306 = ((PcmStreamMixerListener)var2).field1410;
		}

	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "()Ldl;"
	)
	@Export("firstSubStream")
	protected PcmStream firstSubStream() {
		return (PcmStream)this.subStreams.last();
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "()Ldl;"
	)
	@Export("nextSubStream")
	protected PcmStream nextSubStream() {
		return (PcmStream)this.subStreams.previous();
	}

	@ObfuscatedName("x")
	protected int vmethod3889() {
		return 0;
	}

	@ObfuscatedName("a")
	@Export("fill")
	public final synchronized void fill(int[] var1, int var2, int var3) {
		do {
			if (this.field1306 < 0) {
				this.updateSubStreams(var1, var2, var3);
				return;
			}

			if (var3 + this.field1305 < this.field1306) {
				this.field1305 += var3;
				this.updateSubStreams(var1, var2, var3);
				return;
			}

			int var4 = this.field1306 - this.field1305;
			this.updateSubStreams(var1, var2, var4);
			var2 += var4;
			var3 -= var4;
			this.field1305 += var4;
			this.method2300();
			PcmStreamMixerListener var5 = (PcmStreamMixerListener)this.field1303.last();
			synchronized(var5) {
				int var7 = var5.update();
				if (var7 < 0) {
					var5.field1410 = 0;
					this.method2302(var5);
				} else {
					var5.field1410 = var7;
					this.method2309(var5.previous, var5);
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

	@ObfuscatedName("c")
	@Export("skip")
	public final synchronized void skip(int var1) {
		do {
			if (this.field1306 < 0) {
				this.skipSubStreams(var1);
				return;
			}

			if (this.field1305 + var1 < this.field1306) {
				this.field1305 += var1;
				this.skipSubStreams(var1);
				return;
			}

			int var2 = this.field1306 - this.field1305;
			this.skipSubStreams(var2);
			var1 -= var2;
			this.field1305 += var2;
			this.method2300();
			PcmStreamMixerListener var3 = (PcmStreamMixerListener)this.field1303.last();
			synchronized(var3) {
				int var5 = var3.update();
				if (var5 < 0) {
					var3.field1410 = 0;
					this.method2302(var3);
				} else {
					var3.field1410 = var5;
					this.method2309(var3.previous, var3);
				}
			}
		} while(var1 != 0);

	}

	@ObfuscatedName("o")
	@Export("skipSubStreams")
	void skipSubStreams(int var1) {
		for (PcmStream var2 = (PcmStream)this.subStreams.last(); var2 != null; var2 = (PcmStream)this.subStreams.previous()) {
			var2.skip(var1);
		}

	}
}
