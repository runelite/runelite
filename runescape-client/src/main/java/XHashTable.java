import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gv")
@Implements("XHashTable")
public final class XHashTable {
   @ObfuscatedName("u")
   Node field2458;
   @ObfuscatedName("h")
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("q")
   Node field2460;
   @ObfuscatedName("i")
   @Export("size")
   int size;
   @ObfuscatedName("g")
   int field2462;

   @ObfuscatedName("u")
   void method3605() {
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

      this.field2458 = null;
      this.field2460 = null;
   }

   @ObfuscatedName("q")
   public Node method3606() {
      this.field2462 = 0;
      return this.method3607();
   }

   @ObfuscatedName("g")
   public Node method3607() {
      Node var1;
      if(this.field2462 > 0 && this.field2460 != this.buckets[this.field2462 - 1]) {
         var1 = this.field2460;
         this.field2460 = var1.next;
         return var1;
      } else {
         do {
            if(this.field2462 >= this.size) {
               return null;
            }

            var1 = this.buckets[this.field2462++].next;
         } while(var1 == this.buckets[this.field2462 - 1]);

         this.field2460 = var1.next;
         return var1;
      }
   }

   public XHashTable(int var1) {
      this.field2462 = 0;
      this.size = var1;
      this.buckets = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.buckets[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   @ObfuscatedName("i")
   public Node method3615(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field2458 = var3.next; this.field2458 != var3; this.field2458 = this.field2458.next) {
         if(this.field2458.hash == var1) {
            Node var4 = this.field2458;
            this.field2458 = this.field2458.next;
            return var4;
         }
      }

      this.field2458 = null;
      return null;
   }

   @ObfuscatedName("h")
   public void method3617(Node var1, long var2) {
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
