import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ji")
@Implements("IterableDualNodeQueue")
public class IterableDualNodeQueue implements Iterable {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lfw;"
	)
	@Export("sentinel")
	public DualNode sentinel;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lfw;"
	)
	@Export("head")
	DualNode head;

	public IterableDualNodeQueue() {
		this.sentinel = new DualNode();
		this.sentinel.previousDual = this.sentinel;
		this.sentinel.nextDual = this.sentinel;
	}

	@ObfuscatedName("z")
	@Export("clear")
	public void clear() {
		while (this.sentinel.previousDual != this.sentinel) {
			this.sentinel.previousDual.removeDual();
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lfw;)V"
	)
	@Export("add")
	public void add(DualNode var1) {
		if (var1.nextDual != null) {
			var1.removeDual();
		}

		var1.nextDual = this.sentinel.nextDual;
		var1.previousDual = this.sentinel;
		var1.nextDual.previousDual = var1;
		var1.previousDual.nextDual = var1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "()Lfw;"
	)
	@Export("removeLast")
	public DualNode removeLast() {
		DualNode var1 = this.sentinel.previousDual;
		if (var1 == this.sentinel) {
			return null;
		} else {
			var1.removeDual();
			return var1;
		}
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "()Lfw;"
	)
	@Export("last")
	public DualNode last() {
		return this.previousOrLast((DualNode)null);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lfw;)Lfw;"
	)
	@Export("previousOrLast")
	DualNode previousOrLast(DualNode var1) {
		DualNode var2;
		if (var1 == null) {
			var2 = this.sentinel.previousDual;
		} else {
			var2 = var1;
		}

		if (var2 == this.sentinel) {
			this.head = null;
			return null;
		} else {
			this.head = var2.previousDual;
			return var2;
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "()Lfw;"
	)
	@Export("previous")
	public DualNode previous() {
		DualNode var1 = this.head;
		if (var1 == this.sentinel) {
			this.head = null;
			return null;
		} else {
			this.head = var1.previousDual;
			return var1;
		}
	}

	public Iterator iterator() {
		return new IterableDualNodeQueueIterator(this);
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lfw;Lfw;)V"
	)
	@Export("DualNodeDeque_addBefore")
	public static void DualNodeDeque_addBefore(DualNode var0, DualNode var1) {
		if (var0.nextDual != null) {
			var0.removeDual();
		}

		var0.nextDual = var1;
		var0.previousDual = var1.previousDual;
		var0.nextDual.previousDual = var0;
		var0.previousDual.nextDual = var0;
	}
}
