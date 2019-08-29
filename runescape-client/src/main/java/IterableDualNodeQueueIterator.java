import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jz")
@Implements("IterableDualNodeQueueIterator")
public class IterableDualNodeQueueIterator implements Iterator {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Ljm;"
	)
	@Export("queue")
	IterableDualNodeQueue queue;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lfe;"
	)
	@Export("head")
	DualNode head;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lfe;"
	)
	@Export("last")
	DualNode last;

	@ObfuscatedSignature(
		signature = "(Ljm;)V"
	)
	IterableDualNodeQueueIterator(IterableDualNodeQueue var1) {
		this.last = null;
		this.queue = var1;
		this.head = this.queue.sentinel.previousDual;
		this.last = null;
	}

	public boolean hasNext() {
		return this.queue.sentinel != this.head;
	}

	public void remove() {
		if (this.last == null) {
			throw new IllegalStateException();
		} else {
			this.last.removeDual();
			this.last = null;
		}
	}

	public Object next() {
		DualNode var1 = this.head;
		if (var1 == this.queue.sentinel) {
			var1 = null;
			this.head = null;
		} else {
			this.head = var1.previousDual;
		}

		this.last = var1;
		return var1;
	}
}
