import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
@Implements("IterableNodeDequeDescendingIterator")
public class IterableNodeDequeDescendingIterator implements Iterator {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Ljm;"
	)
	@Export("deque")
	IterableNodeDeque deque;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lga;"
	)
	Node field3539;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lga;"
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

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljm;)V"
	)
	@Export("setDeque")
	void setDeque(IterableNodeDeque var1) {
		this.deque = var1;
		this.start();
	}

	@ObfuscatedName("z")
	@Export("start")
	void start() {
		this.field3539 = this.deque != null ? this.deque.sentinel.previous : null;
		this.last = null;
	}

	public Object next() {
		Node var1 = this.field3539;
		if (var1 == this.deque.sentinel) {
			var1 = null;
			this.field3539 = null;
		} else {
			this.field3539 = var1.previous;
		}

		this.last = var1;
		return var1;
	}

	public boolean hasNext() {
		return this.deque.sentinel != this.field3539;
	}

	public void remove() {
		this.last.remove();
		this.last = null;
	}
}
