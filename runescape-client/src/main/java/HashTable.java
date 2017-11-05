import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
@Implements("HashTable")
public final class HashTable {
   @ObfuscatedName("w")
   @Export("size")
   int size;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "[Lgd;"
   )
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   Node field2457;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   Node field2459;
   @ObfuscatedName("g")
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(J)Lgd;"
   )
   @Export("get")
   public Node get(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field2457 = var3.next; var3 != this.field2457; this.field2457 = this.field2457.next) {
         if(this.field2457.hash == var1) {
            Node var4 = this.field2457;
            this.field2457 = this.field2457.next;
            return var4;
         }
      }

      this.field2457 = null;
      return null;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgd;J)V"
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

   @ObfuscatedName("q")
   void method3636() {
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

      this.field2457 = null;
      this.field2459 = null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "()Lgd;"
   )
   public Node method3637() {
      this.index = 0;
      return this.method3638();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "()Lgd;"
   )
   public Node method3638() {
      Node var1;
      if(this.index > 0 && this.buckets[this.index - 1] != this.field2459) {
         var1 = this.field2459;
         this.field2459 = var1.next;
         return var1;
      } else {
         do {
            if(this.index >= this.size) {
               return null;
            }

            var1 = this.buckets[this.index++].next;
         } while(var1 == this.buckets[this.index - 1]);

         this.field2459 = var1.next;
         return var1;
      }
   }
}
