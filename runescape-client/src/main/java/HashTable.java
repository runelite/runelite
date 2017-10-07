import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
@Implements("HashTable")
public final class HashTable {
   @ObfuscatedName("d")
   @Export("size")
   int size;
   @ObfuscatedName("q")
   @Export("index")
   int index;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "[Lgs;"
   )
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   Node field2479;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   Node field2480;

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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "()Lgs;"
   )
   public Node method3646() {
      this.index = 0;
      return this.method3647();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(J)Lgs;"
   )
   @Export("get")
   public Node get(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field2479 = var3.next; var3 != this.field2479; this.field2479 = this.field2479.next) {
         if(this.field2479.hash == var1) {
            Node var4 = this.field2479;
            this.field2479 = this.field2479.next;
            return var4;
         }
      }

      this.field2479 = null;
      return null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "()Lgs;"
   )
   public Node method3647() {
      Node var1;
      if(this.index > 0 && this.buckets[this.index - 1] != this.field2480) {
         var1 = this.field2480;
         this.field2480 = var1.next;
         return var1;
      } else {
         do {
            if(this.index >= this.size) {
               return null;
            }

            var1 = this.buckets[this.index++].next;
         } while(var1 == this.buckets[this.index - 1]);

         this.field2480 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("e")
   void method3645() {
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

      this.field2479 = null;
      this.field2480 = null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgs;J)V"
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
}
