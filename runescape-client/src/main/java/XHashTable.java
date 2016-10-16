import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gx")
@Implements("XHashTable")
public final class XHashTable {
   @ObfuscatedName("z")
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("p")
   int field3140 = 0;
   @ObfuscatedName("t")
   Node field3141;
   @ObfuscatedName("y")
   Node field3142;
   @ObfuscatedName("s")
   @Export("size")
   int size;

   @ObfuscatedName("s")
   public Node method3775(long var1) {
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

   @ObfuscatedName("z")
   public void method3776(Node var1, long var2) {
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

   @ObfuscatedName("t")
   void method3777() {
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
      this.field3142 = null;
   }

   @ObfuscatedName("y")
   public Node method3780() {
      this.field3140 = 0;
      return this.method3785();
   }

   @ObfuscatedName("p")
   public Node method3785() {
      Node var1;
      if(this.field3140 > 0 && this.field3142 != this.buckets[this.field3140 - 1]) {
         var1 = this.field3142;
         this.field3142 = var1.next;
         return var1;
      } else {
         do {
            if(this.field3140 >= this.size) {
               return null;
            }

            var1 = this.buckets[this.field3140++].next;
         } while(var1 == this.buckets[this.field3140 - 1]);

         this.field3142 = var1.next;
         return var1;
      }
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
