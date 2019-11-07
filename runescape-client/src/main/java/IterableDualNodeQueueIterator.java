import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jd")
@Implements("IterableDualNodeQueueIterator")
public class IterableDualNodeQueueIterator implements Iterator {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Ljq;"
	)
	@Export("queue")
	IterableDualNodeQueue queue;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lfa;"
	)
	@Export("head")
	DualNode head;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lfa;"
	)
	@Export("last")
	DualNode last;

	@ObfuscatedSignature(
		signature = "(Ljq;)V"
	)
	IterableDualNodeQueueIterator(IterableDualNodeQueue var1) {
		this.last = null;
		this.queue = var1;
		this.head = this.queue.sentinel.previousDual;
		this.last = null;
	}

	public void remove() {
		this.last.removeDual();
		this.last = null;
	}

	public boolean hasNext() {
		return this.queue.sentinel != this.head;
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
