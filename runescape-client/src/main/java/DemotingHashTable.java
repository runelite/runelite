import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
@Implements("DemotingHashTable")
public final class DemotingHashTable {
   @ObfuscatedName("m")
   @Export("capacity")
   int capacity;
   @ObfuscatedName("f")
   @Export("remaining")
   int remaining;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   @Export("hashTable")
   IterableNodeHashTable hashTable;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   @Export("queue")
   IterableDualNodeQueue queue;

   public DemotingHashTable(int var1, int var2) {
      this.queue = new IterableDualNodeQueue();
      this.capacity = var1;
      this.remaining = var1;

      int var3;
      for (var3 = 1; var3 + var3 < var1 && var3 < var2; var3 += var3) {
      }

      this.hashTable = new IterableNodeHashTable(var3);
   }

   @ObfuscatedName("m")
   @Export("get")
   public Object get(long key) {
      Wrapper var3 = (Wrapper)this.hashTable.get(key);
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

   @ObfuscatedName("f")
   @Export("remove")
   void remove(long key) {
      Wrapper var3 = (Wrapper)this.hashTable.get(key);
      this.removeWrapper(var3);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Leu;)V"
   )
   @Export("removeWrapper")
   void removeWrapper(Wrapper wrapper) {
      if (wrapper != null) {
         wrapper.remove();
         wrapper.removeDual();
         this.remaining += wrapper.size;
      }

   }

   @ObfuscatedName("w")
   @Export("put")
   public void put(Object value, long key, int size) {
      if (size > this.capacity) {
         throw new IllegalStateException();
      } else {
         this.remove(key);
         this.remaining -= size;

         while (this.remaining < 0) {
            Wrapper var5 = (Wrapper)this.queue.removeLast();
            this.removeWrapper(var5);
         }

         DirectWrapper var6 = new DirectWrapper(value, size);
         this.hashTable.put(var6, key);
         this.queue.add(var6);
         var6.keyDual = 0L;
      }
   }

   @ObfuscatedName("o")
   @Export("demote")
   public void demote(int softeningLevel) {
      for (Wrapper var2 = (Wrapper)this.queue.last(); var2 != null; var2 = (Wrapper)this.queue.previous()) {
         if (var2.isSoft()) {
            if (var2.get() == null) {
               var2.remove();
               var2.removeDual();
               this.remaining += var2.size;
            }
         } else if (++var2.keyDual > (long)softeningLevel) {
            SoftWrapper var3 = new SoftWrapper(var2.get(), var2.size);
            this.hashTable.put(var3, var2.key);
            DualNodeDeque.DualNodeDeque_addBefore(var3, var2);
            var2.remove();
            var2.removeDual();
         }
      }

   }

   @ObfuscatedName("u")
   @Export("clear")
   public void clear() {
      this.queue.clear();
      this.hashTable.clear();
      this.remaining = this.capacity;
   }
}
