import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jn")
@Implements("IterableNodeDequeDescendingIterator")
public class IterableNodeDequeDescendingIterator implements Iterator {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Ljp;"
	)
	@Export("deque")
	IterableNodeDeque deque;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lfb;"
	)
	Node field3521;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lfb;"
	)
	@Export("last")
	Node last;

	@ObfuscatedSignature(
		signature = "(Ljp;)V"
	)
	IterableNodeDequeDescendingIterator(IterableNodeDeque var1) {
		this.last = null;
		this.setDeque(var1);
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(Ljp;)V"
	)
	@Export("setDeque")
	void setDeque(IterableNodeDeque var1) {
		this.deque = var1;
		this.start();
	}

	@ObfuscatedName("y")
	@Export("start")
	void start() {
		this.field3521 = this.deque != null ? this.deque.sentinel.previous : null;
		this.last = null;
	}

	public boolean hasNext() {
		return this.deque.sentinel != this.field3521;
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
		Node var1 = this.field3521;
		if (var1 == this.deque.sentinel) {
			var1 = null;
			this.field3521 = null;
		} else {
			this.field3521 = var1.previous;
		}

		this.last = var1;
		return var1;
	}
}
