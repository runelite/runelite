import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
@Implements("DemotingHashTable")
public final class DemotingHashTable {
	@ObfuscatedName("q")
	@Export("capacity")
	int capacity;
	@ObfuscatedName("w")
	@Export("remaining")
	int remaining;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lla;"
	)
	@Export("hashTable")
	IterableNodeHashTable hashTable;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Ljk;"
	)
	@Export("queue")
	IterableDualNodeQueue queue;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	class146 field1966;

	public DemotingHashTable(int var1, int var2) {
		this.queue = new IterableDualNodeQueue();
		this.capacity = var1;
		this.remaining = var1;

		int var3;
		for (var3 = 1; var3 + var3 < var1 && var3 < var2; var3 += var3) {
		}

		this.hashTable = new IterableNodeHashTable(var3);
	}

	@ObfuscatedName("q")
	@Export("get")
	public Object get(long var1) {
		Wrapper var3 = (Wrapper)this.hashTable.get(var1);
		if (var3 == null) {
			return null;
		} else {
			Object var4 = var3.get();
			if (var4 == null) {
				var3.remove();
				var3.removeDual();
				this.remaining += var3.size;
				return null;
			} else {
				if (var3.isSoft()) {
					DirectWrapper var5 = new DirectWrapper(var4, var3.size);
					this.hashTable.put(var5, var3.key);
					this.queue.add(var5);
					var5.keyDual = 0L;
					var3.remove();
					var3.removeDual();
				} else {
					this.queue.add(var3);
					var3.keyDual = 0L;
				}

				return var4;
			}
		}
	}

	@ObfuscatedName("w")
	@Export("remove")
	void remove(long var1) {
		Wrapper var3 = (Wrapper)this.hashTable.get(var1);
		this.removeWrapper(var3);
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lew;)V"
	)
	@Export("removeWrapper")
	void removeWrapper(Wrapper var1) {
		if (var1 != null) {
			var1.remove();
			var1.removeDual();
			this.remaining += var1.size;
		}

	}

	@ObfuscatedName("p")
	@Export("put")
	public void put(Object var1, long var2, int var4) {
		if (var4 > this.capacity) {
			throw new IllegalStateException();
		} else {
			this.remove(var2);
			this.remaining -= var4;

			while (this.remaining < 0) {
				Wrapper var5 = (Wrapper)this.queue.removeLast();
				if (var5 == null) {
					throw new RuntimeException("");
				}

				if (!var5.isSoft()) {
				}

				this.removeWrapper(var5);
				if (this.field1966 != null) {
					this.field1966.method3338(var5.get());
				}
			}

			DirectWrapper var6 = new DirectWrapper(var1, var4);
			this.hashTable.put(var6, var2);
			this.queue.add(var6);
			var6.keyDual = 0L;
		}
	}

	@ObfuscatedName("k")
	@Export("demote")
	public void demote(int var1) {
		for (Wrapper var2 = (Wrapper)this.queue.last(); var2 != null; var2 = (Wrapper)this.queue.previous()) {
			if (var2.isSoft()) {
				if (var2.get() == null) {
					var2.remove();
					var2.removeDual();
					this.remaining += var2.size;
				}
			} else if (++var2.keyDual > (long)var1) {
				SoftWrapper var3 = new SoftWrapper(var2.get(), var2.size);
				this.hashTable.put(var3, var2.key);
				IterableDualNodeQueue.DualNodeDeque_addBefore(var3, var2);
				var2.remove();
				var2.removeDual();
			}
		}

	}

	@ObfuscatedName("l")
	@Export("clear")
	public void clear() {
		this.queue.clear();
		this.hashTable.clear();
		this.remaining = this.capacity;
	}
}
