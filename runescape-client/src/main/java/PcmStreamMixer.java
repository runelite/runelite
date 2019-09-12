import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("PcmStreamMixer")
public class PcmStreamMixer extends PcmStream {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	@Export("subStreams")
	NodeDeque subStreams;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	NodeDeque field1307;
	@ObfuscatedName("t")
	int field1308;
	@ObfuscatedName("g")
	int field1309;

	public PcmStreamMixer() {
		this.subStreams = new NodeDeque();
		this.field1307 = new NodeDeque();
		this.field1308 = 0;
		this.field1309 = -1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ldg;)V"
	)
	@Export("addSubStream")
	public final synchronized void addSubStream(PcmStream var1) {
		this.subStreams.addLast(var1);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ldg;)V"
	)
	@Export("removeSubStream")
	public final synchronized void removeSubStream(PcmStream var1) {
		var1.remove();
	}

	@ObfuscatedName("t")
	void method2292() {
		if (this.field1308 > 0) {
			for (PcmStreamMixerListener var1 = (PcmStreamMixerListener)this.field1307.last(); var1 != null; var1 = (PcmStreamMixerListener)this.field1307.previous()) {
				var1.field1418 -= this.field1308;
			}

			this.field1309 -= this.field1308;
			this.field1308 = 0;
		}

	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lfn;Ldp;)V"
	)
	void method2267(Node var1, PcmStreamMixerListener var2) {
		while (this.field1307.sentinel != var1 && ((PcmStreamMixerListener)var1).field1418 <= var2.field1418) {
			var1 = var1.previous;
		}

		NodeDeque.NodeDeque_addBefore(var2, var1);
		this.field1309 = ((PcmStreamMixerListener)this.field1307.sentinel.previous).field1418;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Ldp;)V"
	)
	void method2296(PcmStreamMixerListener var1) {
		var1.remove();
		var1.remove2();
		Node var2 = this.field1307.sentinel.previous;
		if (var2 == this.field1307.sentinel) {
			this.field1309 = -1;
		} else {
			this.field1309 = ((PcmStreamMixerListener)var2).field1418;
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "()Ldg;"
	)
	@Export("firstSubStream")
	protected PcmStream firstSubStream() {
		return (PcmStream)this.subStreams.last();
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "()Ldg;"
	)
	@Export("nextSubStream")
	protected PcmStream nextSubStream() {
		return (PcmStream)this.subStreams.previous();
	}

	@ObfuscatedName("v")
	protected int vmethod3881() {
		return 0;
	}

	@ObfuscatedName("d")
	@Export("fill")
	public final synchronized void fill(int[] var1, int var2, int var3) {
		do {
			if (this.field1309 < 0) {
				this.updateSubStreams(var1, var2, var3);
				return;
			}

			if (var3 + this.field1308 < this.field1309) {
				this.field1308 += var3;
				this.updateSubStreams(var1, var2, var3);
				return;
			}

			int var4 = this.field1309 - this.field1308;
			this.updateSubStreams(var1, var2, var4);
			var2 += var4;
			var3 -= var4;
			this.field1308 += var4;
			this.method2292();
			PcmStreamMixerListener var5 = (PcmStreamMixerListener)this.field1307.last();
			synchronized(var5) {
				int var7 = var5.update();
				if (var7 < 0) {
					var5.field1418 = 0;
					this.method2296(var5);
				} else {
					var5.field1418 = var7;
					this.method2267(var5.previous, var5);
				}
			}
		} while(var3 != 0);

	}

	@ObfuscatedName("z")
	@Export("updateSubStreams")
	void updateSubStreams(int[] var1, int var2, int var3) {
		for (PcmStream var4 = (PcmStream)this.subStreams.last(); var4 != null; var4 = (PcmStream)this.subStreams.previous()) {
			var4.update(var1, var2, var3);
		}

	}

	@ObfuscatedName("s")
	@Export("skip")
	public final synchronized void skip(int var1) {
		do {
			if (this.field1309 < 0) {
				this.skipSubStreams(var1);
				return;
			}

			if (this.field1308 + var1 < this.field1309) {
				this.field1308 += var1;
				this.skipSubStreams(var1);
				return;
			}

			int var2 = this.field1309 - this.field1308;
			this.skipSubStreams(var2);
			var1 -= var2;
			this.field1308 += var2;
			this.method2292();
			PcmStreamMixerListener var3 = (PcmStreamMixerListener)this.field1307.last();
			synchronized(var3) {
				int var5 = var3.update();
				if (var5 < 0) {
					var3.field1418 = 0;
					this.method2296(var3);
				} else {
					var3.field1418 = var5;
					this.method2267(var3.previous, var3);
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
