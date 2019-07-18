import java.util.Collection;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
@Implements("IterableNodeDeque")
public class IterableNodeDeque implements Iterable, Collection {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lfw;"
	)
	@Export("sentinel")
	Node sentinel;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lfw;"
	)
	Node field3538;

	public IterableNodeDeque() {
		this.sentinel = new Node();
		this.sentinel.previous = this.sentinel;
		this.sentinel.next = this.sentinel;
	}

	@ObfuscatedName("q")
	@Export("rsClear")
	public void rsClear() {
		while (this.sentinel.previous != this.sentinel) {
			this.sentinel.previous.remove();
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lfw;)V"
	)
	@Export("addFirst")
	public void addFirst(Node var1) {
		if (var1.next != null) {
			var1.remove();
		}

		var1.next = this.sentinel.next;
		var1.previous = this.sentinel;
		var1.next.previous = var1;
		var1.previous.next = var1;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lfw;)V"
	)
	@Export("addLast")
	public void addLast(Node var1) {
		if (var1.next != null) {
			var1.remove();
		}

		var1.next = this.sentinel;
		var1.previous = this.sentinel.previous;
		var1.next.previous = var1;
		var1.previous.next = var1;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "()Lfw;"
	)
	@Export("last")
	public Node last() {
		return this.method4807((Node)null);
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lfw;)Lfw;"
	)
	Node method4807(Node var1) {
		Node var2;
		if (var1 == null) {
			var2 = this.sentinel.previous;
		} else {
			var2 = var1;
		}

		if (var2 == this.sentinel) {
			this.field3538 = null;
			return null;
		} else {
			this.field3538 = var2.previous;
			return var2;
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "()Lfw;"
	)
	@Export("previous")
	public Node previous() {
		Node var1 = this.field3538;
		if (var1 == this.sentinel) {
			this.field3538 = null;
			return null;
		} else {
			this.field3538 = var1.previous;
			return var1;
		}
	}

	@ObfuscatedName("i")
	int method4884() {
		int var1 = 0;

		for (Node var2 = this.sentinel.previous; var2 != this.sentinel; var2 = var2.previous) {
			++var1;
		}

		return var1;
	}

	@ObfuscatedName("c")
	@Export("isEmpty")
	public boolean rsIsEmpty() {
		return this.sentinel.previous == this.sentinel;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "()[Lfw;"
	)
	Node[] method4811() {
		Node[] var1 = new Node[this.method4884()];
		int var2 = 0;

		for (Node var3 = this.sentinel.previous; var3 != this.sentinel; var3 = var3.previous) {
			var1[var2++] = var3;
		}

		return var1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lfw;)Z"
	)
	boolean method4847(Node var1) {
		this.addFirst(var1);
		return true;
	}

	public void clear() {
		this.rsClear();
	}

	public boolean isEmpty() {
		return this.rsIsEmpty();
	}

	public boolean contains(Object var1) {
		throw new RuntimeException();
	}

	public Object[] toArray() {
		return this.method4811();
	}

	public Object[] toArray(Object[] var1) {
		int var2 = 0;

		for (Node var3 = this.sentinel.previous; var3 != this.sentinel; var3 = var3.previous) {
			var1[var2++] = var3;
		}

		return var1;
	}

	public boolean containsAll(Collection var1) {
		throw new RuntimeException();
	}

	public boolean removeAll(Collection var1) {
		throw new RuntimeException();
	}

	public int hashCode() {
		return super.hashCode();
	}

	public boolean addAll(Collection var1) {
		throw new RuntimeException();
	}

	public int size() {
		return this.method4884();
	}

	public boolean remove(Object var1) {
		throw new RuntimeException();
	}

	public Iterator iterator() {
		return new IterableNodeDequeDescendingIterator(this);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	public boolean retainAll(Collection var1) {
		throw new RuntimeException();
	}

	public boolean add(Object var1) {
		return this.method4847((Node)var1);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lfw;Lfw;)V"
	)
	@Export("IterableNodeDeque_addBefore")
	public static void IterableNodeDeque_addBefore(Node var0, Node var1) {
		if (var0.next != null) {
			var0.remove();
		}

		var0.next = var1;
		var0.previous = var1.previous;
		var0.next.previous = var0;
		var0.previous.next = var0;
	}
}
