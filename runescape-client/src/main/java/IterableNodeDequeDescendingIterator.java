import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jx")
@Implements("IterableNodeDequeDescendingIterator")
public class IterableNodeDequeDescendingIterator implements Iterator {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Ljs;"
	)
	@Export("deque")
	IterableNodeDeque deque;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lfx;"
	)
	Node field3531;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lfx;"
	)
	@Export("last")
	Node last;

	@ObfuscatedSignature(
		signature = "(Ljs;)V"
	)
	IterableNodeDequeDescendingIterator(IterableNodeDeque var1) {
		this.last = null;
		this.setDeque(var1);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Ljs;)V"
	)
	@Export("setDeque")
	void setDeque(IterableNodeDeque var1) {
		this.deque = var1;
		this.start();
	}

	@ObfuscatedName("c")
	@Export("start")
	void start() {
		this.field3531 = this.deque != null ? this.deque.sentinel.previous : null;
		this.last = null;
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
		Node var1 = this.field3531;
		if (var1 == this.deque.sentinel) {
			var1 = null;
			this.field3531 = null;
		} else {
			this.field3531 = var1.previous;
		}

		this.last = var1;
		return var1;
	}

	public boolean hasNext() {
		return this.deque.sentinel != this.field3531;
	}
}
