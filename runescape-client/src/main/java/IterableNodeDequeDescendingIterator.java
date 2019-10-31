import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
@Implements("IterableNodeDequeDescendingIterator")
public class IterableNodeDequeDescendingIterator implements Iterator {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Ljm;"
	)
	@Export("deque")
	IterableNodeDeque deque;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lfd;"
	)
	Node field3535;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lfd;"
	)
	@Export("last")
	Node last;

	@ObfuscatedSignature(
		signature = "(Ljm;)V"
	)
	IterableNodeDequeDescendingIterator(IterableNodeDeque var1) {
		this.last = null;
		this.setDeque(var1);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Ljm;)V"
	)
	@Export("setDeque")
	void setDeque(IterableNodeDeque var1) {
		this.deque = var1;
		this.start();
	}

	@ObfuscatedName("m")
	@Export("start")
	void start() {
		this.field3535 = this.deque != null ? this.deque.sentinel.previous : null;
		this.last = null;
	}

	public boolean hasNext() {
		return this.deque.sentinel != this.field3535;
	}

	public void remove() {
		if (this.last == null) {
			throw new IllegalStateException();
		} else {
			this.last.remove();
			this.last = null;
		}
	}

	public Object next() {
		Node var1 = this.field3535;
		if (var1 == this.deque.sentinel) {
			var1 = null;
			this.field3535 = null;
		} else {
			this.field3535 = var1.previous;
		}

		this.last = var1;
		return var1;
	}
}
