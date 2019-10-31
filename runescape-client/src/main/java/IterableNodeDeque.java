import java.util.Collection;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jm")
@Implements("IterableNodeDeque")
public class IterableNodeDeque implements Iterable, Collection {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lfd;"
	)
	@Export("sentinel")
	Node sentinel;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lfd;"
	)
	Node field3524;

	public IterableNodeDeque() {
		this.sentinel = new Node();
		this.sentinel.previous = this.sentinel;
		this.sentinel.next = this.sentinel;
	}

	@ObfuscatedName("a")
	@Export("rsClear")
	public void rsClear() {
		while (this.sentinel.previous != this.sentinel) {
			this.sentinel.previous.remove();
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lfd;)V"
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

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lfd;)V"
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

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "()Lfd;"
	)
	@Export("last")
	public Node last() {
		return this.method4954((Node)null);
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lfd;)Lfd;"
	)
	Node method4954(Node var1) {
		Node var2;
		if (var1 == null) {
			var2 = this.sentinel.previous;
		} else {
			var2 = var1;
		}

		if (var2 == this.sentinel) {
			this.field3524 = null;
			return null;
		} else {
			this.field3524 = var2.previous;
			return var2;
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "()Lfd;"
	)
	@Export("previous")
	public Node previous() {
		Node var1 = this.field3524;
		if (var1 == this.sentinel) {
			this.field3524 = null;
			return null;
		} else {
			this.field3524 = var1.previous;
			return var1;
		}
	}

	@ObfuscatedName("o")
	int method4956() {
		int var1 = 0;

		for (Node var2 = this.sentinel.previous; var2 != this.sentinel; var2 = var2.previous) {
			++var1;
		}

		return var1;
	}

	@ObfuscatedName("i")
	public boolean method5004() {
		return this.sentinel.previous == this.sentinel;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "()[Lfd;"
	)
	Node[] method4961() {
		Node[] var1 = new Node[this.method4956()];
		int var2 = 0;

		for (Node var3 = this.sentinel.previous; var3 != this.sentinel; var3 = var3.previous) {
			var1[var2++] = var3;
		}

		return var1;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lfd;)Z"
	)
	boolean method4963(Node var1) {
		this.addFirst(var1);
		return true;
	}

	public int size() {
		return this.method4956();
	}

	public boolean isEmpty() {
		return this.method5004();
	}

	public Object[] toArray() {
		return this.method4961();
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

	public boolean addAll(Collection var1) {
		throw new RuntimeException();
	}

	public boolean removeAll(Collection var1) {
		throw new RuntimeException();
	}

	public boolean retainAll(Collection var1) {
		throw new RuntimeException();
	}

	public int hashCode() {
		return super.hashCode();
	}

	public boolean contains(Object var1) {
		throw new RuntimeException();
	}

	public boolean remove(Object var1) {
		throw new RuntimeException();
	}

	public void clear() {
		this.rsClear();
	}

	public boolean add(Object var1) {
		return this.method4963((Node)var1);
	}

	public Iterator iterator() {
		return new IterableNodeDequeDescendingIterator(this);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lfd;Lfd;)V"
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
