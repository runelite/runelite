import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jh")
@Implements("IterableNodeDequeDescendingIterator")
public class IterableNodeDequeDescendingIterator implements Iterator {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Ljd;"
	)
	@Export("deque")
	IterableNodeDeque deque;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lfn;"
	)
	Node field3516;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lfn;"
	)
	@Export("last")
	Node last;

	@ObfuscatedSignature(
		signature = "(Ljd;)V"
	)
	IterableNodeDequeDescendingIterator(IterableNodeDeque var1) {
		this.last = null;
		this.setDeque(var1);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Ljd;)V"
	)
	@Export("setDeque")
	void setDeque(IterableNodeDeque var1) {
		this.deque = var1;
		this.start();
	}

	@ObfuscatedName("v")
	@Export("start")
	void start() {
		this.field3516 = this.deque != null ? this.deque.sentinel.previous : null;
		this.last = null;
	}

	public boolean hasNext() {
		return this.deque.sentinel != this.field3516;
	}

	public Object next() {
		Node var1 = this.field3516;
		if (var1 == this.deque.sentinel) {
			var1 = null;
			this.field3516 = null;
		} else {
			this.field3516 = var1.previous;
		}

		this.last = var1;
		return var1;
	}

	public void remove() {
		this.last.remove();
		this.last = null;
	}
}
