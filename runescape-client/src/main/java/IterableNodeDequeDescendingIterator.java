import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ja")
@Implements("IterableNodeDequeDescendingIterator")
public class IterableNodeDequeDescendingIterator implements Iterator {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Ljl;"
	)
	@Export("deque")
	IterableNodeDeque deque;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lgk;"
	)
	Node field3509;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lgk;"
	)
	@Export("last")
	Node last;

	@ObfuscatedSignature(
		signature = "(Ljl;)V"
	)
	IterableNodeDequeDescendingIterator(IterableNodeDeque var1) {
		this.last = null;
		this.setDeque(var1);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljl;)V"
	)
	@Export("setDeque")
	void setDeque(IterableNodeDeque var1) {
		this.deque = var1;
		this.start();
	}

	@ObfuscatedName("o")
	@Export("start")
	void start() {
		this.field3509 = this.deque != null ? this.deque.sentinel.previous : null;
		this.last = null;
	}

	public Object next() {
		Node var1 = this.field3509;
		if (var1 == this.deque.sentinel) {
			var1 = null;
			this.field3509 = null;
		} else {
			this.field3509 = var1.previous;
		}

		this.last = var1;
		return var1;
	}

	public boolean hasNext() {
		return this.deque.sentinel != this.field3509;
	}

	public void remove() {
		this.last.remove();
		this.last = null;
	}
}
