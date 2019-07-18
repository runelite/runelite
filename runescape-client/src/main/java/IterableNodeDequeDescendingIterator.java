import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jq")
@Implements("IterableNodeDequeDescendingIterator")
public class IterableNodeDequeDescendingIterator implements Iterator {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lju;"
	)
	@Export("deque")
	IterableNodeDeque deque;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lfw;"
	)
	Node field3549;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lfw;"
	)
	@Export("last")
	Node last;

	@ObfuscatedSignature(
		signature = "(Lju;)V"
	)
	IterableNodeDequeDescendingIterator(IterableNodeDeque var1) {
		this.last = null;
		this.setDeque(var1);
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lju;)V"
	)
	@Export("setDeque")
	void setDeque(IterableNodeDeque var1) {
		this.deque = var1;
		this.start();
	}

	@ObfuscatedName("i")
	@Export("start")
	void start() {
		this.field3549 = this.deque != null ? this.deque.sentinel.previous : null;
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
		Node var1 = this.field3549;
		if (var1 == this.deque.sentinel) {
			var1 = null;
			this.field3549 = null;
		} else {
			this.field3549 = var1.previous;
		}

		this.last = var1;
		return var1;
	}

	public boolean hasNext() {
		return this.deque.sentinel != this.field3549;
	}
}
