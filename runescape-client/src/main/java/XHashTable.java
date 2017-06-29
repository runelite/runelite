import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gs")
@Implements("XHashTable")
public final class XHashTable {
   @ObfuscatedName("w")
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("s")
   int field2466;
   @ObfuscatedName("a")
   Node field2467;
   @ObfuscatedName("t")
   Node field2468;
   @ObfuscatedName("i")
   @Export("size")
   int size;

   @ObfuscatedName("w")
   public void method3529(Node var1, long var2) {
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
   public Node method3530(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field2467 = var3.next; this.field2467 != var3; this.field2467 = this.field2467.next) {
         if(this.field2467.hash == var1) {
            Node var4 = this.field2467;
            this.field2467 = this.field2467.next;
            return var4;
         }
      }

      this.field2467 = null;
      return null;
   }

   @ObfuscatedName("a")
   void method3532() {
      for(int var1 = 0; var1 < this.size; ++var1) {
         Node var2 = this.buckets[var1];

         while(true) {
            Node var3 = var2.next;
            if(var2 == var3) {
               break;
            }

            var3.unlink();
         }
      }

      this.field2467 = null;
      this.field2468 = null;
   }

   @ObfuscatedName("t")
   public Node method3533() {
      this.field2466 = 0;
      return this.method3538();
   }

   public XHashTable(int var1) {
      this.field2466 = 0;
      this.size = var1;
      this.buckets = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.buckets[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   @ObfuscatedName("s")
   public Node method3538() {
      Node var1;
      if(this.field2466 > 0 && this.field2468 != this.buckets[this.field2466 - 1]) {
         var1 = this.field2468;
         this.field2468 = var1.next;
         return var1;
      } else {
         do {
            if(this.field2466 >= this.size) {
               return null;
            }

            var1 = this.buckets[this.field2466++].next;
         } while(var1 == this.buckets[this.field2466 - 1]);

         this.field2468 = var1.next;
         return var1;
      }
   }
}
