import java.util.Collection;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jd")
@Implements("IterableNodeDeque")
public class IterableNodeDeque implements Iterable, Collection {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lfn;"
	)
	@Export("sentinel")
	Node sentinel;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lfn;"
	)
	Node field3506;

	public IterableNodeDeque() {
		this.sentinel = new Node();
		this.sentinel.previous = this.sentinel;
		this.sentinel.next = this.sentinel;
	}

	@ObfuscatedName("c")
	@Export("rsClear")
	public void rsClear() {
		while (this.sentinel.previous != this.sentinel) {
			this.sentinel.previous.remove();
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lfn;)V"
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

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lfn;)V"
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

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "()Lfn;"
	)
	@Export("last")
	public Node last() {
		return this.method4814((Node)null);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lfn;)Lfn;"
	)
	Node method4814(Node var1) {
		Node var2;
		if (var1 == null) {
			var2 = this.sentinel.previous;
		} else {
			var2 = var1;
		}

		if (var2 == this.sentinel) {
			this.field3506 = null;
			return null;
		} else {
			this.field3506 = var2.previous;
			return var2;
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "()Lfn;"
	)
	@Export("previous")
	public Node previous() {
		Node var1 = this.field3506;
		if (var1 == this.sentinel) {
			this.field3506 = null;
			return null;
		} else {
			this.field3506 = var1.previous;
			return var1;
		}
	}

	@ObfuscatedName("v")
	int method4816() {
		int var1 = 0;

		for (Node var2 = this.sentinel.previous; var2 != this.sentinel; var2 = var2.previous) {
			++var1;
		}

		return var1;
	}

	@ObfuscatedName("d")
	public boolean method4874() {
		return this.sentinel.previous == this.sentinel;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "()[Lfn;"
	)
	Node[] method4818() {
		Node[] var1 = new Node[this.method4816()];
		int var2 = 0;

		for (Node var3 = this.sentinel.previous; var3 != this.sentinel; var3 = var3.previous) {
			var1[var2++] = var3;
		}

		return var1;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lfn;)Z"
	)
	boolean method4819(Node var1) {
		this.addFirst(var1);
		return true;
	}

	public Iterator iterator() {
		return new IterableNodeDequeDescendingIterator(this);
	}

	public int size() {
		return this.method4816();
	}

	public boolean isEmpty() {
		return this.method4874();
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

	public boolean addAll(Collection var1) {
		throw new RuntimeException();
	}

	public boolean add(Object var1) {
		return this.method4819((Node)var1);
	}

	public int hashCode() {
		return super.hashCode();
	}

	public boolean removeAll(Collection var1) {
		throw new RuntimeException();
	}

	public boolean remove(Object var1) {
		throw new RuntimeException();
	}

	public Object[] toArray() {
		return this.method4818();
	}

	public boolean retainAll(Collection var1) {
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

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lfn;Lfn;)V"
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
