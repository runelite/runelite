import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
@Implements("EvictingDualNodeHashTable")
public final class EvictingDualNodeHashTable {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   @Export("__m")
   DualNode __m;
   @ObfuscatedName("f")
   @Export("capacity")
   int capacity;
   @ObfuscatedName("q")
   @Export("remainingCapacity")
   int remainingCapacity;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   @Export("hashTable")
   NodeHashTable hashTable;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   @Export("deque")
   DualNodeDeque deque;

   public EvictingDualNodeHashTable(int var1) {
      this.__m = new DualNode();
      this.deque = new DualNodeDeque();
      this.capacity = var1;
      this.remainingCapacity = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.hashTable = new NodeHashTable(var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(J)Lfn;"
   )
   @Export("get")
   public DualNode get(long var1) {
      DualNode var3 = (DualNode)this.hashTable.get(var1);
      if(var3 != null) {
         this.deque.addFirst(var3);
      }

      return var3;
   }

   @ObfuscatedName("f")
   @Export("remove")
   public void remove(long var1) {
      DualNode var3 = (DualNode)this.hashTable.get(var1);
      if(var3 != null) {
         var3.remove();
         var3.removeDual();
         ++this.remainingCapacity;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfn;J)V"
   )
   @Export("put")
   public void put(DualNode var1, long var2) {
      if(this.remainingCapacity == 0) {
         DualNode var4 = this.deque.removeLast();
         var4.remove();
         var4.removeDual();
         if(var4 == this.__m) {
            var4 = this.deque.removeLast();
            var4.remove();
            var4.removeDual();
         }
      } else {
         --this.remainingCapacity;
      }

      this.hashTable.put(var1, var2);
      this.deque.addFirst(var1);
   }

   @ObfuscatedName("w")
   @Export("clear")
   public void clear() {
      this.deque.clear();
      this.hashTable.clear();
      this.__m = new DualNode();
      this.remainingCapacity = this.capacity;
   }
}
