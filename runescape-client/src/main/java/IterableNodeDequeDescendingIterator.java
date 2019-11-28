import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jp")
@Implements("IterableNodeDequeDescendingIterator")
public class IterableNodeDequeDescendingIterator implements Iterator {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Ljm;"
	)
	@Export("deque")
	IterableNodeDeque deque;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lfb;"
	)
	Node field3545;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lfb;"
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

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Ljm;)V"
	)
	@Export("setDeque")
	void setDeque(IterableNodeDeque var1) {
		this.deque = var1;
		this.start();
	}

	@ObfuscatedName("w")
	@Export("start")
	void start() {
		this.field3545 = this.deque != null ? this.deque.sentinel.previous : null;
		this.last = null;
	}

	public void remove() {
		this.last.remove();
		this.last = null;
	}

	public boolean hasNext() {
		return this.deque.sentinel != this.field3545;
	}

	public Object next() {
		Node var1 = this.field3545;
		if (var1 == this.deque.sentinel) {
			var1 = null;
			this.field3545 = null;
		} else {
			this.field3545 = var1.previous;
		}

		this.last = var1;
		return var1;
	}
}
