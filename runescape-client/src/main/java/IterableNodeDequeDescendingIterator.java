import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jv")
@Implements("IterableNodeDequeDescendingIterator")
public class IterableNodeDequeDescendingIterator implements Iterator {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	@Export("deque")
	IterableNodeDeque deque;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lft;"
	)
	Node field3538;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lft;"
	)
	@Export("last")
	Node last;

	@ObfuscatedSignature(
		signature = "(Ljj;)V"
	)
	IterableNodeDequeDescendingIterator(IterableNodeDeque var1) {
		this.last = null;
		this.setDeque(var1);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Ljj;)V"
	)
	@Export("setDeque")
	void setDeque(IterableNodeDeque var1) {
		this.deque = var1;
		this.start();
	}

	@ObfuscatedName("m")
	@Export("start")
	void start() {
		this.field3538 = this.deque != null ? this.deque.sentinel.previous : null;
		this.last = null;
	}

	public boolean hasNext() {
		return this.deque.sentinel != this.field3538;
	}

	public Object next() {
		Node var1 = this.field3538;
		if (var1 == this.deque.sentinel) {
			var1 = null;
			this.field3538 = null;
		} else {
			this.field3538 = var1.previous;
		}

		this.last = var1;
		return var1;
	}

	public void remove() {
		if (this.last == null) {
			throw new IllegalStateException();
		} else {
			this.last.remove();
			this.last = null;
		}
	}
}
