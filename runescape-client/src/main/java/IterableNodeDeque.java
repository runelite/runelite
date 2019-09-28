import java.util.Collection;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("js")
@Implements("IterableNodeDeque")
public class IterableNodeDeque implements Iterable, Collection {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lfx;"
	)
	@Export("sentinel")
	Node sentinel;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lfx;"
	)
	Node field3521;

	public IterableNodeDeque() {
		this.sentinel = new Node();
		this.sentinel.previous = this.sentinel;
		this.sentinel.next = this.sentinel;
	}

	@ObfuscatedName("z")
	@Export("rsClear")
	public void rsClear() {
		while (this.sentinel.previous != this.sentinel) {
			this.sentinel.previous.remove();
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lfx;)V"
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

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lfx;)V"
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

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "()Lfx;"
	)
	@Export("last")
	public Node last() {
		return this.method4796((Node)null);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lfx;)Lfx;"
	)
	Node method4796(Node var1) {
		Node var2;
		if (var1 == null) {
			var2 = this.sentinel.previous;
		} else {
			var2 = var1;
		}

		if (var2 == this.sentinel) {
			this.field3521 = null;
			return null;
		} else {
			this.field3521 = var2.previous;
			return var2;
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "()Lfx;"
	)
	@Export("previous")
	public Node previous() {
		Node var1 = this.field3521;
		if (var1 == this.sentinel) {
			this.field3521 = null;
			return null;
		} else {
			this.field3521 = var1.previous;
			return var1;
		}
	}

	@ObfuscatedName("m")
	int method4774() {
		int var1 = 0;

		for (Node var2 = this.sentinel.previous; var2 != this.sentinel; var2 = var2.previous) {
			++var1;
		}

		return var1;
	}

	@ObfuscatedName("y")
	public boolean method4775() {
		return this.sentinel.previous == this.sentinel;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "()[Lfx;"
	)
	Node[] method4819() {
		Node[] var1 = new Node[this.method4774()];
		int var2 = 0;

		for (Node var3 = this.sentinel.previous; var3 != this.sentinel; var3 = var3.previous) {
			var1[var2++] = var3;
		}

		return var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lfx;)Z"
	)
	boolean method4778(Node var1) {
		this.addFirst(var1);
		return true;
	}

	public Iterator iterator() {
		return new IterableNodeDequeDescendingIterator(this);
	}

	public int size() {
		return this.method4774();
	}

	public boolean isEmpty() {
		return this.method4775();
	}

	public boolean contains(Object var1) {
		throw new RuntimeException();
	}

	public Object[] toArray(Object[] var1) {
		int var2 = 0;

		for (Node var3 = this.sentinel.previous; var3 != this.sentinel; var3 = var3.previous) {
			var1[var2++] = var3;
		}

		return var1;
	}

	public void clear() {
		this.rsClear();
	}

	public boolean add(Object var1) {
		return this.method4778((Node)var1);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	public boolean retainAll(Collection var1) {
		throw new RuntimeException();
	}

	public int hashCode() {
		return super.hashCode();
	}

	public boolean containsAll(Collection var1) {
		throw new RuntimeException();
	}

	public boolean addAll(Collection var1) {
		throw new RuntimeException();
	}

	public boolean remove(Object var1) {
		throw new RuntimeException();
	}

	public Object[] toArray() {
		return this.method4819();
	}

	public boolean removeAll(Collection var1) {
		throw new RuntimeException();
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lfx;Lfx;)V"
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
