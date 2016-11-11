import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gg")
@Implements("XHashTable")
public final class XHashTable {
   @ObfuscatedName("n")
   int field3147 = 0;
   @ObfuscatedName("h")
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("e")
   Node field3149;
   @ObfuscatedName("g")
   Node field3150;
   @ObfuscatedName("i")
   @Export("size")
   int size;

   @ObfuscatedName("i")
   public Node method3812(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field3149 = var3.next; this.field3149 != var3; this.field3149 = this.field3149.next) {
         if(this.field3149.hash == var1) {
            Node var4 = this.field3149;
            this.field3149 = this.field3149.next;
            return var4;
         }
      }

      this.field3149 = null;
      return null;
   }

   @ObfuscatedName("h")
   public void method3813(Node var1, long var2) {
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

   @ObfuscatedName("g")
   public Node method3815() {
      this.field3147 = 0;
      return this.method3816();
   }

   @ObfuscatedName("n")
   public Node method3816() {
      Node var1;
      if(this.field3147 > 0 && this.field3150 != this.buckets[this.field3147 - 1]) {
         var1 = this.field3150;
         this.field3150 = var1.next;
         return var1;
      } else {
         do {
            if(this.field3147 >= this.size) {
               return null;
            }

            var1 = this.buckets[this.field3147++].next;
         } while(var1 == this.buckets[this.field3147 - 1]);

         this.field3150 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("e")
   void method3820() {
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

      this.field3149 = null;
      this.field3150 = null;
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
