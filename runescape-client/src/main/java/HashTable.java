import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
@Implements("HashTable")
public final class HashTable {
   @ObfuscatedName("b")
   @Export("size")
   int size;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "[Lgt;"
   )
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   Node field2548;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   Node field2547;
   @ObfuscatedName("x")
   @Export("index")
   int index;

   public HashTable(int var1) {
      this.index = 0;
      this.size = var1;
      this.buckets = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.buckets[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(J)Lgt;"
   )
   @Export("get")
   public Node get(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field2548 = var3.next; var3 != this.field2548; this.field2548 = this.field2548.next) {
         if(this.field2548.hash == var1) {
            Node var4 = this.field2548;
            this.field2548 = this.field2548.next;
            return var4;
         }
      }

      this.field2548 = null;
      return null;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgt;J)V"
   )
   @Export("put")
   public void put(Node var1, long var2) {
      if(var1.previous != null) {
         var1.unlink();
      }

      Node var4 = this.buckets[(int)(var2 & (long)(this.size - 1))];
      var1.previous = var4.previous;
      var1.next = var4;
      var1.previous.next = var1;
      var1.next.previous = var1;
      var1.hash = var2;
   }

   @ObfuscatedName("r")
   void method3591() {
      for(int var1 = 0; var1 < this.size; ++var1) {
         Node var2 = this.buckets[var1];

         while(true) {
            Node var3 = var2.next;
            if(var3 == var2) {
               break;
            }

            var3.unlink();
         }
      }

      this.field2548 = null;
      this.field2547 = null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "()Lgt;"
   )
   public Node method3592() {
      this.index = 0;
      return this.method3593();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "()Lgt;"
   )
   public Node method3593() {
      Node var1;
      if(this.index > 0 && this.buckets[this.index - 1] != this.field2547) {
         var1 = this.field2547;
         this.field2547 = var1.next;
         return var1;
      } else {
         do {
            if(this.index >= this.size) {
               return null;
            }

            var1 = this.buckets[this.index++].next;
         } while(var1 == this.buckets[this.index - 1]);

         this.field2547 = var1.next;
         return var1;
      }
   }
}
