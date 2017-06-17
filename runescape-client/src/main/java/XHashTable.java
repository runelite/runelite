import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gx")
@Implements("XHashTable")
public final class XHashTable {
   @ObfuscatedName("w")
   int field2474;
   @ObfuscatedName("m")
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("e")
   Node field2476;
   @ObfuscatedName("t")
   Node field2477;
   @ObfuscatedName("p")
   @Export("size")
   int size;

   public XHashTable(int var1) {
      this.field2474 = 0;
      this.size = var1;
      this.buckets = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.buckets[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   @ObfuscatedName("p")
   public Node method3425(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field2476 = var3.next; this.field2476 != var3; this.field2476 = this.field2476.next) {
         if(this.field2476.hash == var1) {
            Node var4 = this.field2476;
            this.field2476 = this.field2476.next;
            return var4;
         }
      }

      this.field2476 = null;
      return null;
   }

   @ObfuscatedName("m")
   public void method3426(Node var1, long var2) {
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

   @ObfuscatedName("e")
   void method3427() {
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

      this.field2476 = null;
      this.field2477 = null;
   }

   @ObfuscatedName("w")
   public Node method3429() {
      Node var1;
      if(this.field2474 > 0 && this.field2477 != this.buckets[this.field2474 - 1]) {
         var1 = this.field2477;
         this.field2477 = var1.next;
         return var1;
      } else {
         while(this.field2474 < this.size) {
            var1 = this.buckets[this.field2474++].next;
            if(var1 != this.buckets[this.field2474 - 1]) {
               this.field2477 = var1.next;
               return var1;
            }
         }

         return null;
      }
   }

   @ObfuscatedName("t")
   public Node method3435() {
      this.field2474 = 0;
      return this.method3429();
   }
}
