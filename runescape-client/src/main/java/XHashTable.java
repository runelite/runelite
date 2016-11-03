import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gy")
@Implements("XHashTable")
public final class XHashTable {
   @ObfuscatedName("c")
   Node field3139;
   @ObfuscatedName("q")
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("f")
   Node field3141;
   @ObfuscatedName("v")
   int field3142 = 0;
   @ObfuscatedName("k")
   @Export("size")
   int size;

   @ObfuscatedName("q")
   public void method3822(Node var1, long var2) {
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

   @ObfuscatedName("f")
   void method3824() {
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

      this.field3141 = null;
      this.field3139 = null;
   }

   @ObfuscatedName("c")
   public Node method3825() {
      this.field3142 = 0;
      return this.method3826();
   }

   @ObfuscatedName("v")
   public Node method3826() {
      Node var1;
      if(this.field3142 > 0 && this.field3139 != this.buckets[this.field3142 - 1]) {
         var1 = this.field3139;
         this.field3139 = var1.next;
         return var1;
      } else {
         do {
            if(this.field3142 >= this.size) {
               return null;
            }

            var1 = this.buckets[this.field3142++].next;
         } while(var1 == this.buckets[this.field3142 - 1]);

         this.field3139 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("k")
   public Node method3828(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field3141 = var3.next; this.field3141 != var3; this.field3141 = this.field3141.next) {
         if(this.field3141.hash == var1) {
            Node var4 = this.field3141;
            this.field3141 = this.field3141.next;
            return var4;
         }
      }

      this.field3141 = null;
      return null;
   }

   public XHashTable(int var1) {
      this.size = var1;
      this.buckets = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.buckets[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }
}
