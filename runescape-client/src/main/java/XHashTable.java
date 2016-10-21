import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ga")
@Implements("XHashTable")
public final class XHashTable {
   @ObfuscatedName("v")
   int field3139 = 0;
   @ObfuscatedName("e")
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("f")
   @Export("size")
   int size;
   @ObfuscatedName("t")
   Node field3142;
   @ObfuscatedName("n")
   Node field3143;

   @ObfuscatedName("f")
   public Node method3849(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field3143 = var3.next; this.field3143 != var3; this.field3143 = this.field3143.next) {
         if(this.field3143.hash == var1) {
            Node var4 = this.field3143;
            this.field3143 = this.field3143.next;
            return var4;
         }
      }

      this.field3143 = null;
      return null;
   }

   @ObfuscatedName("e")
   public void method3850(Node var1, long var2) {
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

   @ObfuscatedName("n")
   void method3851() {
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

      this.field3143 = null;
      this.field3142 = null;
   }

   @ObfuscatedName("t")
   public Node method3852() {
      this.field3139 = 0;
      return this.method3857();
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

   @ObfuscatedName("v")
   public Node method3857() {
      Node var1;
      if(this.field3139 > 0 && this.field3142 != this.buckets[this.field3139 - 1]) {
         var1 = this.field3142;
         this.field3142 = var1.next;
         return var1;
      } else {
         do {
            if(this.field3139 >= this.size) {
               return null;
            }

            var1 = this.buckets[this.field3139++].next;
         } while(var1 == this.buckets[this.field3139 - 1]);

         this.field3142 = var1.next;
         return var1;
      }
   }
}
