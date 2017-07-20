import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
@Implements("XHashTable")
public final class XHashTable {
   @ObfuscatedName("c")
   @Export("size")
   int size;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[Lgh;"
   )
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("g")
   @Export("index")
   int index;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   Node field2431;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   Node field2432;

   public XHashTable(int var1) {
      this.index = 0;
      this.size = var1;
      this.buckets = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.buckets[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "()Lgh;"
   )
   public Node method3492() {
      this.index = 0;
      return this.method3493();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(J)Lgh;"
   )
   @Export("get")
   public Node get(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field2431 = var3.next; var3 != this.field2431; this.field2431 = this.field2431.next) {
         if(this.field2431.hash == var1) {
            Node var4 = this.field2431;
            this.field2431 = this.field2431.next;
            return var4;
         }
      }

      this.field2431 = null;
      return null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "()Lgh;"
   )
   public Node method3493() {
      Node var1;
      if(this.index > 0 && this.buckets[this.index - 1] != this.field2432) {
         var1 = this.field2432;
         this.field2432 = var1.next;
         return var1;
      } else {
         do {
            if(this.index >= this.size) {
               return null;
            }

            var1 = this.buckets[this.index++].next;
         } while(this.buckets[this.index - 1] == var1);

         this.field2432 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("i")
   void method3497() {
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

      this.field2431 = null;
      this.field2432 = null;
   }

   @ObfuscatedName("o")
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
}
