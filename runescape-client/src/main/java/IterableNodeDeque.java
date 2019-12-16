import java.util.Collection;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jl")
@Implements("IterableNodeDeque")
public class IterableNodeDeque implements Iterable, Collection {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lgk;"
	)
	@Export("sentinel")
	Node sentinel;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lgk;"
	)
	Node field3499;

	public IterableNodeDeque() {
		this.sentinel = new Node();
		this.sentinel.previous = this.sentinel;
		this.sentinel.next = this.sentinel;
	}

	@ObfuscatedName("f")
	@Export("rsClear")
	public void rsClear() {
		while (this.sentinel.previous != this.sentinel) {
			this.sentinel.previous.remove();
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lgk;)V"
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

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Lgk;)V"
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

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "()Lgk;"
	)
	@Export("last")
	public Node last() {
		return this.method4847((Node)null);
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lgk;)Lgk;"
	)
	Node method4847(Node var1) {
		Node var2;
		if (var1 == null) {
			var2 = this.sentinel.previous;
		} else {
			var2 = var1;
		}

		if (var2 == this.sentinel) {
			this.field3499 = null;
			return null;
		} else {
			this.field3499 = var2.previous;
			return var2;
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "()Lgk;"
	)
	@Export("previous")
	public Node previous() {
		Node var1 = this.field3499;
		if (var1 == this.sentinel) {
			this.field3499 = null;
			return null;
		} else {
			this.field3499 = var1.previous;
			return var1;
		}
	}

	@ObfuscatedName("x")
	int method4842() {
		int var1 = 0;

		for (Node var2 = this.sentinel.previous; var2 != this.sentinel; var2 = var2.previous) {
			++var1;
		}

		return var1;
	}

	@ObfuscatedName("a")
	public boolean method4843() {
		return this.sentinel.previous == this.sentinel;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "()[Lgk;"
	)
	Node[] method4844() {
		Node[] var1 = new Node[this.method4842()];
		int var2 = 0;

		for (Node var3 = this.sentinel.previous; var3 != this.sentinel; var3 = var3.previous) {
			var1[var2++] = var3;
		}

		return var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lgk;)Z"
	)
	boolean method4848(Node var1) {
		this.addFirst(var1);
		return true;
	}

	public Object[] toArray() {
		return this.method4844();
	}

	public Iterator iterator() {
		return new IterableNodeDequeDescendingIterator(this);
	}

	public boolean isEmpty() {
		return this.method4843();
	}

	public Object[] toArray(Object[] var1) {
		int var2 = 0;

		for (Node var3 = this.sentinel.previous; var3 != this.sentinel; var3 = var3.previous) {
			var1[var2++] = var3;
		}

		return var1;
	}

	public boolean remove(Object var1) {
		throw new RuntimeException();
	}

	public boolean containsAll(Collection var1) {
		throw new RuntimeException();
	}

	public void clear() {
		this.rsClear();
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	public int hashCode() {
		return super.hashCode();
	}

	public int size() {
		return this.method4842();
	}

	public boolean add(Object var1) {
		return this.method4848((Node)var1);
	}

	public boolean removeAll(Collection var1) {
		throw new RuntimeException();
	}

	public boolean addAll(Collection var1) {
		throw new RuntimeException();
	}

	public boolean retainAll(Collection var1) {
		throw new RuntimeException();
	}

	public boolean contains(Object var1) {
		throw new RuntimeException();
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lgk;Lgk;)V"
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
