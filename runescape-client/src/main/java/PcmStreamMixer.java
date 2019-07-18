import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("PcmStreamMixer")
public class PcmStreamMixer extends PcmStream {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	@Export("subStreams")
	NodeDeque subStreams;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	NodeDeque field1342;
	@ObfuscatedName("p")
	int field1343;
	@ObfuscatedName("k")
	int field1344;

	public PcmStreamMixer() {
		this.subStreams = new NodeDeque();
		this.field1342 = new NodeDeque();
		this.field1343 = 0;
		this.field1344 = -1;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ldx;)V"
	)
	@Export("addSubStream")
	public final synchronized void addSubStream(PcmStream var1) {
		this.subStreams.addLast(var1);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Ldx;)V"
	)
	@Export("removeSubStream")
	public final synchronized void removeSubStream(PcmStream var1) {
		var1.remove();
	}

	@ObfuscatedName("e")
	void method2283() {
		if (this.field1343 > 0) {
			for (PcmStreamMixerListener var1 = (PcmStreamMixerListener)this.field1342.last(); var1 != null; var1 = (PcmStreamMixerListener)this.field1342.previous()) {
				var1.field1452 -= this.field1343;
			}

			this.field1344 -= this.field1343;
			this.field1343 = 0;
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lfw;Ldj;)V"
	)
	void method2273(Node var1, PcmStreamMixerListener var2) {
		while (this.field1342.sentinel != var1 && ((PcmStreamMixerListener)var1).field1452 <= var2.field1452) {
			var1 = var1.previous;
		}

		NodeDeque.NodeDeque_addBefore(var2, var1);
		this.field1344 = ((PcmStreamMixerListener)this.field1342.sentinel.previous).field1452;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Ldj;)V"
	)
	void method2274(PcmStreamMixerListener var1) {
		var1.remove();
		var1.remove2();
		Node var2 = this.field1342.sentinel.previous;
		if (var2 == this.field1342.sentinel) {
			this.field1344 = -1;
		} else {
			this.field1344 = ((PcmStreamMixerListener)var2).field1452;
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "()Ldx;"
	)
	protected PcmStream firstSubStream() {
		return (PcmStream)this.subStreams.last();
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "()Ldx;"
	)
	protected PcmStream nextSubStream() {
		return (PcmStream)this.subStreams.previous();
	}

	@ObfuscatedName("i")
	protected int vmethod3892() {
		return 0;
	}

	@ObfuscatedName("c")
	@Export("fill")
	public final synchronized void fill(int[] var1, int var2, int var3) {
		do {
			if (this.field1344 < 0) {
				this.updateSubStreams(var1, var2, var3);
				return;
			}

			if (var3 + this.field1343 < this.field1344) {
				this.field1343 += var3;
				this.updateSubStreams(var1, var2, var3);
				return;
			}

			int var4 = this.field1344 - this.field1343;
			this.updateSubStreams(var1, var2, var4);
			var2 += var4;
			var3 -= var4;
			this.field1343 += var4;
			this.method2283();
			PcmStreamMixerListener var5 = (PcmStreamMixerListener)this.field1342.last();
			synchronized(var5) {
				int var7 = var5.update();
				if (var7 < 0) {
					var5.field1452 = 0;
					this.method2274(var5);
				} else {
					var5.field1452 = var7;
					this.method2273(var5.previous, var5);
				}
			}
		} while(var3 != 0);

	}

	@ObfuscatedName("u")
	@Export("updateSubStreams")
	void updateSubStreams(int[] var1, int var2, int var3) {
		for (PcmStream var4 = (PcmStream)this.subStreams.last(); var4 != null; var4 = (PcmStream)this.subStreams.previous()) {
			var4.update(var1, var2, var3);
		}

	}

	@ObfuscatedName("x")
	@Export("skip")
	public final synchronized void skip(int var1) {
		do {
			if (this.field1344 < 0) {
				this.skipSubStreams(var1);
				return;
			}

			if (this.field1343 + var1 < this.field1344) {
				this.field1343 += var1;
				this.skipSubStreams(var1);
				return;
			}

			int var2 = this.field1344 - this.field1343;
			this.skipSubStreams(var2);
			var1 -= var2;
			this.field1343 += var2;
			this.method2283();
			PcmStreamMixerListener var3 = (PcmStreamMixerListener)this.field1342.last();
			synchronized(var3) {
				int var5 = var3.update();
				if (var5 < 0) {
					var3.field1452 = 0;
					this.method2274(var3);
				} else {
					var3.field1452 = var5;
					this.method2273(var3.previous, var3);
				}
			}
		} while(var1 != 0);

	}

	@ObfuscatedName("r")
	@Export("skipSubStreams")
	void skipSubStreams(int var1) {
		for (PcmStream var2 = (PcmStream)this.subStreams.last(); var2 != null; var2 = (PcmStream)this.subStreams.previous()) {
			var2.skip(var1);
		}

	}
}
