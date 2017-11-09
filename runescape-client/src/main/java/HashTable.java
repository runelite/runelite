import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
@Implements("HashTable")
public final class HashTable {
   @ObfuscatedName("m")
   @Export("size")
   int size;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "[Lgh;"
   )
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   Node field2554;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   Node field2557;
   @ObfuscatedName("v")
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(J)Lgh;"
   )
   @Export("get")
   public Node get(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field2554 = var3.next; var3 != this.field2554; this.field2554 = this.field2554.next) {
         if(this.field2554.hash == var1) {
            Node var4 = this.field2554;
            this.field2554 = this.field2554.next;
            return var4;
         }
      }

      this.field2554 = null;
      return null;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgh;J)V"
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

   @ObfuscatedName("i")
   void method3720() {
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

      this.field2554 = null;
      this.field2557 = null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "()Lgh;"
   )
   public Node method3721() {
      this.index = 0;
      return this.method3728();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "()Lgh;"
   )
   public Node method3728() {
      Node var1;
      if(this.index > 0 && this.buckets[this.index - 1] != this.field2557) {
         var1 = this.field2557;
         this.field2557 = var1.next;
         return var1;
      } else {
         do {
            if(this.index >= this.size) {
               return null;
            }

            var1 = this.buckets[this.index++].next;
         } while(var1 == this.buckets[this.index - 1]);

         this.field2557 = var1.next;
         return var1;
      }
   }
}
